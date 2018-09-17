<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Operación correcta!</title>
</head>
<body>
	<%
		String operacionUsuario = (String) session.getAttribute("operacionUsuario");
		
	%>
	<h1 align="center">
		Felicidades!<br>
		La operación &nbsp;<b><%=operacionUsuario %></b> &nbsp; se realizó con éxito!
		<br>
		<br>
		<a href="ValidaUsuarioServlet?oper='management'">Rergesar Inicio</a>
	</h1>
</body>
</html>