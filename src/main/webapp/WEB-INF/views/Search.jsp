<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.jspiders.cardekho_case_study_MVC.Pojo.CarPojo"%>
<jsp:include page="NavBar.jsp" />

<%
CarPojo pojo = (CarPojo) request.getAttribute("car");
String msg = (String) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
        <fieldset>
        <legend>Search Car Details</legend>
		<form action="./search" method="post">
			<table>
				<tr>
					<td>Enter ID</td>
					<td><input type="text" name="id"></td>
				</tr>	
			</table>
			<input type="submit" value="SEARCH">
		</form>
		</fieldset>

		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>

		<%
		if (pojo != null) {
		%>
		<table id="data">
			<tr>
				<th>CAR ID</th>
				<th>CAR NAME</th>
				<th>CAR BRAND</th>
				<th>CAR FUEL</th>
				<th>CAR PRICE</th>
			</tr>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getCarName()%></td>
				<td><%=pojo.getCarBrand()%></td>
				<td><%=pojo.getCarFuel()%></td>
				<td><%=pojo.getCarPrice()%></td>
			</tr>
		</table>
		<%
		}
		%>
	</div>

</body>
</html>