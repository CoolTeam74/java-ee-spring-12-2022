package org.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Component
public class SelfInjectBeanProcessor implements BeanPostProcessor {
    Map<String, Object> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SelfInject.class)) {
                map.put(beanName, bean);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object proxy, String beanName) throws BeansException {
        Object orinalObject = map.get(beanName);
        if (orinalObject != null) {
            Field[] fields = orinalObject.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(SelfInject.class)) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, orinalObject, proxy);
                }
            }
        }
        return proxy;
    }
}
