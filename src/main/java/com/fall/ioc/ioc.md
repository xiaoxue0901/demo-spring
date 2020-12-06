@Configuration
@ComponetScan(属性的用法: includeFilter, excludeFilter, @Filter, TypeFilter)
@Bean
@Scope
@Lazy
@Conditional
@Import(ImportSelector, ImportBeanDefinitionRegister, FacotryBean)

Bean的生命周期(3种方式)
1. init-method, destory-method
2. InitalzingBean, DisposableBean
3. JSR250的注解: @PostConstruct, @PreDestory
4. BeanPosstProcessor



BeanFactory和FactoryBean区别
CGLIB实例化bean
T = cglib:proxyProcess().invoke(Bike.class)

BeanPostProcessor源码初步分析
控制bean的生命周期
1. postProcessBeforeInitialzation()
2. postProcessAfterInitialization()

refresh(): 创建并刷新容器



bean的创建流程
    入口: AbstractBeanFactory#getBean()
AbstractBeanFactory#getBean()
    #doGetBean: 去获取缓存中的bean或者创建bean
    #DefaultSingletonBeanRegistry#getSingletion: 从三级缓存中获取bean实例---(循环依赖面试题)    
    #getObjectForBeanInstance()--BeanFactory和FactoryBean的面试问题
        AbstractAutowireCapableBeanFactory#createBean: 创建Bean实例,属性填充,实例化
            #doCreateBean: 真正干活的
            #createBeanInstance: 1. 创建bean的空对象
            #addSingletonFactory: 解决循环依赖,存储到三级缓存中
            #populateBean: 2.属性填充
            #initalizeBean: 3. bean的初始化


阅读spring源码,第一个层次:一定要抓住主线,理解spring处理思路;第二个层次,理解完处理思路之后,再去理解面向对象的思想和设计模式的用法.            
Spring的三级缓存
一级缓存:singletonObjects
二级缓存:earlySingletonObjects
三级缓存:singletonFactories
    key:beanNames
    value:ObjectFactory()
    存储时机是bean实例化之后,删除时机是bean创建完成之后和循环依赖的getBean 
    
第一步:实例化之后
第二步:初始化之后
第三部:第一次之后的调用getBean

bean实例化之后会使用三级缓存, 三级缓存中存储的是beanName和提前获取bean的ObjectFactory

bean的实例化,初始化之后, 会将bean实例放入一级缓存中.

第二次调用getBean时,有两种情况:一种是正在创建中的bean,一种是已经创建完成的bean, 正在创建中的bean需要从三级缓存中
获取实例的提前引用,放入二级缓存, 已经创建完成的ean可以直接从一级缓存中获取到.

ObjectFactory: 对对象进行获取,并且调用instantionBeanPostProcessor,完成bean实例化前后的后置处理.

静态代理:针对目标类,编写一个代理类
动态代理:在目标类运行时期,会通过以下的两种方式,动态生成一个代理类
    JDK:java自带的
    CGLIB:第三方代码生成库
    区别:
    JDK:基于接口方式实现的动态代理(目标类和代理类都拥有相同的接口,)也就是说目标类必须由
    CGLIB:基于继承方式实现的动态代理(目标类是父类,代理类是子类,代理类的方法会覆盖父类方法)
spring aop默认使用JDK, 2种代理方式都支持  .想用CGLIB,需要设置aop:aspectj-autoproxy标签的proxy-target-class属性
性能区别:
1. 1.8之前cglib比jdk号,
2. >=1.8之后 jdk比cglib快 . cglib动态生成字节码代理类比较耗时间.
   >
概念
    1. 目标对象:需要被功能增强的java普通对象.
    2. 代理对象:针对目标对象,使用增强器进行增强之后的对象
    3. 增强器类:需要对目标对象增强的功能
    4. 代理对象工厂:用于产生代理对象的.(需要给目标类匹配上增强器)
jDK动态代理实现原理
所以说需要传递接口    
    

    
               
    