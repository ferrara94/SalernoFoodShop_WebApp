package com.develop.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.develop.webapp.service.CustomerService;
import com.develop.webapp.service.FoodstuffService;
import com.develop.webapp.service.ItemService;

@SpringBootApplication
public class SalernoWebAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
		SpringApplication.run(SalernoWebAppApplication.class, args);
		
		/*
		    Database Population at startup
		 */		
		ItemService items = context.getBean(ItemService.class);
		items.populateDB();
		
		FoodstuffService foodstuffs = context.getBean(FoodstuffService.class) ;
		foodstuffs.populateDB();
		
		CustomerService customers = context.getBean(CustomerService.class);
		customers.populateDB();
		
	}

}
