<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Skill Profile </h4>
<h5 style="color:#999;margin-bottom:40px;" class="center"> Please provide proof of skill knowledge below: </h5>
<h5 style="color:#999;margin-bottom:40px;" class="center"> Skill Selected: <s:property value="name" /> </h5>
<h5 style="color:#999;margin-bottom:40px;" class="center"> Eg. Certificate, Details of Course </h5>

<s:form action="uploadProof" namespace="/" method="POST" enctype="multipart/form-data">
 
	<s:hidden name="skillName" value="%{name}" />
	<s:hidden name="firstName" value="%{#session.employee.firstName}" />
	<s:file name="myFile" label="Select a File to upload" size="60" />
 
	<s:submit value="Upload" name="submit" />
 
</s:form>

or:<br />
<br />
<s:form action="AddProof" namespace="/" method="POST" theme= "css_xhtml" >
<s:hidden name="skillName" value="%{name}" />
<s:textarea label="Skills Proof" name="proof" cols="60" rows="4"></s:textarea>
<s:submit value="Submit" name="submit" />
</s:form>
<div class="center" >
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>


</div> 
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>