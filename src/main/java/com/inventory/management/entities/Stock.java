package com.inventory.management.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Stock 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int availableQty;
	private int location_Code;
	@OneToOne(cascade=CascadeType.ALL)
	private Item item;
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(int id, int availableQty, int location_Code, Item item) {
		super();
		this.id = id;
		this.availableQty = availableQty;
		this.location_Code = location_Code;
		this.item = item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}

	public int getLocation_Code() {
		return location_Code;
	}

	public void setLocation_Code(int location_Code) {
		this.location_Code = location_Code;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
