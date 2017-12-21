package com.micro.cloud.one.web.config;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "oneEntityManagerFactory", transactionManagerRef = "oneTransactionManager", basePackages = {
		"com.micro.cloud.one.web.data.repository" })
public class OneJpaConfig {
	@Bean(name = "oneDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.one")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "oneJdbcTemplate")
	@Primary
	public JdbcTemplate jdbcTemplate() {
		System.out.println("springboot 加载数据源：" + dataSource());
		return new JdbcTemplate(dataSource());
	}

	@Bean(name = "oneParameterJdbcTemplate")
	@Primary
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(jdbcTemplate());
	}

	@Primary
	@Bean
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactory(builder).getObject().createEntityManager();
	}

	@Primary
	@Bean(name = "oneEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		DataSource dataSource = dataSource();

		return builder.dataSource(dataSource).packages("com.easynetcn.cloud.one.web.data.entity")
				.persistenceUnit("onePersistenceUnit").build();
	}

	@Primary
	@Bean(name = "oneTransactionManager")
	public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactory(builder).getObject());
	}
}
