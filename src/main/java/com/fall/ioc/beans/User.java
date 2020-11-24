package com.fall.ioc.beans;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xql132@zcsmart.com
 * @date 2020/11/24
 * @time 11:17
 * @description
 */
@Data
@Slf4j
public class User {
    private String name;
    private int age;
    private String sex;
    private Dog dog;
    private List<Integer> intList;
    private List<Dog> dogList;
    private Set<Dog> dogSet;
    private Map<Integer, Dog> dogMap;

    public User() {
    }

    public User(String name, Dog dog, List<Dog> dogList) {
        this.name = name;
        this.dog = dog;
        this.dogList = dogList;
    }

    public void init() {
        log.info("*********开始*********");
    }

    public void destory() {
        log.info("*********结束*********");
    }

    public void destory2() {
        log.info("*********结束2*********");
    }
}
