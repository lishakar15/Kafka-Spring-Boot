package com.lisha.springboot_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaConfiguration {

    @Bean
    public NewTopic getNewTopic()
    {
        return TopicBuilder.name("fruits").partitions(3).replicas(3).build();
    }
}
