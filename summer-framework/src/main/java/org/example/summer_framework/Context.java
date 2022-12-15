package org.example.summer_framework;

import org.example.Car;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    private static final String TAG_BEAN = "bean";
    private static final String TAG_PROPERTY = "property";

    private List<Bean> beans = new ArrayList<>();

    private Map<String, Object> objectsById = new HashMap<>();
    private Map<Class<?>, Object> objectsByClass = new HashMap<>();

    public Context(String xmlPath) throws Exception {
        parseDomXml(xmlPath);
        instantiateBeans();
    }

    private void parseDomXml(String xmlPath) throws Exception {
        Document document;
        document = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().parse(new File(xmlPath));
        Element root = document.getDocumentElement();
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (TAG_BEAN.equals(node.getNodeName())) {
                parseBean(node);
            }
        }
    }

    private void parseBean(Node bean) throws InvalidConfigurationException {
        NamedNodeMap attributes = bean.getAttributes();
        Node id = attributes.getNamedItem("id");
        String idVal = id.getNodeValue();
        String classVal = attributes.getNamedItem("class").getNodeValue();

        Map<String, Property> properties = new HashMap<>();
        NodeList nodes = bean.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (TAG_PROPERTY.equals(node.getNodeName())) {
                Property property = parseProperty(node);
                properties.put(property.getName(), property);
            }
        }

        beans.add(new Bean(idVal, classVal, properties));
    }

    private Property parseProperty(Node node) throws InvalidConfigurationException {
        NamedNodeMap attributes = node.getAttributes();
        Node val = attributes.getNamedItem("val");
        String name = attributes.getNamedItem("name").getNodeValue();
        if (val != null) {
            return new Property(name, val.getNodeValue(), ValueType.VALUE);
        } else {
            Node ref = attributes.getNamedItem("ref");
            if (ref != null) {
                return new Property(name, ref.getNodeValue(), ValueType.REF);
            } else {
                throw new InvalidConfigurationException("Failed to find attribute ref or val: " + name);
            }
        }
    }

    private void instantiateBeans() throws Exception {
        for (Bean bean : beans) {
            Class<?> aClass = Class.forName(bean.getClassName());
            Object object = aClass.newInstance();

            processAnnotations(aClass, object);

            for (String id : bean.getProperties().keySet()) {
                Field field = getField(aClass, id);
                if (field == null) {
                    throw new InvalidConfigurationException("Failed to set field " + id + " for class: " + aClass.getName());
                }
                field.setAccessible(true);
                Property property = bean.getProperties().get(id);
                switch (property.getType()) {
                    case VALUE:
                        field.set(object,  convert(field.getType().getName(), property.getValue()));
                        break;
                    case REF:
                        String refName = property.getValue();
                        if(objectsById.containsKey(refName)) {
                            field.set(object, objectsById.get(refName));
                        } else {
                            throw new InvalidConfigurationException("Failed instantiate been, ref:" + id);
                        }
                        break;
                    default:
                        throw new InvalidConfigurationException("");

                }
            }
            objectsById.put(bean.getId(), object);
            objectsByClass.put(aClass, object);
        }
    }

    private void processAnnotations(Class<?> aClass, Object instance) throws InvalidConfigurationException, IllegalAccessException {
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Auto.class)) {
                Auto auto = field.getAnnotation(Auto.class);
                if (auto.required() && !objectsByClass.containsKey(field.getType())) {
                    throw new InvalidConfigurationException("Failed @Auto " + field.getName() + " " + field.getType());
                }
            } else {
                if (objectsByClass.containsKey(field.getType())) {
                    Object val = objectsByClass.get(field.getType());
                    field.setAccessible(true);
                    field.set(instance, val);
                }
            }
        }
    }


    private Field getField(Class<?> aClass, String fieldName) throws NoSuchFieldException {
        try {
            return aClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class superClass = aClass.getSuperclass();
            if (superClass == null) {
                throw e;
            } else {
                return getField(superClass, fieldName);
            }
        }
    }

    private Object convert(String typeName, String value) throws InvalidConfigurationException {
        switch (typeName) {
            case "int":
            case "Integer":
                return Integer.valueOf(value);
            case "double":
            case "Double":
                return Double.valueOf(value);
            case "float":
            case "Float":
                return Float.valueOf(value);
            case "boolean":
            case "Boolean":
                return Boolean.valueOf(value);
            default:
                throw new InvalidConfigurationException(typeName);
        }
    }

    public Object getBean(String beanName) {
        return objectsById.get(beanName);
    }

    public Object getBean(Class<?> beanClass) {
        return objectsByClass.get(beanClass);
    }
}
