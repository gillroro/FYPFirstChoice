<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:900px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Manage Employee Holidays</h4>

<table class="striped sortable">
<thead><tr>
<th>Date 1</th><th>Date 2</th><th>Date 3</th><th>Employee Name</th><th>Approve</th>
</tr></thead>
<s:iterator value="holidays" status ="holidaysStatus" id="holidayBean" >
 <tr>
  	<s:if test="#holidaysStatus.even == true">
      <td><s:property value ="date1" /> </td>
	  <td><s:property value ="date2" /> </td>
	  <td><s:property value ="date3" /> </td>
	  <td><s:property value ="employeeName" /> </td>
	   <td><s:url id="approveHolidayURL" action="EmployeeHolidayApproval" escapeAmp="false">
			<s:bean name="entity.Holiday"></s:bean>
			<s:param name="employeeName" value="#holidayBean.employeeName"></s:param>
		</s:url>

		<s:a href="%{approveHolidayURL}"><i class="icon-ok-circle"></i></s:a></td>
    </s:if>
    <s:elseif test="#holidaysStatus.first == true">
      <td><s:property value ="date1" /> </td>
	  <td><s:property value ="date2" /> </td>
	  <td><s:property value ="date3" /> </td>
	  <td><s:property value ="employeeName" /> </td>
	  <td><s:url id="approveHolidayURL" action="EmployeeHolidayApproval" escapeAmp="false">
			<s:bean name="entity.Holiday"></s:bean>
			<s:param name="employeeName" value="#holidayBean.employeeName"></s:param>
		</s:url>

		<s:a href="%{approveHolidayURL}"><i class="icon-ok-circle"></i></s:a></td>
    </s:elseif>
    <s:else>
        <td><s:property value ="date1" /> </td>
	  <td><s:property value ="date2" /> </td>
	  <td><s:property value ="date3" /> </td>
	  <td><s:property value ="employeeName" /> </td>
	 <td><s:url id="approveHolidayURL" action="EmployeeHolidayApproval" escapeAmp="false">
			<s:bean name="entity.Holiday"></s:bean>
			<s:param name="employeeName" value="#holidayBean.employeeName"></s:param>
		</s:url>

		<s:a href="%{approveHolidayURL}"><i class="icon-ok-circle"></i></s:a></td>
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