package com.fall.aop;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/18
 * @time 18:51
 * @description 编写切点
 */
public interface Performance {
    /**
     * 执行切点的表达式:
     * execution(* com.fall.aop.Performance.perform(..))
     */
    public void perform();

}
