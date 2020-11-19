package com.fail.quick;

import com.fail.quick.dao.DogDao;
import com.fail.quick.entity.Cat;
import com.fail.quick.entity.CatFactory;
import com.fail.quick.entity.Dog;
import com.fail.quick.entity.Jeep;
import com.fail.quick.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xql132@zcsmart.com
 * @date 2019/12/5 16:42
 * @description
 */
public class MyBean {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class, UserService.class, DogDao.class);
        // 使用xxx.class获取bean
        System.out.println(context.getBean(Dog.class));
        // 使用bean的名字获取bean
        System.out.println(context.getBean("dog"));
        // 使用bean的名字获取bean
        System.out.println(context.getBean("puppy"));
        // 使用FactoryBean
        // cat
        System.out.println(context.getBean(Cat.class));
        // cat
        System.out.println(context.getBean("createFactory"));
        // CatFactory
        System.out.println(context.getBean(CatFactory.class));
        System.out.println(context.getBean("&createFactory"));

        System.out.println(context.getBean(Jeep.class));

        System.out.println(context.getBeansOfType(UserService.class));
        context.close();
    }
}
