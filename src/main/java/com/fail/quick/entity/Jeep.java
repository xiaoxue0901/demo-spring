package com.fail.quick.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xql132@zcsmart.com
 * @date 2019/12/5 17:28
 * @description
 */
public class Jeep {
    @PostConstruct
    public void init(){
        System.out.println("--------init jeep--------");
    }

    @PreDestroy
    public void close() {
        System.out.println("-------------close jeep--------");
    }
}
