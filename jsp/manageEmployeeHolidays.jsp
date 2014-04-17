<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:900px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Manage Employee Holidays</h4>

<table class="editableTable">
<th>Date 1</th><th>Date 2</th><th>Date 3</th><th>Employee ID</th><th>Approve</th>
<s:iterator value="holidays" status ="holidaysStatus" >
 <tr>
  	<s:if test="#holidaysStatus.even == true">
      <td style="background: #CCCCCC"><s:property value ="date1" /> </td>
	  <td style="background: #CCCCCC"><s:property value ="date2" /> </td>
	  <td style="background: #CCCCCC"><s:property value ="date3" /> </td>
	  <td style="background: #CCCCCC"><s:property value ="employee_id" /> </td>
	 <td style="background: #CCCCCC"><a href="<s:url action="fileUploadAction"/>">Approve</a>
    </s:if>
    <s:elseif test="#holidaysStatus.first == true">
      <td><s:property value ="date1" /> </td>
	  <td><s:property value ="date2" /> </td>
	  <td><s:property value ="date3" /> </td>
	  <td><s:property value ="employee_id" /> </td>
	  <td><a href="<s:url action="fileUploadAction"/>">Approve</a>
    </s:elseif>
    <s:else>
        <td><s:property value ="date1" /> </td>
	  <td><s:property value ="date2" /> </td>
	  <td><s:property value ="date3" /> </td>
	  <td><s:property value ="employee_id" /> </td>
	    <td><a href="<s:url action="fileUploadAction"/>">Approve</a>
    </s:else>
  </tr>
</s:iterator>
</table>

<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>

</div> 
</div>
</body>
</html>