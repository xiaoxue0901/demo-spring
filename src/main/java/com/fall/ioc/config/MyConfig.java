package com.fall.ioc.config;

import com.fall.ioc.beans.Bird;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xql132@zcsmart.com
 * @date 2020/11/26
 * @time 11:50 下午
 * @description
 */
@Configuration
@ComponentScan("com.fall.ioc")
public class MyConfig {

    @Bean(initMethod = "init")
    public Bird bird() {
        return new Bird();
    }
}
