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
		
		customers.add(new Customer("Marco", "Alonsi",
				"marcoalonsi90@gmail.com", "333-4567888"));
		customers.add(new Customer("Giovanni", 
				"Capo","giovannicapo87@gmail.com","344-4067890"));
		customers.add(new Customer("Franco", "Albertazzi",
				"francoalberti78@hotmail.it","345-4562868"));
		
		dao.saveAll(customers);
	}

	@Override
	public Long deleteCustomer(Long id) {
		dao.deleteById(id);
		return id;
	}


}
