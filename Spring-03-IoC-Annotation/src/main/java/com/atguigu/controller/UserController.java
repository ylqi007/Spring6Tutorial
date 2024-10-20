package com.atguigu.controller;

import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/20/24 13:15
 */
@Controller
public class UserController {

    // 注入userService
    // 第一种方式：属性注入
//    @Autowired
//    private UserService userService;

    // 第二种方式: set方法注入
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        System.out.println("UserController: 通过set方法注入");
//        this.userService = userService;
//    }

    // 第三种方式: 构造器注入
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        System.out.println("UserController: 通过constructor注入");
//        this.userService = userService;
//    }

    // 第四种方式: 形参上注入
//    private UserService userService;
//
//    public UserController(@Autowired UserService userService) { // 注意与方式三的区别，此时并不是加在构造器上，而是构造器的参数上
//        System.out.println("UserController: 通过形参注入");
//        this.userService = userService;
//    }

    // 第五种方式: 只有一个有参数构造器，无注解
//    private UserService userService;
//
//    public UserController(UserService userService) { // 注意与方式三的区别，此时并不是加在构造器上，而是构造器的参数上
//        System.out.println("有参数的UserController构造器，无注解");
//        this.userService = userService;
//    }

    // 第六种方式: @Autowired + @Qualifier
    @Autowired
    @Qualifier(value = "userRedisServiceImpl")
    private UserService userService;

    public void add() {
        System.out.println("执行 UserController.add() --> UserService.add() ...");
        userService.add();
    }
}
