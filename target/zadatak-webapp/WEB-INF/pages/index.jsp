<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<style>
		.title {
			width: 100%;
			margin-top: 50px;
			text-align:center;
			font-size:40px;
		}
		
		.messages {
			background-color:lightgrey;
			width:80%;
			height: 80px;
			display: none;
		}
		
		.login {
			    margin: auto;
			    width: 50%;
			    padding: 10px;
			    text-align: center;
			    align-items: center;
			    position: relative;
		}
	</style>
</head>
<body>
	<div class="title">
		Document Sequence Generator
	</div>
	<div style="width:100%; height: 100px">
		<div class="messages"></div>
	</div>
	<div style="text-align:center; width:100%;">
		<div class="login">
		<form:form id="loginForm" method="post" action="login" modelAttribute="loginBean">
			<table style="margin-left:25%">
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" name="submit" value="LOGIN"></td>
				</tr>
			</table>
		</form:form>
		</div>
	</div>
	<!--<c:if test="${not empty lists}">

		<ul>
			<c:forEach var="listValue" items="${lists}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>

	</c:if>-->
</body>
</html>
