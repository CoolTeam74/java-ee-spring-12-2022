package org.example.jms;

import org.example.dto.OrderDto;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;

public class OrderProducer {
    @Resource(lookup = "jms/javaee7/ConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/javaee7/Topic")
    private Topic topic;

    public void send(OrderDto orderDto) {
        try (JMSContext context = connectionFactory.createContext()) {
            context.createProducer().send(topic, orderDto);
        }
    }

}
