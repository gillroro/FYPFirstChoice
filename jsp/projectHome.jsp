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
</head>
 
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Project Home</h4>

<div class="center" >
<a href="<s:url action="CreateProject"/>">Create Project</a><br />
<a href="<s:url action="GetProjects"/>">View All Projects</a><br />
<a href="<s:url action="ProjectDeleteForm"/>">Delete A Project</a><br />
<a href="<s:url action="AssignMemberToProject"/>">Assign Employee</a><br />
<div class="center" >
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>
</div>
</div>

</div> 
</div>
</body>
</html>