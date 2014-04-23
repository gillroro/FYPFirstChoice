<%@ include file="header.jsp" %>
<body>
 <div style="height:700px;width:550px;margin:0 auto;">
 
			<img class="full-width" src="images/fc.png" />
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> All Skills</h4>

<table class="striped sortable">
<thead><tr>
<th>Skill Name</th><th>Add To Profile</th>
</tr></thead>
<s:iterator value="skills" status ="skillsStatus" id="skillsBean" >
 <tr>
  	<s:if test="#skillsStatus.even == true">
      <td ><s:property value ="name" /></td>
	 	   <!--<td><a href="<s:url action="AddSkillToProfile"/>"><i class="icon-plus"></i></a>-->

	    <td><s:url id="skillURL" action="AddSkillToProfile" escapeAmp="false">

			<s:bean name="entity.Skill"></s:bean>
			<s:param name="name" value="#skillsBean.name"></s:param>
			<s:param name="description" value="#skillsBean.description"></s:param>
		</s:url>

		<s:a href="%{skillURL}"><i class="icon-plus"></i></s:a></a></td>
    </s:if>
    <s:else>
      <td><s:property value ="name" /></td>
	   <!--<td><a href="<s:url action="AddSkillToProfile"/>"><i class="icon-plus"></i></a>-->
	    <td><s:url id="skillURL" action="AddSkillToProfile" escapeAmp="false">

			<s:bean name="entity.Skill"></s:bean>
			<s:param name="name" value="#skillsBean.name"></s:param>
			<s:param name="description" value="#skillsBean.description"></s:param>
		</s:url>

		<s:a href="%{skillURL}"><i class="icon-plus"></i></s:a></a></td>
    </s:else>
  </tr>
</s:iterator>
</table>

<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>

</div> 
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>