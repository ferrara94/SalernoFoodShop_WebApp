package com.develop.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.develop.webapp.controller.FoodstuffController;
import com.develop.webapp.controller.ItemController;

@SpringBootApplication
public class SalernoWebAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
		SpringApplication.run(SalernoWebAppApplication.class, args);
		
		/*
		    Database Population at startup
		 */		
		ItemController items = context.getBean(ItemController.class);
		items.populateDB();
		
		FoodstuffController foodstuffs = context.getBean(FoodstuffController.class) ;
		foodstuffs.populateDB();
	}

}
