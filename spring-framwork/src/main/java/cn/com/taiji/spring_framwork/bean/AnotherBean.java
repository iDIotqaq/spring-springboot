package cn.com.taiji.spring_framwork.bean;

import javax.annotation.PostConstruct;

public class AnotherBean {
	private String name;
	public void say() {
		System.out.println("my name is "+ name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
