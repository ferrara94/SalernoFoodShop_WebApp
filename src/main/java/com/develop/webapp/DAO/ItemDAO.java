package com.develop.webapp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.webapp.model.Item;

@Repository
public interface ItemDAO extends JpaRepository<Item, String>{

	public List<Item> findByFoodstuff(String foodstuff);
	
}
