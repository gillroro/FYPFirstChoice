<%@ include file="header.jsp" %>
<div style="height:500px;width:900px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Manage Employee Appraisal for <s:property value="firstName" /></h4>
<table class="striped sortable">
<thead><tr>
<th>Accomplishments</th><th>Barriers</th><th>Improvements</th><th>Performance</th><th>Attendance</th><th>Respect</th>
</tr></thead>
<s:iterator value="appraisals" status ="appraisalsStatus" >
 <tr>
  	<s:if test="#appraisalsStatus.even == true">
      <td><s:property value ="accomplishments" /> </td>
	  <td><s:property value ="barriers" /> </td>
	  <td><s:property value ="improvements" /> </td>
	  <td><s:property value ="performance" /> </td>
	  <td><s:property value ="attendance" /> </td>
	  <td><s:property value ="respect" /> </td>
    </s:if>
    <s:elseif test="#appraisalsStatus.first == true">
      <td><s:property value ="accomplishments" /> </td>
	  <td><s:property value ="barriers" /> </td>
	  <td><s:property value ="improvements" /> </td>
	  <td><s:property value ="performance" /> </td>
	  <td><s:property value ="attendance" /> </td>
	  <td><s:property value ="respect" /> </td>
    </s:elseif>
    <s:else>
        <td><s:property value ="accomplishments" /> </td>
	  <td><s:property value ="barriers" /> </td>
	  <td><s:property value ="improvements" /> </td>
	  <td><s:property value ="performance" /> </td>
	  <td><s:property value ="attendance" /> </td>
	  <td><s:property value ="respect" /> </td>
    </s:else>
  </tr>
</s:iterator>
</table>
</div>
</div>
</body>
</html>