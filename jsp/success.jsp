<%@ include file="header.jsp" %>
<body >
     
            <div id="menu">
				
			
			</div>
        <div style="height:450px;width:550px;margin:0 auto;">
			<img class="full-width" src="images/fc.png" />
			<h4 style="color:#999;margin-bottom:40px;" class="center"> Welcome to Your Dashboard! </h4>
			<h4 style="color:#999;margin-bottom:40px;" class="center"> User: <s:property value="#session.employee.firstName"/> <s:property value="#session.employee.surname"/></h4>

        </div>		
		<div class="center" >
			<!--<a href="<s:url action="ManageDetails"/>">Manage Details</a><br />-->
			<a href="<s:url action="DateTimePicker"/>">Manage Holiday Requests</a><br />
			<a href="<s:url action="EmployeeJobBoards"/>">Job Boards</a><br />
			<a href="<s:url action="SelfAppraise"/>">Self Appraise</a><br />
			<a href="<s:url action="UpdateSkillProfile"/>">Update Skill Profile</a><br />

		</div>
		
		<div id="body">
			<div id="feedControl">Loading...</div>
		</div>
		
		<div class ="center" style="height:200px;width:550px;margin:0 auto;">
		<s:form action = "Logout" >
					<s:submit value = "Logout" theme= "simple"  />
			</s:form>
	</div>
     
 <%@ include file="footer.jsp" %>
</body>
</html>