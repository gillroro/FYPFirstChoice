<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Delete Project</h4>

<p><i>Please enter the project name that you wish to delete?</p></i>
<s:form action="DeleteProject" >
	<s:textfield name="projectName" label="Project Name" theme= "css_xhtml"/>	
	<s:submit value="Delete Project" theme="simple" />
</s:form>	
</div> 
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>