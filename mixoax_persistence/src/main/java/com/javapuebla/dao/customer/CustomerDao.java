package com.javapuebla.dao.customer;

import java.util.List;

import com.javapuebla.bd.domain.Customer;

public interface CustomerDao {
	List<Customer> findAllCustomer();
	void updateUsuario(Customer customer);
}
