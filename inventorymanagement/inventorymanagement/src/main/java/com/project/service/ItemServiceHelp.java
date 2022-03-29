package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.model.Item;
import com.project.repository.ItemRepository;

public class ItemServiceHelp implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public List<Item>getAllItems() {
		return itemRepository.findAll();
	}
	
	@Override
	public void saveItem(Item item) {
		this.itemRepository.save(item);
	}
	 @Override
	    public Item getItemById(long id) {
	        Optional < Item > optional = itemRepository.findById(id);
	        Item item = null;
	        if (optional.isPresent()) {
	            item = optional.get();
	        } else {
	            throw new RuntimeException(" Item wasn't found for id :: " + id);
	        }
	        return item;
	    }

	    @Override
	    public void deleteItemById(long id) {
	        this.itemRepository.deleteById(id);
	    }
}
