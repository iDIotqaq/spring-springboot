package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.bean.User;

@Component
@Order(1)
public class OrderRunner1 implements CommandLineRunner{
	@Autowired
	private User user;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(user);
		System.out.println("OrderRunner1 is running......");
	}
	
}
