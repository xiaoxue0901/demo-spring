# Spring AOP

## 设计模式: 代理
说明: 代理是一种设计模式, 提供了对目标对象的另外的访问方式: 即通过代理对象访问目标对象.
### 静态代理
核心: 
> 1. 目标对象
> 2. 代理对象
> 3. 使用

`目标对象和代理对象要实现同一个接口或继承同一个父类` 
```java
public interface RoleService {

    int saveRole();
}
```
`目标类`
```java
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Override
    public int saveRole() {
        log.info("目标类::新增角色");
        return 1;
    }
}
```
`代理类`
```java
public class RoleServiceProxy implements RoleService {
    /**
     * 目标类
     */
    private RoleService roleService;

    public RoleServiceProxy(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public int saveRole() {
        System.out.println("代理类:增强操作1");
        // 调用目标类
        int result = roleService.saveRole();
        System.out.println("代理类:增强操作2");
        return result;
    }
}
```
`静态代理使用`
```java
public class RoleServiceProxyTest {
    @Test
    public void saveRole() {
        // 目标类
        RoleService target = new RoleServiceImpl();
        // 代理类
        RoleServiceProxy proxy = new RoleServiceProxy(target);
        // 通过调用代理类的方法从而调用目标类
        int result = proxy.saveRole();
        Assert.assertEquals(1, result);
    }
}
```

**总结:**
 1. 代理类中目标类是固定的, 是RoleService的固定代理类, 无法变化, 故称为静态代理
 2. 缺点: 代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.

### JDK动态代理
核心: 
1.代理对象是利用JDK的API, 动态的在内存中构建代理对象(通过指定类加载器和目标对象实现的接口的类型来创建)
2.JDK动态代理又称为接口代理: 代理对象和目标对象实现同样的接口
3. JDK动态产生代理对象的API: ``

`目标类`
```java
public class RoleServiceImpl implements RoleService {
    @Override
    public int saveRole() {
        System.out.println("JDK动态代理目标类: 新增角色");
        return 1;
    }
}
```
`增强类`
需要实现java的接口`java.lang.reflect.InvocationHandler`
```java
public class JdkInvocationHandler implements InvocationHandler {
    /**
     * 目标对象
     */
    private Object target;

    /**
     * 构造方法
     * @param target
     */
    public JdkInvocationHandler(Object target) {
        // invoke中需要用到目标类对象
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK代理: 增强操作");
        // JDK的反射: method是目标类的方法, 此处使用JDK反射API调用target的方法
        Object res = method.invoke(target, args);
        System.out.println("JDK代理: 增强操作");
        return res;
    }
}
```

`工厂`
```java
public class JdkProxyFactory {

    /**
     * 获取一个代理类实例
     * @param target
     * @return
     */
    public Object getJdkProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new JdkInvocationHandler(target));
    }
    
}
```
`使用`
```java
public class JdkProxyFactoryTest {

    @Test
    public void getProxyInstance() {
        // 目标类
        RoleService roleService = new RoleServiceImpl();
        // 代理工厂
        JdkProxyFactory factory = new JdkProxyFactory();
        // 代理类
        RoleService proxy = (RoleService) factory.getJdkProxy(roleService);
        // 代理类调用和目标类实现的同样的接口的方法
        int res = proxy.saveRole();
        System.out.println("result:"+res);
    }
}
```

### CGLIB动态代理
`目标类: 和JDK动态代理一致: RoleServiceImpl, 不能是接口(CGLIB是通过子类调用父类的方法实现代理的)`
`增强类: 实现MethodInterceptor接口`
```java
public class CglibMethodInterceptor implements MethodInterceptor {
    /**
     *
     * @param o 代理类
     * @param method 目标对象方法
     * @param objects 目标对象方法参数
     * @param methodProxy 代理对象调用目标对象的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB代理:增强操作");
        // CGLIB通过子类调用父类的方法实现目标类的调用
        Object res = methodProxy.invokeSuper(o, objects);
        System.out.println("CGLIB代理:增强操作");
        return res;
    }
}
```
`工厂: 产生代理类`
```java
public class CglibProxyFactory {
    /**
     * 产生代理对象
     * @param target
     * @return
     */
    public Object getCglibProxy(Class<?> target) {
        // 创建增强器
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target);
        // 设置回调方法
        enhancer.setCallback(new CglibMethodInterceptor());
        // 创建代理对象
        return enhancer.create();
    }
}
```

`使用`
```java
public class CglibProxyFactoryTest {

    @Test
    public void getProxy() {
        // 工厂类
        CglibProxyFactory factory = new CglibProxyFactory();
        // 产生代理对象
        RoleService proxy = (RoleServiceImpl)factory.getCglibProxy(RoleServiceImpl.class);
        proxy.saveRole();
        // 产生代理对象
        UserService userProxy = (UserService) factory.getCglibProxy(UserServiceImpl.class);
        userProxy.saveUser();
    }

}
```

第一节:
jdk和cglib动态代理分析--运行时产生代理对象
    jdk产生代理对象的步骤-- 由代理对象工厂去
    1. 针对目标类的接口去使用Java api编写代理类的代码(.java文件)
    2. 编译java代码成class文件
    3. 使用ClassLoader去加载class文件到jvm中
    4. 通过class对象去反射生成代理对象
    代理对象的主要工作是委托给InvocationHandler类(增强器)去处理
    
spring Aop 原理介绍

AOP联盟定义的一些类

符合AspectJ表达式: excution()
AbstractAutoProxyCreator
AspectJAwareAdvisorAutoProxyCreator

TargetSource
AopFactory