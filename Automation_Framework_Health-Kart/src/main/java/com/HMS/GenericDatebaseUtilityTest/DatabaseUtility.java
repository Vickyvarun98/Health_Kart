package com.HMS.GenericDatebaseUtilityTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;
	

	public void getConnection(String url, String Username, String Password) throws SQLException {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, Username, Password);
		} catch (Exception e) {

		}
	}
		
	public void closeConnection() throws SQLException {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	
	
	
	
	
	public ResultSet executeSelectQuery(String Query) throws SQLException {

		ResultSet result = null;
		;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(Query);
		} catch (Exception e) {
		}
		return result;
	}

	
	
	
	
	
	public int executeNonSelectQuery(String Query) throws SQLException {
		int result = 0;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeUpdate(Query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public void Update(int result) {
		if (result==0) {
			System.out.println("Value is not Updated...");
		}
		else {
			System.out.println("Value is Updated...");
		}
	}

}
