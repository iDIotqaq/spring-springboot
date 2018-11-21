package cn.com.taiji.spring_framwork;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.taiji.spring_framwork.bean.*;
import cn.com.taiji.spring_framwork.service.HelloworldService;

public class BeanXmlTest {
	private ClassPathXmlApplicationContext context;
	
	@Before
	public void InitialContext() {
		context = new ClassPathXmlApplicationContext("beans.xml");
		
		//获取bean数量
		int count = context.getBeanDefinitionCount();
		System.out.println(count);
		//获取所有bean 的名字
		String[] names = context.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string+"~~~~"+string.getClass());
			
		}
		
	}
	
	@Test
	public void test() {
		HelloworldService hello = (HelloworldService) context.getBean("HelloworldService");
		hello.sayName();
		context.close();
	}
	
	@Test
	public void lifeBean() {
		lifeBean life = (lifeBean)context.getBean("lifeBean");
		life.run();
		context.close();
	}
	
	@Test
	public void example() {
		exampleBean example = (exampleBean)context.getBean("exampleBean");
		anotherBean aotherBean =  example.getAnotherBean();
		otherBean otherBean = example.getOtherBean();
		aotherBean.say();
		otherBean.say();
		System.out.println(example.getI());
		
	}
}
