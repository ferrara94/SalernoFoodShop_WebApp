package com.develop.webapp.service;

import java.util.List;

import com.develop.webapp.model.Item;

public interface ItemService {
	
	public List<Item> getItems(String foodstuff);
	
	public List<Item> getAllItems();
	
	public List<Item> getPathImages(List<Item> items);
	
	public void populateDB();

}
