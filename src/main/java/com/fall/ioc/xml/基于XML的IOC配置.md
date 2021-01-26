# 基于XML的IOC配置
## bean实例化的三种方式
* 第一种: 使用默认的无参构造器
>在默认情况下, 它会根据无参构造函数来创建类对象.如果bean中没有默认无参构造函数, 将会创建失败
```xml
<bean id="userService" class="com.fall.ioc.xml.UserServiceImpl"/>
```
* 第二种: 静态工厂
>使用StaticFactory类中的静态方法创建类对象, 并存入Spring容器中.
```xml
<!--2. 使用静态工厂创建类对象, 并存入spring容器中
        id属性:指定bean的id, 用于从容器中读取
        class属性: 指定静态工厂的全限定类名
        factory-method属性: 指定生产对象的静态方法
    -->
<bean id="userService2" class="com.fall.ioc.xml.StaticFactory" factory-method="createUserService"/>
```
* 第三种: 实例工厂
```java
/*
* @description 实例工厂
 * 模拟一个实例工厂, 创建业务层实现类
 * 此工厂创建对象, 必须有现有工厂实例对象, 再调用方法
 */
public class InstanceFactory {
    public UserService createUserService() {
        return new UserServiceImpl();
    }

}
```
```xml
 <!--3. 实例工厂: 先把工厂的创建交给spring来管理, 然后再使用工厂的bean来调用类里面的方法-->
    <bean id="instanceFactory" class="com.fall.ioc.xml.InstanceFactory"/>
    <!--factory0-bean属性: 用于指定实例工厂的bean的id, factory-method:用来指定实例工厂中创建对象的方法-->
    <bean id="userService3" factory-bean="instanceFactory" factory-method="createUserService"/>
```

### 依赖
> 依赖: 指的是bean实例中的属性
> 依赖(属性)分为: 简单类型(8种基本数据类型和String类型)的属性, POJO类型的属性, 集合数据类型的属性

> 依赖注入: Dependency Injection, 它是spring框架核心IOC的具体实现.

> 为什么要进行依赖注入: 我们的程序在编写时,通过控制反转,把对象的创建交给了spring,但是代码中不可能出现没有依赖的情况.
> 那如果一个bean中包含了一些属性,那么spring棒我们实例化对象之后, 也需要将对于的属性信息进行赋值操作, 这种属性赋值操作,
> 就是所谓的依赖注入(获取值,注入属性)

#### 依赖注入的方式
* 构造函数注入
  >使用类中的构造函数, 给成员变量赋值. 注意:赋值的操作不是我们自己做的,而是通过配置的方式,让spring框架来为我们注入
```java
public class UserServiceImpl implements UserService {

    private int id;
    private String name;

    public UserServiceImpl(int id, String name) {
        this.id = id;
        this.name = name;
    }
}    
```   
```xml
<!--1. 使用构造函数的方式给属性赋值的要求: 类中需要提供一个对应参数列表的构造函数, 涉及标签
    constructor-arg:
        * index: 指定参数在构造函数参数列表中的索引位置
        * name: 指定函数在构造函数中的名称
        * value: 它能赋值的值是基本数据类型和string类型
        * ref: 他能赋值的是其他bean类型, 也就是说, 必须得是在配置文件中配置过的bean
    -->
    <bean id="userService4" class="com.fall.ioc.xml.UserServiceImpl">
        <constructor-arg name="id" value="1"/>
        <constructor-arg name="name" value="wangwu"/>
    </bean>
```
* set方法注入
    - 手动装配方式(xml)
```java

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
```  
```xml
<!--2. set方式注入
    需要配置bean标签的子标签property
    需要类中有指定的setter方法
    -->
    <bean id="userService5" class="com.fall.ioc.xml.UserServiceImpl">
        <property name="id" value="2"/>
        <property name="name" value="历史"/>
    </bean>
```
- 自动装配方式(注解)
> @Autowire: 
> 作用1: 查找实例,从spring容器中根据bean的类型获取实例
> 作用2: 赋值, 将找到的实例,装配给另一个实例的属性值.
> 注意事项: 一个java类型在同一个spring容器中, 只能有一个实例

> @Resource: 
> 作用1: 查找实例, 从spring容器中根据bean的名称获取实例
> 作用2: 赋值, 将找到的实例, 装配给另一个实例的属性值

> @Inject:
* p名称空间注入数据
> 不使用.此处不做说明
