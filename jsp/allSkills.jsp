<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> All Skills</h4>

<table class="striped sortable">
<thead><tr>
<th> Skill Name </th>
</tr></thead>
<s:iterator value="skills" status ="skillsStatus" >
 <tr>
  	<s:if test="#skillsStatus.even == true">
      <td style="background: #CCCCCC"><s:property value ="name" /></td>
    </s:if>
    <s:else>
      <td><s:property value ="name" /></td>
    </s:else>
  </tr>
</s:iterator>
</table>

<input type="button" value="Dashboard" onclick="window.history.go(-2);"/>

</div> 
</div>
</body>
</html>