package com.atguigu.aop;


import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/25/24 21:41
 */
class CalculatorTest {

    @Test
    public void test01() {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getProxy();

        proxy.mul(2, 2);
    }

}