package com.javapuebla.bd.mappers;

import java.util.List;

import com.javapuebla.bd.domain.Customer;

public interface CustomerMapper {
	List<Customer> findAllCustomer();
	void updateCustomer(Customer customer);
}
