package com.fail.quick.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author xql132@zcsmart.com
 * @date 2019/12/5 16:43
 * @description Bean的初始化和销毁通过实现InitialzingBean和DisposableBean实现
 */
public class Dog implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("====destory======");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=======start=========");
    }
}
