package com.fall.ioc;

import com.fall.ioc.beans.Bird;
import com.fall.ioc.config.JavaConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/2
 * @time 18:42
 * @description java配置方式实现装配bean: 用于第三方的类
 */
@Slf4j
public class ConfigApp {
    public static void main(String[] args) {
        // 1.@Configuration声明一个配置类, 类似于spring-beans.xml
        // 2.@Bean声明一个bean.
        // 3. 应用上下文加载bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Bird bird = context.getBean(Bird.class);
        log.info("小鸟:{}, 小鸟主任:{}", bird.getName(),bird.getUser());
        context.close();
    }
}
