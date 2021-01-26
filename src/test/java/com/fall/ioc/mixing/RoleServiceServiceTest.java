package com.fall.ioc.mixing;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/26
 * @time 14:08
 * @description
 */
public class RoleServiceServiceTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc-mix.xml");
        // 注解@Service和xml配置<context:componentScan>混合使用创建bean实例
        RoleService roleService = context.getBean("roleServiceImpl", RoleServiceImpl.class);
        roleService.addRole();
    }

    @Test
    public void addRole() {
    }
}