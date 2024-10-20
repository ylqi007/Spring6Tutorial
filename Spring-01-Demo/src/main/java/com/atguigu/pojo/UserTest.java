package com.atguigu.pojo;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/19/24 21:40
 */
public class UserTest {

    @Test
    public void test01() {
        // 1. 加载Spring的配置文件，对象创建
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        // 2. 获取创建的对象
        User user = (User) applicationContext.getBean("user");

        // 3. 使用对象进行测试
        System.out.println("user = " + user);
        user.add();
    }

    /**
     * 通过反射创建对象
     */
    @Test
    public void test02() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取Class对象
        Class<?> clazz = Class.forName("com.atguigu.pojo.User");

        // 调用方法创建对象
        User user = (User)clazz.getDeclaredConstructor().newInstance();

        System.out.println("test02: user = " + user);
    }
}
