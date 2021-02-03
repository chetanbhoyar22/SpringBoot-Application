package com.enterprise.models;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Service;

@Service
public class EmployeeManager 
{
	public boolean addEmployee(Employee emp)
	{
		boolean flag=false;
		Connection con;
		PreparedStatement pst;
		
		try
		{
			DBConnector dbobj=new DBConnector();
			con=dbobj.getConnected();
			
			pst=con.prepareStatement("insert into employee values(?,?,?,?,?)");
			
			pst.setInt(1, emp.getEmpno());
			pst.setString(2,emp.getEmpname());
			pst.setString(3,emp.getDept());
			pst.setDouble(4, emp.getSalary());
			pst.setString(5, emp.getLocation());
			
			int n=pst.executeUpdate();
			
			if(n>0)
				flag=true;
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		return flag;
	}

}
