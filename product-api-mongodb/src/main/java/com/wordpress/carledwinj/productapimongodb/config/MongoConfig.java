package com.wordpress.carledwinj.productapimongodb.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

@Configuration
public class MongoConfig {

	private static final int MONGO_DB_PORT = 27018;
	private static final String MONGO_DB_URL = "localhost";
	private static final String MONGO_DB_NAME = "carl_db";
	
	@Bean
	public MongoTemplate mongoTemplate() throws IOException {
		
		EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
		mongo.setBindIp(MONGO_DB_URL);
		mongo.setPort(MONGO_DB_PORT);
		MongoClient mongoClient = mongo.getObject();
		
		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
		
		return mongoTemplate;
	}
}
