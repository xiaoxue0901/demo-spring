package com.fall.aop.proxy1.target;

import com.fall.aop.proxy1.RoleService;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/24
 * @time 15:56
 * @description 目标类
 */
public class RoleServiceImpl implements RoleService {
    @Override
    public int saveRole() {
        System.out.println("JDK动态代理目标类: 新增角色");
        return 0;
    }
}
