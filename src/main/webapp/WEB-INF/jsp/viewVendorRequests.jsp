<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recycle Management System</title>
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

	<div class="container content">
		<div style="background: rgb(139, 0, 139);" class="jumbotron heading">
			<h1 style="color: white; text-align: center">Vendor Requests</h1>
		</div>

		<div align="center">
			<table class="table table-striped">
				<tr>
					<th>Request Id</th>
					<th>Vendor Email</th>
					<th>Type of Organization</th>
					<th>Amount</th>
					<th>Location</th>
					<th>Request Date</th>
					<th>Required Date</th>
					<th>Status</th>
					<th>Time</th>
					<th>Edit Status</th>
				</tr>

				<c:forEach items="${requestsList}" var="req">
					<tr>
						<td>${req.requestId}</td>
						<td>${req.vendorEmail}</td>
						<td>${req.typeOfOrg}</td>
						<td>${req.amount}</td>
						<td>${req.location}</td>
						<td>${req.requestDate}</td>
						<td>${req.requiredDate}</td>
						<td>${req.status}</td>
						<td>${req.time}</td>
						<td><select name="status" id="status">
								<option value="New">New</option>
								<option value="Waiting for Truck Availability">Waiting
									for Truck Availability</option>
								<option value="Truck Send">Truck Send</option>
								<option value="Received">Received</option>
						</select> <a id="myAnchor" type="button" class="btn btn-success"
							onclick="editvendorrequest(${req.requestId})">Edit</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>