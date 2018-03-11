package com.wordpress.carledwinj.productapimongodb.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.wordpress.carledwinj.productapimongodb.model.Product;

public interface ProductRepository extends MongoRepository<Product, ObjectId>, ProductRepositoryCustom {

	Product findFirstByDescription(String description);
	Product findByDescriptionAndAvailable(String description, boolean available);
	
	@Query("{description : ?0}")//native JSON query string
	Product findCustomByDescription(String description);
	
	@Query("{description : { $regex : ?0 } }")
	List<Product> findCustomByRegExDescription(String domain);
}
