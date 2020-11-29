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
            
    