package com.develop.webapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.develop.webapp.model.Foodstuff;

public interface FoodstuffDAO extends JpaRepository<Foodstuff, String>{

}
