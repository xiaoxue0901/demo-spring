package com.fall.aop.proxy1.factory;

import com.fall.aop.proxy1.advice.CglibMethodInterceptor;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/24
 * @time 20:34
 * @description
 */
public class CglibProxyFactory {
    /**
     * 产生代理对象
     * @param target
     * @return
     */
    public Object getCglibProxy(Class<?> target) {
        // 创建增强器
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target);
        // 设置回调方法
        enhancer.setCallback(new CglibMethodInterceptor());
        // 创建代理对象
        return enhancer.create();
    }
}
