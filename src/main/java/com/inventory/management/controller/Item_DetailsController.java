package com.inventory.management.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.management.entities.Item_Details;
import com.inventory.management.services.Item_DetailsServices;

@RestController
public class Item_DetailsController
{
	
	@Autowired
	private Item_DetailsServices  itdServices;
	@GetMapping("/item_Details")
	public ResponseEntity<List<Item_Details>> handler1() 
	{	
		List<Item_Details>itdList=this.itdServices.getAllItem_Details();
		if(itdList.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(itdList));		
	}
	
	@GetMapping("/item_Details/{id}")	
	public ResponseEntity<Item_Details> handler2(@PathVariable("id") int id) 
	{		
		Item_Details itd= this.itdServices.getItem_DetailsById(id);	
		if(itd==null) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(itd));
	}
	
	@PostMapping("/item_Details")	
	public ResponseEntity<Item_Details> handler3(@RequestBody Item_Details itd) 
	{		
		try
		{
			this.itdServices.addItem_Details(itd);
			return ResponseEntity.status(HttpStatus.CREATED).body(itd);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@DeleteMapping("/item_Details/{id}")
	public ResponseEntity<Void> handler4(@PathVariable("id") int id) 
	{
		try 
		{
			this.itdServices.deleteItem_Details(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/item_Details/{id}")
	public ResponseEntity<Item_Details> handler5(@RequestBody Item_Details itd, @PathVariable("id") int id) 
	{
		try
		{
			this.itdServices.updateItem_Details(itd,id);
			return ResponseEntity.of(Optional.of(itd));
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
