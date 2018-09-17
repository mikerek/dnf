<%@page import="com.umeni.db.bean.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/estilos.css">
<title>Momento de Vender - Umeni</title>
</head>
<body>

	
	<%
		UsuarioBean bean = ( UsuarioBean ) session.getAttribute("beanUsuario");
	%>
	<p class="titulos1">
		Favor de llenar los detalles de la Venta!
	</p>
	<form action="RealizarVentaServlet">
		<table class="compraventa">
			<tr>
				<td>
					<label for="compra">Costo de la compra:</label>
				</td>
			</tr>
			<tr>
				<td>
					<input name="compra" id="compra" type="text" value="0.00"/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="comentarios">Comentarios Generarles:</label>
				</td>
			</tr>
			<tr>
				<td>
					<textarea rows="10" cols="30" name="comentarios" id="comentarios">
						Detalles de la compra:
						
					</textarea>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" id="id_usuario" name="id_usuario" value="<%=bean.getId_Usuario() %>"/>
					<input type="hidden" id="fecha" name="fecha" value="<%=new java.text.SimpleDateFormat("dd/mm/yyyy").format(new java.util.Date()) %>"/>
					<input type="hidden" id="hora" name="hora" value=""/>
					<input type="submit" value="Realizar Compra"/>
				</td>
			</tr>
			<!-- tr>
				<td>
				</td>
			</tr-->
		</table>
	</form>
	<%@ include file="../regresarPagina.jsp" %>
	
</body>
</html>