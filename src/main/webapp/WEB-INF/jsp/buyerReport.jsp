<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer Orders</title>
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
		<h1 style="text-align: center">Buyers Report</h1>
		<table class="table table-striped">
			<form method="POST" action="/viewReportForBuyer">
				<b>${msg}</b> <b>${msg2}</b>
				<tr>
					<td><label class="date">From Date:</label></td>
					<td><input type="date" name="date1" id="date1"
						value="${date1}" max="${today}" required="required"></input></td>
				</tr>
				<tr>
					<td><label class="date">To Date:</label></td>
					<td><input type="date" name="date2" id="date2"
						value="${date2}" max="${today}" required="required"></input></td>
				</tr>
				<c:if test="${status}">
					<tr>
						<th>Request Id</th>
						<th>Buyer Email</th>
						<th>Amount</th>
						<th>Quantity Ordered</th>
						<th>Location</th>
						<th>Order Date</th>
						<th>Required Date</th>
						<th>Payment Date</th>
						<th>Status</th>
						<th>Paid Amount</th>
					</tr>
					<c:forEach items="${orders}" var="order">
						<tr>
							<td>${order.requestId}</td>
							<td>${order.buyerEmail}</td>
							<td>Rs. ${order.amount}</td>
							<td>${order.quantity}</td>
							<td>${order.location}</td>
							<td>${order.requestDate}</td>
							<td>${order.requiredDate}</td>
							<td>${order.paymentDate}</td>
							<td>${order.status}</td>
							<td>Rs. ${order.paidAmount}</td>
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
						<form method="GET" action="/downloadReportForBuyer">
							<input type="hidden" name="date1" value="${date1}" max="${today}">
							<input type="hidden" name="date2" value="${date2}" max="${today}">

							<button id="btn-success" type="submit" id="submit" name="submit"
								value="Download the report">Download</button>
						</form>
					</td>
				</tr>
			</c:if>
		</table>
		<script type="text/javascript" src="js/script.js"></script>
</body>
</html>