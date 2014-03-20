<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
	<!-- META -->
	<title>First Choice</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta name="description" content="" />
	
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="css/kickstart.css" media="all" />
	<!--<link rel="stylesheet" type="text/css" href="style.css" media="all" /> -->
	
	<!-- Javascript -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/kickstart.js"></script>
	<script type="text/javascript" src="js/editTable.js"></script>
</head>
 
<body>
 <div style="height:500px;width:900px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Manage Employee Appraisals</h4>
<s:form action="SelectedEmployee" >
<i>Employee Name</i><s:select headerKey="-1" headerValue="Select Employee Name" name="firstName" list="employees" listKey="first_name" listValue="firstName"  theme = "css_xhtml" ></s:select>

<s:submit name="Submit" value="Submit" theme= "simple" />

</s:form>
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>

</div> 
</div>
</body>
</html>