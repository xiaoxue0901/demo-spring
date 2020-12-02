package com.fall.ioc.beans;

import lombok.Data;

/**
 * @author xql132@zcsmart.com
 * @date 2020/11/24
 * @time 13:50
 * @description
 */
@Data
public class Bird {
    private String name;

    private User user;

    public Bird(User user) {
        this.user = user;
    }

    public Bird(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("bird start");
    }

    public void destory() {
        System.out.println("bird dead");
    }
}
