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

import com.inventory.management.entities.Stock;
import com.inventory.management.services.StockServices;

@RestController
public class StockController
{
	
	@Autowired
	private StockServices  stockServices;
	@GetMapping("/stock")
	public ResponseEntity<List<Stock>> handler1() 
	{	
		List<Stock>stockList=this.stockServices.getAllStock();
		if(stockList.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(stockList));		
	}
	
	@GetMapping("/stock/{id}")	
	public ResponseEntity<Stock> handler2(@PathVariable("id") int id) 
	{		
		Stock stock= this.stockServices.getStockById(id);	
		if(stock==null) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(stock));
	}
	
	@PostMapping("/stock")	
	public ResponseEntity<Stock> handler3(@RequestBody Stock stock) 
	{		
		try
		{
			this.stockServices.addStock(stock);
			return ResponseEntity.status(HttpStatus.CREATED).body(stock);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@DeleteMapping("/stock/{id}")
	public ResponseEntity<Void> handler4(@PathVariable("id") int id) 
	{
		try 
		{
			this.stockServices.deleteStock(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/stock/{id}")
	public ResponseEntity<Stock> handler5(@RequestBody Stock stock, @PathVariable("id") int id) 
	{
		try
		{
			this.stockServices.updateStock(stock,id);
			return ResponseEntity.of(Optional.of(stock));
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
