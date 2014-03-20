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
			<h4 style="color:#999;margin-bottom:30px;" class="center"> Employee Appraisal </h4>
			<p><i>Employees should complete this form prior to the annual performance appraisal meeting with their supervisor</p></i>
        </div>
		
		<div align="center" style="height:1000px;width:800px;margin:0 auto;">
		
			<table>

			<s:form action="Appraisal" namespace="/" method="POST" theme= "css_xhtml" >
			
							 
				<s:textarea label="Describe your most significant accomplishments this past year." name="accomplishments" cols="60" rows="4"></s:textarea>
				<s:textarea label="Describe any barriers or challenges that impacted you in effectively completing your 
job responsibilities or accomplishing your goals." name="barriers" cols="60" rows="4"></s:textarea>
			<s:textarea label="Please list your area(s) of strength and area(s) of improvement." name="improvements" cols="60" rows="4"></s:textarea>
			<s:textarea label="What skills or new knowledge would you like to develop to improve your performance? " name="performance" cols="60" rows="4"></s:textarea>
			
				<i>Attendance</i><s:radio name="attendanceRecord"  list="attendance" value="attendanceRecord" />
				<i>Respect for Others</i><s:radio name="respectRecord" list="respect" value="respectRecord" />	
				<!--<i>Manager</i><s:select headerKey="-1" headerValue="Select Manager" name="firstName" list="managers" listKey="employee_id" listValue="firstName"  ></s:select>-->
				<s:submit name ="Appraisal" value="Submit" theme= "simple" />
			
			</s:form>	
			</table>
		</div>

		
		  <div id="footer">
			
			<h6 style="color:#999;margin-bottom:40px;" class="center"> ©Gillian Rowan, 2013.      </h6>
	            
        </div>
</body>

</html>