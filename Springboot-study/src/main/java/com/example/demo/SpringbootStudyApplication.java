package com.example.demo;

import java.util.stream.Collectors;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import com.example.demo.bean.yangyeBean;

@SpringBootApplication

public class SpringbootStudyApplication {
//	
//	@RequestMapping("/yy")
//	public String helloworld() {
//		return "hello yy";
//	}
	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootStudyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args->{
			System.out.println(context.getBeanDefinitionCount());
		};
	}
	@Bean
	public static CommandLineRunner testA() {
		CommandLineRunner runner = new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				yangyeBean bean = new yangyeBean();
				bean.setName("aaaaa");
				System.out.println(bean);
				System.out.println("testA is running......");
			}
		};
		return runner;
	}
	@Bean
	public static ApplicationRunner testB() {
		ApplicationRunner runner = new ApplicationRunner() {
			
			@Override
			public void run(ApplicationArguments args) throws Exception {
				System.out.println("ApplicationRunner");
				for (String opt : args.getOptionNames()) {
					System.out.println(opt+"->");
					System.out.println(args.getOptionValues(opt).stream().collect(Collectors.joining()));
				}
				
			}
		};
		return runner;
		}
	//监听器
	@Bean
	public ApplicationListener<ApplicationEvent> helloListener2(){
		return (ApplicationEvent event)->{
			final String URL = "/yangye";
			
			if(event instanceof ServletRequestHandledEvent) {
				ServletRequestHandledEvent e = (ServletRequestHandledEvent)event;
				if(e.getRequestUrl().equals(URL)) {
					System.out.println("URL IS :"+e.getRequestUrl());
				}
			}
		};
	}
	@Bean
	public ApplicationListener<ApplicationEvent> helloListener(){
		final String URL ="/yy";
		ApplicationListener<ApplicationEvent> listener = new ApplicationListener<ApplicationEvent>() {
			
			@Override
			public void onApplicationEvent(ApplicationEvent event) {
				// TODO Auto-generated method stub
				if(event instanceof ServletRequestHandledEvent) {
					ServletRequestHandledEvent e = (ServletRequestHandledEvent)event;
					
				if(e.getRequestUrl().equals(URL)){
					System.out.println("URL is "+e.getRequestUrl());
				}
				}
				
			}
		};
		return listener;
	}
	}
