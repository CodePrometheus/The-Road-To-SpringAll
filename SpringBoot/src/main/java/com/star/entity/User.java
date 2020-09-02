package com.star.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User {
    private String id;
    private String name;
    private int age;
    private Date date;


}
