package com.star;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
@EnableAutoConfiguration//开启自动配置 初始化Spring SpringMVC环境 只能用在类上
实际作用 根据pom.xml文件中的依赖自动判断 spring-boot-starter-web
@EnableAutoConfiguration。这个注解告诉Spring Boot根据添加的jar依赖关系“猜测”您如何配置Spring。
 由于spring-boot-starter-web添加了Tomcat和Spring MVC，
 因此自动配置假定您正在开发Web应用程序并相应地设置Spring


@ComponentScan
用来扫描相关注解  扫描范围：当前入口类（Application）所在包及子包  只能作用在类上
*/


@SpringBootApplication //组合注解
@MapperScan("com.star.dao")
public class Application {

    public static void main(String[] args) {
/*
        应用类  用来启动spring boot应用
        参数   传入入口类的类对象  main参数
  main方法作用：我们应用程序的最后一部分是主要方法。这是遵循Java约定的应用程序入口点的标准方法。
  我们的主要方法通过调用run委托给Spring Boot 的 SpringApplication类。并告知当前springboot主应用类是谁
  SpringApplication会引导我们的应用程序，并启动Spring，后者反过来又会启动自动配置的Tomcat Web服务器。
  我们需要将Example.class作为参数传递给run方法，以告诉SpringApplication哪个是主要的Spring组件。
  args数组也通过传递以公开任何命令行参数
*/
        SpringApplication.run(Application.class, args);
    }
}

/*
在springboot中两种方式配置class，通过springboot管理自定义Java class
1，java config Java配置，自定义java对象管理  推荐
@Configuration注解类似于@Component注解 多个自定义对象管理（推荐）
@Import直接导入一个配置类  导入指定对象

2. xml方式配置，通过xml配置管理java对象  @ImportResource(".xml")
*/


