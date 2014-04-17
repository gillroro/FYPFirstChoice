<%@ include file="header.jsp" %>
<body>
<div class="center" >	
	
	
	<h5>Edit Employee:</h5>
<s:form action="updateEmployee">
	<s:textfield value="%{firstName}" label="Name" theme="css_xhtml" />
	<s:textfield value="%{surname}" label="Surname" theme="css_xhtml" />
	<s:textfield value="%{username}" label="Username" theme="css_xhtml" />
	<s:textfield value="%{password}" label="Password" theme="css_xhtml" />
	<s:textfield value="%{address}" label="Address" theme="css_xhtml" />
	<s:textfield value="%{salary}" label="Salary" theme="css_xhtml" />
	<s:textfield value="%{manager}" label="Manager" theme="css_xhtml" />
	<s:textfield value="%{userType}" label="User Type" theme="css_xhtml" />
	<s:submit value="Update" theme="simple" />
</s:form>
</div>
</body>
</html>