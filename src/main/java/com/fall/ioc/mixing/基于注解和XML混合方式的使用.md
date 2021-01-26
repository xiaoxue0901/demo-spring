# 基于注解和XML混合方式的使用

第一步: spring配置文件中, 配置如下标签
```xml
   <!--开启注解并扫描指定包中带有注解的类-->
    <context:component-scan base-package="com.fall.ioc.mixing"/>
```

第二步: 类上加上注解@Component, 或者它的衍生注解@Controller, @Service, @Repository
```java
@Service
public class RoleServiceImpl implements RoleService{}
```

@Component注解
> 作用: 把资源让spring来管理, 相当于在xml中配置一个bean.
> 属性value: 指定bean的id, 如果不指定value属性, 默认bean的id就是当前类的类名, 首字母小写.

@Controllor, @Service, @Repository注解
> 是@Component的衍生注解, 他们作用及属性都是一样的.只不过是提供了更加明确的语义化.
> @Controller: 一般用于表现层的注解
> @Service: 一般用于业务层的注解
> @Repository: 一般用于持久层的注解

## 依赖注入的注解
- @Autowire
> 1. 按类型匹配(byType)
> 2. 由AutowiredAnnotationBeanPostProcessor类实现
> 3. 是Spring自带的注解
> 4. 默认情况下要求依赖对象必须存在, 如果需要允许null值, 可以设置required属性为false, 如:@Autowire(required=false)
> 5. 如果想按名称装配可以结合@Qualifier注解进行使用.

- @Qualifier
> 1. 在自动按照类型注入的基础上,再按照bean的id注入.
> 2. 在给字段注入时不能独立使用, 必须和@Autowire一起使用
> 3. 可以独立给方法参数注入.

- @Resource
> 1. 默认按名称装配, 可以通过@Resource的name属性指定名称.
> 2. 如果没有指定name属性, 当注解写在字段上时, 默认按字段名称进行查找. 当找不到与名称匹配的bean时,才安装bean的类型进行匹配

- @Value
> 1. 给基本类型和String类型注入值
> 2. 可以使用占位符获取属性文件中的值
```java
   @Value("${pwd}")
    private String pwd;
```

## 改变bean作用范围的注解
- @Scope: 指定bean的作用范围
> 属性: value: 指定范围的值. 取值: singleton, prototype, request, session, globalsession

## 生命周期相关的注解
- @PostConstruct, 相当于init-method
- @PreDestory, 相当于destory-method



