package aop;

import org.springframework.context.annotation.Lazy;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public Customer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Customer(Integer age) {
        this.age = age;
    }
}
