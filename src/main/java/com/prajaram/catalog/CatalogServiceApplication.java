package com.prajaram.catalog;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.prajaram.catalog.utils.InvocationLogger;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.prajaram.catalog.core.repository.jpa" })
@EntityScan(basePackages = { "com.prajaram.catalog.core.entity" })
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableEurekaClient
@EnableSwagger2
@EnableRabbit
@EnableScheduling
public class CatalogServiceApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CatalogServiceApplication.class, args);
		System.out.println(context.getBean(InvocationLogger.class));
	}
}
