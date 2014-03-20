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
	
	<!-- Javascript -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/kickstart.js"></script>
	<s:head theme="ajax" />
</head>
<body>
<div style="height:350px;width:550px;margin:0 auto;">
			<img class="full-width" src="images/fc.png" />
			<h4 style="color:#999;margin-bottom:40px;" class="center"> Holiday Requests </h4>
        </div>
	<div class="center" >
	<s:form action="holidayResultAction" namespace="/" method="POST" theme= "css_xhtml" >
 
		<s:datetimepicker name="date1" label="Holiday Date 1" displayFormat="dd/MM/yyyy"  required="true" />
 
		<s:datetimepicker name="date2" label="Holiday Date 2" displayFormat="dd/MM/yyyy"  required="true" />
 
		<s:datetimepicker name="date3" label="Holiday Date 3" displayFormat="dd/MM/yyyy"  required="true" />
 
		<s:submit value="Request" name="submit" theme="simple"/>
 
	</s:form>
	</div>
</body>
</html>