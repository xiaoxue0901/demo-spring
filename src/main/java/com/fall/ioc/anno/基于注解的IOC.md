#基于纯注解方式的使用

去掉xml后, 如何创建ApplicationContext, 之前的操作是
`ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc-mix.xml");`

## @Configuration
> @Configuration相当于spring的xml配置文件
> 配置类内部包含有一个或多个被@Bean注解的方法, 这些方法会被AnnotationConfigApplicationContext或
> AnnotationConfigWebApplicationContext类进行扫描, 并用于构建bean定义对象, 初始化spring容器

- 属性
    value: 用于指定配置类的字节码
- 示例代码  
