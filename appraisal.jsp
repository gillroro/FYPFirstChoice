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
</head>
<body>

		<div style="height:500px;width:550px;margin:0 auto;">
			<img class="full-width" src="images/fc.png" />
			<h4 style="color:#999;margin-bottom:40px;" class="center"> Employee Appraisal </h4>
        </div>
		
		<div class="center" >
			<s:form action="Appraisal" namespace="/" method="POST" theme= "css_xhtml" >
				 <h6>Attendance</h6><s:radio name="attendanceRecord" list="#{'1':'Excellent','2':'Very Good', '3':'Average', '4': 'Poor'}" />
				 <h6>Respect for Others</h6><s:radio name="respectRecord" list="#{'1':'Excellent','2':'Very Good', '3':'Average', '4': 'Poor'}"  />
				 <h6>Employee Efficiency</h6><s:radio  name ="efficiencyRecord" list="#{'1':'Excellent','2':'Very Good', '3':'Average', '4': 'Poor'}" />
				 <h6>Accuracy of Work</h6><s:radio  name ="accuracyRecord" list="#{'1':'Excellent','2':'Very Good', '3':'Average', '4': 'Poor'}" />
				 <h6>Quality of Work</h6><s:radio  name ="qualityRecord" list="#{'1':'Excellent','2':'Very Good', '3':'Average', '4': 'Poor'}" />
				 <h6>Manager Name</h6><s:textfield name="manager" />
				 <h6>Comments</h6><s:textarea name="address" cols="40" rows="10" />
				 <s:submit name ="Appraisal" value="Appraise" theme= "simple" />
			</s:form>	 
		</div>

</body>

</html>