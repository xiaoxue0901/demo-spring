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
public class AudiencePointCut {

    /**
     * 定义命名的切点
     */
    @Pointcut("execution(** com.fall.aop.Performance.perform(..))")
    public void performance(){}
    /**
     * 表演前:手机静音
     * 使用了通知注解来表明方法(silenceCellPhones)应该在什么时候调用.
     * @Before: 通知方法(silenceCellPhones)会在目标对象调用之前执行
     */
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    /**
     * 表演前:就坐
     */
    @Before("performance()")
    public void taskSeats() {
        System.out.println("Tasking seats");
    }

    /**
     * 表演后:鼓掌
     * @AfterReturning: 通知方法(applause)会在目标方法(perform)返回后调用
     */
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP !!!");
    }

    /**
     * 表演失败退款
     * @AfterThrowing: 通知方法(demandRefund)会在目标方法(perform)抛出异常后调用
     */
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
