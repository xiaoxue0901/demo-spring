package com.fall.ioc.xml;

import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/26
 * @time 10:03
 * @description
 */

@Slf4j
public class UserServiceImplTest {

    @Test
    public void createBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc-xml.xml");
        UserServiceImpl userService = context.getBean("userService", UserServiceImpl.class);
        log.info("通过默认无参构造器创建类对象:{}", userService.hashCode());

        UserServiceImpl userService2 = context.getBean("userService2", UserServiceImpl.class);
        log.info("通过静态工厂创建类对象:{}", userService2.hashCode());

        UserServiceImpl userService3 = context.getBean("userService3", UserServiceImpl.class);
        log.info("通过实例工厂创建类对象:{}", userService3.hashCode());
    }

    @Test
    public void diTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-di.xml");
        // 1. 构造器方式注入
        UserServiceImpl userService4 = context.getBean("userService4", UserServiceImpl.class);
        userService4.addUser();
        // 2. set方式注入
        UserServiceImpl userService5 = context.getBean("userService5", UserServiceImpl.class);
        userService5.addUser();
    }
}