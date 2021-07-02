package com.develop.webapp.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.webapp.DAO.CustomerDAO;
import com.develop.webapp.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO dao;
	
	@Override
	public List<Customer> getCustomers() {
		return dao.findAll();
	}

	@Override
	public Customer getCustomer(Long id) {
		Optional<Customer> c = dao.findById(id);
		
		if(c.isEmpty())	return null;
		else return c.get();
	}
	
	@Override
	public void populateDB() {
		
		List<Customer> customers = new LinkedList<>();
		
		customers.add(new Customer("Marco", "Alonsi","marcoalonsi90@gmail.com"));
		customers.add(new Customer("Giovanni", "Capo","giovannicapo87@gmail.com"));
		customers.add(new Customer("Franco", "Albertazzi","francoalberti78@hotmail.it"));
		
		dao.saveAll(customers);
	}


}
