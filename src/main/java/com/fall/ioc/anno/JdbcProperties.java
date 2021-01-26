package com.fall.ioc.anno;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/26
 * @time 17:23
 * @description
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcProperties {
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

}
