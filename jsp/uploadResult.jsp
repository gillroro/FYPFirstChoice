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
<h4 style="color:#999;margin-bottom:40px;" class="center"> CV Upload</h4>
 
<h4>
   File Name : <s:property value="fileUploadFileName"/> 
</h4> 
 
<h4>
   Content Type : <s:property value="fileUploadContentType"/> 
</h4> 
 
<h4>
   File : <s:property value="fileUpload"/> 
</h4> 
<input type="button" value="Dashboard" onclick="window.history.go(-2);"/>
 </div> 
</div>
</body>
</html>