package com.fall.aop;

import org.aspectj.lang.annotation.*;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/22
 * @time 16:00
 * @description AudienceNew只是一个java类, 只是通过注解表明会作为切面使用而已
 * 需要配置@EnableAspectJAutoProxy来启动自动代理
 */

@Aspect
public class AudienceAround {

    /**
     * 定义命名的切点
     */
    @Pointcut("execution(** com.fall.aop.Performance.perform(..))")
    public void performance(){}

    /**
     * 环绕通知
     */
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint point) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            System.out.println("CLAP!!!");
            point.process();
        } catch (Exception e) {
            System.out.println("Demaing a refund");
        }
    }
}
