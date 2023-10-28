package com.cupitmadland.item;

import java.util.ArrayList;
import java.util.List;

import com.cupitmadland.item.controller.ItemDaoImpl;
import com.cupitmadland.item.model.Item;

public class App 
{
    public static void main( String[] args )
    {
    	ItemDaoImpl obj = new ItemDaoImpl();
    	
//    	ArrayList<Item> itemlist = new ArrayList<Item>();
//    	itemlist.add(new Item(650, "pencil", 10.00));
//       obj.saveItem(itemlist);
//       System.out.println("--------Item added Successfully-------");
       
       obj.removeItemById(350);
       System.out.println("--------Item(s) deleted Successfully-------");
       
      
       
    }
}
