<%@ include file="header.jsp" %>
<body>
<div style="height:350px;width:550px;margin:0 auto;">
			<img class="full-width" src="images/fc.png" />
			<h4 style="color:#999;margin-bottom:40px;" class="center"> Employee Registration </h4>
        </div>
	<div class="center" >	
	
	
	<h5>Register Employee:</h5>
			<s:form action="Register" >
				<s:textfield name="newFirstName" value= "First Name" theme= "css_xhtml"/>
				<s:textfield name="surname" value= "Surname" theme= "css_xhtml"/>
				<s:textfield name="Username" value= "Username" theme= "css_xhtml"/>
				<s:password name="Password" value= "Password" showPassword= "true" theme= "css_xhtml"/>
				<s:textfield name="Address" value= "Address" theme= "css_xhtml"/>
				<s:textfield name="Salary" value= "Salary" theme= "css_xhtml"/>
				<s:textfield name="UserType" value= "User Type" theme= "css_xhtml"/>
				<s:select headerKey="-1" headerValue="--Select Manager--" name="firstName" list="managers" listKey="firstName" listValue="firstName" theme= "css_xhtml" ></s:select>
				<s:submit value="Register" theme= "simple"/>
			</s:form>
	</div>
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>