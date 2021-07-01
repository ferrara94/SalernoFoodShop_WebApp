package com.develop.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.develop.webapp.model.Item;
import com.develop.webapp.service.FoodstuffService;
import com.develop.webapp.service.ItemServiceImpl;

@Controller
public class ItemController {
	
	@Autowired
	ItemServiceImpl service;
	@Autowired
	FoodstuffService foodstuffService;

	@GetMapping(value ="items/{foodstuff}")
	public String getItemsPage(@PathVariable("foodstuff") String foodstuff,
			Model model) {
						
		String infoPage = foodstuff.toLowerCase();
		
		List<Item> items = service.getItems(foodstuff);
		
		foodstuff = foodstuff.toLowerCase() + "Folder/";
		
		
		model.addAttribute("foodstuff", foodstuff);
		model.addAttribute("infoPage", infoPage);
		
		
		items = service.getPathImages(items);
		
		
		model.addAttribute("products", items);
		
		return "item";	
	}
	
	@GetMapping(value ="items/all")
	public String getAllItems(Model model) {
								
		List<Item> items = service.getAllItems();
		
		if(items.isEmpty())	return "allItems";
		
		List<String> foodStuffs = foodstuffService.getFoodstuff();
		
		items = service.getPathImages(items);
				
		model.addAttribute("products", items);
		model.addAttribute("foodstuffs", foodStuffs);
		
		
		return "allItems";	
	}
	
	@GetMapping(value ="items/populateDB")
	public String populateDB() {
				
		service.populateDB();
		
		return "success";		
	}
	
}
