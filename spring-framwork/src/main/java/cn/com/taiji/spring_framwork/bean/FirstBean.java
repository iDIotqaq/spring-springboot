package cn.com.taiji.spring_framwork.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class FirstBean {
	@Value("FirstBean")
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
