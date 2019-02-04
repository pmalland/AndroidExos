package com.paulmalland.repository;

import java.util.List;

import com.paulmalland.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}