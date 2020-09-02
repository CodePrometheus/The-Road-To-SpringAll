package life;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLife {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("life/spring.xml");
        Product product = (Product) context.getBean("product");
        context.close();
//        System.out.println("product = " + product);
    }
}
