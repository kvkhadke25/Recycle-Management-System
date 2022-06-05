<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Login Admin Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<nav class="navbar navbar-default bg-success navbar-dark">
		<div class="container-fluid">

			<div class="navbar-header navbar-right">
				<a href="/recycleManagementHomePage">
					<button onclick="myFunctionHomePage()" class="btn btn-info btn-lg">
						<span class="glyphicon glyphicon-log-out"></span> HomePage
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
			<h1 style="color: white; text-align: center">Admin Login</h1>
		</div>
		<font color="red">${message}</font>
		<form method="post" action="/loginAdmin">
			<span class="border border-secondary">
				<table class="table">
					<tr>
						<td><label class="label label-primary" for="name">Username:</label></td>
						<td><input type="text" name="username" class="form-control"
							required="required" /></td>
					</tr>
					<tr>
						<td><label class="label label-primary" for="password">Password:</label></td>
						<td><input type="password" name="password"
							class="form-control" required="required" /></td>
					</tr>
					<tr>
						<td><button class="btn btn-success" type="submit" id="submit"
								name="submit">Submit</button></td>
						<td><button class="btn btn-warning" type="reset" id="reset"
								name="reset">Clear</button></td>
					</tr>
				</table>
		</form>
		<script type="text/javascript" src="js/script.js"></script>
</body>
</html>