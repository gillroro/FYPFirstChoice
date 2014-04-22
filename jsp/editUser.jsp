<%@ include file="header.jsp" %>
<body>
<div class="center" >	
	
	
	<h5>Edit Employee:</h5>
<s:form action="updateEmployee">
	<s:textfield value="%{firstName}" label="First Name" theme="css_xhtml" name="firstName" />
	<s:textfield value="%{surname}" label="Surname" theme="css_xhtml" name="surname" />
	<s:hidden value="%{username}"  name="username" />
	<s:textfield value="%{password}" label="Password" theme="css_xhtml" disabled="true" name="password" />
	<s:textfield value="%{address}" label="Address" theme="css_xhtml" name="address" />
	<s:textfield value="%{salary}" label="Salary" theme="css_xhtml" name="salary" />
	<s:textfield value="%{userType}" label="User Type" theme="css_xhtml" name="userType" />
	<s:submit value="Update" theme="simple" />
</s:form>
</div>
</body>
</html>