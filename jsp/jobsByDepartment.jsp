<%@ include file="header.jsp" %> 
<body>
 <div style="height:800px;width:550px;margin:0 auto;">
 <img class="full-width" src="images/fc.png" />
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Job Boards</h4>

<s:form action ="JobDepartment" >
	<s:textfield  name="department" label="Department" theme= "css_xhtml" />
	<s:submit value= "Search" theme="simple" />
</s:form>	
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>
</div>
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>