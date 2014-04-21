<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Upload CV Document for <s:property value="jobName" /></h4>
 
<s:form action="resultAction" namespace="/" method="POST" enctype="multipart/form-data">
 
	<s:file name="fileUpload" label="Select a File to upload" size="40" />
 
	<s:submit value="Upload" name="submit" />
 
</s:form>
</div> 
</div>
</body>
</html>