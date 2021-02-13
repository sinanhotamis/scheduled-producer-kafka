package com.snnlab.scheduledproducermessage.jobs;

import com.snnlab.scheduledproducermessage.model.SnnLabInfoDTO;
import com.snnlab.scheduledproducermessage.producer.kafka.GenericKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class ScheduledProducerKafkaJob {

    private GenericKafkaProducer<SnnLabInfoDTO> genericKafkaProducer;

    @Autowired
    public ScheduledProducerKafkaJob(GenericKafkaProducer genericKafkaProducer) {
        this.genericKafkaProducer = genericKafkaProducer;
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void executeInternal() {
        for (int i = 1; i < 10; i++) {
            //this.genericKafkaProducer.sendMessage(generatePaymentInfo());
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
