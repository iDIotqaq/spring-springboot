package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.demo.service.MessageService;

@Service
@Profile({"goodbye","dev"})
public class HelloService implements MessageService {
	@Value("${name:World}")
	private String name;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "hello"+this.name;
	}
	

}
