package com.inventory.management.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.inventory.management.dao.Item_DetailsRepo;
import com.inventory.management.entities.Item_Details;

@Component
public class Item_DetailsServices 
{
	@Autowired
	private Item_DetailsRepo itdRepo;
	public List<Item_Details> getAllItem_Details() 
	{
		List<Item_Details>itd1=(List<Item_Details>)this.itdRepo.findAll();
		return itd1;
	}
	
	public Item_Details getItem_DetailsById(int id) 
	{
		Item_Details itd2=null;
		try
		{
		    itd2=this.itdRepo.findById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return itd2;
	}
	public Item_Details addItem_Details(Item_Details itd3) 
	{
		this.itdRepo.save(itd3);
		return itd3;
	}
	public void deleteItem_Details(int id) 
	{
		itdRepo.deleteById(id);
	}
	public Item_Details updateItem_Details(Item_Details itd3,int id) 
	{
		Item_Details itd=new Item_Details();
		itd.setId(itd3.getId());
		itd.setName(itd3.getName());
		itd.setDescription(itd3.getDescription());
		itd.setMedia(itd3.getMedia());
		this.itdRepo.save(itd);
		return itd;
	}
}
