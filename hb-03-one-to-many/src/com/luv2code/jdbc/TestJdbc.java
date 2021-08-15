package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
		
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try
		{
			System.out.println("Connecting to DB:" + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection Successful");
			
		}
		
		catch(Exception exc)
		{
			System.out.println("ERROR");
			
		}

	}

}