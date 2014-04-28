<%@ include file="header.jsp" %>
<body>
<div class="center" >	
	
	
	<h5>Approval Holidays</h5>
<s:form action="EmployeeHolidayApproval">
	<s:textfield value="%{employeeName}"  name="employeeName"  label="Employee Name" theme="css_xhtml" />
	<s:submit value="Approve" theme="simple" />
</s:form>
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>