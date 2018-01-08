package com.example.greeting;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(GreetingRequest greetingRequest) throws Exception {
		Thread.sleep(1000);
		return new Greeting("Hello, " + greetingRequest.getName() + "!");
	}

}
