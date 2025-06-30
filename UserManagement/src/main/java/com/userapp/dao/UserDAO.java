package com.userapp.dao;

import com.userapp.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	protected Connection con = null;

    // Database Connection details
    private static final String URL = "jdbc:mysql://localhost:3306/userdb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    // Load MySQL Driver once when class loads
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Explicitly load MySQL driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to get the DB Connection
    private Connection getConnection() throws SQLException {
    	Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);	
    		return connection;
    	
    }

    // Method to add a USER to Database
    public boolean addUser(User user) {
        String qry = "INSERT INTO users (name, email,contact,password) VALUES (?,?,?,?)";

        try{
        	
        	Connection con = getConnection(); 
        	PreparedStatement pstmt = con.prepareStatement(qry);
            // setting values to the placeholders
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getContact());
            pstmt.setString(4, user.getPassword());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Method to Validate a User
    public boolean validateUser(String email,String password) {
    	boolean isExist = false;
    	try {
    		Connection con = getConnection();
    		ResultSet rs = null;
    		String qry = "Select *from users where email = ? and password = ?";
    		PreparedStatement pstmt = con.prepareStatement(qry);
    		
    		pstmt.setString(1,email);
    		pstmt.setString(2,password);
    		
    		rs = pstmt.executeQuery();
    		
    		isExist = rs.next(); //true if user and password exist
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return isExist;
    }
    
    

    // Method to get all users from the Database
    public List<User> getUsers() {
//    	System.out.println("Starting to fetch users");
        List<User> users = new ArrayList<>();
        String qry = "SELECT * FROM users";

        try {
        	Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(qry);
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("contact"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
//        System.out.println("Count of users fetched the users from DB: "+users.size());

        return users;
    }

    // Method to delete a USER from the Database
//    public boolean deleteUser(int id) {
//        String qry = "DELETE FROM users WHERE id = ?";
//        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(qry)) {
//
//            pstmt.setInt(1, id);
//
//            int rowsAffected = pstmt.executeUpdate();
//            return rowsAffected > 0;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    //Get the User
	public User getUserById(int id) {
		User user = null;
		try {
			Connection con = getConnection();
			String qry = "SELECT *FROM users WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setContact(rs.getString("contact"));
				
			
				
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	//Update User
	public boolean updateUser(User user) {
	    boolean rowUpdated = false;
	    try {
	        Connection conn = getConnection();
	        String sql = "UPDATE users SET name = ?, email = ?, contact = ? WHERE id = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, user.getName());
	        stmt.setString(2, user.getEmail());
	        stmt.setString(3, user.getContact());
	        stmt.setInt(4, user.getId());

	        rowUpdated = stmt.executeUpdate() > 0;
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return rowUpdated;
	}
		
	//Delete the User
	public boolean deleteUser(int id) {
	    boolean deleted = false;
	    try {
	        Connection conn = getConnection();
	        String sql = "DELETE FROM users WHERE id = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, id);

	        deleted = stmt.executeUpdate() > 0;
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return deleted;
	}
}
