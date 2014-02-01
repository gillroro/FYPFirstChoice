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
		<script>
	function addInputBox() { 

var ni = document.getElementById('myDiv'); 

var numi = document.myForm.inputboxlength; 

var num = parseInt(numi.value) +1; 
//alert(num); 
numi.value = num; 

var newdiv = document.createElement('div'); 

var divIdName = 'my'+num+'Div'; 

newdiv.setAttribute('id',divIdName); 

newdiv.innerHTML = "<input type=\"text\" name=\"txtArea"+num +"\" /> <input type=\"button\" onclick=\"removeInputBox(\'"+divIdName+"\')\" value='Remove'/>" 

ni.appendChild(newdiv); 

} 
function removeInputBox(divNum) { 

//alert(); 
var d = document.getElementById('myDiv'); 
var numi = document.myForm.inputboxlength; 
//alert("current value inputboxlength="+numi.value); 
var num = parseInt(numi.value) -1; 

numi.value = num; 
var olddiv = document.getElementById(divNum); 
d.removeChild(olddiv); 
//alert("after removing value inputboxlength="+num); 

} 
</script>
</head>
<body>

		<div style="height:350px;width:550px;margin:0 auto;">
			<img class="full-width" src="images/fc.png" />
			<h4 style="color:#999;margin-bottom:40px;" class="center"> Employee Appraisal - Tasks </h4>
        </div>
		
<div align="center" style="height:500px;width:500px;margin:0 auto;">
<h6 style="color:#999;margin-bottom:40px;" class="center"> Please add task completed</h6>

	<s:form name="myForm" > 
		<s:submit onclick='addInputBox()' value='Add' theme="css_xhtml"/>
		<s:hidden name="inputboxlength" value="0" /> 
		<div id="myDiv"> </div> 
	</s:form> 			

</div>
</body>

</html>