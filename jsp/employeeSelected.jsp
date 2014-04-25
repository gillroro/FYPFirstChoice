<%@ include file="header.jsp" %>
<div style="height:500px;width:900px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Manage Employee Appraisal for <s:property value="firstName" /></h4>
<table class="striped sortable">
<thead><tr>
<th>Accomplishments</th><th>Barriers</th><th>Improvements</th><th>Performance</th><th>Attendance</th><th>Respect</th><th>Project Details</th><th>Bonus</th>
</tr></thead>
<s:iterator value="appraisals" status ="appraisalsStatus" id="appraisalBean" >
 <tr>
  	<s:if test="#appraisalsStatus.even == true">
      <td><s:property value ="accomplishments" /> </td>
	  <td><s:property value ="barriers" /> </td>
	  <td><s:property value ="improvements" /> </td>
	  <td><s:property value ="performance" /> </td>
	  <td><s:property value ="attendance" /> </td>
	  <td><s:property value ="respect" /> </td>	 
	  <td><s:property value ="projectDetails" /> </td>
	  <td><s:url id="approveURL"  escapeAmp="false">
			<s:bean name="entity.Appraisal"></s:bean>
			<s:param name="accomplishments" value="#appraisalBean.accomplishments"></s:param>
			<s:param name="improvements" value="#appraisalBean.improvements"></s:param>
			<s:param name="projectDetails" value="#appraisalBean.projectDetails"></s:param>
		</s:url>

		<s:a href="%{approveURL}"><i class="icon-ok-circle"></i></s:a>
		<s:url id="removeURL"  escapeAmp="false">
			<s:bean name="entity.Appraisal"></s:bean>
			<s:param name="accomplishments" value="#appraisalBean.accomplishments"></s:param>
			<s:param name="improvements" value="#appraisalBean.improvements"></s:param>
			<s:param name="projectDetails" value="#appraisalBean.projectDetails"></s:param>
		</s:url>

		<s:a href="%{removeURL}"><i class="icon-remove-circle"></i></s:a></td>
    </s:if>
    <s:elseif test="#appraisalsStatus.first == true">
      <td><s:property value ="accomplishments" /> </td>
	  <td><s:property value ="barriers" /> </td>
	  <td><s:property value ="improvements" /> </td>
	  <td><s:property value ="performance" /> </td>
	  <td><s:property value ="attendance" /> </td>
	  <td><s:property value ="respect" /> </td>
	  <td><s:property value ="projectDetails" /> </td>
	    <td><s:url id="approveURL"  escapeAmp="false">
			<s:bean name="entity.Appraisal"></s:bean>
			<s:param name="accomplishments" value="#appraisalBean.accomplishments"></s:param>
			<s:param name="improvements" value="#appraisalBean.improvements"></s:param>
			<s:param name="projectDetails" value="#appraisalBean.projectDetails"></s:param>
		</s:url>

		<s:a href="%{approveURL}"><i class="icon-ok-circle"></i></s:a>
		<s:url id="removeURL"  escapeAmp="false">
			<s:bean name="entity.Appraisal"></s:bean>
			<s:param name="accomplishments" value="#appraisalBean.accomplishments"></s:param>
			<s:param name="improvements" value="#appraisalBean.improvements"></s:param>
			<s:param name="projectDetails" value="#appraisalBean.projectDetails"></s:param>
		</s:url>

		<s:a href="%{removeURL}"><i class="icon-remove-circle"></i></s:a></td>
    </s:elseif>
    <s:else>
        <td><s:property value ="accomplishments" /> </td>
	  <td><s:property value ="barriers" /> </td>
	  <td><s:property value ="improvements" /> </td>
	  <td><s:property value ="performance" /> </td>
	  <td><s:property value ="attendance" /> </td>
	  <td><s:property value ="respect" /> </td>
	  <td><s:property value ="projectDetails" /> </td>
	    <td><s:url id="approveURL"  escapeAmp="false">
			<s:bean name="entity.Appraisal"></s:bean>
			<s:param name="accomplishments" value="#appraisalBean.accomplishments"></s:param>
			<s:param name="improvements" value="#appraisalBean.improvements"></s:param>
			<s:param name="projectDetails" value="#appraisalBean.projectDetails"></s:param>
		</s:url>

		<s:a href="%{approveURL}"><i class="icon-ok-circle"></i></s:a>
		<s:url id="removeURL"  escapeAmp="false">
			<s:bean name="entity.Appraisal"></s:bean>
			<s:param name="accomplishments" value="#appraisalBean.accomplishments"></s:param>
			<s:param name="improvements" value="#appraisalBean.improvements"></s:param>
			<s:param name="projectDetails" value="#appraisalBean.projectDetails"></s:param>
		</s:url>

		<s:a href="%{removeURL}"><i class="icon-remove-circle"></i></s:a></td>
    </s:else>
  </tr>
</s:iterator>
</table>
</div>
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>