function managerValidate()

{
	 var flag = true;
    
	var firstname = document.getElementById("firstname");
	if(firstname.value.length<3 || firstname.value.length>15)
	{
		firstname.style.borderColor="red";
		firstname.style.backgroundColor = "#fc566c";
		var errormsg = document.getElementById("firstnameerrormsg");
		errormsg.innerHTML = "length should be 3-15";
		errormsg.style.color = "red";
		flag = false;
	}
	else
	{
		firstname.style.borderColor="";
		firstname.style.backgroundColor = "";
		var errormsg = document.getElementById("firstnameerrormsg");
		errormsg.innerHTML = "";
		errormsg.style.color = "";
	}

	var lastname = document.getElementById("lastname");
	if( lastname.value.length<3 || lastname.value.length>15 )
        
	{
        
	lastname.style.borderColor="red";
	lastname.style.backgroundColor = "#fc566c";
	var errormsg = document.getElementById("lastnameerrormsg");
	errormsg.innerHTML = "length should be 3-15";
	errormsg.style.color = "red";
	flag = false;
	}
	else
	{
		lastname.style.borderColor="";
		lastname.style.backgroundColor = "";
		var errormsg = document.getElementById("lastnameerrormsg");
		errormsg.innerHTML = "";
		errormsg.style.color = "";
	}

	var contact = document.getElementById("contact");
	if(contact.value.length!=10)
	{
	contact.style.borderColor="red";
	contact.style.backgroundColor = "#fc566c";
	var errormsg = document.getElementById("contacterrormsg");
	errormsg.innerHTML = "enter correct contact number";
	errormsg.style.color = "red";
	flag = false;
	}
	else
	{
		contact.style.borderColor="";
		contact.style.backgroundColor = "";
		var errormsg = document.getElementById("contacterrormsg");
		errormsg.innerHTML = "";
		errormsg.style.color = "";
	}
	
	var email = document.getElementById("email");
	var patt = /[a-zA-Z0-9]+@[a-zA-Z0-9]/g;
	if(!patt.test(email.value))
		{
		email.style.borderColor="red";
		email.style.backgroundColor = "#fc566c";
		var errormsg = document.getElementById("emailerrormsg");
		errormsg.innerHTML = "enter correct email";
		errormsg.style.color = "red";
		flag = false;
		}
	    else
		{
		email.style.borderColor="";
		email.style.backgroundColor = "";
		var errormsg = document.getElementById("emailerrormsg");
		errormsg.innerHTML = "";
		errormsg.style.color = "";
		}

	var password = document.getElementById("password");
	if(password.value.length<6)
	{
		password.style.borderColor="red";
		password.style.backgroundColor = "#fc566c";
		var errormsg = document.getElementById("passerrormsg");
		errormsg.innerHTML = "password length should be minimum 6";
		errormsg.style.color = "red";
		flag = false;
		}
	    else
		{
		var spec1 = /[!@#$%^&*]+/g;
		var spec2 = /[0-9]+/g;
		if(!spec1.test(password.value))
		{
		password.style.borderColor="red";
		password.style.backgroundColor = "#fc566c";
		var errormsg = document.getElementById("passerrormsg");
		errormsg.innerHTML = "password should contain a special character !@#$%^&*";
		errormsg.style.color = "red";
		flag = false;
		}
		else if(!spec2.test(password.value))
		{
		password.style.borderColor="red";
		password.style.backgroundColor = "#fc566c";
		var errormsg = document.getElementById("passerrormsg");
		errormsg.innerHTML = "password should contain a numeric character";
		errormsg.style.color = "red";
		flag = false;
		}
		else
		{
		password.style.borderColor="";
		password.style.backgroundColor = "";
		var errormsg = document.getElementById("passerrormsg");
		errormsg.innerHTML = "";
		errormsg.style.color = "";
		}
		}

	if(!flag)
		{
	alert("Please update the highlighted manadatory field");
		}
	return flag;
	}
	
	
	function logout()
	{
	alert("You are going to Logout");
	window.location="/recycleManagementHomePage";
	}
	
	function myFunction()
	{
	alert("You are going to Logout");
	window.location="/recycleManagementHomePage";
	}
	
	function myFunctionHomePage()
	{
	window.location="/recycleManagementHomePage";
	}
	
	function editvendorrequest(reqId)
	{
	var status = document.getElementById("status");
	document.getElementById("myAnchor").href = "/submitstatus?requestid="+reqId+"&status="+status.value;
	}
	
	function validate(){
	var firstName=document.getElementById("firstName").value;
	var lastName=document.getElementById("lastName").value;
	var phoneNumber=document.getElementById("phoneNumber").value;
	var email=document.getElementById("email").value;
	var password=document.getElementById("password").value;
	var gender=document.getElementById("gender").value;
	var passwordpattern=  /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,}$/

	if(firstName===null || firstName==="" || firstName.length<3 || firstName.length>15){
	document.getElementById('firstName').style.borderColor = "red";
	alert("Please update the highlighted mandatory fields!");
	return false;
	}
	if(lastName===null || lastName==="" || lastName.length<3 || lastName.length>15){
	document.getElementById('lastName').style.borderColor = "red";
	alert("Please update the highlighted mandatory fields!");
	return false;
	}
	if(phoneNumber===null || phoneNumber==="" || phoneNumber.length!=10){
	document.getElementById('phoneNumber').style.borderColor = "red";
	alert("Please update the highlighted mandatory fields!");
	return false;
	}
	if(email===null || email==="" || !(email.includes("@"))){
	document.getElementById('email').style.borderColor = "red";
	alert("Please update the highlighted mandatory fields!");
	return false;
	}
	if(password===null || password==="" || !(password.match(passwordpattern))){
	document.getElementById('password').style.borderColor = "red";
	alert("Please update the highlighted mandatory fields!");
	return false;
	}
	if(gender==="----Select----"){
	document.getElementById('gender').style.borderColor = "red";
	alert("Please update the highlighted mandatory fields!");
	return false;
	}

	}
	
	function goToAdminPage(){
	window.location="/adminOptions";
	}
	
	function goToUserPage(){
	window.location="/userOptions";
	}
	
	function paymentSuccess(){
	alert("Payment successful");
	}
	
