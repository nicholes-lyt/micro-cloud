## 基于SpringCloud构建云服务

### springcloud从1.x升级到2.x问题汇总

#### 1、eureka的pom引用修改
```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

#### 2、spring-boot-admin监控升级2.0需添加配置
* Actuator 在 spring boot 2.0 版本后，只暴露了两个端点；因此监控的每个服务模块的yml需要添加配置如下：
```
management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: ALWAYS
```
#### 3、one-web中修改
* 1、将基础WebMvcConfigurerAdapter改为implements WebMvcConfigurer
* 2、jpa配置将jpaProperties.getHibernateProperties(dataSource)改为如下方式
```
	@Primary
	@Bean(name = "oneEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		DataSource dataSource = dataSource();
		return builder.dataSource(dataSource).properties(jpaProperties.getProperties()).packages("com.easynetcn.cloud.one.web.data.entity")
				.persistenceUnit("onePersistenceUnit").build();
	}
```