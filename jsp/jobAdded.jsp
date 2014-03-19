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
<h4 style="color:#999;margin-bottom:40px;" class="center"> Job Boards</h4>
<h5 style="color:#999;margin-bottom:40px;" class="center"> Job <s:property value="job_name" /> Added </h5>
<div class="center" >
<a href="<s:url action="PostJob"/>">Post Job</a>
<a href="<s:url action="ViewAll"/>">View All Jobs</a>
<a href="<s:url action="ViewSpecific"/>">View Jobs By Department</a>
<div class="center" >
<input type="button" value="Dashboard" onclick="window.history.go(-3);"/>
</div>
</div>
</div> 
</div>
</body>
</html>