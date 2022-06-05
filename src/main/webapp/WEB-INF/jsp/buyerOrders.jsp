<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
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
					onclick="myFunctionHomePage()">
					<span class="glyphicon glyphicon-arrow-left"></span> Go Back
				</button>
			</div>

			<div class="navbar-custom" style="text-align: center;">
				<span class="navbar-style">Recycle Management System</span>
			</div>

		</div>
	</nav>
	<div class="container">
		<h1 style="text-align: center">Buyer Orders</h1>
		<table class="table table-striped">

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
				<th>Days Due</th>
				<th>Edit Status</th>
			</tr>
			<c:forEach items="${orders}" var="order" varStatus="status">
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
					<td>${due[status.index]}</td>
					<td><c:if test="${editToShip[status.index]}">
							<a href="/editStatus?requestId=${order.requestId}&orderStatus=2">EDIT</a>
						</c:if> <c:if test="${editToReady[status.index]}">
							<a href="/editStatus?requestId=${order.requestId}&orderStatus=1">EDIT</a>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
		<script type="text/javascript" src="js/script.js"></script>
</body>
</html>