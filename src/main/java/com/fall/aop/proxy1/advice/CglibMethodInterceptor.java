package com.fall.aop.proxy1.advice;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/24
 * @time 20:29
 * @description
 */
public class CglibMethodInterceptor implements MethodInterceptor {
    /**
     *
     * @param o 代理类
     * @param method 目标对象方法
     * @param objects 目标对象方法参数
     * @param methodProxy 代理对象调用目标对象的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB代理:增强操作");
        // CGLIB通过子类调用父类的方法实现目标类的调用
        Object res = methodProxy.invokeSuper(o, objects);
        System.out.println("CGLIB代理:增强操作");
        return res;
    }
}
