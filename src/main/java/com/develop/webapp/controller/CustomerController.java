package com.develop.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.develop.webapp.model.Customer;
import com.develop.webapp.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService service;

	@GetMapping(value ="customers/all")
	public String getCustomers(Model model) {
		
		List<Customer> customers = service.getCustomers();
		
		model.addAttribute("infoPage", "Customers");
		model.addAttribute("customers", customers);
		
		
		return "customers";
	}
	
	@GetMapping(value ="customers/customer/{id}")
	public String getCustomer(@PathVariable Long id, Model model) {
		
		Customer c = service.getCustomer(id);
		model.addAttribute("customer", c);
		
		return "customer";
	}
	
	@DeleteMapping(value = "customer/delete/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		
	}
	
	
	
}
