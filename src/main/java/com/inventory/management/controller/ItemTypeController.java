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

import com.inventory.management.entities.ItemType;
import com.inventory.management.services.ItemTypeServices;

@RestController
public class ItemTypeController {
	@Autowired
	private ItemTypeServices itServices;
	@GetMapping("/itemtype")
	public ResponseEntity<List<ItemType>> handler1(){
		List<ItemType> itList= this.itServices.getAllItemType();
		if(itList==null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(itList));
	}
	@GetMapping("/itemtype/{id}")
	public ResponseEntity<ItemType> handler2(@PathVariable("id") int id){
		ItemType it1=this.itServices.getItemTypeById(id);
		if(it1==null)
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(it1));
	}
	@PostMapping("/itemtype")
	public ResponseEntity<ItemType> handler3(@RequestBody ItemType it) {
		try {
		ItemType it2=this.itServices.addItemType(it);
		return ResponseEntity.status(HttpStatus.CREATED).body(it);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@PutMapping("/itemtype/{id}")
	public ResponseEntity<ItemType> handler4(@RequestBody ItemType it, @PathVariable("id") int id){
		try{
			ItemType it3=this.itServices.updateItemType(it);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@DeleteMapping("/itemtype/{id}")
	public ResponseEntity<Void> handler5(@PathVariable("id") int id){
		try{
			this.itServices.deleteItemType(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
