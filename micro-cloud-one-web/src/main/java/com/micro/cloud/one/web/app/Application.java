package com.micro.cloud.one.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.micro.cloud.one.web")
@RefreshScope
public class Application implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/", "classpath:/css/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/", "classpath:/fonts/");
		registry.addResourceHandler("/img/**").addResourceLocations("/img/", "classpath:/img/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/", "classpath:/js/");
	}
}
