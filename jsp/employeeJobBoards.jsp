<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
 
			<img class="full-width" src="images/fc.png" />
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Employee Job Boards</h4>
			<h4 style="color:#999;margin-bottom:40px;" class="center"> User: <s:property value="#session.employee.firstName"/> <s:property value="#session.employee.surname"/></h4>

<div class="center" >

<s:url id="viewAllURL" action="ViewAll" escapeAmp="false" />
<s:a href="%{viewAllURL}">View All Jobs</s:a>

<s:url id="viewdepartmentsURL" action="ViewSpecific" escapeAmp="false" />
<s:a href="%{viewdepartmentsURL}">View Jobs By Department</s:a>
<div class="center" >
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>
</div>
</div>

</div> 
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>