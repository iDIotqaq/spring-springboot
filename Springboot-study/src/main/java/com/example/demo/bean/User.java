package com.example.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix="yangye")
@Component
@Data
public class User {
	private String name;
	private int age;
	private String sex;
}
