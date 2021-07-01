package com.develop.webapp.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.webapp.DAO.FoodstuffDAO;
import com.develop.webapp.model.Foodstuff;

@Service
public class FoodstuffServiceImpl implements FoodstuffService {

	@Autowired
	FoodstuffDAO dao;
	
	@Override
	public List<String> getFoodstuff() {
		
		List<Foodstuff> stuffs = dao.findAll();
		List<String> stuffsList = new LinkedList<>();
		
		for(Foodstuff f: stuffs)
			stuffsList.add(f.getName());
		
		return stuffsList;
	}

	@Override
	public void populateDB() {
		List<Foodstuff> items = new LinkedList<>();
						
		items.add( new Foodstuff("pasta", 
				"type of food typically made from an unleavened dough of wheat "
				+ "flour mixed with water or eggs, and formed into sheets "
				+ "or other shapes, then cooked by boiling or baking."
				+ "Pasta is a staple food of Italian cuisine.") );
		
		items.add( new Foodstuff("chocolate", 
				"Chocolate is a preparation of roasted and ground cacao seeds "
				+ "that is made in the form of a liquid, paste, or in a block, "
				+ "which may also be used as a flavoring ingredient in other foods. ") );
		
		items.add( new Foodstuff("water", "Important thing needed to survive") );
		
		items.add( new Foodstuff("fish", "Fish are an important resource for humans worldwide, "
				+ "especially as food. Commercial and subsistence fishers hunt fish in wild fisheries "
				+ "or farm them in ponds or in cages in the ocean (in aquaculture). ") );
		
		dao.saveAll(items);
		
	}

}
