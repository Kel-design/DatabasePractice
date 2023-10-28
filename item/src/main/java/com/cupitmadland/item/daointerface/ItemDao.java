package com.cupitmadland.item.daointerface;

import java.util.List;

import com.cupitmadland.item.model.Item;

public interface ItemDao {
	
	List<Item> getAllItems();
	void saveItem(List<Item> itemList);
	void addItem(Item i);
	boolean removeItemById(int id);

}
