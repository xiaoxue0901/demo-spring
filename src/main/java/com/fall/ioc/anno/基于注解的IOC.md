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
```java
@Configuration
public class SpringConfiguration {
    /**
     * spring容器初始化时, 会调用配置类的无参构造函数
     */
    public SpringConfiguration() {
        System.out.println("容器启动初始化");
    }
```

## @Bean
> 相当于<bean>标签
> 作用为: 注册bean对象, 主要用来配置非自定义的bean.
> @Bean注解在方法上.
> 属性: name:给当前@Bean注解方法创建的对象指定一个名称(即bean的id). 如果不指定, 默认与标注的方法名相同
> @Bean注解默认作用域为单例singletion作用域, 可通过@Bean("prototype")设置为原型作用域
```java
    @Bean
    @Scope("prototype")
    public Cup cup() {
        return new Cup();
    }
```

##@ComponentScan
> 相当于context:component-scan标签
> 组件扫描器, 扫描@Component,@Service, @Repository注解的类
> 改注解是编写在类上面的, 一般配合@Configuration注解一起使用

> 属性: 
> 1. basePackages: 用于指定要扫描的包
> 2. value: 和basePackages作用一样

##@PropertiySource
> 相当于context:property-placeholder标签, 编写在类上面, 作用是加载properties配置文件
> 属性-value[]: 用于指定properties文件路径, 如果在类路径下, 需要协商classpath
```java
@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcProperties {
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

}
```

## 创建纯注解方式上下文容器
```java
ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        String[] beans = context.getBeanDefinitionNames();
```