<%@ include file="header.jsp" %>
 
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
 
 
 <img class="full-width" src="images/fc.png" />
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Project Home</h4>

<div class="center" >
<a href="<s:url action="CreateProject"/>">Create Project</a><br />
<a href="<s:url action="GetProjects"/>">View All Projects</a><br />
<a href="<s:url action="ProjectDeleteForm"/>">Delete A Project</a><br />
<a href="<s:url action="AssignMemberToProject"/>">Assign Employee</a><br />
<div class="center" >
<br />
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>
</div>
</div>

</div> 
</div>
<br />
 <%@ include file="footer.jsp" %>
</body>
</html>