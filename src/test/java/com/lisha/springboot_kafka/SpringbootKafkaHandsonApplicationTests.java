package com.lisha.springboot_kafka;

import com.lisha.springboot_kafka.kafka.KafkaProducer;
import com.lisha.springboot_kafka.model.Address;
import com.lisha.springboot_kafka.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootKafkaHandsonApplicationTests {
	@Autowired
	KafkaProducer kafkaProducer;

	@Test
	public void testSendMessage()
	{
		User user = User.builder()
				.userId(101L)
				.userName("Rambo")
				.country("US")
				.build();
		kafkaProducer.sendMessage(user);
	}

	@Test
	public void testSendMessage1()
	{
		Address address = Address.builder()
				.id(10L)
				.street("Park Street")
				.zipCode("2541")
				.build();
		kafkaProducer.sendMessageUsingMessageBuilder(address);
	}


}
