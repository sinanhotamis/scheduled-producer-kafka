package com.snnlab.scheduledproducermessage.jobs;

import com.snnlab.scheduledproducermessage.config.rabbitmq.QueueProperties;
import com.snnlab.scheduledproducermessage.model.SnnLabInfoDTO;
import com.snnlab.scheduledproducermessage.producer.rabbitmq.GenericRabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class ScheduledProducerRabbitMQJob {

    private GenericRabbitMqProducer genericRabbitMqProducer;
    private QueueProperties queueProperties;

    @Autowired
    public ScheduledProducerRabbitMQJob(GenericRabbitMqProducer genericRabbitMqProducer, QueueProperties queueProperties) {
        this.genericRabbitMqProducer = genericRabbitMqProducer;
        this.queueProperties = queueProperties;
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void executeInternal()  {
        for (int i = 1; i < 10; i++) {
            this.genericRabbitMqProducer.consumeMessage(this.queueProperties, generatePaymentInfo());
        }
    }

    private SnnLabInfoDTO generatePaymentInfo() {
        UUID uuid = UUID.randomUUID();
        SnnLabInfoDTO snnLabInfoDTO = new SnnLabInfoDTO();
        snnLabInfoDTO.setId(uuid.toString());
        snnLabInfoDTO.setAmount(BigDecimal.valueOf(100000.00));
        snnLabInfoDTO.setCurrency("TRY");

        return snnLabInfoDTO;
    }
}
