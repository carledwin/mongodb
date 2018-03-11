package com.wordpress.carledwinj.productapimongodb.repository;

import com.wordpress.carledwinj.productapimongodb.model.Customer;

public interface CustomerRepository {

    public void create(final Customer customer);
    public void update(final Customer customer);
    public void delete(final String id);
    public Customer findById(final String id);
}
