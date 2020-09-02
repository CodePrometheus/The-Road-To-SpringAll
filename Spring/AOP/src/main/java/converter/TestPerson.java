package converter;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("converter/spring.xml");
        Person person = (Person) context.getBean("person");
        System.out.println("person = " + person);
        System.out.println("bir = " + person.getBir());
    }
}
