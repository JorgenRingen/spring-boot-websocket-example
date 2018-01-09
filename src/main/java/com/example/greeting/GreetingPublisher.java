package com.example.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.example.WebSocketConfig.TOPIC_GREETINGS;

@Component
public class GreetingPublisher {

	private final SimpMessagingTemplate webSocket;

	@Autowired
	public GreetingPublisher(SimpMessagingTemplate webSocket) {
		this.webSocket = webSocket;
	}

	@Scheduled(fixedRate = 5000)
	public void sendMessage() {
		webSocket.convertAndSend(TOPIC_GREETINGS, new Greeting("Hello from server @ " + LocalDate.now().toString() + "!"));
	}
}
