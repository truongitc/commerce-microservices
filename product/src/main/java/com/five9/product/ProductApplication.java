package com.five9.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "com.five9")
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableWebMvc
public class ProductApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}
