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
		
		String barilla = "Grano prodotto 100% da agricoltura italiana con "
				+ "strumenti innovativi e in totale sicurezza. Abbiamo "
				+ "fatto 100. Grano di qualità prodotto al 100% in Italia.";
		
		//pasta
		items.add( new Item("Barilla tortiglioni", "pasta", 1.89, barilla) );
		items.add( new Item("Barilla trofie", "pasta", 1.89, barilla) );
		items.add( new Item("Barilla whole", "pasta", 1.89, barilla) );

		String tuna = "Tonno appartenente a specie non sovrasfruttate "
				+ "e pescato con metodi sostenibili.";
		
		//fish
		items.add( new Item("Riomare tuna", "fish", 4.20, tuna) );
		items.add( new Item("Rizzoli tuna", "fish", 3.20, tuna) );
		
		String nutella = "nuova crema spalmabile al cioccolato di Baci Perugina. Con la sua "
				+ "inconfondibile granella di nocciole. Basta provarla per innamorarsi.";
		
		//chocolate
		items.add( new Item("Nutella 400gr", "chocolate", 5.99, nutella) );
		items.add( new Item("Nutella go", "chocolate", 2.00, nutella) );
		
		String water = "Acqua che ha origine dai ghiacciai del massiccio del Monte Rosa";
		
		//water
		items.add( new Item("volvic", "water", 0.99,water) );
		items.add( new Item("vichy", "water", 0.70,water) );
		
		dao.saveAll(items);
	}

	
	
}
