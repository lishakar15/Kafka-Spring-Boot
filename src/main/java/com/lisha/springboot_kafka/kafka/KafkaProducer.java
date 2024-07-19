package com.lisha.springboot_kafka.kafka;

import com.lisha.springboot_kafka.model.Address;
import com.lisha.springboot_kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    public void sendMessage(User user)
    {
        try
        {
            kafkaTemplate.send("Users",user.getUserId(),user);
        }
        catch (KafkaException ex)
        {
            LOGGER.error("Exception occurred while sending message "+ex.getMessage());
        }
    }

    public void sendMessageUsingMessageBuilder(Address address)
    {
        Message<Address> message = MessageBuilder
                .withPayload(address)
                .setHeader(KafkaHeaders.TOPIC,"Address")
                .build();
        try
        {
            kafkaTemplate.send(message);
        }
        catch (KafkaException ex)
        {
            LOGGER.error("Exception occurred while sending message "+ex.getMessage());
        }
    }
}
