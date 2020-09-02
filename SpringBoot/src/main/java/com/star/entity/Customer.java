package com.star.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Customer {
    private Integer id;
    private String name;
    private String email;
    private Date birth;

}
