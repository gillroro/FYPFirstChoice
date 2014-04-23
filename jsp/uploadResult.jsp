<%@ include file="header.jsp" %>
<body>
 <div style="height:500px;width:550px;margin:0 auto;">
<div class="center" >
<h4 style="color:#999;margin-bottom:40px;" class="center"> CV Upload Complete</h4>
 
<h5>
   File Name : <s:property value="myFile"/> 
</h5> 
<h5>
   File : <s:property value="myFile"/> 
</h5> 
<input type="button" value="Dashboard" onclick="window.history.go(-2);"/>
 </div> 
</div>

 <%@ include file="footer.jsp" %>
</body>
</html>