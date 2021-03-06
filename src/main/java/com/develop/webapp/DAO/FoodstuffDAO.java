package com.develop.webapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.webapp.model.Foodstuff;

@Repository
public interface FoodstuffDAO extends JpaRepository<Foodstuff, String>{

}
