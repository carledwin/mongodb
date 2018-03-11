package com.wordpress.carledwinj.productapimongodb.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wordpress.carledwinj.productapimongodb.model.Customer;
import com.wordpress.carledwinj.productapimongodb.repository.CustomerRepository;

@Repository("customerRepository")
public class CustomerDAO implements CustomerRepository {

	private MongoTemplate mongoTemplate;

	@Autowired
	public CustomerDAO(final MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public void create(final Customer customer) {
		this.mongoTemplate.insert(customer);
	}

	@Override
	public void update(final Customer customer) {
		this.mongoTemplate.save(customer);
	}

	@Override
	public void delete(String id) {
		final Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		this.mongoTemplate.remove(query, Customer.class);
	}

	@Override
	public Customer findById(String id) {
		final Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		return this.mongoTemplate.findOne(query, Customer.class);
	}

	@Override
	public List<Customer> findAll() {
		return this.mongoTemplate.findAll(Customer.class);
	}

	@Override
	public void createAll(final Customer[] customers) {
		
		List<Customer> list = Arrays.asList(customers);
		
		this.mongoTemplate.insertAll(list);
	}
}
