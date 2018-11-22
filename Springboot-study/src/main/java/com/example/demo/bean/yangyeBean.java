package com.example.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="my")
@Component
public class yangyeBean {
	private String name;
	private int age;
	private String sex;
	private String address;
	
	public yangyeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public yangyeBean(String name, int age, String sex, String address) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "yangyeBean [name=" + name + ", age=" + age + ", sex=" + sex + ", address=" + address + "]";
	}
	
}
