<%@ include file="header.jsp" %>
 
<body>
 <div style="height:500px;width:900px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Manage Employee Details</h4>

<table >
<th>First Name</th><th>Surname</th><th>Username</th><th>Password</th><th>Address</th><th>Salary</th><th>User Type</th><th>Manager</th><th>Edit</th>
<s:iterator value="employees" status ="employeesStatus" id="employeesBean" >
 <tr>
  	<s:if test="#employeesStatus.even == true">
      <td style="background: #CCCCCC"><s:property value ="firstName" /> </td>
	  <td style="background: #CCCCCC"><s:property value ="surname" /> </td>
	  <td style="background: #CCCCCC"><s:property value ="username" /> </td>
	  <td style="background: #CCCCCC"><s:property value ="password" /> </td>
	  <td style="background: #CCCCCC"><s:property value ="address" /> </td>
	  <td style="background: #CCCCCC"><s:property value ="salary" /> </td>
	  <td style="background: #CCCCCC"><s:property value ="userType" /> </td>
	 <td style="background: #CCCCCC"><s:property value ="manager" /> </td>
	 <td style="background: #CCCCCC"><s:url id="editURL" action="editUser" escapeAmp="false">

			<s:bean name="entity.Employee"></s:bean>
			<s:param name="firstName" value="#employeesBean.firstName"></s:param>
			<s:param name="surname" value="#employeesBean.surname"></s:param>
			<s:param name="username" value="#employeesBean.username"></s:param>
			<s:param name="password" value="#employeesBean.password"></s:param>
			<s:param name="address" value="#employeesBean.address"></s:param>
			<s:param name="salary" value="#employeesBean.salary"></s:param>
			<s:param name="manager" value="#employeesBean.manager"></s:param>
			<s:param name="userType" value="#employeesBean.userType"></s:param>


		</s:url>

		<s:a href="%{editURL}">Edit</s:a></td>
    </s:if>
    <s:elseif test="#employeesStatus.first == true">
      <td><s:property value ="firstName" /></td>
	  <td><s:property value ="surname" /> </td>
	  <td><s:property value ="username" /> </td>
	  <td><s:property value ="password" /> </td>
	  <td><s:property value ="address" /> </td>
	  <td><s:property value ="salary" /> </td>
	  <td><s:property value ="userType" /> </td>
	  <td><s:property value ="manager" /> </td>
	  <td><s:url id="editURL" action="editUser" escapeAmp="false">

			<s:bean name="entity.Employee"></s:bean>
			<s:param name="firstName" value="#employeesBean.firstName"></s:param>
			<s:param name="surname" value="#employeesBean.surname"></s:param>
			<s:param name="username" value="#employeesBean.username"></s:param>
			<s:param name="password" value="#employeesBean.password"></s:param>
			<s:param name="address" value="#employeesBean.address"></s:param>
			<s:param name="salary" value="#employeesBean.salary"></s:param>
			<s:param name="manager" value="#employeesBean.manager"></s:param>
			<s:param name="userType" value="#employeesBean.userType"></s:param>


		</s:url>

		<s:a href="%{editURL}">Edit</s:a></td>
    </s:elseif>
    <s:else>
      <td><s:property value ="firstName" /></td>
	  <td><s:property value ="surname" /> </td>
	  <td><s:property value ="username" /> </td>
	  <td><s:property value ="password" /> </td>
	  <td><s:property value ="address" /> </td>
	  <td><s:property value ="salary" /> </td>
	  <td><s:property value ="userType" /> </td>
	  <td><s:property value ="manager" /> </td>
	  	  <td><s:url id="editURL" action="editUser" escapeAmp="false">

			<s:bean name="entity.Employee"></s:bean>
			<s:param name="firstName" value="#employeesBean.firstName"></s:param>
			<s:param name="surname" value="#employeesBean.surname"></s:param>
			<s:param name="username" value="#employeesBean.username"></s:param>
			<s:param name="password" value="#employeesBean.password"></s:param>
			<s:param name="address" value="#employeesBean.address"></s:param>
			<s:param name="salary" value="#employeesBean.salary"></s:param>
			<s:param name="manager" value="#employeesBean.manager"></s:param>
			<s:param name="userType" value="#employeesBean.userType"></s:param>


		</s:url>

		<s:a href="%{editURL}">Edit</s:a></td>
    </s:else>
  </tr>
</s:iterator>
</table>

<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>

</div> 
</div>
</body>
</html>