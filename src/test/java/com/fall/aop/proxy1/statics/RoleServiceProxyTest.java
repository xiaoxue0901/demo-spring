package com.fall.aop.proxy1.statics;

import com.fall.aop.proxy1.RoleService;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/24
 * @time 15:23
 * @description 静态代理测试
 */
public class RoleServiceProxyTest {
    @Test
    public void saveRole() {
        // 目标类
        RoleService target = new RoleServiceImpl();
        // 代理类
        RoleServiceProxy proxy = new RoleServiceProxy(target);
        // 通过调用代理类的方法从而调用目标类
        int result = proxy.saveRole();
        Assert.assertEquals(1, result);
    }
}