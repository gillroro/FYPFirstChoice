<%@ include file="header.jsp" %>
<body>
<div style="height:350px;width:550px;margin:0 auto;">
			<img class="full-width" src="images/fc.png" />
			<h4 style="color:#999;margin-bottom:40px;" class="center"> Holiday Requests </h4>
        </div>
	<div class="center" >
	<s:form action="holidayResultAction" namespace="/" method="POST" theme= "css_xhtml" >
 
		<s:datetimepicker name="date1" label="Holiday Date 1" displayFormat="dd/MM/yyyy"  required="true" />
 
		<s:datetimepicker name="date2" label="Holiday Date 2" displayFormat="dd/MM/yyyy"  required="true" />
 
		<s:datetimepicker name="date3" label="Holiday Date 3" displayFormat="dd/MM/yyyy"  required="true" />
 
		<s:submit value="Request" name="submit" theme="simple"/>
 
	</s:form>
	</div>
	
 <%@ include file="footer.jsp" %>
</body>
</html>