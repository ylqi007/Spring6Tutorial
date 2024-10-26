package com.atguigu.junit4;

import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/26/24 09:21
 */
@Component(value = "userJunit4")
//@Component
public class User {
    public void run() {
        System.out.println("com.atguigu.junit4.User.run()...");
    }
}
