package bsp;

import java.sql.*;
import java.util.logging.Logger;


public class Database {
	 private static final String DB_URL = "jdbc:sqlite:BRGY.db";
	    private static final Logger LOGGER = Logger.getLogger(Database.class.getName());
	    
	    public static Connection connect() throws SQLException {
	        return DriverManager.getConnection(DB_URL);
	    }
	    
	    public static void MembersTable() {
	        String StaffMembersTale = "CREATE TABLE IF NOT EXISTS (" +
	                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
	                "fullName TEXT NOT NULL, " +
	                "Username TEXT NOT NULL UNIQUE, " +
	                "Password TEXT NOT NULL, " +
	                "Position TEXT NOT NULL, " +
	                "Email TEXT NOT NULL UNIQUE, " +
	                "PhoneNumber TEXT NOT NULL UNIQUE, " +
	                "Address TEXT NOT NULL" +
	                ");";


	        try (Connection conn = connect();
	             Statement stmt = conn.createStatement()) {
	            stmt.execute(StaffMembersTale);
	        } catch (SQLException e) {
	            LOGGER.severe("Error creating tables: " + e.getMessage());
	        }
	    }
	    
	    public static boolean loginStaff(String Username, String Password) {
	        String sql = "SELECT 1 FROM members WHERE Username = ? AND Password = ?";
	        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, Username);
	            ps.setString(2, Password);
	            try (ResultSet rs = ps.executeQuery()) {
	                return rs.next();
	            }
	        } catch (SQLException e) {
	            return false;
	        }
	    }
	    public static boolean registerStaff(String fullName, String Username, String Password, String Position, String Email, String PhoneNumber, String Address) {
	        String sql = "INSERT INTO members (fullName, Username, Password, Position, Email, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, fullName);
	            ps.setString(2, Username);
	            ps.setString(3, Password);
	            ps.setString(4, Position);
	            ps.setString(5, Email);
	            ps.setString(6, PhoneNumber);
	            ps.setString(7, Address);
	            ps.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            return false;
	        }
	    }
	    
	    
	    
}