

# spring-springboot

## spring-framwork

### xml方式依赖注入

````xml
<!--setter方式注入 -->
<bean id="HelloworldService" class="cn.com.taiji.spring_framwork.service.HelloworldService">
		<property name="name" value="yangye"/>
</bean>
<!--构造器方式注入 -->
<bean id="HelloworldService" class="cn.com.taiji.spring_framwork.service.HelloworldService">
	<constructor-arg type="String" value="constructor"></constructor-arg>
</bean>
<!--注入两个自定义bean -->
<bean id="aotherBean" class="cn.com.taiji.spring_framwork.bean.anotherBean">
		<property name="name" value="aoherBean"></property>
</bean>
<bean id="otherBean" class="cn.com.taiji.spring_framwork.bean.otherBean">
		<property name="name" value="other"></property>
</bean>
<bean id="exampleBean" class="cn.com.taiji.spring_framwork.bean.exampleBean">
		<property name="anotherBean" ref="aotherBean"></property>
		<property name="otherBean" ref="otherBean"></property>
		<property name="i" value="333"></property>
</bean>
````

### 注解注入

````java
//第一个bean
@Repository
public class FirstBean {
	@Value("FirstBean")
	private String name;
	public void say() {
		System.out.println("my name is "+ name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
//第二个bean
@Repository
public class SecondBean {
	@Value("SecondBean")
	private String name;
	public void say() {
		System.out.println("my name is " + name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
//被注入
@Repository
public class exampleBean2 {
	@Inject
	private FirstBean FirstBean;
	@Autowired
	private SecondBean SecondBean;
	@Value("999")
	private int i;
}
````

### java方式注入

````java
@Configuration
@ComponentScan("cn.com.taiji.spring_framwork")//扫描的包
public class SampleConfig {
	//一个bean
	@Bean
	public anotherBean anotherBean() {
		anotherBean anotherBean = new anotherBean();
		anotherBean.setName("First");
		return anotherBean;
	}
	//另一个bean
	@Bean 
	public otherBean otherBean() {
		otherBean otherBean = new otherBean();
		otherBean.setName("Second");
		return otherBean;
	}
	//被注入的bean
	@Bean
	public exampleBean exampleBean() {
		exampleBean exampleBean = new exampleBean();
		exampleBean.setAnotherBean(anotherBean());
		exampleBean.setOtherBean(otherBean());
		exampleBean.setI(587);
		return exampleBean;		
	}
}

````

### 生命周期

````xml
<!--在beans添加 设置全局default-init-method="start" default-destroy-method="stop" -->
<!-- 单独添加 -->
<bean id="lifeBean" class="cn.com.taiji.spring_framwork.bean.LifeBean" init-method="start" destroy-method="stop"></bean>
````

````java
//注解方式
@PostConstruct //init
@PreDestroy //destory

````



## Springboot-study

### 创建方法

+ start.spring.io
+ IDE创建

### 默认配置为你教案

+ application.properties
+ application.yml

### 通过配置文件的属性注入给bean

```properties
yangye.name=yangye
yangye.age=99
yangye.sex=nan
#properties方式
```

````java
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix="yangye")
@Component
@Data //lambok插件
public class User {
	private String name;
	private int age;
	private String sex;
}

````

````yaml
my:
 name: yangye
 age: ${random.int(8000)}
 sex: 未知
 address: 蓟县
#yml方式
````

````java

@ConfigurationProperties(prefix="my")
@Component
@Data
public class yangyeBean {
	private String name;
	private int age;
	private String sex;
	private String address;	
}
````

### 在控制台输出消息

````java
//实现CommandLineRunner方式
@Component
@Order(2)  //从小到大决定order输出的顺序
public class OrderRunner2 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("OrderRunner2 is running......");
	}
	
}
//注解方式
	@Bean
public static ApplicationRunner testB() {
		ApplicationRunner runner = new ApplicationRunner() {
			
			@Override
			public void run(ApplicationArguments args) throws Exception {
				System.out.println("ApplicationRunner");
				for (String opt : args.getOptionNames()) {
					System.out.println(opt+"->");	System.out.println(args.getOptionValues(opt).stream().collect(Collectors.joining()));
				}	
			}
		};
return runner;
}
````

### 监听器

````java
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
````

### profile选择注入bean

````java
//接口
public interface MessageService {
	String getMessage();
}
//第一个实现类
@Service
@Profile({"goodbye","dev"})
public class HelloService implements MessageService {
	@Value("${name:World}")
	private String name;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "hello"+this.name;
	}
}
//第二个实现类
@Component
@Profile({"default","hello"})
public class GoodByeService implements MessageService {
	@Value("${name}")
	private String name;
	@Override
	public String getMessage() {
		
		return "goodbye"+name;
	}
}

````

````yaml
#application.yml
#指定的有 用指定的 没有用默认的
name: yangye
spring:
 profiles:
  active: dev #还可以调用另一个文件
---
spring:
 profiles: goodbye
name: yy
````

````yaml
#application-dev.yml
name: gouye
````

### 日志

````properties
#设置级别 和 输出日志到文件
logging.level.root=warn
logging.level.org.springframwork.web=debug
#loggin.file=my.log 
````

### 监控

````yaml
#在yml中进行额外的配置
management:
  security:
    enabled: false #关闭安全认证
  port: 8888 #开放端口号
  context-path: /abc  #目录
#配置端点
endpoints:
  actuator:
    enabled: true
  shutdown: 
    enabled: true
info:
  app:
    name: zhangxx
    version: 1.0.0
````

### Spring-admin

```xml
<!--在admin中添加依赖-->
<dependency>
			<groupId>de.codecentric</groupId>
			<artifactId>spring-boot-admin-starter-server</artifactId>
</dependency>

<dependency>
			<groupId>de.codecentric</groupId>
			<artifactId>spring-boot-admin-server-ui</artifactId>
</dependency>
<!-- 在被管理的项目添加依赖 -->
<dependency>
			<groupId>de.codecentric</groupId>
			<artifactId>spring-boot-admin-starter-client</artifactId>
			<version>1.5.6</version>
</dependency>
```

````java
//再启动服务添加注解
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
````

````properties
#在被管理项目中添加
spring.boot.admin.url=http://localhost:8000  
management.security.enabled=false
````

````yaml
#还可以用yml文件添加
spring:
  boot:
    admin:
      url: http://localhost:8000  
management:
  security:
    enabled: false #关闭安全认证
````

