package com.fail.quick.dao;

import org.springframework.stereotype.Repository;

/**
 * @author xql132@zcsmart.com
 * @date 2019/12/5 17:35
 * @description
 */
@Repository // 用在数据处理层
public class DogDao {

    public void insert() {
        System.out.println("存数据");
    }

}
