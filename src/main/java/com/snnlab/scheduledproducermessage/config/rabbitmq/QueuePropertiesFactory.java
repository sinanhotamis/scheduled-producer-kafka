package com.snnlab.scheduledproducermessage.config.rabbitmq;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueuePropertiesFactory {

    @Bean("snnLabQueueProperties")
    @ConfigurationProperties(prefix = "spring.rabbitmq.prop.snnlab")
    public QueueProperties snnLabQueueProperties(){
        return QueueProperties.builder().build();
    }

}
