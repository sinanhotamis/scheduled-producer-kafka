package com.snnlab.scheduledproducerkafka.config.jobs;

import com.snnlab.scheduledproducerkafka.jobs.ScheduledProducerJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduledProducerJobConfig {

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob().ofType(ScheduledProducerJob.class)
                .storeDurably()
                .withIdentity("ScheduledProducerJob")
                .withDescription("Invoke Sample Job service...")
                .build();
    }

    @Bean
    //Every 1 minutes cron trigger, for scheduler job
    public Trigger trigger(JobDetail job) {
       return TriggerBuilder.newTrigger()
                .withIdentity("scheduled-producer-cron-trigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *"))
                .forJob("ScheduledProducerJob")
                .build();

    }
}
