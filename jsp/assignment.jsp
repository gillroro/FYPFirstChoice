<%@ include file="header.jsp" %>
<body>

		<div style="height:150px;width:750px;margin:0 auto;">
			<h4 style="color:#999;margin-bottom:30px;" class="center"> Project Assignment </h4>
        </div>
		
		<div align="center" style="height:400px;width:800px;margin:0 auto;">
		
			<table>

			<s:form action="CompleteAssignment" namespace="/" method="POST" theme= "css_xhtml" >
				<!--<s:doubleselect  headerValue="--- Please Select ---" headerKey="-1" name="projectName" list="projects" listKey="project_id" listValue="projectName" doubleHeaderValue="--- Please Select ---" doubleHeaderKey="-1" doubleName="firstName" doubleList="members" doubleListKey="employee_id" doubleListValue="firstName +' '+surname+ ' ('+username+') '"  theme = "css_xhtml" />-->
				<i>Project Name</i><s:select headerKey="-1" headerValue="Select Project Name" name="projectName" list="projects" listKey="projectName" listValue="projectName"  theme = "css_xhtml" ></s:select>
				<br />
				<i>Employee Name</i><s:select headerKey="-1" headerValue="Select Employee Name" name="firstName" list="members" listKey="firstName" listValue="firstName"  theme = "css_xhtml" ></s:select>
				<br />
				<s:submit name ="Assign" value="Submit" theme= "simple" />
			</s:form>	
			</table>
			<input type="button" value="Project Dashboard" onclick="window.history.go(-1);"/>
		</div>
		
		  <div id="footer">
			
			<h6 style="color:#999;margin-bottom:40px;" class="center"> ©Gillian Rowan, 2013.      </h6>
	            
        </div>
</body>

</html>