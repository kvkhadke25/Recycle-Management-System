<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recycle Management System</title>
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
		<h1 style="text-align: center">Wastage Report</h1>
		<table class="table table-striped">
			<form method="POST" action="/wastageReport">
				<b>${msg}</b> <b>${msg2}</b>
				<tr>
					<td><label class="date">From Date:</label></td>
					<td><input type="date" name="startdate" id="startdate"
						value="${startdate}" max="${yesterday}" required="required"></input></td>
				</tr>
				<tr>
					<td><label class="date">To Date:</label></td>
					<td><input type="date" name="enddate" id="enddate"
						value="${enddate}" max="${yesterday}" required="required"></input></td>
				</tr>
				<c:if test="${status}">
					<tr>
						<th>Request Id</th>
						<th>Vendor Email</th>
						<th>Type of Org</th>
						<th>Amount</th>
						<th>Location</th>
						<th>Request date</th>
						<th>Collection date</th>
						<th>Status</th>
						<th>Time</th>
					</tr>
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
						</tr>
					</c:forEach>
				</c:if>
				<tr>
					<td><button id="btn-success" type="submit" id="submit"
							name="submit">Submit</button></td>
				</tr>

			</form>
		</table>
		<table class="table table-striped">
			<c:if test="${status}">
				<tr>
					<td>
						<form method="GET" action="/downloadReportForVendor">
							<input type="hidden" name="startdate" id="startdate"
								value="${startdate}" max="${yesterday}"> <input
								type="hidden" name="enddate" id="enddate" value="${enddate}"
								max="${yesterday}"> <input type="submit"
								value="Download the report">
						</form>
					</td>
				</tr>
			</c:if>
		</table>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>