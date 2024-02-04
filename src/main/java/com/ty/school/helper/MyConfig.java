package com.ty.school.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = "com.ty.school")
public class MyConfig {
	@Bean("entityManagerFactory")
	public EntityManagerFactory getEntityManagerFactory() {
	return   Persistence.createEntityManagerFactory("vikas");

	}

}
