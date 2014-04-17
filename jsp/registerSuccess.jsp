<%@ include file="header.jsp" %>
<body>
<div style="height:500px;width:550px;margin:0 auto;">
			<img class="full-width" src="images/fc.png" />
			<h4 style="color:#999;margin-bottom:40px;" class="center"> Employee Registered </h4>
        </div>
	<div class="center" >

 
<h4>
   New Employee <s:property value="firstName"/>  Registered
</h4> 
 
<input type="button" value="Dashboard" onclick="window.history.go(-2);"/>
 </div>
</body>
</html>