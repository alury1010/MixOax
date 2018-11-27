package com.javapuebla.bo.customer.impl;

import javax.inject.Named;

import com.javapuebla.bo.customer.CustomerBo;

@Named
public class CustomerBoImpl implements CustomerBo{
 
	public String getMessage() {
		
		return "JSF 2 + Spring Integration - mensaje desde bean injectado por Spring";
	
	}
 
}