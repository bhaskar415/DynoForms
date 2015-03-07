package com.app.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoDBConfig extends AbstractMongoConfiguration{

	 
	
		@Override
		public String getDatabaseName() {
			return "dyno-forms";
		}
	 
		@Override
		@Bean
		public Mongo mongo() throws Exception {
			return new MongoClient("127.0.0.1");
		}
		
	
		
	}

