package com.inventory.management.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.inventory.management.entities.Classification;

@Entity
public class ItemType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	@OneToOne(cascade=CascadeType.ALL)
	private Classification classification;
	@OneToOne(mappedBy="itemtype")
	@JsonBackReference
	private Item item;
	public ItemType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemType(int id, String name, String description, Classification classification) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.classification = classification;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Classification getClassification() {
		return classification;
	}
	public void setClassification(Classification classification) {
		this.classification = classification;
	}
}
