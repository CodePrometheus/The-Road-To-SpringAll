package aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop/spring.xml");
        EmpService p = context.getBean("/empService", EmpService.class);
        EmpService p1 = context.getBean("empService", EmpService.class);
        System.out.println("p1 = " + p1);
        System.out.println("p = " + p);
        String[] Names = context.getBeanDefinitionNames();
        for (String name : Names) {
            System.out.println("name = " + name);
        }
        System.out.println("=================");

        //根据类型获得id值
        String[] beanNamesForType = context.getBeanNamesForType(EmpService.class);
        for (String s : beanNamesForType) {
            System.out.println("s = " + s);
        }
        System.out.println("=================");

        boolean beanDefinition = context.containsBeanDefinition("2p");
        System.out.println("beanDefinition 是否存在 " + beanDefinition);
        System.out.println("=================");

        boolean b = context.containsBean("2p");
        System.out.println("b = " + b);


//        empService.find("Spring");
    }


    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/spring.xml");
        Emp emp = (Emp) context.getBean("emp1");
        System.out.println("emp = " + emp);
        String[] email = emp.getEmail();
        for (String s : email) {
            System.out.println("s = " + s);
        }
        System.out.println("=============");
        Set<String> tels = emp.getTels();
        for (String tel : tels) {
            System.out.println("tel = " + tel);
        }
        System.out.println("=============");
        List<String> addr = emp.getAddr();
        for (String ad : addr) {
            System.out.println("addr = " + ad);
        }
        System.out.println("=============");
        Map<String, String> qqs = emp.getQqs();
        Set<String> keys = qqs.keySet();
        for (String key : keys) {
            System.out.println("key = " + key + "   value = " + qqs.get(key));
        }
        System.out.println("=============");
        Properties prop = emp.getProp();
        for (String key : prop.stringPropertyNames()) {
            System.out.println(key + "=" + prop.getProperty(key));
        }
    }

//    测试构造方法
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/spring.xml");
        Customer customer = (Customer) context.getBean("customer");
        System.out.println("customer = " + customer);

    }
}
