package cn.com.taiji.spring_framwork.bean;

public class exampleBean {
	private anotherBean anotherBean;
	private otherBean otherBean;
	private int i;
	
	
	
	public exampleBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public exampleBean(anotherBean anotherBean,otherBean otherBean, int i) {
		super();
		this.anotherBean = anotherBean;
		this.otherBean = otherBean;
		this.i = i;
	}
	public anotherBean getAnotherBean() {
		return anotherBean;
	}
	public void setAnotherBean(anotherBean anotherBean) {
		this.anotherBean = anotherBean;
	}
	public otherBean getOtherBean() {
		return otherBean;
	}
	public void setOtherBean(otherBean otherBean) {
		this.otherBean = otherBean;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
}