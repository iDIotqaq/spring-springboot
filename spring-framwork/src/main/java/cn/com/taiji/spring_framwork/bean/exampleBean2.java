package cn.com.taiji.spring_framwork.bean;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class exampleBean2 {
	@Inject
	private FirstBean FirstBean;
	@Autowired
	private SecondBean SecondBean;
	@Value("999")
	private int i;
	
	
	public exampleBean2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public exampleBean2(cn.com.taiji.spring_framwork.bean.FirstBean firstBean,
			cn.com.taiji.spring_framwork.bean.SecondBean secondBean, int i) {
		super();
		FirstBean = firstBean;
		SecondBean = secondBean;
		this.i = i;
	}
	public FirstBean getFirstBean() {
		return FirstBean;
	}
	public void setFirstBean(FirstBean firstBean) {
		FirstBean = firstBean;
	}
	public SecondBean getSecondBean() {
		return SecondBean;
	}
	public void setSecondBean(SecondBean secondBean) {
		SecondBean = secondBean;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public void run() {
		FirstBean.say();
		SecondBean.say();
		System.out.println(i);
	}
}
