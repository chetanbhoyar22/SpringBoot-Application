package com.enterprise.officemanager;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.enterprise.models.CustomerProducts;
import com.enterprise.models.CustomersProductsManager;
import com.enterprise.models.Employee;
import com.enterprise.models.EmployeeManager;
import com.enterprise.models.Products;

@Controller
public class OfficeController 
{
	
	@Autowired
	private CustomersProductsManager cpm;
	
	@Autowired
	private EmployeeManager em;

	@RequestMapping("office")

	public String index()
	{
		return "index.jsp";
	}
	
	@RequestMapping("checkcode")
	public String checkCode(@RequestParam String code)
	{
		String flag="Failure.jsp";
		
		if(code.equals("mission"))
			flag="UserHome.jsp";
		
		return flag;
	}
	
	@RequestMapping("newemp")
	public String newEmployee()
	{
		return "NewEmployee.jsp";
	}
	
	@RequestMapping("register")
	public ModelAndView registerEmployee(Employee e)
	{
		
		ModelAndView mv=new ModelAndView();
		
//		EmployeeManager em=new EmployeeManager();
		if(em.addEmployee(e))
		{
			mv.addObject("msg", "New Employee Registered Successfully..");
			mv.setViewName("Success.jsp");
		}
		else
		{
			mv.addObject("msg", "New Employee Registration Failed..");
			mv.setViewName("Error.jsp");
		}
		
		return mv;
	}
	
	
	@RequestMapping("prodlist")
	public ModelAndView productsList()
	{
		ModelAndView mv=new ModelAndView();
		
		//CustomersProductsManager cpm=new CustomersProductsManager();
		ArrayList<Products> plist=cpm.getProductsList();
		
		mv.addObject("plist", plist);
		mv.setViewName("ProdPurchaseReport.jsp");
		
		return mv;
	}
	
	
	@RequestMapping("prodpurchase")
	public ModelAndView purchaseReport(@RequestParam String prodid)
	{
		ModelAndView mv=new ModelAndView();
		
		//CustomersProductsManager cpm=new CustomersProductsManager();
		ArrayList<CustomerProducts> cplist=cpm.getPurchaseReport(prodid);
		
		mv.addObject("purchaselist", cplist);
		mv.setViewName("ShowPurchaseReport.jsp");
		
		return mv;
	}
	
	
	
}
