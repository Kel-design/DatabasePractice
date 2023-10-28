package com.cupitmadland.item.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cupitmadland.item.daointerface.ConnectionDao;
import com.cupitmadland.item.daointerface.ItemDao;
import com.cupitmadland.item.model.Item;

public class ItemDaoImpl extends ConnectionDao implements ItemDao{

	
	private ArrayList<Item> itemObj;
	
	@Override
	public List<Item> getAllItems() {
		try {
			Connection connection = ConnectionDao.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM item");
			List itemList = new ArrayList<>();
			
			while (rs.next());{
				Item i = new Item();
				i.setId(rs.getInt("id"));
				i.setName(rs.getString("name"));
				i.setPrice(rs.getDouble("price"));
				itemList.add(i);
			}
		
		return itemList;
	}catch(SQLException ex) {
		ex.printStackTrace();
		System.out.printf("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
	}
		return null;
	}
	@Override
	public void saveItem(List<Item> itemList) {
		try {
			Connection con = ConnectionDao.getConnection();
			for (Item i: itemList) {
				String sqlQuery = "INSERT INTO item (id, name, price) VALUES(?,?,?)";
				PreparedStatement ps = con.prepareStatement(sqlQuery);
				ps.setInt(1, i.getId());
				ps.setString(2, i.getName());
				ps.setDouble(3, i.getPrice());
				int affectedRows = ps.executeUpdate();
				System.out.println(affectedRows + " row(s) affected");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addItem(Item i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeItemById(int id) {
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE ITEMS FROM item WHERE id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i == 1 ) {
				return true;
			}	
		}catch(SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return false;
	}
	

}
