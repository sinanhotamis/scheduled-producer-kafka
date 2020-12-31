package com.snnlab.scheduledproducerkafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class GenericKafkaProducer<T> {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TUTORIAL_TOPIC_NAME = "snnLab";

    @Autowired
    public GenericKafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(T producedType) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TUTORIAL_TOPIC_NAME, producedType);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //TODO logging
                System.out.println(new StringBuilder()
                        .append("The data:")
                        .append(producedType.toString())
                        .append("produced into Kafka Topic ")
                        .append(TUTORIAL_TOPIC_NAME)
                        .append(" successfully.").toString());

            }
            @Override
            public void onFailure(Throwable throwable) {
                //TODO logging
                System.out.println(new StringBuilder()
                        .append("The data:")
                        .append(producedType.toString())
                        .append("produced into Kafka Topic ")
                        .append(TUTORIAL_TOPIC_NAME)
                        .append(" unsuccessfully with exception:")
                        .append(throwable.getMessage()).toString());
            }
        });
    }
}
