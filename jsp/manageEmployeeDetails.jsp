<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
	<!-- META -->
	<title>First Choice</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta name="description" content="" />
	
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="css/kickstart.css" media="all" />
	<!--<link rel="stylesheet" type="text/css" href="style.css" media="all" /> -->
	
	<!-- Javascript -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/kickstart.js"></script>
	<script type="text/javascript" src="js/editTable.js"></script>
</head>
 
<body>
 <div style="height:500px;width:900px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Manage Employee Details</h4>

<table >
<th>First Name</th><th>Surname</th><th>Username</th><th>Password</th><th>Address</th><th>Salary</th><th>User Type</th><th>Manager</th><th>Edit</th>
<s:iterator value="employees" status ="employeesStatus" >
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
	 <td style="background: #CCCCCC"><s:url id="editURL" action="editUser">
					<s:param name="id" value="%{id}"></s:param></s:url> <s:a href="%{editURL}">Edit</s:a></td>
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
	  <td><s:url id="editURL" action="editUser">
					<s:param name="id" value="%{id}"></s:param></s:url> <s:a href="%{editURL}">Edit</s:a></td>
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
	  	  <td><s:url id="editURL" action="editUser">
					<s:param name="id" value="%{id}"></s:param></s:url> <s:a href="%{editURL}">Edit</s:a></td>
    </s:else>
  </tr>
</s:iterator>
</table>

<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>

</div> 
</div>
</body>
</html>