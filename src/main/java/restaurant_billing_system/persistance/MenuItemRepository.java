package restaurant_billing_system.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant_billing_system.models.MenuItem;

public class MenuItemRepository {

// connection
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}
		
	public int add(MenuItem menuItem) {
		String sql="INSERT INTO menu_item(id,name,description,price,menu_item_type_id)VALUES(?,?,?,?,?)";
		int result;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, menuItem.getId());
			ps.setString(2, menuItem.getName());
			ps.setString(3, menuItem.getDescription());
			ps.setDouble(4, menuItem.getPrice());
			ps.setInt(5,menuItem.getMenu_item_type_id());
			
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("Menu item insert error: "+e);
	    }
		return result;
	}	
	
	public int edit(MenuItem menuItem) {
		int result=0;
		String sql="UPDATE menu_item SET name=?,description=?,price=?,menu_item_type_id=? WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, menuItem.getName());
			ps.setString(2, menuItem.getDescription());
			ps.setDouble(3, menuItem.getPrice());
			ps.setInt(4, menuItem.getMenu_item_type_id());
			ps.setInt(5, menuItem.getId());
			
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("Menu item  edit error: "+e);
	    }
		return result;
}
	
	public int delete(int id) {
		int result=0;
		String sql="DELETE FROM menu_item WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1,id);
			
			
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("Menu item delete err : "+e);
		}
		return result;
	}
	
	public List<MenuItem>getAll(){
		List<MenuItem> menuItems=new ArrayList<>();
		String sql="SELECT b.*,a.type as menu_item_type_name FROM menu_item b INNER JOIN menu_item_type a ON b.menu_item_type_id=a.id";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				MenuItem menuItem=new MenuItem();
				menuItem.setId(rs.getInt("id"));
				menuItem.setName(rs.getString("name"));
				menuItem.setDescription(rs.getString("description"));
				menuItem.setPrice(rs.getDouble("price"));
				menuItem.setMenu_item_type_id(rs.getInt("menu_item_type_id"));
				menuItem.setMenu_item_type_name(rs.getString("menu_item_type_name"));
			
				menuItems.add(menuItem);
				
			}
			
			
		}catch(SQLException e) {
			System.out.println("Menu item select err : "+e);
		}
		
		return menuItems;
	}
	
	public MenuItem getById(int id) {
		MenuItem menuItem=null;
		String sql="SELECT * FROM menu_item WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				menuItem=new MenuItem();
				menuItem.setId(rs.getInt("id"));
				menuItem.setName(rs.getString("name"));
				menuItem.setDescription(rs.getString("description"));
				menuItem.setPrice(rs.getDouble("price"));
				menuItem.setMenu_item_type_id(rs.getInt("menu_item_type_id"));
				
			}
			
			
		}catch(SQLException e) {
			menuItem=null;
			System.out.println("Menu item getbycode err : "+e);
		}
		return menuItem;
		
	}
}
