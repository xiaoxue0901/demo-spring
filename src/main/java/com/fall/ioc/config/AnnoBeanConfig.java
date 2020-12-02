package com.fall.ioc.config;

import com.fall.ioc.beans.EmptyConfig;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xql132@zcsmart.com
 * @date 2020/12/2
 * @time 16:19
 * @description
 */
// basePackages: 扫描指定的包下面的@Component或其他Spring组件注解的类
// @ComponentScan(basePackages = {"com.fall.ioc.beans","com.fall.ioc.config"}
// basePackageClasses: 扫描EmptyConfig.class下的类和下级的所有的包.
@ComponentScan(basePackageClasses = EmptyConfig.class)
public class AnnoBeanConfig {
}
