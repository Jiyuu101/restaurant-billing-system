package restaurant_billing_system.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant_billing_system.models.MenuItemType;

public class MenuItemTypeRepository {
	// connection
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}
	
	public int add(MenuItemType menuItemType) {
		String sql="INSERT INTO menu_item_type(type,is_available)VALUES(?,?)";
		int result;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, menuItemType.getType());
			ps.setBoolean(2,menuItemType.isIs_available());
			
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("Menu item type insert error: "+e);
	    }
		return result;
	}
	
	
	public int edit(MenuItemType menuItemType) {
		int result=0;
		String sql="UPDATE menu_item_type SET type=?,is_available=? WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, menuItemType.getType());
			ps.setInt(2, menuItemType.getId());
			ps.setBoolean(3,menuItemType.isIs_available());
			
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("Menu item type edit error: "+e);
	    }
		return result;
}
	
	public int delete(int id) {
	    int result = 0;
	    String sql = "DELETE FROM menu_item_type WHERE id = ?";
	    try {
	    	PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1,id);
	
			result=ps.executeUpdate();
			
	    } catch (SQLException e) {
	        result = 0;
	        System.out.println("Menu item type delete error: " + e);
	    }
	    return result;
	}
	
	public List<MenuItemType>getAll(){
		List<MenuItemType> menuItemTypes=new ArrayList<>();
		String sql="SELECT * FROM menu_item_type where is_available=1";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				MenuItemType menuItemType=new MenuItemType();
				menuItemType.setId(rs.getInt("id"));
				menuItemType.setType(rs.getString("type"));
				menuItemType.setIs_available(rs.getBoolean("is_available"));
			
				menuItemTypes.add(menuItemType);
				
			}
			
		}catch(SQLException e) {
			System.out.println("Menu item type select err : "+e);
		}
		
		return menuItemTypes;
	}
	
	public MenuItemType getById(int id) {
		MenuItemType menuItemType=null;
		String sql="SELECT * FROM menu_item_type WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				menuItemType=new MenuItemType();
				menuItemType.setId(rs.getInt("id"));
				menuItemType.setType(rs.getString("type"));
				
			}
			
			
		}catch(SQLException e) {
			menuItemType=null;
			System.out.println("Menu item type getbycode err : "+e);
		}
		return menuItemType;
		
	}
}
