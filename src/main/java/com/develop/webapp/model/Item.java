package com.develop.webapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Item implements Serializable{
	
	private static final long serialVersionUID = -4162279481140618624L;

	@Id
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "FOODSTUFF")
	private String foodstuff;
	
	@OneToOne(mappedBy ="item", cascade = CascadeType.ALL, orphanRemoval = true)
	private Foodstuff relationStuff;
	
	@Column(name = "PRICE")
	private double price;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	/*
	 @Temporal(TemporalType.DATE)
	 private Date dataCreation;
	*/
	
	
	@Transient
	private String pathImage;
	
	public Item() {}
	
	public Item(String name, String foodstuff, double price, String description) {
		super();
		this.name = name;
		this.foodstuff = foodstuff;
		this.price = price;
		this.description = description;
	}
	
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFoodstuff() {
		return foodstuff;
	}
	public void setFoodstuff(String foodstuff) {
		this.foodstuff = foodstuff;
	}
	public String getPathImage() {
		return pathImage;
	}
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public Foodstuff getRelationStuff() {
		return relationStuff;
	}

	public void setRelationStuff(Foodstuff relationStuff) {
		this.relationStuff = relationStuff;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", foodstuff=" + foodstuff + ", relationStuff=" + relationStuff + ", price="
				+ price + "]";
	}
	
	

}
