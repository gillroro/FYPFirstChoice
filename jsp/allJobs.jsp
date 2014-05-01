<%@ include file="header.jsp" %>
<body>
 <div style="height:900px;width:800px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Job Boards</h4>

<table>
<table class="striped sortable">
<thead>
<tr>
<th>Position Name</th><th>Description</th><th>Department</th><th>Closing Date</th><th>Apply</th>
</tr>
</thead>
<s:iterator value="jobs" status ="jobsStatus" id="jobsBean" >
 <tr>
  	<s:if test="#jobsStatus.even == true">
      <td><s:property value ="jobName" /></td>
	  <td><s:property value ="jobDesc" /></td>
	  <td><s:property value ="department" /></td>
	  <td><s:property value ="closing_date" /></td>
	  <td><s:url id="applyURL" action="JobApplication" escapeAmp="false">

			<s:bean name="entity.Job"></s:bean>
			<s:param name="jobName" value="#jobsBean.jobName"></s:param>
			<s:param name="jobDesc" value="#jobsBean.jobDesc"></s:param>
			<s:param name="department" value="#jobsBean.department"></s:param>
			<s:param name="closing_date" value="#jobsBean.closing_date"></s:param>


		</s:url>

		<s:a href="%{applyURL}"><i class="icon-pencil"></i></s:a></td>
    </s:if>
    <s:elseif test="#jobsStatus.first == true">
      <td><s:property value ="jobName"  /></td>
	  <td><s:property value ="jobDesc" /></td>
	  <td><s:property value ="department" /></td>
	  <td><s:property value ="closing_date" /></td>
	  <td><s:url id="applyURL" action="JobApplication" escapeAmp="false">

			<s:bean name="entity.Job"></s:bean>
			<s:param name="jobName" value="#jobsBean.jobName"></s:param>
			<s:param name="jobDesc" value="#jobsBean.jobDesc"></s:param>
			<s:param name="department" value="#jobsBean.department"></s:param>
			<s:param name="closing_date" value="#jobsBean.closing_date"></s:param>


		</s:url>

		<s:a href="%{applyURL}"><i class="icon-pencil"></i></s:a></td>
    </s:elseif>
    <s:else>
      <td><s:property value ="jobName" /></td>
	  <td><s:property value ="jobDesc" /></td>
	  <td><s:property value ="department" /></td>
	  <td><s:property value ="closing_date" /></td>
	  <td><s:url id="applyURL" action="JobApplication" escapeAmp="false">

			<s:bean name="entity.Job"></s:bean>
			<s:param name="jobName" value="#jobsBean.jobName"></s:param>
			<s:param name="jobDesc" value="#jobsBean.jobDesc"></s:param>
			<s:param name="department" value="#jobsBean.department"></s:param>
			<s:param name="closing_date" value="#jobsBean.closing_date"></s:param>


		</s:url>

		<s:a href="%{applyURL}"><i class="icon-pencil"></i></s:a></td>
    </s:else>
  </tr>
</s:iterator>
</table>

<input type="button" value="Go Back" onclick="window.history.go(-1);"/>

</div> 
</div>
 <%@ include file="footer.jsp" %>
</body>
</html>