package com.fall.ioc.beans.annobeans;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/2
 * @time 16:21
 * @description
 */
@Data
@Component
public class Teacher {
    private String name;
    private String sex;
}
