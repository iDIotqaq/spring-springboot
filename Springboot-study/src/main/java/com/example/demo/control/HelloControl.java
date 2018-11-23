package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;
import com.example.demo.bean.yangyeBean;
import com.example.demo.service.MessageService;

@RestController
public class HelloControl {
	@Value("${my.name}")
	private String name;
	@Value("${my.age}")
	private String age;
	@Value("${my.sex}")
	private String sex;
	@Autowired
	private yangyeBean bean;
	@Autowired
	private User user;

	@RequestMapping("/yy")
	public String helloworld() {
		System.out.println(bean.toString());
		return "123";
	}
	@RequestMapping("/person")
	public yangyeBean person() {
		return bean;
	}
	@RequestMapping("/user")
	public User user() {
		return user;
	}
	@RequestMapping("/yangye")
	public String hello() {
		return "hello," + name + "```" + age + "```" + sex;
	}
}
