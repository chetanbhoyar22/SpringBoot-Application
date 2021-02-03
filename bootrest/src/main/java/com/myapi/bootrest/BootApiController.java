package com.myapi.bootrest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapi.models.Accounts;
import com.myapi.services.AccountsServices;

@RestController
@RequestMapping("/api/boot")
public class BootApiController
{
	@Autowired
	private AccountsServices serv;
	
	@GetMapping("/allaccounts")
	public ArrayList<Accounts> showAllAccounts()
	{		
		ArrayList<Accounts> alist=serv.getAllAccounts();
		return alist;
	}
	
	@GetMapping("/searchacc/{id}")
	public Accounts searchAccount(@PathVariable(value="id") int ano)
	{
		Accounts acc=serv.getAccById(ano);
		return acc;
	}
	
//	@PostMapping("/newacc")
//	public Accounts newAccount(@RequestBody Accounts obj)
//	{
//		serv.createAccount(obj);		
//		return obj;
//	}
	
	@PostMapping("/newacc")
	public ResponseEntity<String> newAccount(@RequestBody Accounts obj)
	{
		String msg="Account creation failed..";
		
		int n=serv.createAccount(obj);	
		
		if(n>0)
			msg="Account created successfully..";
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	

}
