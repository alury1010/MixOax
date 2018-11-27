package com.javapuebla.dao.customer;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;

import com.javapuebla.bd.domain.Customer;
import com.javapuebla.bd.mappers.CustomerMapper;
import com.javapuebla.bd.util.MyBatisSqlSessionFactory;

@Named
public class CustomerDaoImpl implements CustomerDao,Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Override
	public List<Customer> findAllCustomer() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CustomerMapper customerMapper = sqlSession
					.getMapper(CustomerMapper.class);
			return customerMapper.findAllCustomer();
		} finally {
			sqlSession.close();
		}
	}

//	@Override
	public void updateUsuario(Customer customer) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CustomerMapper customerMapper = sqlSession
					.getMapper(CustomerMapper.class);
			customerMapper.updateCustomer(customer);
			
			//Confirma el registro
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}
