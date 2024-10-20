package com.atguigu;

import com.atguigu.controller.UserController;
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
        UserController userController = applicationContext.getBean(UserController.class);
        userController.add();
    }
}
