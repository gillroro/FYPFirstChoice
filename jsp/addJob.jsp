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
	<link rel="stylesheet" type="text/css" href="style.css" media="all" /> 
	
	<!-- Javascript -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/kickstart.js"></script>
	<s:head theme="ajax" />
</head>
 
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Post a Job</h4>

<s:form action="AddJob" >
	<s:textfield name="job_name" label="Job Name" theme= "css_xhtml"/>
	<s:datetimepicker name="closing_date" label="Closing Date" displayFormat="dd/MM/yyyy"  required="true" theme="css_xhtml"/>
	<s:textarea name="description" label="Description" theme="css_xhtml" />
	<s:textfield name="department" label="Department" theme="css_xhtml" />
	
	<s:submit value="Add Job" theme="simple" />
</s:form>	
</div> 
</div>
</body>
</html>