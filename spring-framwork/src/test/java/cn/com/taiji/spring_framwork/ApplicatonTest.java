package cn.com.taiji.spring_framwork;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.taiji.spring_framwork.service.*;

import cn.com.taiji.spring_framwork.bean.*;
public class ApplicatonTest {
	private AnnotationConfigApplicationContext context;
	
	@Before
	public void before() {
		context = new AnnotationConfigApplicationContext();
		context.scan("cn.com.taiji.spring_framwork");
		//添加销毁
		context.refresh();
		context.registerShutdownHook();
	}
	
	@Test
	public void helloworld() {
		context.getBean("helloworldService2",HelloworldService2.class).sayName();
		
	}
	@Test
	public void exampleBean2() {
		context.getBean("exampleBean2",exampleBean2.class).run();
	}
	
	@Test
	public void helloworld2() {
		ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("META-INF/application-context.xml");
		context2.getBean("helloworldService2",HelloworldService2.class).sayName();
		
	}
}
