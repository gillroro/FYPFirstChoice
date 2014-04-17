<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Employee Job Boards</h4>

<div class="center" >
<a href="<s:url action="ViewAll"/>">View All Jobs</a>
<a href="<s:url action="ViewSpecific"/>">View Jobs By Department</a>
<div class="center" >
<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>
</div>
</div>

</div> 
</div>
</body>
</html>