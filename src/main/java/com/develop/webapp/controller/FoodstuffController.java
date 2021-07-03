package com.develop.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.develop.webapp.service.FoodstuffService;

@Controller
public class FoodstuffController {

	@Autowired
	FoodstuffService service;
	
	
	
}
