package cn.com.taiji.spring_framwork.bean;

public class OtherBean {
	private String name;
	public void say() {
		System.out.println("my name is " + name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
