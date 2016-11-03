package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	public static Connection getConnection(){
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/student";
		String username = "root";
		String password = "abc123!@#";

		System.out.println("Connecting database...");
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void closeConnection( Connection conn) {
        if( conn == null )
            return;
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		Connection conn = getConnection();
		
		if(conn == null){
			System.out.println("Can't connect to database");
		}else{
			System.out.println("Connect to database successful");
		}
	}

}
