package com.inventory.management.dao;

import org.springframework.data.repository.CrudRepository;
import com.inventory.management.entities.Item_Details;

public interface Item_DetailsRepo extends CrudRepository<Item_Details,Integer> 
{
	public Item_Details findById(int id);
}
