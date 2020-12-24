package com.fall.aop.proxy1.statics;

import com.fall.aop.proxy1.RoleService;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/24
 * @time 15:20
 * @description 静态代理类
 */
public class RoleServiceProxy implements RoleService {
    /**
     * 目标类
     */
    private RoleService roleService;

    public RoleServiceProxy(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public int saveRole() {
        System.out.println("代理类:增强操作1");
        // 调用目标类
        int result = roleService.saveRole();
        System.out.println("代理类:增强操作2");
        return result;
    }
}
