package com.snnlab.scheduledproducermessage.config.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class QueueProperties {

    private String exchange;
    private String queue;
    private String routingKey;
}
