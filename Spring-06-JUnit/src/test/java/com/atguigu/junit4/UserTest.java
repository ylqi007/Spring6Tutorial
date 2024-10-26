package com.atguigu.junit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/26/24 09:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:bean.xml")
public class UserTest {

    @Autowired
    @Qualifier("userJunit4")
    private User user;

    @Test
    public void test01() {
        user.run();
    }

}