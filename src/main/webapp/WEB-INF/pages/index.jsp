<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	<style>
	body {
		font-family: 'Source Sans Pro';
	}
	</style>
		<title>Login</title>
	</head>
	<body>
		<div align="center">
			<div style="width: 50%; height: 70px; text-align:center;">
				<p style="font-size:30px; margin-top:45px;">
					Document sequence generator
				</p>
			</div>
		
			<div style="width: 50%; height: 40px; text-align:center;">
				${message}
			</div>
		
			<h2>Login form:</h2>
				<form action="sendAuthenticationRequest" method="post">
					<p>
						User name: <input name="username" type="text" />
					</p>
					<p>
						Password:  &nbsp;<input name="password" type="password" />
					</p>
					<input
						type="submit" value="LOGIN" />
				</form>
		</div>
	</body>
</html>
