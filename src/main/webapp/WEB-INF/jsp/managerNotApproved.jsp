<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/styles.css">
<meta charset="ISO-8859-1">
<title>MANAGER</title>
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

	<div class="alert alert-danger" role="alert" align="center">Manager
		With Email Does Not Exist</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>