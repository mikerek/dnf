<%@page import="java.util.ArrayList"%>
<%@page import="com.umeni.db.bean.RolBean"%>
<%@page import="com.umeni.db.bean.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>Welcome!</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<table align="center">
		<tr>
			<td align="center">
				<p class="menu">
					<b>Menú</b>
				</p>
				<hr class="mediaHr">
				<p class="menuOpciones">
					| &nbsp; <%= menu %>
				</p>
				<hr class="mediaHr">
				<p align="right">
					<p class="titulos1">
						<b>Bienvenido al Sistema administrativo de Umeni</b>
						<br>
					</p>
					<p class="titulos2">
						* Revisa las opcines del menú superior de acuerdo a los permisos de tu usuario *
						<br>
						<br>
						<img alt="Umeni Galeria" src="img/logoUmeni.png" width="530" height="300">
					</p>
				</p>
			</td>
		</tr>
	</table>
	<hr>
	<table align="right">
		<tr>
			<td>
				<p class="minimo">
					<a href="logout.jsp">Salir del sistema</a>
				</p>
			</td>
		</tr>
	</table>
</body>
</html>