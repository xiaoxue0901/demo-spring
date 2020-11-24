package com.fall.quick.entity;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author xql132@zcsmart.com
 * @date 2019/12/5 16:50
 * @description
 */
public class CatFactory implements FactoryBean<Cat> {
    @Override
    public Cat getObject() {
        return new Cat();
    }

    @Override
    public Class<?> getObjectType() {
        return Cat.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
