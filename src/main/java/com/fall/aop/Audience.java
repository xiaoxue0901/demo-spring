package com.fall.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/22
 * @time 15:17
 * @description 使用AspectJ注解定义切面
 * Audience类中的方法使用注解定义切面的具体行为
 */
// @Aspect:表明Audience不仅仅是一个POJO, 还是一个切面
@Aspect
public class Audience {

    /**
     * 表演前:手机静音
     * 使用了通知注解来表明方法(silenceCellPhones)应该在什么时候调用.
     * @Before: 通知方法(silenceCellPhones)会在目标对象调用之前执行
     */
    @Before("execution(** com.fall.aop.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    /**
     * 表演前:就坐
     */
    @Before("execution(** com.fall.aop.Performance.perform(..))")
    public void taskSeats() {
        System.out.println("Tasking seats");
    }

    /**
     * 表演后:鼓掌
     * @AfterReturning: 通知方法(applause)会在目标方法(perform)返回后调用
     */
    @AfterReturning("execution(** com.fall.aop.Performance.perform(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP !!!");
    }

    /**
     * 表演失败退款
     * @AfterThrowing: 通知方法(demandRefund)会在目标方法(perform)抛出异常后调用
     */
    @AfterThrowing("execution(** com.fall.aop.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
