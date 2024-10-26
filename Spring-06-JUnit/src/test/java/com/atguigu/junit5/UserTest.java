package com.atguigu.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


/**
 * Description:
 *  Method 1: @SpringJUnitConfig(locations = "classpath:bean.xml")  [更常用]
 *  Method 2: @ExtendWith(SpringExtension.class) + @ContextConfiguration(value = "classpath:bean.xml")
 *
 * @Author: ylqi007
 * @Create: 10/26/24 09:15
 */
// @SpringJUnitConfig(locations = "classpath:bean.xml")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = "classpath:bean.xml")
class UserTest {

    @Autowired
    private User user;

    @Test
    public void test01() {
        user.run();
    }

}