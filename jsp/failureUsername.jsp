<%@ include file="header.jsp" %>
<body>
	<div class="col_12" style="margin-top:100px;">
		<h1 class="center">
		<p><i class="icon-fire"></i></p>
			Welcome to First Choice</h1>
		<h4 style="color:#999;margin-bottom:40px;" class="center"> The Human Resource Management Solution!</h4>
	</div>
	<div class ="center">

            <h4 style="color:#999;margin-bottom:40px;" class="center"> The username you have entered is already taken</h4>
			<h4 style="color:#999;margin-bottom:40px;" class="center"> Please return to the previous page and </h4>
			<h4 style="color:#999;margin-bottom:40px;" class="center"> choose a new username.</h4>

	</div>
		<div class ="center">
			<div class="center" >
				<input type="button" value="Dashboard" onclick="window.history.go(-1);"/>
			</div>
		</div>
		
 <%@ include file="footer.jsp" %>
</body>
</html>