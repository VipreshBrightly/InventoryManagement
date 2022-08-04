package com.inventory.management.controller;

import java.util.List;
import java.util.Optional;

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

import com.inventory.management.entities.Item;
import com.inventory.management.services.ItemServices;

@RestController
public class ItemController {
	@Autowired
	private ItemServices itServices;
	@GetMapping("/item")
	public ResponseEntity<List<Item>> handler1(){
		List<Item> itList= this.itServices.getAllItem();
		if(itList==null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(itList));
	}
	@GetMapping("/item/{UniqueID}")
	public ResponseEntity<Item> handler2(@PathVariable("UniqueID") int UniqueID){
		Item it1=this.itServices.getItemById(UniqueID);
		if(it1==null)
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(it1));
	}
	@PostMapping("/item")
	public ResponseEntity<Item> handler3(@RequestBody Item it) {
		try {
		Item it2=this.itServices.addItem(it);
		return ResponseEntity.status(HttpStatus.CREATED).body(it2);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@PutMapping("/item/{UniqueID}")
	public ResponseEntity<Item> handler4(@RequestBody Item it, @PathVariable("UniqueID") int UniqueID){
		try{
			Item it3=this.itServices.updateItem(it);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@DeleteMapping("/item/{UniqueID}")
	public ResponseEntity<Void> handler5(@PathVariable("UniqueID") int UniqueID){
		try{
			this.itServices.deleteItem(UniqueID);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
