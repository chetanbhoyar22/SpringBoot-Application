package com.myapi.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapi.models.Accounts;


@Service
public class AccountsServices 
{
	@Autowired
	DBConnector dbobj;
	
	public ArrayList<Accounts> getAllAccounts()
	{
		ArrayList<Accounts> alist=new ArrayList<Accounts>();
		Connection con;
		Statement st;
		ResultSet rs;
		
		try
		{			
			con=dbobj.getConnected();
			
			st=con.createStatement();
			rs=st.executeQuery("select * from accounts");
			
			Accounts acc;
			
			while(rs.next())
			{
				acc=new Accounts();
				
				acc.setAccno(rs.getInt("id"));
				acc.setAccnm(rs.getString("accnm"));
				acc.setAcctype(rs.getString("acctype"));
				acc.setBalance(rs.getDouble("balance"));
				
				alist.add(acc);
			}
			
		}
		catch(Exception ex) 
		{
			System.out.println("Exception : "+ex);
		}
		return alist;
	}
	
	
	public Accounts getAccById(int accno)
	{
		Accounts acc=new Accounts();
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try
		{
			con=dbobj.getConnected();
			
			pst=con.prepareStatement("select * from accounts where id=?");
			pst.setInt(1, accno);
			
			rs=pst.executeQuery();
			
			if(rs.next())
			{
				acc.setAccno(rs.getInt("id"));
				acc.setAccnm(rs.getString("accnm"));
				acc.setAcctype(rs.getString("acctype"));
				acc.setBalance(rs.getDouble("balance"));
			}
		}
		catch(Exception ex)
		{
			System.out.println("Exception : "+ex);
		}
		
		return acc;
	}

	public int createAccount(Accounts acc)
	{
		int cnt=0;
		Connection con;
		CallableStatement cst;
		
		try
		{
			con=dbobj.getConnected();
			
			cst=con.prepareCall("{call newacc(?,?,?,?)}");
			
			cst.setInt(1, acc.getAccno());
			cst.setString(2,acc.getAccnm());
			cst.setString(3,acc.getAcctype());
			cst.setDouble(4, acc.getBalance());
			
			cnt=cst.executeUpdate();
			System.out.println("Inserted : "+cnt);
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception : "+ex);
		}
		
		return cnt;
	}
	
}
