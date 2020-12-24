package com.fall.aop.proxy1.factory;

import com.fall.aop.proxy1.advice.JdkInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/24
 * @time 19:58
 * @description 工厂: 动态产生代理实例
 */
public class JdkProxyFactory {

    /**
     * 获取一个代理类实例
     * @param target
     * @return
     */
    public Object getJdkProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new JdkInvocationHandler(target));
    }

}
