package restaurant_billing_system.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	static Connection con=null;
	public static Connection getConnection() {
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 String db="jdbc:mysql://localhost:3306/bookdb_m_m";
			 String username="root";
			 String password="root";
			 con=DriverManager.getConnection(db,username,password); 
			 } catch (ClassNotFoundException e) {
			 System.out.println("Driver class not found");
			 } catch (SQLException e) {
			 System.out.println("Database Coonectin not found"); 
			}
		return con;
	}
}
	