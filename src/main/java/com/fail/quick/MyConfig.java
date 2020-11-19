package com.fail.quick;

import com.fail.quick.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @author xql132@zcsmart.com
 * @date 2019/12/5 16:43
 * @description Spring注入Bean 的方式
 */
@Configuration
public class MyConfig {

    /**
     * 方式1: 直接使用@Bean注解, bean的名称不指定,则是方法名: dog
     * @return
     */
    @Bean
    public Dog dog() {
        return new Dog();
    }

    /**
     * LittleDog的bean的名称是puppy
     * 初始化bean方式2: 使用initMethod和destoryMethod初始化和销毁bean
     * @return
     */
    @Bean(name = "puppy", initMethod = "init", destroyMethod = "close")
    public LittleDog createLittleDog() {
        return new LittleDog();
    }


    /**
     * FactoryBean 工厂方式
     * @return
     */
    @Bean
    public CatFactory createFactory() {
        return new CatFactory();
    }

    @Bean
    @Primary // 发现多个bean, 则使用此注解对应的bean. 即不会使用createFactory产生的bean
    public Cat cat() {
        return createFactory().getObject();
    }

    @Bean
    @Scope
    public JeepFctory createJeepFactory() {
        return new JeepFctory();
    }

    /**
     * Spring容器会从MyConfig中获取到factory注入.
     * @param factory
     * @return
     */
    @Bean
    public Jeep jeep(JeepFctory factory) {
        return factory.creat();
    }



}
