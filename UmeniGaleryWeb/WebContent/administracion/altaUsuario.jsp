<%@page import="com.umeni.db.bean.RolBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umeni.db.bean.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script language="javascript" type="text/javascript" src="../js/validation.js"></script>
<title>Alta de Usuario</title>
</head>
<body>
	<%
		UsuarioBean bean = (UsuarioBean) session.getAttribute("beanUsuario");
		ArrayList < RolBean > listRolBean = ( ArrayList< RolBean > ) session.getAttribute( "listBeanRol" );
		if( bean.getNombre().equals( null ) || listRolBean.equals( null ) ) {
			
			out.print("Fuera perro!");
			
		}
	%>
	<h1 align="center">Llena los campos del usuario nuevo del sistema</h1>
	<br>
	<form action="../NewUserServlet" method="post" onsubmit="javascript:return validaNuevoUsuario();">
		<table align="center">
			<tr>
				<td>
					Nombre Usuario:
				</td>
				<td>
					<input type="text" name="nombreUsuario" id="nombreUsuario"/>
				</td>
			</tr>
			<tr>
				<td>
					Email:
				</td>
				<td>
					<input type="text" name="emailUsuario" id="emailUsuario"/>
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
					Rol:
				</td>
				<td>
					<select name="rolIdUsuario" id="rolIdUsuario">
						<option value="0">- selecciona -</option>
						<% 
						for ( int i=0; i< listRolBean.size() ; i++ ){
							
							int id_rol = listRolBean.get( i ).getId_rol();
							String nombreRol = listRolBean.get( i ).getNombre(); 
						%>
						<option value= "<%= id_rol %>"><%= nombreRol %></option>
						<% } %>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Agregar Usuario" />
				</td>
			</tr>
		</table>
	</form>
	<%@ include file="../regresarPagina.jsp" %>
</body>
</html>