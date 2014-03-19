<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>

	<!-- META -->
	<title>First Choice</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta name="description" content="" />
	
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="css/kickstart.css" media="all" />
	<link rel="stylesheet" type="text/css" href="style.css" media="all" /> 
	
	<!-- Javascript -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/kickstart.js"></script>
	<s:head theme="ajax" />
</head>
<body>
<div style="height:500px;width:550px;margin:0 auto;">
			<img class="full-width" src="images/fc.png" />
			<h4 style="color:#999;margin-bottom:40px;" class="center"> Employee Registration </h4>
        </div>
	<div class="center" >	
	
	
	<h5>Register Employee:</h5>
			<s:form action="Register" >
				<s:textfield name="firstName" value= "First Name" theme= "css_xhtml"/>
				<s:textfield name="surname" value= "Surname" theme= "css_xhtml"/>
				<s:textfield name="Username" value= "Username" theme= "css_xhtml"/>
				<s:password name="Password" value= "Password" showPassword= "true" theme= "css_xhtml"/>
				<s:textfield name="Address" value= "Address" theme= "css_xhtml"/>
				<s:textfield name="Salary" value= "Salary" theme= "css_xhtml"/>
				<s:textfield name="UserType" value= "User Type" theme= "css_xhtml"/>
				<s:textfield name="Manager" value= "Manager ID" theme="css_xhtml"/>
				<s:submit value="Register" theme= "simple"/>
			</s:form>
	</div>
</div>
</body>
</html>