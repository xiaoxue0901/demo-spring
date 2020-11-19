package com.fail.quick.service;

import com.fail.quick.dao.DogDao;
import com.fail.quick.entity.Cat;
import com.fail.quick.entity.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author xql132@zcsmart.com
 * @date 2019/12/5 17:34
 * @description
 */
@Service
public class UserService {

    @Autowired
    DogDao dogDao;

    @Autowired
    @Qualifier("createFactory")
    Cat cat;

    /**
     * JSR250的用法
     */
    @Resource
    Dog dog;

    @PostConstruct
    public void print() {
        dogDao.insert();
        System.out.println("使用的cat"+cat);
        System.out.println("使用的dog"+dog);
    }

}
