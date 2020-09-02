package beanpost;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCategroy {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanpost/spring.xml");
        Categroy categroy = (Categroy) context.getBean("categroy");
        System.out.println("name = " + categroy.getName());
    }
}
