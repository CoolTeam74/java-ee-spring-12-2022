package org.example.jms;

import org.example.dto.OrderDto;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSConnectionFactoryDefinition;
import javax.jms.JMSConnectionFactoryDefinitions;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jsm/javaee7/Topic", activationConfig = {
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "totalAmount > 5000")
})
@JMSConnectionFactoryDefinitions({
        @JMSConnectionFactoryDefinition(name="java/javaee7/ConnectionFactory", className = "javax.jms.ConnectionFactory"),
        @JMSConnectionFactoryDefinition(name="java/javaee7/Topic", className = "javax.jms.Topic", interfaceName = "javax.jms.Topic")
})
public class ExpensiveOrderMdb implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            OrderDto orderDto = message.getBody(OrderDto.class);
            System.out.println(orderDto.toString());
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }
}
