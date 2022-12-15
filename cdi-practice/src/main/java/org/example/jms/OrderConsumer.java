package org.example.jms;

import org.example.dto.OrderDto;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Topic;

public class OrderConsumer {
    @Resource(lookup = "jms/javaee7/ConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/javaee7/Topic")
    private Topic topic;

    public void receive() {
        try (JMSContext context = connectionFactory.createContext()) {
            Message receive = context.createConsumer(topic, "totalAmount BETWEEN 1000 and 5000").receive();
            OrderDto orderDto = receive.getBody(OrderDto.class);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
