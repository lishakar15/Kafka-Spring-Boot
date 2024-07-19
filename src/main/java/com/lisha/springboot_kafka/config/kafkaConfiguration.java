package com.lisha.springboot_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaConfiguration {

    @Bean
    public NewTopic getNewTopic1()
    {
        return TopicBuilder.name("Users").partitions(3).replicas(1).build(); //Topic 1
    }
    @Bean
    public NewTopic getNewTopic2()
    {
        return TopicBuilder.name("Address").partitions(2).build(); //Topic 2
    }
}
