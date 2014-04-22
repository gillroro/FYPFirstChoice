<%@ include file="header.jsp" %>
<body>
 <div style="height:1000px;width:550px;margin:0 auto;">
 <img class="full-width" src="images/fc.png" />
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Job Application </h4>
Upload CV Document for <s:property value="jobName" />
<div class="center" >

<s:form action="resultAction" namespace="/" method="POST" enctype="multipart/form-data">

	<s:hidden name="firstName" value="%{#session.employee.firstName}" />
	<s:textfield name="jobName" value="%{jobName}" label="Job Name" />
	<s:textfield name="jobDesc" value="%{jobDesc}" label="Job Description" />
	<s:textfield name="department" value="%{department}" label="Department" />
	<!--<input type="file" name="myFile" />-->
	<s:file name="myFile" label="Select a File to upload" size="40" />
 
	<s:submit value="Upload" name="submit" />
 
</s:form> 

<div class="center" >
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>
</div>
</div>

</div> 
</div>
 <%@ include file="footer.jsp" %>
</body>
</html>