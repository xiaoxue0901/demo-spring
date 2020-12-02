package com.fall.ioc;

import com.fall.ioc.beans.annobeans.Activition;
import com.fall.ioc.config.AnnoBeanConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/2
 * @time 16:17
 * @description
 */
@Slf4j
public class AnnotationApp {
    public static void main(String[] args) {
        // 1.使用@Component注解声明bean
        // 2.使用@ComponentScan注解扫描@Component并启用注解
        // 3. 使用应用上下文获取bean.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnoBeanConfig.class);
        String[] beans =context.getBeanDefinitionNames();
        for (String bean : beans) {
            log.info("创建的bean:{}", bean);
        }
        Activition activition = context.getBean(Activition.class);
        activition.teach();

    }
}
