<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Favicon Image -->
<link href="<c:url value="/resources/images/favicon.ico" />" rel="icon" />
<link rel="apple-touch-icon-precomposed" href="<c:url value="/resources/images/favicon.ico" />" />
<meta name="msapplication-TileImage"
	content="<c:url value="/resources/images/favicon.ico" />" />
	
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/Poiret.css" />"
	rel="stylesheet" />
</head>

<body onload='document.loginForm.username.focus();'>
	<form name='loginForm'
		action="<c:url value='j_spring_security_check' />" method='POST'
		novalidate>
		<h1 align="center">Certainty Infotech Private Limited</h1>
		<center>
			<p id="form">
				<i>HR Login</i>
			</P>
			<div id="box">

				<label>User name </label></br> </br> <input type="text" name="username"
					required ng:minlength="3" class="form-control"></br> <label>Password
				</label></br> </br> <input required ng:minlength="3" type="password" name="password"
					class="form-control"> </br> </br> <input name="submit" type="submit"
					value="submit" id="submit" />
		</center>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		</div>
	</form>

</body>
</html>




