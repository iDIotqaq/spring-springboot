package cn.com.taiji.spring_framwork.bean;

import javax.annotation.PostConstruct;

public class ExampleBean {
	private AnotherBean anotherBean;
	private OtherBean otherBean;
	private int i;
	
	
	
	public ExampleBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExampleBean(AnotherBean anotherBean,OtherBean otherBean, int i) {
		super();
		this.anotherBean = anotherBean;
		this.otherBean = otherBean;
		this.i = i;
	}
	public AnotherBean getAnotherBean() {
		return anotherBean;
	}
	public void setAnotherBean(AnotherBean anotherBean) {
		this.anotherBean = anotherBean;
	}
	public OtherBean getOtherBean() {
		return otherBean;
	}
	public void setOtherBean(OtherBean otherBean) {
		this.otherBean = otherBean;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public void run() {
		anotherBean.say();
		otherBean.say();
		System.out.println(i);
	}
	@PostConstruct
	public void start() {
		System.out.println("开始");
	}
}
