package com.inventory.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventory.management.dao.ItemRepo;
import com.inventory.management.entities.Item;

@Component
public class ItemServices {
	@Autowired
	private ItemRepo itRepo;
	public List<Item> getAllItem(){
		List<Item> itList=(List<Item>) this.itRepo.findAll();
		return itList;
	}
	public Item getItemById(int id){
	  Item it1 = null;
	  try {
	  it1=this.itRepo.findById(id);
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
		return it1;
	}
	public Item addItem(Item it2) {
		this.itRepo.save(it2);
		return it2;
	}
	public Item updateItem(Item it3) {
		Item it= new Item();
		it.setCategories(it3.getCategories());
		it.setCode(it3.getCode());
		it.setCompany_id(it3.getCompany_id());
		it.setItemtype(it3.getItemtype());
		it.setStock_id(it3.getStock_id());
		it.setUniqueID(it3.getUniqueID());
		this.itRepo.save(it);
		return it;
	}
	public void deleteItem(int id) {
		this.itRepo.deleteById(id);
	}
}
