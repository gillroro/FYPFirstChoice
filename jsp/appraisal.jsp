<%@ include file="header.jsp" %>
<body>

		<div style="height:150px;width:750px;margin:0 auto;">
			<h4 style="color:#999;margin-bottom:30px;" class="center"> Employee Appraisal </h4>
			<p><i>Employees should complete this form prior to the annual performance appraisal meeting with their supervisor</p></i>
        </div>
		
		<div align="center" style="height:1000px;width:800px;margin:0 auto;">
		
			

			<s:form action="Appraisal" namespace="/" method="POST" theme= "css_xhtml" >
			
							 
				<s:textarea label="Describe your most significant accomplishments this past year" name="accomplishments" cols="60" rows="4"></s:textarea>
				<s:textarea label="Describe any barriers or challenges that impacted you in effectively completing your 
job responsibilities or accomplishing your goals" name="barriers" cols="60" rows="4"></s:textarea>
			<s:textarea label="Please list your area(s) of strength and area(s) of improvement" name="improvements" cols="60" rows="4"></s:textarea>
			<s:textarea label="What skills or new knowledge would you like to develop to improve your performance?" name="performance" cols="60" rows="4"></s:textarea>
			
				<i>Attendance</i><s:radio name="attendanceRecord"  list="attendance" value="attendanceRecord" />
				<i>Respect for Others</i><s:radio name="respectRecord" list="respect" value="respectRecord" />	
				<!--<i>Manager</i><s:select headerKey="-1" headerValue="Select Manager" name="firstName" list="managers" listKey="employee_id" listValue="firstName"  ></s:select>-->
				<i>Projects</i>
				
				<table>
					<th>Project Name</th>
						<s:iterator value="projects" status ="projectsStatus" >
					<tr>
						<s:if test="#projectsStatus.even == true">
							<td style="background: #CCCCCC"><s:property value ="projectName" /></td>
						</s:if>
						<s:elseif test="#projectsStatus.first == true">
							<td><s:property value ="projectName"  /></td>
						</s:elseif>
						<s:else>
							<td><s:property value ="projectName"  /></td>
						</s:else>
					</tr>
						</s:iterator>
				</table>
				
				
				<s:submit name ="Appraisal" value="Submit" theme= "simple" />
			
			</s:form>	
	
	
		</div>

		
		  <div id="footer">
			
			<h6 style="color:#999;margin-bottom:40px;" class="center">©Gillian Rowan, 2013.      </h6>
	            
        </div>
</body>

</html>