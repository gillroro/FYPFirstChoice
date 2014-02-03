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
     
            <div id="menu">
		
			
			</div>
        <div style="height:500px;width:550px;margin:0 auto;">
			<img class="full-width" src="images/fc.png" />
			<h4 style="color:#999;margin-bottom:40px;" class="center"> Welcome to Your Dashboard! </h4>
			<h4 style="color:#999;margin-bottom:40px;" class="center"> User: <s:property value="Username"/> </h4>

        </div>
		
		<div class="center" >
			<a href="<s:url action="fileUploadAction"/>">Upload CV</a>  
			<a href="<s:url action="DateTimePicker"/>">Manage Details</a>
			<a href="<s:url action="DateTimePicker"/>">Manage Holiday Requests</a>
			<a href="<s:url action="EmployeeJobBoards"/>">Job Boards</a>
			<a href="<s:url action="SelfAppraise"/>">Self Appraise</a>
			<a href="<s:url action="fileUploadAction"/>">Update Skill Profile</a>

		</div>
		<div class ="center" >
		<s:form action = "Logout" >
					<s:submit value = "Logout" theme= "simple"  />
			</s:form>
	</div>
        <div id="footer">
			
			<h6 style="color:#999;margin-bottom:40px;" class="center"> ©Gillian Rowan, 2013.      </h6>
	            
        </div>


</body>
</html>