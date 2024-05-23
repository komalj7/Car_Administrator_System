<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.jspiders.cardekho_case_study_MVC.Pojo.CarPojo"%>
<%@page import="java.util.List"%>
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
        <legend>Remove Car Details</legend>
		<form action="./remove" method="post">

			<table>

				<tr>
					<td>Enter Car Id</td>
					<td><input type="text" name="id">
				</tr>

			</table>
			<input type="submit" value="REMOVE">
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
				<th>Car ID</th>
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
				<td><%=pojo.getCarName()%></td>
				<td><%=pojo.getCarBrand()%></td>
				<td><%=pojo.getCarFuel()%></td>
				<td><%=pojo.getCarPrice()%></td>
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