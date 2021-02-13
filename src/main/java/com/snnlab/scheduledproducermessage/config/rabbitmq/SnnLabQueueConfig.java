package com.snnlab.scheduledproducermessage.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnnLabQueueConfig {

    private QueueProperties queueProperties;

    @Autowired
    public SnnLabQueueConfig(@Qualifier("snnLabQueueProperties") QueueProperties queueProperties){
        this.queueProperties = queueProperties;
    }

    @Bean
    public Queue queue() {
        return new Queue(this.queueProperties.getQueue(), false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(this.queueProperties.getExchange());
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(this.queueProperties.getRoutingKey());
    }
}
