package restaurant_billing_system.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import restaurant_billing_system.models.MenuItemType;
import restaurant_billing_system.models.Order;

public class MenuItemTypeRepository {
	// connection
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}
	
	public int add(MenuItemType menuItemType) {
		String sql="INSERT INTO menu_item_type(id,type)VALUES(?,?)";
		int result;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, menuItemType.getId());
			ps.setString(2, menuItemType.getType());
			
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("Menu item type insert error: "+e);
	    }
		return result;
	}
	
	public int edit(MenuItemType menuItemType) {
		int result=0;
		String sql="UPDATE order SET type=? WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, menuItemType.getType());
			
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("Menu item type edit error: "+e);
	    }
		return result;
}
}
