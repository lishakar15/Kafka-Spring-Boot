package com.lisha.springboot_kafka.kafka;

import com.lisha.springboot_kafka.model.Address;
import com.lisha.springboot_kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "Users", groupId = "myGroup")
    public void consumeMessage(User user)
    {
        LOGGER.info("Message consumed successfully... "+user.toString());
    }
    @KafkaListener(topics = "Address",groupId = "myGroup")
    public void consumeMessage1(Address address)
    {
        LOGGER.info("Message for Address consumed successfully.. "+address.toString());
    }
}
