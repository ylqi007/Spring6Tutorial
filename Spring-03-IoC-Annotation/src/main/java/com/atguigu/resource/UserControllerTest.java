package com.atguigu.resource;

import com.atguigu.resource.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/20/24 13:22
 */
public class UserControllerTest {
    @Test
    public void test01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserController userController = applicationContext.getBean("resourceUserController", UserController.class);
        userController.add();
    }
}
