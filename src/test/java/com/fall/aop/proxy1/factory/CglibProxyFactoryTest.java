package com.fall.aop.proxy1.factory;

import com.fall.aop.proxy.target.UserService;
import com.fall.aop.proxy.target.UserServiceImpl;
import com.fall.aop.proxy1.RoleService;
import com.fall.aop.proxy1.target.RoleServiceImpl;
import org.junit.Test;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/24
 * @time 18:37
 * @description
 */
public class CglibProxyFactoryTest {

    @Test
    public void getProxy() {
        // 工厂类
        CglibProxyFactory factory = new CglibProxyFactory();
        // 产生代理对象
        RoleService proxy = (RoleServiceImpl)factory.getCglibProxy(RoleServiceImpl.class);
        proxy.saveRole();
        // 产生代理对象
        UserService userProxy = (UserService) factory.getCglibProxy(UserServiceImpl.class);
        userProxy.saveUser();
    }

}