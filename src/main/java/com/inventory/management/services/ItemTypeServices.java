package com.inventory.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.inventory.management.dao.ItemTypeRepo;
import com.inventory.management.entities.ItemType;

@Component
public class ItemTypeServices {
	@Autowired
	private ItemTypeRepo itRepo;
	public List<ItemType> getAllItemType(){
		List<ItemType> itList=(List<ItemType>) this.itRepo.findAll();
		return itList;
	}
	public ItemType getItemTypeById(int id){
	  ItemType it1 = null;
	  try {
	  it1=this.itRepo.findById(id);
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
		return it1;
	}
	public ItemType addItemType(ItemType it2) {
		this.itRepo.save(it2);
		return it2;
	}
	public ItemType updateItemType(ItemType it3) {
		ItemType it= new ItemType();
		it.setId(it3.getId());
		it.setDescription(it3.getDescription());
		it.setName(it3.getName());
		it.setClassification(it.getClassification());
		this.itRepo.save(it);
		return it;
	}
	public void deleteItemType(int id) {
		this.itRepo.deleteById(id);
	}
}
