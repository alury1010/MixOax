package com.javapuebla.service.customer;

import java.util.List;

import com.javapuebla.bd.domain.Customer;

public interface CustomerService {
	List<Customer> findAllCustomer();
	void updateUsuario(Customer customer);
}
