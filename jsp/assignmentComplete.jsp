<%@ include file="header.jsp" %>
<body>

		<div style="height:150px;width:750px;margin:0 auto;">
			<h4 style="color:#999;margin-bottom:30px;" class="center"> Project Assignment Complete</h4>
        </div>
		
		<div align="center" style="height:300px;width:800px;margin:0 auto;">
		
			<table>
			<th>Project Name</th><th>Employee</th>
			<tr>
			<td><s:property value="%{projectName}" /> <br /></td>
			<td><s:property value="firstName" /><br /></td>
				</tr>
			</table>
			
			<input type="button" value="Project Dashboard" onclick="window.history.go(-2);"/>
		</div>
				
		  <div id="footer">
			
			<h6 style="color:#999;margin-bottom:40px;" class="center"> ©Gillian Rowan, 2013.      </h6>
	            
        </div>
</body>

</html>