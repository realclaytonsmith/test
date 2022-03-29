package com.project.service;

import java.util.List;

import com.project.model.Item;

public interface ItemService {

	 List < Item > getAllItems();
	    void saveItem(Item item);
	    Item getItemById(long id);
	    void deleteItemById(long id);
}
