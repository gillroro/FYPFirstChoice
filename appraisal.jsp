<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
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
		$(document).ready(function(){
 
    var counter = 2;
 
    $("#addButton").click(function () {
 
	if(counter>10){
            alert("Only 10 tasks allowed");
            return false;
	}   
 
	var newTextBoxDiv = $(document.createElement('div'))
	     .attr("id", 'TextBoxDiv' + counter);
 
	newTextBoxDiv.after().html('<label>Task #'+ counter + ' : </label>' +
	      '<input type="text" name="textbox' + counter + 
	      '" id="textbox' + counter + '" value="" >');
 
	newTextBoxDiv.appendTo("#TextBoxesGroup");
 
 
	counter++;
     });
 
     $("#removeButton").click(function () {
	if(counter==1){
          alert("No more tasks to remove");
          return false;
       }   
 
	counter--;
 
        $("#TextBoxDiv" + counter).remove();
 
     });
 
     $("#getButtonValue").click(function () {
 
	var msg = '';
	for(i=1; i<counter; i++){
   	  msg += "\n Task #" + i + " : " + $('#textbox' + i).val();
	}
    	  alert(msg);
     });
  });
	</script>
	<sx:head />

</head>
<body>

		<div style="height:350px;width:550px;margin:0 auto;">
			<img class="full-width" src="images/fc.png" />
			<h4 style="color:#999;margin-bottom:40px;" class="center"> Employee Appraisal </h4>
        </div>
		
		<div align="center" style="height:800px;width:600px;margin:0 auto;">
		
			<table>

			<s:form action="Appraisal" namespace="/" method="POST" theme= "css_xhtml" >
			
				 <h6>Attendance</h6><s:radio name="attendanceRecord" list="#{'1':'Excellent','2':'Very Good', '3':'Average', '4': 'Poor'}" />
				 <h6>Respect for Others</h6><s:radio name="respectRecord" list="#{'1':'Excellent','2':'Very Good', '3':'Average', '4': 'Poor'}"  />
				 <h6>Employee Efficiency</h6><s:radio  name ="efficiencyRecord" list="#{'1':'Excellent','2':'Very Good', '3':'Average', '4': 'Poor'}" />
			
			
				 <h6>Accuracy of Work</h6><s:radio  name ="accuracyRecord" list="#{'1':'Excellent','2':'Very Good', '3':'Average', '4': 'Poor'}" />
				 <h6>Quality of Work</h6><s:radio  name ="qualityRecord" list="#{'1':'Excellent','2':'Very Good', '3':'Average', '4': 'Poor'}" />
				 <h6>Manager</h6> <sx:autocompleter size="1" list="managers" name="manager"></sx:autocompleter>
					</action>
					<h6 style="color:#999;margin-bottom:20px;" class="center"> Please add task completed</h6>
				<div id='TextBoxesGroup'>
					<div id="TextBoxDiv1">
						<label>Task #1 : </label><input type='textbox' id='textbox1' >
					</div>
				</div>
				<input type='button' value='Add Task' id='addButton'>
				<input type='button' value='Remove Task' id='removeButton'>
				<input type='button' value='Save Tasks' id='getButtonValue'>	
				


			
			
			
				 <s:submit name ="Appraisal" value="Appraise" theme= "simple" />
			
			</s:form>	
			</table>
		</div>

		
		  <div id="footer">
			
			<h6 style="color:#999;margin-bottom:40px;" class="center"> ©Gillian Rowan, 2013.      </h6>
	            
        </div>
</body>

</html>