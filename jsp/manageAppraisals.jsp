<%@ include file="header.jsp" %>
<body>
 <div style="height:600px;width:550px;margin:0 auto;">
			<img class="full-width" src="images/fc.png" />
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Manage Employee Appraisals</h4>
<s:form action="SelectedEmployee" >
<i>Employee Name</i><s:select headerKey="-1" headerValue="Select Employee Name" name="firstName" list="employees" listKey="firstName" listValue="firstName"  theme = "css_xhtml" ></s:select>

<s:submit name="Submit" value="Submit" theme= "simple" />

</s:form>
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>

</div> 
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>