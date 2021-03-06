<%@ include file="header.jsp" %>
 
<body>
 <div style="height:1000px;width:900px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Manage Employee Details</h4>

	<table class="striped sortable">
				<thead>
				<tr>
<th>First Name</th><th>Surname</th><th>Username</th><th>Address</th><th>Salary</th><th>User Type</th><th>Manager</th><th>Edit</th>
</tr></thead>
<s:iterator value="employees" status ="employeesStatus" id="employeesBean" >
 <tr>
  	<s:if test="#employeesStatus.even == true">
      <td><s:property value ="firstName" /> </td>
	  <td><s:property value ="surname" /> </td>
	  <td><s:property value ="username" /> </td>
	  <td><s:property value ="address" /> </td>
	  <td><s:property value ="salary" /> </td>
	  <td><s:property value ="userType" /> </td>
	 <td><s:property value ="manager" /> </td>
	 <td><s:url id="editURL" action="editUser" escapeAmp="false">

			<s:bean name="entity.Employee"></s:bean>
			<s:param name="firstName" value="#employeesBean.firstName"></s:param>
			<s:param name="surname" value="#employeesBean.surname"></s:param>
			<s:param name="username" value="#employeesBean.username"></s:param>
			<s:param name="address" value="#employeesBean.address"></s:param>
			<s:param name="salary" value="#employeesBean.salary"></s:param>
			<s:param name="manager" value="#employeesBean.manager"></s:param>
			<s:param name="userType" value="#employeesBean.userType"></s:param>


		</s:url>

		<s:a href="%{editURL}"><i class="icon-edit"></i></s:a></td>
    </s:if>
    <s:elseif test="#employeesStatus.first == true">
      <td><s:property value ="firstName" /></td>
	  <td><s:property value ="surname" /> </td>
	  <td><s:property value ="username" /> </td>
	  <td><s:property value ="address" /> </td>
	  <td><s:property value ="salary" /> </td>
	  <td><s:property value ="userType" /> </td>
	  <td><s:property value ="manager" /> </td>
	  <td><s:url id="editURL" action="editUser" escapeAmp="false">

			<s:bean name="entity.Employee"></s:bean>
			<s:param name="firstName" value="#employeesBean.firstName"></s:param>
			<s:param name="surname" value="#employeesBean.surname"></s:param>
			<s:param name="username" value="#employeesBean.username"></s:param>
			<s:param name="address" value="#employeesBean.address"></s:param>
			<s:param name="salary" value="#employeesBean.salary"></s:param>
			<s:param name="manager" value="#employeesBean.manager"></s:param>
			<s:param name="userType" value="#employeesBean.userType"></s:param>


		</s:url>

		<s:a href="%{editURL}"><i class="icon-edit"></i></s:a></td>
    </s:elseif>
    <s:else>
      <td><s:property value ="firstName" /></td>
	  <td><s:property value ="surname" /> </td>
	  <td><s:property value ="username" /> </td>
	  <td><s:property value ="address" /> </td>
	  <td><s:property value ="salary" /> </td>
	  <td><s:property value ="userType" /> </td>
	  <td><s:property value ="manager" /> </td>
	  	  <td><s:url id="editURL" action="editUser" escapeAmp="false">

			<s:bean name="entity.Employee"></s:bean>
			<s:param name="firstName" value="#employeesBean.firstName"></s:param>
			<s:param name="surname" value="#employeesBean.surname"></s:param>
			<s:param name="username" value="#employeesBean.username"></s:param>
			<s:param name="address" value="#employeesBean.address"></s:param>
			<s:param name="salary" value="#employeesBean.salary"></s:param>
			<s:param name="manager" value="#employeesBean.manager"></s:param>
			<s:param name="userType" value="#employeesBean.userType"></s:param>


		</s:url>

		<s:a href="%{editURL}"><i class="icon-edit"></i></s:a></td>
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