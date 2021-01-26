package com.fall.ioc.anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/26
 * @time 18:07
 * @description
 */
public class SpringConfigurationTest {

    @Test
    public void cup() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        String[] beans = context.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println("bean:"+bean);
        }


    }
}