<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>New Employee</h2>
<hr/>

<form name="frm" method="post" action="register">

<table>
	<tr>
		<td>Employee No</td>
		<td><input type="text" name="empno"/> </td>
	</tr>
	<tr>
		<td>Employee Name</td>
		<td><input type="text" name="empname"/> </td>
	</tr>
	<tr>
		<td>Department</td>
		<td><select name="dept">
			<option value="sales">Sales</option>
			<option value="production">Production</option>
			<option value="finance">Finance</option>
			<option value="manufacturing">Manufacturing</option>			
			</select>
		 </td>
	</tr>
	<tr>
		<td>Salary</td>
		<td><input type="text" name="salary"/> </td>
	</tr>
	<tr>
		<td>Location</td>
		<td><input type="text" name="location"/> </td>
	</tr>
	<tr>
		<td><input type="submit" value="Submit"/> </td>
	</tr>
</table>

</form>


</body>
</html>