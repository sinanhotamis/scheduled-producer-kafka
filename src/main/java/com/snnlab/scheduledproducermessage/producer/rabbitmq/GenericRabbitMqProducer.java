package com.snnlab.scheduledproducermessage.producer.rabbitmq;

import com.snnlab.scheduledproducermessage.config.rabbitmq.QueueProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class GenericRabbitMqProducer {

    private RabbitTemplate rabbitTemplate;

    public  GenericRabbitMqProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void consumeMessage(QueueProperties queueProperties, Object message){
        this.rabbitTemplate.convertAndSend(queueProperties.getExchange(),queueProperties.getRoutingKey(),message);
    }
}
