<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recycle Management System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">
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
					onclick="myFunctionHomePage()">
					<span class="glyphicon glyphicon-arrow-left"></span> Go Back
				</button>
			</div>

			<div class="navbar-custom" style="text-align: center;">
				<span class="navbar-style">Recycle Management System</span>
			</div>

		</div>
	</nav>
	<div class="container content">
		<div style="background: rgb(139, 0, 139);" class="jumbotron heading">
			<h1 style="color: white; text-align: center">Welcome to Admin
				Page</h1>
		</div>
		<div class="row" style="margin: auto; padding-top: 50px;">
			<a class="col-sm-4 btn btn-basic" role="button" href="/viewOrders"><h3>
					<b>View Buyer Requests</b>
				</h3></a> <a class="col-sm-4 btn btn-basic" role="button"
				href="/managerapproval"><h3>
					<b>Approve Managers</b>
				</h3></a> <a class="col-sm-4 btn btn-basic" role="button" href="/requests"><h3>
					<b>View Vendor Requests</b>
				</h3></a>
		</div>

		<div class="row" style="margin: auto; padding-top: 50px;">
			<a class="col-sm-6 btn btn-basic" role="button"
				href="/viewReportForBuyer"><h3>
					<b>Generate Report for Buyers</b>
				</h3></a> <a class="col-sm-6 btn btn-basic" role="button"
				href="/wastageReport"><h3>
					<b>Generate Wastage Report</b>
				</h3></a>

		</div>
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>