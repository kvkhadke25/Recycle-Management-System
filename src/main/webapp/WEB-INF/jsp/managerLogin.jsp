<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="/css/styles.css">
<title>MANAGER</title>
</head>
<body>

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

			<div class="navbar-custom" style="text-align: center">
				<span class="navbar-style">Recycle Management System</span>
			</div>

		</div>
	</nav>

	<div class="container content">
		<div style="background: rgb(139, 0, 139);" class="jumbotron heading">
			<h1 style="color: white; text-align: center">Manager Login</h1>
		</div>


		<br> <br>

		<form method="POST" action="validatemanager">
			<span class="border border-secondary">
				<table class="table">
					<tr>
						<td><label class="label label-primary" for="email">Email
								Address:</label></td>
						<td><input id="email" name="email" class="form-control"
							placeholder="Enter Email" required="required" /></td>
					</tr>
					<tr>
						<td><small class="form-text text-muted">example@gmail.com</small></td>
						<td></td>
					</tr>
					<tr>
						<td><label class="label label-primary" for="password">Password:</label></td>
						<td><input name="password" id="password" type="password"
							class="form-control" placeholder="Enter Password"
							required="required" /></td>
					</tr>
					<tr>
						<td><button class="btn btn-success" type="submit" id="submit"
								name="submit">Submit</button></td>
						<td><button class="btn btn-warning" type="reset" id="reset"
								name="reset">Clear</button></td>
					</tr>
				</table>
			</span>
		</form>
		<script type="text/javascript" src="js/script.js"></script>
</body>
</html>