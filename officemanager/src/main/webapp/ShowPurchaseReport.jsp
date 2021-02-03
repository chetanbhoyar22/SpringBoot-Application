<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core_rt" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table class="table table-bordered table-hover" style="width:70%">
	<tr class="thead-dark">
		<th>Customer Name</th>
		<th>Product Name</th>
		<th>Company</th>
		<th>Price</th>
		<th>Payment Mode</th>
	</tr>


	<spring:forEach items="${purchaselist}" var="cp">
	
		<tr>
			<td>${cp.custname}</td>
			<td>${cp.prodnm}</td>
			<td>${cp.company}</td>
			<td>${cp.price}</td>
			<td>${cp.paymode}</td>
		</tr>
	
	</spring:forEach>


</table>


</body>
</html>