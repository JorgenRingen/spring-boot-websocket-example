package com.example.greeting;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GreetingRequest {

	private final String name;

	@JsonCreator
	public GreetingRequest(@JsonProperty("name") String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
