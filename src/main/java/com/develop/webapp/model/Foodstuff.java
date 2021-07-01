package com.develop.webapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Foodstuff implements Serializable{
	
	private static final long serialVersionUID = -8465532910237069305L;

	@Id
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "stuff_fk")//the link to foreign table will take place through primary key	
	private Item item;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Foodstuff(String name) {
		super();
		this.name = name;
	}

	public Foodstuff() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Foodstuff(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Foodstuff [name=" + name + ", description=" + description + "]";
	}
	
	
	
	
	
}
