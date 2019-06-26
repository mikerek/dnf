<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../metaData.jsp" %>	
	<title>Operación INCORRECTA!</title>
</head>
<body>
	<%@ include file="../header.jsp" %>	
	<%
		String operacionUsuario = (String) session.getAttribute("operacionUsuario");
		
	%>
	<h1 align="center">
		<B>HUBO UN ERROR EN LA OPERACIÓN</B>!<br>
		La operación &nbsp;<b><%=operacionUsuario %></b> &nbsp; NO se realizó!
		<br>
		<br>
		<a href="ValidaUsuarioServlet?oper='management'">Rergesar Inicio</a>
	</h1>
	<%@ include file="../jQueryFooter.jsp"%>
	<%@ include file="../regresarPagina.jsp" %>
	<%@ include file="../copyright.jsp"%>
</body>
</html>