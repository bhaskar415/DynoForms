package com.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@EnableMongoRepositories({"com","com.demo"})
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@ComponentScan({"com", "com.demo"})
public class Application {

	public static void main(String[] args) {	
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        RepositoryRestConfiguration restConfiguration = ctx.getBean(RepositoryRestConfiguration.class);

        restConfiguration.setReturnBodyOnCreate(true);
        restConfiguration.setReturnBodyOnUpdate(true);
        
	}
}