package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class ItemDAO implements ItemDAOTemplate{
	private static ItemDAO dao = new ItemDAO();
	
	public ItemDAO() {
		try {
			Class.forName(ServerInfo.DRVIER_NAME);
		} catch (ClassNotFoundException e) {
		}
	}
	
	public static ItemDAO getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connection");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	@Override
	public ArrayList<Item> getAllItem() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM ITEM";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Item> list  = new ArrayList<>();
		while (rs.next()) {
			Item item = new Item();
			item.setItemName(rs.getString("name"));
			item.setPrice(rs.getInt("price"));
			list.add(item);
		}
		closeAll(rs, ps, conn);
		return list;
	}

	@Override
	public Item getItem(int itemId) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM item WHERE item_id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		ps.setInt(1, itemId);
		Item item = null;
		if(rs.next()) {
			item = new Item();
			item.setItemName(rs.getString("itemId"));
			item.setPrice(rs.getInt("price"));
			item.setDescription(rs.getString("descripton"));
		}
		closeAll(rs,ps,conn);
		return item;
	}

	@Override
	public boolean updateRecordCount(int itemId) throws SQLException {
		Connection conn = getConnection();
		Item item = new Item();
		
		String query = "UPDATE item SET COUNT = COUNT + 1 WHERE item_id = '?'";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(itemId, item.getCount());
		
		ps.executeUpdate();
		closeAll(ps, conn);
		
		return false;
	}
	
}