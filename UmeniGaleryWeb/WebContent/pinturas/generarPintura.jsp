<%@page import="java.util.ArrayList"%>
<%@page import="com.umeni.db.bean.ProductoMedidaBean"%>
<%@page import="com.umeni.db.bean.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../bsHead.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/estilos.css">
<title>Creación de nueva Pintura - Umeni</title>
</head>
<body>

	
	<%
		UsuarioBean bean = ( UsuarioBean ) session.getAttribute("beanUsuario");
		ArrayList< ProductoMedidaBean > beanMedidas = ( ArrayList ) session.getAttribute( "listaMedidaPinturas" );
	%>
	<p class="titulos1">
		Momento de registrar una nueva pintura en el sistema
	</p>
	<form action="RealizarVentaServlet">
		<table class="compraventa">
			<tr>
				<td>
					<label for="producto">Escribe el identificador del Producto:</label>
				</td>
			</tr>
			<tr>
				<td>
					<input name="productoVenta" id="productoVenta" type="text" />
				</td>
			</tr>
			<tr>
				<td>
					<div id="notaAlPie">
						El identidicador del producto es aquella clave que le ayuda al usuario del sistema distinguir si es un Abstracto, un Paisaje, etc
					</div>
<				</td>
			</tr>
			<tr>
				<td>
					<hr id="inputForm"/>
<				</td>
			</tr>
			<tr>
				<td>
					<label for="comentarios">Comentarios Generarles:</label>
				</td>
			</tr>
			<tr>
				<td>
					<select name="rolIdUsuario" id="rolIdUsuario">
						<option value="0">- selecciona -</option>
						<% 
						for ( int i=0; i< beanMedidas.size() ; i++ ){
							
							int id_producto_medida = beanMedidas.get( i ).getId_producto_medida();
							String medida = beanMedidas.get( i ).getMedida(); 
						%>
						<option value= "<%= id_producto_medida %>"><%= medida %></option>
						<% } %>
					</select>
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