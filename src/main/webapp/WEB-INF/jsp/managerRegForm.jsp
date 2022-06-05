<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MANAGER</title>
<style>
.error {
	color: red
}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/styles.css">
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

			<div class="navbar-custom" style="text-align: center;">
				<span class="navbar-style">Recycle Management System</span>
			</div>


		</div>
	</nav>

	<div class="container content">
		<div style="background: rgb(139, 0, 139);" class="jumbotron heading">
			<h1 style="color: white; text-align: center">Manager
				Registration</h1>
		</div>
		<table class="table">
			<form:form class="form-style-2" onsubmit="return managerValidate()"
				action="submitForm" modelAttribute="manager" method="post">
				<span class="border border-secondary">

					<tr>
						<td><label for="firstname" class="label label-primary">First
								Name</label></td>
						<td><form:input path="firstName" type="text"
								placeholder="Enter FirstName" id="firstname"
								class="form-control" required="required" /></td>
						<td><small class="form-text text-muted"
							id="firstnameerrormsg"></small></td>
					</tr>

					<tr>
						<td><label for="lastname" class="label label-primary">Last
								Name</label></td>
						<td><form:input path="lastName" type="text"
								placeholder="Enter LastName" id="lastname" class="form-control"
								required="required" /></td>
						<td><small class="form-text text-muted" id="lastnameerrormsg"></small></td>
					</tr>

					<tr>
						<td><label for="contact" class="label label-primary">Contact
								Number</label></td>
						<td><form:input path="contact" type="text"
								placeholder="Enter Contact Number" id="contact"
								class="form-control" pattern="[0-9]+" required="required" /></td>
						<td><small class="form-text text-muted" id="contacterrormsg"></small></td>
					</tr>

					<tr>
						<td><label for="email" class="label label-primary">Email</label></td>
						<td><form:input path="email" type="text"
								placeholder="Enter Email" id="email" class="form-control"
								required="required" /></td>
						<td><small class="form-text text-muted" id="emailerrormsg"></small></td>
					</tr>

					<tr>
						<td><label for="password" class="label label-primary">Password</label></td>
						<td><form:input path="password" type="text"
								placeholder="Enter Password" id="password" class="form-control"
								required="required" /></td>
						<td><small class="form-text text-muted" id="passerrormsg"></small></td>
					</tr>

					<tr>
						<td><label for="skills" class="label label-primary">Select
								Skill:</label></td>
						<td>Skill1<form:checkbox path="skill" value="Skill1"
								name="skills" /> Skill2<form:checkbox path="skill"
								value="Skill2" name="skills" /> Skill3<form:checkbox
								path="skill" value="Skill3" name="skills" /> Skill4<form:checkbox
								path="skill" value="Skill4" name="skills" /></td>
					</tr>

					<tr>
						<td><label for="gender" class="label label-primary">Select
								Gender</label></td>
						<td><form:select path="gender" name="gender">
								<form:option value="Male">Male</form:option>
								<form:option value="Female">Female</form:option>
							</form:select></td>
					</tr>

					<tr>
						<td><button class="btn btn-success" type="submit" id="submit"
								name="submit">Submit</button></td>
						<td><button class="btn btn-warning" type="reset" id="reset"
								name="reset">Clear</button></td>
					</tr>


				</span>
			</form:form>
		</table>

		<script type="text/javascript" src="js/script.js"></script>
</body>
</html>