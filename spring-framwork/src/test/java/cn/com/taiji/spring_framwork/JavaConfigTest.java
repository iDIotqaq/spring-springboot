package cn.com.taiji.spring_framwork;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.taiji.spring_framwork.bean.exampleBean;

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
		context.getBean("exampleBean",exampleBean.class).run();
	}
}
