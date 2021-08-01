package com.interview.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
private static Connection con;
	
	public static Connection getConnetcion() throws ClassNotFoundException, SQLException {
		if(con==null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","aravind1","12345");
		}
		return con;
	}
}
