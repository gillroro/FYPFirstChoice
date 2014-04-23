 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
	<!-- META -->
	<title>First Choice</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta name="description" content="" />
	
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="css/kickstart.css" media="all" />
	
	<!-- Javascript -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/kickstart.js"></script>
	<script type="text/javascript" src="js/checkbox.js"></script>
	
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script src="http://www.google.com/uds/solutions/dynamicfeed/gfdynamicfeedcontrol.js" type="text/javascript"></script>

	<style type="text/css">
			@import url("http://www.google.com/uds/solutions/dynamicfeed/gfdynamicfeedcontrol.css");

		#feedControl {
		margin-top : 10px;
		margin-left: auto;
		margin-right: auto;
		width : 440px;
		font-size: 12px;
		color: #9CADD0;
		}	
	</style>
	<script type="text/javascript">
		function load() {
		var feed ="http://feeds.examiner.ie/iebusiness";
		new GFdynamicFeedControl(feed, "feedControl");

		}
	google.load("feeds", "1");
	google.setOnLoadCallback(load);
	</script>
	
	<s:head theme="ajax" />

</head>