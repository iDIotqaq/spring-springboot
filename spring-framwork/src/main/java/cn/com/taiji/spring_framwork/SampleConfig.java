package cn.com.taiji.spring_framwork;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.com.taiji.spring_framwork.bean.*;

@Configuration
public class SampleConfig {
	
	@Bean
	public anotherBean anotherBean() {
		anotherBean anotherBean = new anotherBean();
		anotherBean.setName("First");
		return anotherBean;
	}
	
	@Bean 
	public otherBean otherBean() {
		otherBean otherBean = new otherBean();
		otherBean.setName("Second");
		return otherBean;
	}
	
	@Bean
	public exampleBean exampleBean() {
		exampleBean exampleBean = new exampleBean();
		exampleBean.setAnotherBean(anotherBean());
		exampleBean.setOtherBean(otherBean());
		exampleBean.setI(587);
		return exampleBean;
		
	}
}
