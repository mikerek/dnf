<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../metaData.jsp" %>	
	<title>Operaci�n correcta!</title>
</head>
<body>
	<%@ include file="../header.jsp" %>	
	<%
		String operacionUsuario = (String) session.getAttribute("operacionUsuario");
		
	%>
	<h1 align="center">
		Felicidades!<br>
		La operaci�n &nbsp;<b><%=operacionUsuario %></b> &nbsp; se realiz� con �xito!
		<br>
		<br>
		<a href="ValidaUsuarioServlet?oper='management'">Rergesar Inicio</a>
	</h1>
	<%@ include file="../jQueryFooter.jsp"%>
	<%@ include file="../regresarPagina.jsp" %>
	<%@ include file="../copyright.jsp"%>
</body>
</html>