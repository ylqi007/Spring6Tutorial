package com.atguigu.resource;

import com.atguigu.config.SpringConfig;
import com.atguigu.resource.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/20/24 13:22
 */
public class UserControllerConfigTest {
    @Test
    public void test01() {
        // 加载配置类，
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserController userController = applicationContext.getBean("resourceUserController", UserController.class);
        userController.add();
    }
}
