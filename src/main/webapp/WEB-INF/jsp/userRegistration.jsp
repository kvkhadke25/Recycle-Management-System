<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/styles.css">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>User</title>
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
			<h1 style="color: white; text-align: center">User Registration</h1>
		</div>

		<form:form onsubmit="return validate()" method="POST"
			action="registerUser" modelAttribute="user">
			<span class="border border-secondary">
				<table class="table">

					<tr>
						<td><form:label class="label label-primary" path="firstName">First Name: </form:label></td>
						<td><form:input path="firstName" id="firstName"
								class="form-control" /></td>
					</tr>
					<tr>
						<td><form:label class="label label-primary" path="lastName">Last Name: </form:label></td>
						<td><form:input path="lastName" id="lastName"
								class="form-control" /></td>

					</tr>
					<tr>
						<td><form:label class="label label-primary"
								path="phoneNumber">Phone Number: </form:label></td>
						<td><form:input path="phoneNumber" id="phoneNumber"
								class="form-control" /></td>
					</tr>
					<tr>
						<td><form:label class="label label-primary" path="email">Email Id: </form:label></td>
						<td><form:input path="email" id="email" class="form-control" /></td>
					</tr>
					<tr>
						<td><form:label class="label label-primary" path="password">Password: </form:label></td>
						<td><form:password path="password" id="password"
								class="form-control" /></td>
					</tr>
					<tr>
						<td><form:label class="label label-primary" path="gender">Gender: </form:label></td>
						<td><form:select path="gender" items="${genderList}"
								id="gender" class="form-control" /></td>
					</tr>
					<br>
					<tr>
						<td><button class="btn btn-success" type="submit" id="submit"
								name="submit">Submit</button></td>
						<td><button class="btn btn-warning" type="reset" id="reset"
								name="reset">Clear</button></td>
					</tr>
				</table>
			</span>
		</form:form>
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>