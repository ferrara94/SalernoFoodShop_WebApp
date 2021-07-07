package com.develop.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.develop.webapp.model.Customer;
import com.develop.webapp.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService service;

	@GetMapping(value ="customers/all")
	@PreAuthorize("hasRole('ADMIN')")
	public String getCustomers(Model model) {
		
		List<Customer> customers = service.getCustomers();
		
		model.addAttribute("infoPage", "Customers");
		model.addAttribute("customers", customers);
		
		
		return "customers";
	}
	
	@GetMapping(value ="customers/customer/{id}")
	public String getCustomer(@PathVariable Long id, Model model) {
		
		Customer c = service.getCustomer(id);
		
		if(c==null) {
			String msg = "Customer with ID_NUMBER " + id + " is not present";
			
			List<Customer> customers = service.getCustomers();
			
			model.addAttribute("infoPage", "Customers");
			model.addAttribute("customers", customers);
			model.addAttribute("condition", "false");
			model.addAttribute("msg", msg);
			
			return "customers";
		}
		
		model.addAttribute("customer", c);
		
		return "customer";
	}
	
	@GetMapping(value = "customers/customer/delete/{id}")
	public String deleteCustomer(@PathVariable Long id, Model model) {
		
		Customer c = service.getCustomer(id);
				 
		if(c==null) {
			String msg = "Customer with ID_NUMBER " + id + " is not present";
			
			List<Customer> customers = service.getCustomers();
			
			model.addAttribute("infoPage", "Customers");
			model.addAttribute("customers", customers);
			model.addAttribute("condition", "false");
			model.addAttribute("msg", msg);
			
			return "customers";
		} else {
			service.deleteCustomer(id);
			
			String msg = "Customer with ID_NUMBER " +
					id + " successfully removed";
			
			List<Customer> customers = service.getCustomers();
			
			model.addAttribute("infoPage", "Customers");
			model.addAttribute("customers", customers);
			model.addAttribute("condition", "true");
			model.addAttribute("msg", msg);
			
		}
		
		return "customers";
				
	}
	
	
	
}
