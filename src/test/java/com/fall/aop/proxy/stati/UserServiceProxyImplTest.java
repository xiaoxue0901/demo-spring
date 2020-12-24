package com.fall.aop.proxy.stati;

import com.fall.aop.proxy.target.UserService;
import com.fall.aop.proxy.target.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/24
 * @time 14:40
 * @description
 */
public class UserServiceProxyImplTest {

    @Test
    public void saveUser() {
        // 实例化目标类
        UserService target = new UserServiceImpl();
        // 实例化代理类
        UserServiceProxyImpl proxy = new UserServiceProxyImpl(target);
        // 通过调用代理类调用目标类
        proxy.saveUser();
    }
}