<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
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
			<h1 style="color: white; text-align: center">Order Details</h1>
		</div>
		<div style="text-align: center">
			<c:if test="${sorry}">
				<font color="red">${sorryMsg}</font>
				<button id="btn-success">
					<a href="/buyer">Place order again</a>
				</button>
			</c:if>
			<c:if test="${!sorry}">
				<font color="red">${msg} Total Amount to be paid: Rs
					${amount}.0. You need to pay Rs ${pamount} now as an advance
					payment.</font>
				<form action="/payment">
					<td><button id="btn-success" type="submit" id="submit"
							name="submit">Advance Payment</button></td>
				</form>
			</c:if>
		</div>
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>