<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.jspiders.cardekho_case_study_MVC.Pojo.CarPojo"%>
<%@page import="java.util.List"%>

<jsp:include page="NavBar.jsp" />
<%
List<CarPojo> cars = (List<CarPojo>) request.getAttribute("cars");
String msg = (String) request.getAttribute("msg");
CarPojo pojo = (CarPojo) request.getAttribute("pojo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<%
		if (pojo == null) {
		%>
		<fieldset>
		<legend>Select Car</legend>
		<form action="./update" method="post">

			<table>
				<tr>
					<td>Enter Id</td>
					<td><input type="text" name="id"></td>
				</tr>
			</table>

			<input type="submit" value="SELECT">

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
			for (CarPojo car : cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getCarName()%></td>
				<td><%=car.getCarBrand()%></td>
				<td><%=car.getCarFuel()%></td>
				<td><%=car.getCarPrice()%></td>
			</tr>
			<%
			}
			}
			%>
		</table>
		<%
		} else {
		%>
        <fieldset>
        <legend>Update Car</legend>
		<form action="./updateCar" method="post">
			<table border="1">
				<tr>
					<td>Car Id</td>
					<td><%=pojo.getId()%></td>
					<td><input type="number" name="id" value="<%=pojo.getId()%>"
						hidden="true"></td>
				</tr>
				<tr>
					<td>Car Name</td>
					<td><%=pojo.getCarName()%></td>
					<td><input type="text" name="carName"
						value="<%=pojo.getCarName()%>"></td>
				</tr>
				<tr>
					<td>Car Brand</td>
					<td><%=pojo.getCarBrand()%></td>
					<td><input type="text" name="carBrand"
						value="<%=pojo.getCarBrand()%>"></td>
				</tr>
				<tr>
					<td>Car Fuel</td>
					<td><%=pojo.getCarFuel()%></td>
					<td><input type="text" name="carFuel"
						value="<%=pojo.getCarFuel()%>"></td>

				</tr>
				<tr>
					<td>Car Price</td>
					<td><%=pojo.getCarPrice()%></td>
					<td><input type="number" name="carPrice"
						value="<%=pojo.getCarPrice()%>"></td>
				</tr>

			</table>
			<input type="submit" value="Update">
		</form>
       </fieldset>

		<%
		}
		%>



	</div>

</body>
</html>