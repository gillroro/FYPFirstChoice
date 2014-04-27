<%@ include file="header.jsp" %>
<body>
 <div style="height:600px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Post a Job</h4>

<s:form action="AddJob" >
	<s:textfield name="jobName" label="Job Name" theme= "css_xhtml"/>
	<s:datetimepicker name="closing_date" label="Closing Date" displayFormat="dd/MM/yyyy"  required="true" theme="css_xhtml"/>
	<s:textarea name="description" label="Description" theme="css_xhtml" />
	<s:textfield name="department" label="Department" theme="css_xhtml" />
	
	<s:submit value="Add Job" theme="simple" />
</s:form>	
</div> 
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>