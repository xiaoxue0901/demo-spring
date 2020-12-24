package com.fall.aop.proxy1.statics;

import com.fall.aop.proxy1.RoleService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/24
 * @time 15:11
 * @description 目标类
 */
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Override
    public int saveRole() {
        log.info("目标类::新增角色");
        return 1;
    }
}
