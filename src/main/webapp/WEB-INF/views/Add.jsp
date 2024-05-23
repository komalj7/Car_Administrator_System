 <%@page import="java.util.List"%>
<%@page import="com.jspiders.cardekho_case_study_MVC.Pojo.CarPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
List<CarPojo> cars = (List<CarPojo>) request.getAttribute("cars");
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
	<legend>Add Car Details</legend>
		<form action="./add" method="post">
			<table>

				<tr>
					<td>Car Name</td>
					<td><input type="text" name="carName"></td>
				</tr>

				<tr>
					<td>Car Brand</td>
					<td><input type="text" name="carBrand"></td>
				</tr>

				<tr>
					<td>Car Fuel</td>
					<td><input type="text" name="carFuel"></td>
				</tr>
				<tr>
					<td>Car Price</td>
					<td><input type="text" name="carPrice"></td>
				</tr>
			</table>
			<br> <input type="submit" id="sub" value="Click to Add Car">
			<br>
			<br>
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
		if (cars != null) {
		%>
		<table id="data">

			<tr>
				<th>Car Id</th>
				<th>Car Name</th>
				<th>Car Brand</th>
				<th>Car Fuel</th>
				<th>Car Price</th>
			</tr>

			<%
			for (CarPojo pojo : cars) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getCarName()%>
				<td><%=pojo.getCarFuel()%>
				<td><%=pojo.getCarBrand()%>
				<td><%=pojo.getCarPrice()%>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>


	</div>
</body>
</html>