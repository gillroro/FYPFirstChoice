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
<h4 style="color:#999;margin-bottom:40px;" class="center"> Skill Profile</h4>
<h5 style="color:#999;margin-bottom:40px;" class="center"> Please provide proof of skill knowledge below: </h5>
<h5 style="color:#999;margin-bottom:40px;" class="center"> Eg. Certificate, Details of Course </h5>

<s:form action="resultAction" namespace="/" method="POST" enctype="multipart/form-data">
 
	<s:file name="fileUpload" label="Select a File to upload" size="40" />
 
	<s:submit value="Upload" name="submit" />
 
</s:form>

or:<br />
<br />
<s:form action="AddProof" namespace="/" method="POST" theme= "css_xhtml" >
<s:textarea label="Skills Proof" name="proof" cols="60" rows="4"></s:textarea>
<s:submit value="Submit" name="submit" />
</s:form>
<div class="center" >
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>


</div> 
</div>
</body>
</html>