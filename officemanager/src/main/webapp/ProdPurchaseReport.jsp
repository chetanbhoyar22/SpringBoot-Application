<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core_rt" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="css/bootstrap.min.css"/>
<script type="text/javascript" src="js/bootstrap.min.js"></script>


<script language="Javascript" type="text/javascript">
        <!--

        function createRequestObject() {
            var tmpXmlHttpObject;
            if (window.XMLHttpRequest) {
                    tmpXmlHttpObject = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
            }
            return tmpXmlHttpObject;
        }

        var http = createRequestObject();

        function makeGetRequest(pid) {
            //alert(pid);
            http.open('get', 'prodpurchase?prodid='+pid);
            http.onreadystatechange = processResponse;
            http.send(null);
        }

        function processResponse() {
            if(http.readyState == 4){
                var response = http.responseText;
                document.getElementById('report').innerHTML = response;
            }
        }
        -->
        </script>

</head>
<body>

<h2>Products Purchase Report</h2>
<hr/>
<form name="frm">
<table>
	<tr>
		<td>Select Product : </td>
		<td>		
			<select name="prodid" onchange="makeGetRequest(this.value)">
			<spring:forEach items="${plist}" var="prod">
				<option value="${prod.prodid}">${prod.prodname}</option>
			</spring:forEach>			
			</select>		
		</td>
	</tr>
</table>
</form>

<br/><br/>
<div id="report"></div>


</body>
</html>