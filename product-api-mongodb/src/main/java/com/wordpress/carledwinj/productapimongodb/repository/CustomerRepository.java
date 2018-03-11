package com.wordpress.carledwinj.productapimongodb.repository;

import java.util.List;

import com.wordpress.carledwinj.productapimongodb.model.Customer;

public interface CustomerRepository {

    void create(final Customer customer);
    void update(final Customer customer);
    void delete(final String id);
    Customer findById(final String id);
    List<Customer> findAll();
    void createAll(final Customer[] customers);
}
