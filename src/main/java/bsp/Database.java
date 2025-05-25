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
}