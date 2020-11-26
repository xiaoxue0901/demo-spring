package com.fall.ioc.handler;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author xql132@zcsmart.com
 * @date 2020/11/26
 * @time 11:42 下午
 * @description
 */
@Component
public class JamesBaanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization..."+s+"..."+o);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization..."+s+"..."+o);
        return o;
    }
}
