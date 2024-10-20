package com.atguigu;

import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/20/24 12:55
 */
public class UserTest {

    @Test
    public void test01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) applicationContext.getBean("user");
        user.add();

        User user1 = applicationContext.getBean(User.class);
        user1.add();

        System.out.println(user == user1);
    }
}
