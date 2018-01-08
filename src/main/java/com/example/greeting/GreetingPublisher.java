package com.example.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

public class GreetingPublisher {

	private final SimpMessagingTemplate webSocket;

	@Autowired
	GreetingPublisher(SimpMessagingTemplate webSocket) {
		this.webSocket = webSocket;
	}

	@Scheduled(fixedRate = 5000)
	public void sendMessage() {
		System.out.println("HelloSender.sendMessage");
		webSocket.convertAndSend("/topic/greetings", new Greeting("Hello from server!"));
	}
}
