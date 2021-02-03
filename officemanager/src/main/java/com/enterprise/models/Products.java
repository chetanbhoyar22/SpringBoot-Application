package com.enterprise.models;

public class Products 
{
	private String prodid;
	private String prodname;
	private String company;
	private double price;
	
	public Products()
	{
		prodid="";
		prodname="";
		company="";
		price=0.0;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
