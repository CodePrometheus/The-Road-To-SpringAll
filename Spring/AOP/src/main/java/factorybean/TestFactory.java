package factorybean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class TestFactory {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("factorybean/spring.xml");
        Connection connection = (Connection) context.getBean("connection");
        Connection connection1 = (Connection) context.getBean("connection");
        System.out.println("connection = " + connection);
        System.out.println("connection1 = " + connection1);
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("factorybean/spring.xml");
        ConnectionFactoryBean connection = (ConnectionFactoryBean) context.getBean("&connection");
        System.out.println("connection = " + connection);
    }

//    测试实例工厂
    @Test
    public void test3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("factorybean/spring.xml");
        Connection connection = (Connection) context.getBean("connection");
        System.out.println("connection = " + connection);
    }
}
