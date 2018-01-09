package com.example.greeting;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import static com.example.WebSocketConfig.TOPIC_GREETINGS;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo(TOPIC_GREETINGS)
	public Greeting greeting(GreetingRequest greetingRequest) throws Exception {
		Thread.sleep(1000);
		return new Greeting("Hello, " + greetingRequest.getName() + "!");
	}

}
