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
		<h1 style="text-align: center">Buyer Home Page</h1>

		<form method="POST"
			action="pay2?payamount=${payamount}&totamount=${totamount}&requestId=${requestId}"
			onsubmit="paymentSuccess()">
			<table class="table">
				<tr>
					<td><label>Mode of Payment: <label></td>
					<td><input type="radio" name=mode value="Credit Card"
						required="required" />Credit Card</td>
					<td><input type="radio" name=mode value="Debit Card"
						required="required" />Debit Card</td>

				</tr>
				<tr>
					<td><label>Card No: <label></td>
					<td><input id="cardno" required="required" /></td>

				</tr>
				<tr>
					<td><label>Card Holder's Name: <label></td>
					<td><input id="name" required="required" /></td>

				</tr>
				<tr>
					<td><label>Amount: <label></td>
					<td><input name="paidAmount" id="paidAmount" type="number"
						readOnly="readOnly" value="${payamount}" /></td>

				</tr>
				<tr>
					<td><button id="btn-success" type="submit" id="submit"
							name="submit">Pay</button></td>

				</tr>
			</table>
		</form>
		<script type="text/javascript" src="js/script.js"></script>
</body>
</html>