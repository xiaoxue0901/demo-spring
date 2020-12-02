package com.fall.ioc.beans.annobeans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/2
 * @time 16:22
 * @description
 */
@Slf4j
@Component
public class Activition {
    @Autowired
    private Teacher teacher;
    @Autowired
    private Student student;

    // @Autowired
    // public Activition(Teacher teacher, Student student) {
    //     log.info("教学活动*******");
    //     log.info("老师:{}, 学生:{}", teacher.getName(), student.getName());
    // }

    public void teach() {
      log.info("教学活动开始*******");
    }
}
