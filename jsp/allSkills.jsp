<%@ include file="header.jsp" %>
<body>
 <div style="height:1000px;width:650px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> All Skills</h4>

<table class="striped sortable">
<thead><tr>
<th> Skill Name </th><th>Description</th>
</tr></thead>
<s:iterator value="skills" status ="skillsStatus" >
 <tr>
  	<s:if test="#skillsStatus.even == true">
      <td><s:property value ="name" /></td>
      <td><s:property value ="description" /></td>
    </s:if>
    <s:else>
      <td><s:property value ="name" /></td>
      <td><s:property value ="description" /></td>
    </s:else>
  </tr>
</s:iterator>
</table>

<input type="button" value="Dashboard" onclick="window.history.go(-2);"/>

</div> 

</div>
<%@ include file="footer.jsp" %>
 
</body>
</html>