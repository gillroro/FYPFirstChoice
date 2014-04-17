<<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Add a skill</h4>

<s:form action="AddSkill" >
	<s:textfield name="skillName" label="Skill Name" theme= "css_xhtml"/>
	<s:textarea name="description" label="Description" theme="css_xhtml" />
	<s:submit value="Add Skill" theme="simple" />
</s:form>

<div class="center" >
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>
</div>
	
</div> 
</div>
</body>
</html>