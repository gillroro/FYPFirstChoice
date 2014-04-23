<%@ include file="header.jsp" %>
 
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Add Project</h4>

<s:form action="AddProject" >
	<s:textfield name="projectName" label="Project Name" theme= "css_xhtml"/>
	<s:datetimepicker name="startDate" label="Start Date" displayFormat="dd/MM/yyyy"  required="true" theme="css_xhtml"/>
	<s:datetimepicker name="endDate" label="End Date" displayFormat="dd/MM/yyyy"  required="true" theme="css_xhtml"/>
	<s:textfield name="department" label="Department" theme="css_xhtml" />
	
	<s:submit value="Add Project" theme="simple" />
</s:form>	
</div> 
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>