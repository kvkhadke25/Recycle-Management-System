<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>MANAGER</title>
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

		<div align="center">

			<h1>Approve Manager</h1>

			<table class="table table-striped">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>Skills</th>
					<th>Gender</th>
					<th>Approved</th>
					<th>Edit Approval</th>
				</tr>

				<c:forEach items="${managerdetails}" var="details">
					<tr>
						<td>${details.firstName}</td>
						<td>${details.lastName}</td>
						<td>${details.contact}</td>
						<td>${details.email}</td>
						<td>${details.gender}</td>
						<td>${details.skill}</td>
						<td>${details.approval}</td>
						<td><a type="button" class="btn btn-success"
							href="/submitapproval?email=${details.email}&approve=Yes">Yes</a>
							<a type="button" class="btn btn-danger"
							href="/submitapproval?email=${details.email}&approve=No">No</a></td>
					</tr>
				</c:forEach>

			</table>

			<br> <br>

		</div>

		<script type="text/javascript" src="js/script.js"></script>
</body>
</html>