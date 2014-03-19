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
	<link rel="stylesheet" type="text/css" href="style.css" media="all" /> 
	
	<!-- Javascript -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/kickstart.js"></script>
</head>
 
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> All Skills</h4>

<table>
<th>Skill Name</th><th>Add To Profile</th>
<s:iterator value="skills" status ="skillsStatus" >
 <tr>
  	<s:if test="#skillsStatus.even == true">
      <td style="background: #CCCCCC"><s:property value ="name" /></td>
	  <td style="background: #CCCCCC"><a href="<s:url action="AddSkillToProfile"/>">Add</a>
    </s:if>
    <s:else>
      <td><s:property value ="name" /></td>
	   <td><a href="<s:url action="AddSkillToProfile"/>">Add</a>
    </s:else>
  </tr>
</s:iterator>
</table>

<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>

</div> 
</div>
</body>
</html>