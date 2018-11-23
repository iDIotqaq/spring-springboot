package cn.com.taiji.spring_framwork;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.taiji.spring_framwork.bean.*;
import cn.com.taiji.spring_framwork.service.*;
public class JavaConfigTest {
	private AnnotationConfigApplicationContext context;
	
	@Before
	public void before() {
		context = new AnnotationConfigApplicationContext(SampleConfig.class);
		int count = context.getBeanDefinitionCount();
		System.out.println("Bean数量为:"+count);
		String[] names = context.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string+"~~~~~~"+string.getClass());
		}
	}
	
	
	@Test
	public void exampleBean() {
		context.getBean("exampleBean",ExampleBean.class).run();
	}
	@Test
	public void exampleBean2() {
		context.getBean("exampleBean2",ExampleBean2.class).run();
	}
	@Test
	public void HelloworldService2() {
		context.getBean("helloworldService2",HelloworldService2.class).sayName();
	}
}
