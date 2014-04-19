<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> All Skills</h4>

<table class="striped sortable">
<thead><tr>
<th>Skill Name</th><th>Add To Profile</th>
</tr></thead>
<s:iterator value="skills" status ="skillsStatus" >
 <tr>
  	<s:if test="#skillsStatus.even == true">
      <td ><s:property value ="name" /></td>
	  <td><a href="<s:url action="AddSkillToProfile"/>"><i class="icon-plus"></i></a>
    </s:if>
    <s:else>
      <td><s:property value ="name" /></td>
	   <td><a href="<s:url action="AddSkillToProfile"/>"><i class="icon-plus"></i></a>
    </s:else>
  </tr>
</s:iterator>
</table>

<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>

</div> 
</div>
</body>
</html>