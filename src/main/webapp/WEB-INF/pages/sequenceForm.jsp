<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style>
	body {
		margin:0px;
	}
	</style>
<title>Insert new sequence</title>
</head>
<body>
	<div style="background-color: gainsboro; height:50px; width:100%">
		<form action="logout" method="post">
			<p style="text-align:right;-webkit-margin-before: 0em; padding: 15px;">Welcome <b>${loggedInUser}</b>!&nbsp;&nbsp;
			<input type="submit" value="Logout">
			</p>
		</form>
	</div>
	
	<div align="center">
		<h2>Create new:</h2>
		<form action="saveSequence" method="post" onclick="return checkLength();">
			<p>
				Purpose: <input name="purpose" id="purpose" type="text" />
			</p>
			<input type="submit" value="Save new sequence" />
		</form>	
		<br>
		<form action="backToList" method="post">
			<input type="submit" value="Back" />
		</form>
    </div>
</body>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>
<script>
	function checkLength(){
		var input = document.getElementById("purpose").value;
		var n = input.length;
		if(n < 1){
			return false;
		}
	}
</script>
</html>