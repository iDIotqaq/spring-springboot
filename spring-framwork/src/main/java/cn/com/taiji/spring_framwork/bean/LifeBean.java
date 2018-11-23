package cn.com.taiji.spring_framwork.bean;

import javax.annotation.PreDestroy;

public class LifeBean {

	
	public void start() {
		System.out.println("开始");
	}
	public void run() {
		System.out.println("运行");
	}
	public void stop() {
		System.out.println("停止");
		
	}
	
}
