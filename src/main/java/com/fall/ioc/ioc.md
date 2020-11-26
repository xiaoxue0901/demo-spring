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