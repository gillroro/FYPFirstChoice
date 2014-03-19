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
</head>
 
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Add a skill</h4>

<s:form action="AddSkill" >
	<s:textfield name="skillName" label="Skill Name" theme= "css_xhtml"/>
	<s:textarea name="description" label="Description" theme="css_xhtml" />
	<s:submit value="Add Skill" theme="simple" />
</s:form>

<div class="center" >
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>
</div>
	
</div> 
</div>
</body>
</html>