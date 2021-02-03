package com.enterprise.models;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class CustomersProductsManager 
{
	public ArrayList<Products> getProductsList()
	{
		ArrayList<Products> plist=new ArrayList<Products>();
		Connection con;
		Statement st;
		ResultSet rs;
		
		try
		{
			DBConnector dbobj=new DBConnector();
			con=dbobj.getConnected();
			
			st=con.createStatement();
			rs=st.executeQuery("select * from products");
			
			Products obj;
			
			while(rs.next())
			{
				obj=new Products();
				obj.setProdid(rs.getString("prodid"));
				obj.setProdname(rs.getString("prodnm"));
				obj.setPrice(rs.getDouble("price"));
				obj.setCompany(rs.getString("company"));
				
				plist.add(obj);
			}
			
		}
		catch(Exception ex) {}
		
		return plist;
	}

	
	public ArrayList<CustomerProducts> getPurchaseReport(String prodid)
	{
		ArrayList<CustomerProducts> lst=new ArrayList<CustomerProducts>();
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try
		{
			DBConnector dbobj=new DBConnector();
			con=dbobj.getConnected();
			
			pst=con.prepareStatement("select * from customerproducts where prodid=?");
			pst.setString(1,prodid);
			
			rs=pst.executeQuery();
			
			CustomerProducts obj;
			while(rs.next())
			{
				obj=new CustomerProducts();
				obj.setProdid(rs.getString("prodid"));
				obj.setProdnm(rs.getString("prodnm"));
				obj.setPrice(rs.getDouble("price"));
				obj.setCompany(rs.getString("company"));
				obj.setCustno(rs.getInt("custno"));
				obj.setCustname(rs.getString("custnm"));
				obj.setPaymode(rs.getString("paymode"));
				
				lst.add(obj);
			}
			
		}
		catch(Exception ex)
		{
			
		}
		
		return lst;
	}
	
	
}
