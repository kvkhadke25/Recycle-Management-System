<html>
<head>
<title>Recycle Management System</title>
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
			<h1 style="color: white; text-align: center">Welcome User</h1>
		</div>
		<div class="col" style="margin: auto; padding-top: 50px;">
			<a class="col-sm-6 btn btn-basic" role="button" href="/buyer"><h3>
					<b>Buyer Home Page</b>
				</h3></a> <a class="col-sm-6 btn btn-basic" role="button"
				href="/vendorRequest"><h3>
					<b>Vendor Home Page</b>
				</h3></a>
		</div>
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>