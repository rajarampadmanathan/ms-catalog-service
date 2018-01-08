package com.mcd.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mcd.catalog.utils.InvocationLogger;

@SpringBootApplication
@EnableJpaRepositories(basePackages= {"com.mcd.catalog.core.repository.jpa"})
@EntityScan(basePackages= {"com.mcd.catalog.core.entity"})
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableEurekaClient
public class CatalogServiceApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(CatalogServiceApplication.class, args);
		System.out.println(context.getBean(InvocationLogger.class));
	}
}
