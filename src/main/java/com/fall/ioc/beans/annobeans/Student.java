package com.fall.ioc.beans.annobeans;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/2
 * @time 16:20
 * @description
 */
@Data
@Component
public class Student {
    private String name;
    private int age;
    private String clazz;
    private Teacher teacher;
}
