<%@ include file="header.jsp" %>
 
<body>
 <div style="height:500px;width:800px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> All Projects</h4>

<table>
<th>Project Name</th><th>Start Date</th><th>End Date</th><th>Department</th>
<s:iterator value="projects" status ="projectsStatus" >
 <tr>
  	<s:if test="#projectsStatus.even == true">
      <td style="background: #CCCCCC"><s:property value ="projectName" /></td>
	  <td style="background: #CCCCCC"><s:property value ="startDate" /></td>
	  <td style="background: #CCCCCC"><s:property value ="endDate" /></td>
	  <td style="background: #CCCCCC"><s:property value ="department" /></td>
    </s:if>
    <s:elseif test="#projectsStatus.first == true">
      <td><s:property value ="projectName"  /></td>
	  <td><s:property value ="startDate" /></td>
	  <td><s:property value ="endDate" /></td>
	  <td><s:property value ="department" /></td>
    </s:elseif>
    <s:else>
     <td><s:property value ="projectName"  /></td>
	  <td><s:property value ="startDate" /></td>
	  <td><s:property value ="endDate" /></td>
	  <td><s:property value ="department" /></td>
    </s:else>
  </tr>
</s:iterator>
</table>

<input type="button" value="Project Home" onclick="window.history.go(-1);"/>

</div> 
</div>
</body>
</html>