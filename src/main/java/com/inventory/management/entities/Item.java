package com.inventory.management.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int UniqueID;
	@OneToOne(cascade=CascadeType.ALL)
	private ItemType itemtype;
	@OneToOne(mappedBy="item")
	@JsonBackReference
	private Item_Details itd;
	private int code;
	private String categories;
	private int company_id;
	private int stock_id;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int uniqueID, ItemType it, int code, String categories, int company_id, int stock_id) {
		super();
		UniqueID = uniqueID;
		this.itemtype = itemtype;
		this.code = code;
		this.categories = categories;
		this.company_id = company_id;
		this.stock_id = stock_id;
	}
	public int getUniqueID() {
		return UniqueID;
	}
	public void setUniqueID(int uniqueID) {
		UniqueID = uniqueID;
	}
	public ItemType getItemtype() {
		return itemtype;
	}
	public void setItemtype(ItemType itemtype) {
		this.itemtype = itemtype;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	
}
