package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Productor implements  CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		
		rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz", "Hello from RabbitMQ!");
	}

}
