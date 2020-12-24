package com.fall.aop.proxy.stati;

import com.fall.aop.proxy.target.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/24
 * @time 14:37
 * @description
 */
@Slf4j
public class UserServiceProxyImpl implements UserService {

    private UserService userService;

    public UserServiceProxyImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void saveUser() {
        log.info("代理类可以在此处做处理");
        userService.saveUser();
        log.info("代理类可以在此处做处理");
    }
}
