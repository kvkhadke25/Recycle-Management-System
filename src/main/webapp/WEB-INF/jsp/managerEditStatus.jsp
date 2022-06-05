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

	<div class="container content">
		<div style="background: rgb(139, 0, 139);" class="jumbotron heading">
			<h1 style="color: white; text-align: center">Edit Status</h1>
		</div>


		<form class="form-style-2" action="submitstatus" method="post">
			<span class="border border-secondary">
				<table class="table">
					<tr>
						<td><label class="label label-primary" for="requestid">Enter
								Request Id:</label></td>
						<td><input id="requestid" name="requestid"
							class="form-control" placeholder="Enter Request Id"
							required="required" /></td>
					</tr>
					<tr>
						<td><label class="label label-primary" for="status">Change
								Status To:</label></td>
						<td><select name="status" id="status">
								<option value="New">New</option>
								<option value="Waiting for Truck Availability">Waiting
									for Truck Availability</option>
								<option value="Truck Send">Truck Send</option>
								<option value="Received">Received</option>
						</select></td>
					</tr>
					<tr>
						<td><button class="btn btn-success" type="submit" id="submit"
								name="submit">Change Status</button></td>
						<td><button class="btn btn-warning" type="reset" id="reset"
								name="reset">Clear</button></td>
					</tr>
				</table>
			</span>
		</form>
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>