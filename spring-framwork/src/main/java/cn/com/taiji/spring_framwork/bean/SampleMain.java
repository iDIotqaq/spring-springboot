package cn.com.taiji.spring_framwork.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.taiji.spring_framwork.service.HelloworldService;

public class SampleMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//获取bean数量
		int count = context.getBeanDefinitionCount();
		System.out.println(count);
		//获取所有bean 的名字
		String[] names = context.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string);
		}
		HelloworldService hello = (HelloworldService) context.getBean("HelloworldService");
		hello.sayName();
	}
}
