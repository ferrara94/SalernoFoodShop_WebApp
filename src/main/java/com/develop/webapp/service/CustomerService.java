package com.develop.webapp.service;

import java.util.List;

import com.develop.webapp.model.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(Long id);
	
	public Long deleteCustomer(Long id);

	void populateDB();
	
}
