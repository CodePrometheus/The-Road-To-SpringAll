package life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean, DisposableBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("set调用");
        this.name = name;
    }

    //public class Product {
    public Product() {
        System.out.println("创建对象product");
    }


    public void myMethod() {
        System.out.println("实现方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化操作afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁操作destroy");
    }

    public void myDestroy(){
        System.out.println("自定义destroy");
    }
}
