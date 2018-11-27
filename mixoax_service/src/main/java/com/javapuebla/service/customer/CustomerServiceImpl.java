package com.javapuebla.service.customer;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.javapuebla.bd.domain.Customer;
import com.javapuebla.dao.customer.CustomerDao;

@Named
public class CustomerServiceImpl implements CustomerService,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	CustomerDao customerDao;
	
//	@Override
	public List<Customer> findAllCustomer() {
		return customerDao.findAllCustomer();
	}

//	@Override
	public void updateUsuario(Customer customer) {
		customerDao.updateUsuario(customer);
	}

}
