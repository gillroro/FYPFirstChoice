<%@ include file="header.jsp" %>
<body>
     
            <div id="menu">
		
			
			</div>
        <div style="height:350px;width:550px;margin:0 auto;">
			<img class="full-width" src="images/fc.png" />
			<h4 style="color:#999;margin-bottom:40px;" class="center"> Welcome to Your Dashboard! </h4>
			
        </div>
		
		<div class="center" >
	
		
		<div class="center" >
			<a href="<s:url action="AddEmployee"/>">Register Employee</a><br />
			<a href="<s:url action="ManageAppraisals"/>">Manage Employee Appraisal</a><br />
			<a href="<s:url action="ManageEmployeeDetails"/>">Manage Employee Details</a><br />
			<a href="<s:url action="ManageEmployeeHolidays"/>">Manage Holiday Requests</a><br />
			<a href="<s:url action="JobBoards"/>">Manage Job Boards</a><br />
			<a href="<s:url action="Projects"/>">Manage Projects</a><br />
			<a href="<s:url action="SkillsBoard"/>">Manage Skills</a><br />
		</div>
		<div class ="center" style="height:200px;width:550px;margin:0 auto;">
		<s:form action = "Logout" >
					<s:submit value = "Logout" theme= "simple"  />
			</s:form>
	</div>
        <div id="footer">
			
			<h6 style="color:#999;margin-bottom:40px;" class="center"> ©Gillian Rowan, 2013.      </h6>
	            
        </div>


</body>
</html>