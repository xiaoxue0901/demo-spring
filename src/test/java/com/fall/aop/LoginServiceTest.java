package com.fall.aop;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @author xql132@zcsmart.com
 * @date 2021/2/4
 * @time 15:21
 * @description
 */
@Slf4j
public class LoginServiceTest {

    @Test
    public void login() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        LoginService loginService = context.getBean(LoginService.class);
        loginService.login("张武", "123456");
        // loginService.updPwd("李四", "iydiidi");
    }
}