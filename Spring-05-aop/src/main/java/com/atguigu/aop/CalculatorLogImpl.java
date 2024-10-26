package com.atguigu.aop;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/25/24 16:29
 */
public class CalculatorLogImpl implements Calculator {
    /**
     * 问题：日志与核心代码混合
     * 解决思路: 代理模式
     * @param i
     * @param j
     * @return
     */
    @Override
    public int add(int i, int j) {
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);

        int result = i + j;
        System.out.println("方法内部 result = " + result);

        System.out.println("[日志] add 方法结束了，结果是：" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("[日志] sub 方法开始了，参数是：" + i + "," + j);

        int result = i - j;
        System.out.println("方法内部 result = " + result);

        System.out.println("[日志] sub 方法结束了，结果是：" + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("[日志] mul 方法开始了，参数是：" + i + "," + j);

        int result = i * j;
        System.out.println("方法内部 result = " + result);

        System.out.println("[日志] mul 方法结束了，结果是：" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("[日志] div 方法开始了，参数是：" + i + "," + j);

        int result = i / j;
        System.out.println("方法内部 result = " + result);

        System.out.println("[日志] div 方法结束了，结果是：" + result);
        return result;
    }
}
