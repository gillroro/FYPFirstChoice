<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> All Skills</h4>

<table>
<th>Skill Name</th><th>Add To Profile</th>
<s:iterator value="skills" status ="skillsStatus" >
 <tr>
  	<s:if test="#skillsStatus.even == true">
      <td style="background: #CCCCCC"><s:property value ="name" /></td>
	  <td style="background: #CCCCCC"><a href="<s:url action="AddSkillToProfile"/>">Add</a>
    </s:if>
    <s:else>
      <td><s:property value ="name" /></td>
	   <td><a href="<s:url action="AddSkillToProfile"/>">Add</a>
    </s:else>
  </tr>
</s:iterator>
</table>

<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>

</div> 
</div>
</body>
</html>