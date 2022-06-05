<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*,java.time.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<title>Recycle Management System</title>
<head>
<link rel="stylesheet" href="/css/styles.css">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default bg-success navbar-dark">
		<div class="container-fluid">

			<div class="navbar-header navbar-right">
				<a href="/recycleManagementHomePage">
					<button onclick="myFunction()" class="btn btn-info btn-lg">
						<span class="glyphicon glyphicon-log-out"></span> Log out
					</button>
				</a>
			</div>

			<div class="navbar-header">
				<button class="btn btn-info btn-lg" id="goback"
					onclick="goToAdminPage()">
					<span class="glyphicon glyphicon-arrow-left"></span> Go Back
				</button>
			</div>

			<div class="navbar-custom" style="text-align: center;">
				<span class="navbar-style">Recycle Management System</span>
			</div>

		</div>
	</nav>
	<div class="container">
		<table class="table table-striped">
			<caption style="text-align: center">List of Requests for
				${date}</caption>
			<tr>
				<th>Request Id</th>
				<th>Vendor Email</th>
				<th>Type of Org</th>
				<th>Amount</th>
				<th>Location</th>
				<th>Request date</th>
				<th>Required date</th>
				<th>Status</th>
				<th>Time</th>
			</tr>
			<c:set var="total" value="${0}" />
			<c:forEach var="req" items="${list}">
				<tr>
					<td>${req.requestId}</td>
					<td>${req.vendorEmail}</td>
					<td>${req.typeOfOrg}</td>
					<td>${req.amount}</td>
					<td>${req.location}</td>
					<td>${req.requestDate}</td>
					<td>${req.requiredDate}</td>
					<td>${req.status}</td>
					<td>${req.time}</td>
					<c:set var="total" value="${total+req.amount}" />
				</tr>
			</c:forEach>

		</table>
		<table class="table table-striped">
			<tr>
				<th>Total waste supposed to be received</th>
			</tr>
			<tr>
				<td>${total}</td>
			</tr>
		</table>



		<form method="GET" action="/requestOnDate">
			<table class="table table-striped">
				<tr>
					<td><label class="date">Date:</label></td>
					<td><input type="date" name="date" id="date"
						max="${currentDate}" required="required" /></td>
					<td><button id="btn-success" type="submit" id="submit"
							name="submit">Click to View Collections</button></td>

				</tr>
			</table>
		</form>
		<form method="GET" action="/requests">
			<table class="table table-striped">
				<td><button id="btn-success" type="submit">Update Page</button></td>
			</table>
		</form>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>
