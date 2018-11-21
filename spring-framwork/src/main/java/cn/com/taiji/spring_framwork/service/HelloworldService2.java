package cn.com.taiji.spring_framwork.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class HelloworldService2 {
	@Value("yangye")
	private String name;
	
	public HelloworldService2() {}
	
	public HelloworldService2(String name) {
	
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void sayName() {
		System.out.println("hello,"+name);
	}

}
