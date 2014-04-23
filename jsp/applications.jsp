<%@ include file="header.jsp" %>
<body>

		<div style="height:150px;width:750px;margin:0 auto;">
			<h4 style="color:#999;margin-bottom:30px;" class="center"> Job Applications</h4>
        </div>
		
		<div align="center" style="height:500px;width:800px;margin:0 auto;">
		
			<table class="striped sortable">
				<thead>
				<tr>
<th>Employee Name</th><th>Job Name</th><th>LinkedIn</th><th>File</th>
</tr></thead>
<s:iterator value="applications" status ="applicationsStatus" id="applicationsBean" >
 <tr>
  	<s:if test="#applicationsStatus.even == true">
		<td><s:property value ="username" /> </td>
		<td><s:property value ="jobName" /> </td>
		<td><s:url id="linkedin" value ="linkedin" /> <s:a href="#" onclick="javascript:window.open('%{linkedin}');">LinkedIn Profile</s:a></td>
		<td><s:url id="fileDownload" namespace="/" action="download" ></s:url> <s:a href="%{fileDownload}">Download CV</s:a></td>
    </s:if>
    <s:elseif test="#applicationsStatus.first == true">
		<td><s:property value ="username" /> </td>
		<td><s:property value ="jobName" /> </td>
		<td><s:url id="linkedin" value ="linkedin" /> <s:a href="#" onclick="javascript:window.open('%{linkedin}');">LinkedIn Profile</s:a></td>
		<td><s:url id="fileDownload" namespace="/" action="download" ></s:url> <s:a href="%{fileDownload}">Download CV</s:a></td>
    </s:elseif>
    <s:else>
		<td><s:property value ="username" /> </td>
		<td><s:property value ="jobName" /> </td>
		<td><s:url id="linkedin" value ="linkedin" /> <s:a href="#" onclick="javascript:window.open('%{linkedin}');">LinkedIn Profile</s:a></td>
		<td><s:url id="fileDownload" namespace="/" action="download" ></s:url> <s:a href="%{fileDownload}">Download CV</s:a></td>
    </s:else>
  </tr>
</s:iterator>
</table>
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>
		</div>

		
		  
 <%@ include file="footer.jsp" %>
</body>

</html>