package com.myapi.services;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Service;

@Service
public class DBConnector 
{
	public Connection getConnected()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chetan?user=root&password=12345");
		}
		catch(Exception ex) {}
		
		return con;
	}

}
