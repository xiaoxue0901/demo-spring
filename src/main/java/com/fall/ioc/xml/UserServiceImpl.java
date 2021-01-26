package com.fall.ioc.xml;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/26
 * @time 9:57
 * @description
 */
@Slf4j
public class UserServiceImpl implements UserService{

    private int id;
    private String name;

    public UserServiceImpl(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public UserServiceImpl() {
        log.info("********构造类实例成功*************");
    }



    @Override
    public void addUser() {
        log.info("保存用id:{}, name:{} service实现", id, name);
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
