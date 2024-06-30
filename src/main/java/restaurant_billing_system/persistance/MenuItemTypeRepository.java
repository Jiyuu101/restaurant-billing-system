package restaurant_billing_system.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale.Category;

import restaurant_billing_system.models.MenuItemType;

public class MenuItemTypeRepository {

	//connection
	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
		
	}
	public int add(MenuItemType menuItemtype) {
		int result=0;
		String sql="INSERT INTO menu_item_type(id, type) VALUES(?,?)";
		try {
			PreparedStatement mn=con.prepareStatement(sql);
			mn.setInt(1, menuItemtype.getId());
			mn.setString(2, menuItemtype.getType());
			
			result = mn.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("Menu Item Type insert error: "+ e);
		}return result;
	}
	
	//delete
	
	public int delete(int id) {
		int result=0;
		String sql="DELETE FROM menu_item_type id=?";
		try {
			PreparedStatement mn=con.prepareStatement(sql);
			mn.setInt(1, id);
			
			result = mn.executeUpdate();
		}catch(SQLException e) {
			result=0;
			System.out.println("Category delete error :"+ e);
		}return result;
		
	}
}
