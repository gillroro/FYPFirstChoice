<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
 
 <img class="full-width" src="images/fc.png" />
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Job Boards</h4>

<div class="center" >
<a href="<s:url action="PostJob"/>">Post Job</a>
<a href="<s:url action="ViewAll"/>">View All Jobs</a>
<a href="<s:url action="ViewSpecific"/>">View Jobs By Department</a>
<a href="<s:url action="ViewApplications"/>">View Applications</a>
<div class="center" >
<br />
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>
</div>
</div>

</div> 
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>