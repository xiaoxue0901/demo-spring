package com.fall.quick.service;

import com.fall.quick.dao.DogDao;
import com.fall.quick.entity.Cat;
import com.fall.quick.entity.Dog;
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
