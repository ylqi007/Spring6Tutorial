package com.atguigu.pojo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Description:
 */
@Component(value = "user")  // 默认是类的首字母小写
// @Repository
// @Service
// @Controller
public class User {

    public User() {
        System.out.println("User 的无参构造器");
    }

    public void add() {
        System.out.println("User.add() ...");
    }
}
