package com.aca.coffeestore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbUtil {
	
	private static String connectionUrl = 
			"jdbc:mariadb://localhost:3306/mycoffee?user=root&password=sack2191";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		return connection;
	}

	public static void main(String[] args) {
		Connection conn = MariaDbUtil.getConnection();
		if (null != conn) {
			System.out.println("Got my first Java connection to my DB!");
			
			
		} else {
			System.out.println("Failed to connect");
		}
		

	}

}
