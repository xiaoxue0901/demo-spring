package com.fall.ioc.xml;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/26
 * @time 10:26
 * @description 实例工厂
 * 模拟一个实例工厂, 创建业务层实现类
 * 此工厂创建对象, 必须有现有工厂实例对象, 再调用方法
 */
public class InstanceFactory {
    public UserService createUserService() {
        return new UserServiceImpl();
    }

}
