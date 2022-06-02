<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MANAGER</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>

	<nav class="navbar navbar-custom">
		<div class="container-fluid">

			<div class="navbar-header navbar-right">
				<button onclick="logout()" class="btn btn-info btn-lg">
					<span class="glyphicon glyphicon-log-out"></span> Log out
				</button>
			</div>

			<div class="navbar-header">
				<button class="btn btn-info btn-lg" id="goback"
					onclick="history.go(-1);">
					<span class="glyphicon glyphicon-arrow-left"></span> Go Back
				</button>
			</div>

			<div class="navbar-custom" style="text-align: center;">
				<span class="navbar-style">Recycle Management System</span>
			</div>

		</div>
	</nav>

	<div class="alert alert-success" role="alert" align="center">Welcome
		${name} you have logged in successfully</div>
	<div align="center">
		<br>
		<form action="viewrequests">
			<button type="submit" value="View Vendor Requests"
				class="btn btn-success">Click here to view Vendors Requests</button>
		</form>
		<br>
		<form action="viewOrders">
			<button type="submit" value="View Buyer Requests"
				class="btn btn-success">Click here to view Buyers Requests</button>
		</form>
	</div>

	<script type="text/javascript" src="js/script.js"></script>

</body>
</html>