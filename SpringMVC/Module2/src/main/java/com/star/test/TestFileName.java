package com.star.test;

import org.apache.commons.io.FilenameUtils;

import java.time.LocalDate;
import java.util.Date;

public class TestFileName {
    public static void main(String[] args) {
        String filename = "自我介绍aa.txt";

//        分隔符
        String[] split = filename.split("\\.");
        System.out.println(split[split.length - 1]);

//        字符串
        int i = filename.lastIndexOf(".");
        String substring = filename.substring(i);
        System.out.println(substring);

//        工具类
        String extension = FilenameUtils.getExtension(filename);
        System.out.println(extension);

        System.out.println(new Date());
        System.out.println(LocalDate.now());
    }
}
