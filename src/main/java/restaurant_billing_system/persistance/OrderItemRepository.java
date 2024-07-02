package restaurant_billing_system.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant_billing_system.models.OrderItem;

public class OrderItemRepository {

	// connection
		public static Connection con = null;
		static {
			con = MyConnection.getConnection();
		}
		
		public int add(OrderItem orderItem) {
			
			String sql="INSERT INTO order_item(id,menu_item_id,order_id,quantity,price,total_price) VALUES(?,?,?,?,?,?)";
			int result;
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, orderItem.getMenu_item_id());
				ps.setString(2, orderItem.getMenu_item_name());
				ps.setInt(3, orderItem.getOrder_id());
				ps.setInt(4,orderItem.getQuantity());
				ps.setDouble(5, orderItem.getPrice());
				ps.setDouble(6, orderItem.getTotal_price());
				
				result=ps.executeUpdate();
				
			}catch(SQLException e) {
				result=0;
				System.out.println("Order Item insert error: "+e);
		    }
			return result;
	}		
		
		public int edit(OrderItem orderItem) {
			int result=0;
			String sql="UPDATE order_item SET menu_item_id=?,order_id=?,quantity=?,price=?,total_price=? WHERE id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, orderItem.getMenu_item_id());
				ps.setString(2, orderItem.getMenu_item_name());
				ps.setInt(2, orderItem.getOrder_id());
				ps.setInt(3,orderItem.getQuantity());
				ps.setDouble(4, orderItem.getPrice());
				ps.setDouble(5, orderItem.getTotal_price());
				
				result=ps.executeUpdate();
				
			}catch(SQLException e) {
				result=0;
				System.out.println("Order Item edit error: "+e);
		    }
			return result;
	}
		
		public int delete(int id) {
			int result=0;
			String sql="DELETE FROM order_item WHERE id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setInt(1,id);
				
				
				result=ps.executeUpdate();
				
			}catch(SQLException e) {
				result=0;
				System.out.println("Order Item delete err : "+e);
			}
			return result;
		}
		
		public List<OrderItem>getAll(){
			List<OrderItem> orderItems=new ArrayList<>();
		    String sql = "SELECT oi.*, mi.name as menu_item_name,mi.price as menu_item_price,mit.type as menu_item_type_name " +
	                 "FROM order_item oi " +
	                 "INNER JOIN menu_item mi ON oi.menu_item_id = mi.id " +
	                 "INNER JOIN menu_item_type mit ON mi.menu_item_type_id = mit.id";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					OrderItem orderItem=new OrderItem();
					orderItem.setId(rs.getInt("id"));
					orderItem.setMenu_item_id(rs.getInt("menu_item_id"));
					orderItem.setMenu_item_name(rs.getString("menu_item_name"));
					orderItem.setMenu_item_type_name(rs.getString("menu_item_type_name"));
					orderItem.setOrder_id(rs.getInt("order_id"));
					orderItem.setQuantity(rs.getInt("quantity"));
					orderItem.setPrice(rs.getDouble("price"));
					orderItem.setTotal_price(rs.getDouble("total_price"));
				
					orderItems.add(orderItem);
					
				}
				
				
			}catch(SQLException e) {
				System.out.println("Order Item select err : "+e);
			}
			
			return orderItems;
		}
		
		public OrderItem getById(int id) {
			OrderItem orderItem=null;
			String sql="SELECT * FROM order_item WHERE id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					orderItem=new OrderItem();
					orderItem.setId(rs.getInt("id"));
					orderItem.setMenu_item_id(rs.getInt("menu_item_id"));
					orderItem.setOrder_id(rs.getInt("order_id"));
					orderItem.setQuantity(rs.getInt("quantity"));
					orderItem.setPrice(rs.getDouble("price"));
					orderItem.setTotal_price(rs.getDouble("total_price"));
				}
				
				
			}catch(SQLException e) {
				orderItem=null;
				System.out.println("Order Item getbycode err : "+e);
			}
			return orderItem;
			
		}
}
