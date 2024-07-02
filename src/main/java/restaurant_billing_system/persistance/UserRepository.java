package restaurant_billing_system.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant_billing_system.models.User;

public class UserRepository {
	// connection
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}
	
	public User getByLogin(String email, String password) {
	    User user = null;
	    String sql = "SELECT b.*, a.name as role_name FROM role a INNER JOIN user b ON b.role_id = a.id WHERE b.email = ? AND b.password = ?";
	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, email);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            user = new User();
	            user.setId(rs.getInt("id"));
	            user.setName(rs.getString("name"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            user.setRole_id(rs.getInt("role_id"));
	            user.setRole_name(rs.getString("role_name"));
	            System.out.println("User found: " + user.getEmail() + ", Role: " + user.getRole_name());
	        } else {
	            System.out.println("No user found with email: " + email);
	        }
	    } catch (SQLException e) {
	        System.out.println("User getByLogin error: " + e);
	    }
	    return user;
	}


	
	
	public int add(User user) {
		int result=0;
		String sql="INSERT INTO user(id,name,email,password,role_id) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3,user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getRole_id());
			
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("User insert error: "+e);
	    }
		return result;
}
	
	public int edit(User user) {
		int result=0;
		String sql="UPDATE user SET name=?,email=?,password=?,role_id=? WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getRole_id());
			
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("User edit error: "+e);
	    }
		return result;
}
	
	public int delete(int id) {
		int result=0;
		String sql="DELETE FROM user WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1,id);
			
			
			result=ps.executeUpdate();
			
		}catch(SQLException e) {
			result=0;
			System.out.println("User delete err : "+e);
		}
		return result;
	}
	
	public List<User>getAll(){
		List<User> users=new ArrayList<>();
		String sql="SELECT * FROM user";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole_id(rs.getInt("role_id"));
			
				users.add(user);
				
			}
			
			
		}catch(SQLException e) {
			System.out.println("User select err : "+e);
		}
		
		return users;
	}
	
	public User getByCode(int id) {
		User user=null;
		String sql="SELECT * FROM user WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole_id(rs.getInt("role_id"));
			}
			
			
		}catch(SQLException e) {
			user=null;
			System.out.println("User getbycode err : "+e);
		}
		return user;
		
	}
}
