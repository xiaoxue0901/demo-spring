package com.fall.ioc.mixing;

import com.fall.ioc.xml.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/26
 * @time 14:07
 * @description
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService{
    @Value("${pwd}")
    private String pwd;

    private int id;
    private String name;

    @Autowired
    @Qualifier("userService")
    private UserService userService;


    @Override
    public void addRole() {
        log.info("新增角色");
    }
}
