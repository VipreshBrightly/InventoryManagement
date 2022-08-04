package com.inventory.management.dao;
import com.inventory.management.entities.Classification;
import org.springframework.data.repository.CrudRepository;

public interface ClassificationRepo extends CrudRepository<Classification,Integer> {

	public Classification findById(int id);
}



