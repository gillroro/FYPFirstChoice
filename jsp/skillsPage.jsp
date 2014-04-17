<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Skill Management</h4>

<div class="center" >
<a href="<s:url action="AddSkillPage"/>">Add a Skill</a>
<a href="<s:url action="ViewAllSkill"/>">View All Skills</a>

<div class="center" >
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>
</div>
</div>

</div> 
</div>
</body>
</html>