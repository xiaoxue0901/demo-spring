package com.fall.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author xql132@zcsmart.com
 * @date 2021/2/4
 * @time 15:16
 * @description
 */
@Aspect
@Slf4j
@Component
public class LogAspect {

    @AfterReturning( returning = "name", value = "execution(* com.fall.aop.LoginService.login(..))")
    public void logReturn(Object name) {
        log.info("切面存日志return");
        log.info("存日志完成:{}", (String)name);
    }

    @Before("(execution(* com.fall.aop.LoginService.login(String,*)) || execution(* com.fall.aop.LoginService.updPwd(String,*))) && args(userId,*)")
    public void log(String userId) {
        log.info("存日志开始:{}", userId);
    }
}
