package com.fall.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xql132@zcsmart.com
 * @date 2021/2/4
 * @time 15:22
 * @description
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.fall.aop")
public class AopConfig {

}
