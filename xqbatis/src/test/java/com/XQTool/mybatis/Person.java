package com.XQTool.mybatis;

import lombok.Data;

/**
 * @ClassName Person
 * @Description TODO
 * @Author admin
 * @Date 2022/10/13 15:50
 * @Version 1.0
 **/

@Data
public class Person {
    private String username;
    private String password;
    private int age;
    private Leg leg;

}
