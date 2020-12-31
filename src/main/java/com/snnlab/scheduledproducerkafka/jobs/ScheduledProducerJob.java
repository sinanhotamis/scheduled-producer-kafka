package com.snnlab.scheduledproducerkafka.jobs;

import com.snnlab.scheduledproducerkafka.model.PaymentInfoDTO;
import com.snnlab.scheduledproducerkafka.producer.GenericKafkaProducer;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class ScheduledProducerJob extends QuartzJobBean {

    private GenericKafkaProducer<PaymentInfoDTO> genericKafkaProducer;

    @Autowired
    public ScheduledProducerJob(GenericKafkaProducer genericKafkaProducer) {
        this.genericKafkaProducer = genericKafkaProducer;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        for (int i = 1; i < 10; i++) {
            try {
                this.genericKafkaProducer.sendMessage(generatePaymentInfo());
            } catch (Exception e) {
                throw new JobExecutionException(e.getMessage());
            }
        }
    }

    private PaymentInfoDTO generatePaymentInfo() {
        UUID uuid = UUID.randomUUID();
        PaymentInfoDTO paymentInfoDTO = new PaymentInfoDTO();
        paymentInfoDTO.setId(uuid.toString());
        paymentInfoDTO.setAmount(BigDecimal.valueOf(100000.00));
        paymentInfoDTO.setCurrency("TRY");

        return paymentInfoDTO;
    }
}
