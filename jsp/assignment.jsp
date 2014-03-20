<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
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
	
	
	<sx:head />

</head>
<body>

		<div style="height:150px;width:750px;margin:0 auto;">
			<h4 style="color:#999;margin-bottom:30px;" class="center"> Project Assignment </h4>
        </div>
		
		<div align="center" style="height:1000px;width:800px;margin:0 auto;">
		
			<table>

			<s:form action="CompleteAssignment" namespace="/" method="POST" theme= "css_xhtml" >
				<i>Project Name</i><s:select headerKey="-1" headerValue="Select Project Name" name="projectName" list="projects" listKey="project_id" listValue="projectName"  theme = "css_xhtml" ></s:select>
				<br />
				<i>Employee Name</i><s:select headerKey="-1" headerValue="Select Employee Name" name="firstName" list="members" listKey="employee_id" listValue="firstName +' '+surname+ ' ('+username+') '"  theme = "css_xhtml" ></s:select>
				<br />
				<s:submit name ="Assign" value="Submit" theme= "simple" />
			</s:form>	
			</table>
		</div>

		
		  <div id="footer">
			
			<h6 style="color:#999;margin-bottom:40px;" class="center"> ©Gillian Rowan, 2013.      </h6>
	            
        </div>
</body>

</html>