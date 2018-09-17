<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script language="javascript" type="text/javascript" src="js/validation.js"></script>
	<script language="javascript" type="text/javascript" src="js/ajaxFunctions.js"></script>
	<script language="javascript" type="text/javascript" src="js/JSONCalls.js"></script>
<title>Login Page</title>
</head>
<body>
	<form action="ValidaUsuarioServlet" method="post" onsubmit="javascript:return validaLogin();">
		<table align="center">
			<tr>
				<td colspan="2" align="center">
					<img src="img/logoUmeni.png" width="450" height="200"/>
				</td>
			</tr>
		</table>
		<br>
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
	</form>
	<div id="notificationDivFather" style="display: none" align="center">
		<img src="img/yes.jpg" width="100" height="100" />
		<div id="notificationDiv">
		</div>
	</div>
</body>
</html>