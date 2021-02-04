package com.fall.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xql132@zcsmart.com
 * @date 2021/2/4
 * @time 15:15
 * @description
 */
@Service
@Slf4j
public class LoginService {


    public String login(String userId, String pwd) {
        log.info("用户登录:{}, {}", userId, pwd);
        return "李斯";
    }

    public void updPwd(String userId, String pwd) {
        log.info("修改密码:{}, {}", userId, pwd);
    }
}
