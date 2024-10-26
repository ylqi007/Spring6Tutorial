package com.atguigu.aopannotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/25/24 22:34
 */
class CalculatorTest {

    @Test
    public void testAdd() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = applicationContext.getBean(Calculator.class);
        calculator.add(6, 7);
    }

}