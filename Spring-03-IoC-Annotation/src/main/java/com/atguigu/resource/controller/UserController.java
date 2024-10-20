package com.atguigu.resource.controller;

import com.atguigu.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/20/24 13:15
 */
@Controller(value = "resourceUserController")
public class UserController {

    // 方式一：根据name注入
//    @Resource(name = "resourceUserServiceImpl")
//    private UserService userService;

    // 方式二: 当@Resource注解使⽤时没有指定name的时候，还是根据name进⾏查找，这个name是属性名
    @Resource
    private UserService resourceUserServiceImpl;

    // 方式三: 当方式一和二均不满足时，可以根据byType进行注入。byType注⼊时，某种类型的Bean只能有⼀个

    public void add() {
        System.out.println("执行 UserController.add() --> UserService.add() ...");
        // userService.add();
        resourceUserServiceImpl.add();
    }
}
