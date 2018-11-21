package cn.com.taiji.spring_framwork.service;

public class HelloworldService {
	private String name;
	public HelloworldService() {}
	
	public HelloworldService(String name) {
	
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
