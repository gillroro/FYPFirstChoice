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
	
	<!-- Javascript -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/kickstart.js"></script>
</head>
 
<body>
 <div style="height:500px;width:800px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Job Boards</h4>

<table>
<th>Position Name</th><th>Description</th><th>Department</th><th>Closing Date</th><th>Apply</th>
<s:iterator value="jobs" status ="jobsStatus" >
 <tr>
  	<s:if test="#jobsStatus.even == true">
      <td style="background: #CCCCCC"><s:property value ="jobName" /></td>
	  <td style="background: #CCCCCC"><s:property value ="jobDesc" /></td>
	  <td style="background: #CCCCCC"><s:property value ="department" /></td>
	  <td style="background: #CCCCCC"><s:property value ="closing_date" /></td>
	  <td style="background: #CCCCCC"><a href="<s:url action="JobApplication"/>">Apply</a>
    </s:if>
    <s:elseif test="#jobsStatus.first == true">
      <td><s:property value ="jobName"  /></td>
	  <td><s:property value ="jobDesc" /></td>
	  <td><s:property value ="department" /></td>
	  <td><s:property value ="closing_date" /></td>
	  <td><a href="<s:url action="JobApplication"/>">Apply</a>
    </s:elseif>
    <s:else>
      <td><s:property value ="jobName" /></td>
	  <td><s:property value ="jobDesc" /></td>
	  <td><s:property value ="department" /></td>
	  <td><s:property value ="closing_date" /></td>
	  <td><a href="<s:url action="JobApplication"/>">Apply</a>
    </s:else>
  </tr>
</s:iterator>
</table>

<input type="button" value="Dashboard" onclick="window.history.go(-2);"/>

</div> 
</div>
</body>
</html>