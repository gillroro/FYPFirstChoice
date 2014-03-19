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
	
	<!-- Javascript -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/kickstart.js"></script>
	<s:head theme="ajax" />
</head>
 
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Add Project</h4>

<s:form action="AddProject" >
	<s:textfield name="projectName" label="Project Name" theme= "css_xhtml"/>
	<s:datetimepicker name="startDate" label="Start Date" displayFormat="dd/MM/yyyy"  required="true" theme="css_xhtml"/>
	<s:datetimepicker name="endDate" label="End Date" displayFormat="dd/MM/yyyy"  required="true" theme="css_xhtml"/>
	<s:textfield name="department" label="Department" theme="css_xhtml" />
	
	<s:submit value="Add Project" theme="simple" />
</s:form>	
</div> 
</div>
</body>
</html>