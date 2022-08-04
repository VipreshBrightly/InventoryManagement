package com.inventory.management.dao;

import org.springframework.data.repository.CrudRepository;
import com.inventory.management.entities.Stock;

public interface StockRepo extends CrudRepository<Stock, Integer>
{
	public Stock findById(int id);
}
