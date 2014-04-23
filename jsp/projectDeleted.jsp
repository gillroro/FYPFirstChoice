<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> Projects</h4>
<h5 style="color:#999;margin-bottom:40px;" class="center"> Project <s:property value="projectName" /> Deleted </h5>

<div class="center" >
<input type="button" value="Project Home" onclick="window.history.go(-2);"/>
</div>

</div> 

 <%@ include file="footer.jsp" %>
</body>
</html>