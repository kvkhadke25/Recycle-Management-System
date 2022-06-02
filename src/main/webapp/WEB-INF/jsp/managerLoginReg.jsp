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
	<div align="center">


		<nav class="navbar navbar-custom">
			<div class="container-fluid">

				<div class="navbar-header navbar-right">
					<a href="/recycleManagementHomePage">
						<button onclick="myFunctionHomePage()" class="btn btn-info btn-lg">
							<span class="glyphicon glyphicon-log-out"></span> Homepage
						</button>
					</a>
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

		<div class="container content">
			<div style="background: rgb(139, 0, 139);" class="jumbotron heading">
				<h1 style="color: white; text-align: center">Manager
					Login/Registration</h1>
			</div>

			<div class="col" style="margin: auto; padding-top: 50px;">
				<a class="col-sm-6 btn btn-basic" role="button"
					href="/managerRegForm"><h3>
						<b>MNANAGER REGISTRATION</b>
					</h3></a> <a class="col-sm-6 btn btn-basic" role="button"
					href="/loginmanager"><h3>
						<b>MANAGER LOGIN</b>
					</h3></a>
			</div>
		</div>
		<script type="text/javascript" src="js/script.js"></script>
</body>
</html>