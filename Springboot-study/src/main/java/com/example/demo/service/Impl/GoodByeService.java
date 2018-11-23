package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.demo.service.MessageService;

@Component
@Profile({"default","hello"})
public class GoodByeService implements MessageService {
	@Value("${name}")
	private String name;
	@Override
	public String getMessage() {
		
		return "goodbye"+name;
	}

}
