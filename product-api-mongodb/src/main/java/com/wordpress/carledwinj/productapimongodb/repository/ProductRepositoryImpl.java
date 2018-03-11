package com.wordpress.carledwinj.productapimongodb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;
import com.wordpress.carledwinj.productapimongodb.model.Product;


public class ProductRepositoryImpl implements ProductRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public int updateProduct(String description, boolean available) {
		
		Query query = new Query(Criteria.where("description").is(description));
		
		Update update = new Update();
		update.set("available", available);
		
		UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Product.class);
		
		if(updateResult != null)
			return 1;//updateResult.getModifiedCount();
		else
	return 0;
	}

}
