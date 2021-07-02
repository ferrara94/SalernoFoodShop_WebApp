package com.develop.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.develop.webapp.service.FoodstuffService;

@Controller
public class FoodstuffController {

	@Autowired
	FoodstuffService service;
	
	
	
}
