package restaurant_billing_system.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant_billing_system.models.Order;

public class OrderRepository {
	// connection
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}
	
	public int add(Order order) {
		
		String sql="INSERT INTO order(id,status,date_and_time,table_id,payment_id,total_price) VALUES(?,?,?,?,?,?)";
		int result;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, order.getId());
			ps.setString(2, order.getStatus());
			ps.setString(3, order.getDate_and_time());
			ps.setInt(4,order.getTable_id());
			ps.setInt(5, order.getPayment_id());
			ps.setDouble(6, order.getTotal_price());
			
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("Order insert error: "+e);
	    }
		return result;
}
	
	public int edit(Order order) {
		int result=0;
		String sql="UPDATE order SET status=?,date_and_time=?,table_id=?,payment_id=?,total_price=? WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, order.getStatus());
			ps.setString(2, order.getDate_and_time());
			ps.setInt(3,order.getTable_id());
			ps.setInt(4, order.getPayment_id());
			ps.setDouble(5, order.getTotal_price());
			
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("Order edit error: "+e);
	    }
		return result;
}
	
	public int delete(int id) {
		int result=0;
		String sql="DELETE FROM order WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1,id);
			
			
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("Order delete err : "+e);
		}
		return result;
	}
	
	public List<Order>getAll(){
		List<Order> orders=new ArrayList<>();
		String sql="SELECT * FROM order";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Order order=new Order();
				order.setId(rs.getInt("id"));
				order.setStatus(rs.getString("status"));
				order.setDate_and_time(rs.getString("date_and_time"));
				order.setTable_id(rs.getInt("table_id"));
				order.setPayment_id(rs.getInt("payment_id"));
				order.setTotal_price(rs.getDouble("total_price"));
			
				orders.add(order);
				
			}
			
			
		}catch(SQLException e) {
			System.out.println("Order select err : "+e);
		}
		
		return orders;
	}
	
	public Order getById(int id) {
		Order order=null;

	    String sql = "SELECT o.*, oi.name as order_item_name,oi.total_price as order_item_total_price,t.id as table_id " +
                "FROM order o WHERE id=? " +
                "INNER JOIN order_item oi ON o.order_item_id = oi.id " +
                "INNER JOIN table t ON o.table_id = t.id";


		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				order=new Order();
				order.setId(rs.getInt("id"));
				order.setStatus(rs.getString("status"));
				order.setDate_and_time(rs.getString("date_and_time"));
				order.setTable_id(rs.getInt("table_id"));
				order.setPayment_id(rs.getInt("payment_id"));
				order.setTotal_price(rs.getDouble("total_price"));
			}
			
			
		}catch(SQLException e) {
			order=null;
			System.out.println("Course getbycode err : "+e);
		}
		return order;
		
	}
}
