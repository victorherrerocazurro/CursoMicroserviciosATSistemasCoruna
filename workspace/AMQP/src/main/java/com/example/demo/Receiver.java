package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Receiver {
	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
	}
}