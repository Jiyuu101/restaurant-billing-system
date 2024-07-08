package restaurant_billing_system.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuItemRepository {
// connection
		public static Connection con = null;
		static {
			con = MyConnection.getConnection();
		}
		//insert
		public int add() {
			int result=0;
			String sql="";
			try {
				
				PreparedStatement ps=con.prepareStatement(sql);
				result = ps.executeUpdate();
				
			}catch(SQLException e) {
				result=0;
				System.out.println("err: " + e);
			}
			return result;
		}
		// Update (edit)
		public int edit() {
			int result = 0;
			String sql = "";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				
				
				result = ps.executeUpdate();

			} catch (SQLException e) {
				result = 0;
				System.out.println("edit err: " + e);
			}
			return result;
		}
		// delete
		public int delete(int id) {
			int result = 0;
			String sql = "";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				

				result = ps.executeUpdate();

			} catch (SQLException e) {
				result = 0;
				System.out.println(" delete err: " + e);
			}
			return result;
		}
		

}
