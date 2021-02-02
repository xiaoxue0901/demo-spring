package com.fall.cycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author xql132@zcsmart.com
 * @date 2021/2/2
 * @time 11:25
 * @description
 */
@Slf4j
public class StudentATest {

    @Test
    public void testCycle() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-student.xml");
        StudentA a = context.getBean("a", StudentA.class);
        log.info("a: {}", a.getStudentB());
    }
}