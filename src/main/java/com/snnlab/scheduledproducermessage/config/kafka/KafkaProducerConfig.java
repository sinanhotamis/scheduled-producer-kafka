package com.snnlab.scheduledproducermessage.config.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ProducerFactory<String,Object> producerFactory(){
        Map<String,Object> configProperties = new HashMap<>();
        //put config elements
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,this.kafkaProperties.getBindAddress());
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configProperties.put(JsonSerializer.TYPE_MAPPINGS, "paymentInfoDTO:com.snnlab.scheduledproducerkafka.model.PaymentInfoDTO");


        return new DefaultKafkaProducerFactory<>(configProperties);
    }


    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
