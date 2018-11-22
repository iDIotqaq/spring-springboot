package com.example.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix="my")
@Component
@Data
public class yangyeBean {
	private String name;
	private int age;
	private String sex;
	private String address;

	
}
