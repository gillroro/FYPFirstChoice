<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:900px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Manage Employee Appraisals</h4>
<s:form action="SelectedEmployee" >
<i>Employee Name</i><s:select headerKey="-1" headerValue="Select Employee Name" name="firstName" list="employees" listKey="first_name" listValue="firstName"  theme = "css_xhtml" ></s:select>

<s:submit name="Submit" value="Submit" theme= "simple" />

</s:form>
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>

</div> 
</div>
</body>
</html>