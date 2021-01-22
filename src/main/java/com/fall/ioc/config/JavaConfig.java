package com.fall.ioc.config;

import com.fall.aop.AudiencePointCut;
import com.fall.ioc.beans.Bird;
import com.fall.ioc.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/2
 * @time 18:32
 * @description
 */
@Configuration
// @EnableAspectJAutoProxy启动AspectJ自动代理
@EnableAspectJAutoProxy
public class JavaConfig {

    @Bean(name = "bird2", initMethod = "init", destroyMethod = "destory")
    public Bird bird() {
        return new Bird(user());
    }

    @Bean
    public User user() {
        return new User();
    }


    /**
     * 声明@Audience bean
     * @return
     */
    @Bean
    public AudiencePointCut audienceNew() {return new AudiencePointCut();}
}
