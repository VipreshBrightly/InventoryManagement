package com.inventory.management.dao;

import org.springframework.data.repository.CrudRepository;

//import com.inventory.management.controller.ItemType;
import com.inventory.management.entities.Classification;
import com.inventory.management.entities.ItemType;
public interface ItemTypeRepo extends CrudRepository<ItemType,Integer>{
	public ItemType findById(int id);

}
