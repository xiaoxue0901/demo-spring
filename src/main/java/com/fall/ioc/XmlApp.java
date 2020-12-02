package com.fall.ioc;

import com.alibaba.fastjson.JSON;
import com.fall.ioc.beans.Bird;
import com.fall.ioc.beans.Dog;
import com.fall.ioc.beans.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/2
 * @time 16:13
 * @description
 */
@Slf4j
public class XmlApp {
    public static void main(String[] args) {
        xmlBean();
    }
    public static void xmlBean() {
        //配置spring-beans.xml: 声明bean
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beans.xml");
        // 获取ioc容器中的实例
        String[] beans = context.getBeanDefinitionNames();
        Arrays.stream(beans).forEach(e -> log.info("ioc中的bean::{}", e));
        // 读取user和user2
        User user = (User) context.getBean("user");
        log.info("user: {}", JSON.toJSONString(user));
        User user2 = (User) context.getBean("user2");
        log.info("user2: {}", JSON.toJSONString(user2));
        user2.getDogSet().stream().forEach(e -> log.info("set: {}",JSON.toJSONString(e)));


        Dog dog = context.getBean("dog", Dog.class);
        log.info("dog: {}", JSON.toJSONString(dog));

        // 读取dog: 此用法针对单例模式读取
        Bird bird = context.getBean(Bird.class);
        log.info("bird:{}", JSON.toJSONString(bird));
    }
}
