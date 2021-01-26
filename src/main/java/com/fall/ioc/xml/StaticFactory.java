package com.fall.ioc.xml;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/26
 * @time 10:12
 * @description
 */
public class StaticFactory {

    /**
     * 模拟一个静态工厂, 创建业务层实现类
     * @return
     */
    public static UserService createUserService() {
        return new UserServiceImpl();
    }
}
