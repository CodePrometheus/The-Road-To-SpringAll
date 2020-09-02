package com.star.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

public class User {
    private String id;
    private String name;
    private Integer age;
    private Date bir;

    private List<String> list;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bir=" + bir +
                ", list=" + list +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public User(String id, String name, Integer age, Date bir) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bir = bir;
        this.list = list;
    }

    public List<String> getList(){
        return list;
    }

}
