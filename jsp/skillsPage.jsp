<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
 
			<img class="full-width" src="images/fc.png" />
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Skill Management</h4>

<div class="center" >
<a href="<s:url action="AddSkillPage"/>">Add a Skill</a>
<a href="<s:url action="ViewAllSkill"/>">View All Skills</a>
<br />
<div class="center" >
<br />
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>
</div>
</div>

</div> 
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>