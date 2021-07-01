package com.develop.webapp.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.webapp.DAO.ItemDAO;
import com.develop.webapp.model.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDAO dao;

	@Override
	public List<Item> getItems(String foodstuff) {
		return dao.findByFoodstuff(foodstuff);
	}
	
	@Override
	public List<Item> getAllItems() {
		return dao.findAll();
	}	
	

	@Override
	public List<Item> getPathImages(List<Item> items) {
		
		for(Item i: items)
			i.setName(i.getName().toLowerCase());
				
		for(Item i: items)
			i.setPathImage((i.getName().replace(" ", "_") + ".jpg"));
		
		return items;
	}

	@Override
	public void populateDB() {
		
		List<Item> items = new LinkedList<>();
		
		//pasta
		items.add( new Item("Barilla tortiglioni", "pasta", 1.89) );
		items.add( new Item("Barilla trofie", "pasta", 1.89) );
		items.add( new Item("Barilla whole", "pasta", 1.89) );

		//fish
		items.add( new Item("Riomare tuna", "fish", 4.20) );
		items.add( new Item("Rizzoli tuna", "fish", 3.20) );
		
		//fish
		items.add( new Item("Nutella 400gr", "chocolate", 5.99) );
		items.add( new Item("Nutella go", "chocolate", 2.00) );
		
		//water
		items.add( new Item("volvic", "water", 0.99) );
		items.add( new Item("vichy", "water", 0.70) );
		
		dao.saveAll(items);
	}

	
	
}
