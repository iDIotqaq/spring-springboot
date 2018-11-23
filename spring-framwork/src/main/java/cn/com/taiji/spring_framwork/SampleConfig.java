package cn.com.taiji.spring_framwork;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cn.com.taiji.spring_framwork.bean.*;

@Configuration
@ComponentScan("cn.com.taiji.spring_framwork")
public class SampleConfig {
	
	@Bean
	public AnotherBean anotherBean() {
		AnotherBean anotherBean = new AnotherBean();
		anotherBean.setName("First");
		return anotherBean;
	}
	
	@Bean 
	public OtherBean otherBean() {
		OtherBean otherBean = new OtherBean();
		otherBean.setName("Second");
		return otherBean;
	}
	
	@Bean
	public ExampleBean exampleBean() {
		ExampleBean exampleBean = new ExampleBean();
		exampleBean.setAnotherBean(anotherBean());
		exampleBean.setOtherBean(otherBean());
		exampleBean.setI(587);
		return exampleBean;		
	}
}
