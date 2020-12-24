package com.fall.aop.proxy1.factory;

import com.fall.aop.proxy1.RoleService;
import com.fall.aop.proxy1.target.RoleServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/24
 * @time 16:22
 * @description
 */
public class JdkProxyFactoryTest {

    @Test
    public void getProxyInstance() {
        // 目标类
        RoleService roleService = new RoleServiceImpl();
        // 代理工厂
        JdkProxyFactory factory = new JdkProxyFactory();
        // 代理类
        RoleService proxy = (RoleService) factory.getJdkProxy(roleService);
        // 代理类调用和目标类实现的同样的接口的方法
        int res = proxy.saveRole();
        System.out.println("result:"+res);
    }
}