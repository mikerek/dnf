<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login Page</title>


<script language="javascript" type="text/javascript"
	src="js/validation.js"></script>
<script language="javascript" type="text/javascript"
	src="js/ajaxFunctions.js"></script>
<script language="javascript" type="text/javascript"
	src="js/JSONCalls.js"></script>

<%@ include file="bsHead.jsp"%>
<link rel="stylesheet" type="text/css" href="css/loginCSS.css">

</head>
<body class="text-center">
	<form action="ValidaUsuarioServlet" method="post" class="form-signin"
		onsubmit="javascript:return validaLogin();">

		<img class="mb-4 image-top" src="img/logoUmeni.svg" 
			height="auto"> <br>
		<h1 class="h3 mb-3 font-weight-normal">Login al sistema...</h1>
		<label for="loginId" class="sr-only">Email</label> 
		<input type="text" name="loginId" id="loginId" class="form-control" placeholder="Email@usuario.com"
			required autofocus> 
		<label for="passwordUsuario" class="sr-only">Password</label> 
		<input type="password" id="passwordUsuario" name="passwordUsuario" class="form-control" placeholder="*******"
			required>
		<div class="checkbox mb-3">
			<label> 
			<input type="checkbox" value="remember-me">
				Recuérdame
			</label>
		</div>
		<button class="btn btn-lg btn-secondary btn-block" type="submit">Ingresar</button>
		<%@ include file="copyright.jsp" %>
		<!-- 
		<table align="center">
			<tr>
				<td>
					Nombre:
				</td>
				<td>
					<input type="text" name="loginId" id="loginId" onchange="javascript:checkUserAjax( this.value )"/>
				</td>
			</tr>
			<tr>
				<td>
					Password:
				</td>
				<td>
					<input type="password" name="passwordUsuario" id="passwordUsuario"/>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Ingresar!" />
				</td>
			</tr>
		</table>
		-->
	</form>
	<div id="notificationDivFather" style="display: none" align="center">
		<img src="img/yes.jpg" width="100" height="100" />
		<div id="notificationDiv"></div>
	</div>
</body>
</html>