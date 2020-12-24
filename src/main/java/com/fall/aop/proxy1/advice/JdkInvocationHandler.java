package com.fall.aop.proxy1.advice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/24
 * @time 19:46
 * @description JDK动态代理执行类
 */
public class JdkInvocationHandler implements InvocationHandler {
    /**
     * 目标对象
     */
    private Object target;

    /**
     * 构造方法
     * @param target
     */
    public JdkInvocationHandler(Object target) {
        // invoke中需要用到目标类对象
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK代理: 增强操作");
        // JDK的反射: method是目标类的方法, 此处使用JDK反射API调用target的方法
        Object res = method.invoke(target, args);
        System.out.println("JDK代理: 增强操作");
        return res;
    }
}
