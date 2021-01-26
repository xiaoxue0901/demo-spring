package com.fall.ioc.anno;

import org.springframework.context.annotation.*;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/26
 * @time 16:57
 * @description
 */
@Configuration
@ComponentScan(basePackages = {"com.fall.ioc.anno"})
@Import({JdbcProperties.class})
public class SpringConfiguration {
    /**
     * spring容器初始化时, 会调用配置类的无参构造函数
     */
    public SpringConfiguration() {
        System.out.println("容器启动初始化");
    }

    @Bean
    @Scope("prototype")
    public Cup cup() {
        return new Cup();
    }
}
