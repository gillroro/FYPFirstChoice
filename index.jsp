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
	<s:head />
</head>
<body>
<div class="grid">
	<!--<s:form action ="Login">
		<s:submit value="Manager" theme="css_xhtml" />
	</s:form>-->
	<div class="col_12" style="margin-top:100px;">
		<h1 class="center">
		<p><i class="icon-fire"></i></p>
			Welcome to First Choice</h1>
		<h4 style="color:#999;margin-bottom:40px;" class="center"> The Human Resource Management Solution!</h4>
	</div>
	<div align="center" style="height:500px;width:500px;margin:0 auto;">
	<div class="col_400 float_l" >
	<s:actionerror />
<s:fielderror />
	<h5>Employee Login:</h5>
		<s:form action="Login" validate="true">
		<s:textfield name="Username" value ="Username" theme= "css_xhtml" />
		<s:password name="Password" value="Password" showPassword="true" theme= "css_xhtml"  />
		<s:submit value="Login" />
		</s:form>
	</div>
	<div class="col_400 float_r" >
		<h5>Manager Login:</h5>
		<s:form action="ManagerLogin" validate="true">
		<s:textfield name="Username" value ="Username" theme= "css_xhtml" />
		<s:password name="Password" value="Password" showPassword="true" theme= "css_xhtml"  />
		<s:submit value="Login" />
		</s:form>
	
	</div>
	</div>
	<!-- Slideshow -->
	<div align="center" style="height:500px;width:500px;margin:0 auto;">
		<ul class="slideshow" align="center">
			<li><img src="images/hrm2.jpg" width="550" height="350" /></li>
			<li><img src="images/white.jpg" width="550" height="350" /></li>
			<li><img src="images/HumanResources.jpg" width="550" height="350" /></li>
		</ul>
	</div>
</div> <!-- End Grid -->
	 <div id="footer">
			
			<h6 style="color:#999;margin-bottom:40px;" class="center"> ©Gillian Rowan, 2013.      </h6>
	            
        </div>

</body>
</html>
