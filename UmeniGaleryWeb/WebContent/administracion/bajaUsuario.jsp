<%@page import="java.util.ArrayList"%>
<%@page import="com.umeni.db.bean.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script language="javascript" type="text/javascript" src="../js/ajaxFunctions.js"></script>
<title>Bajas de Usuario</title>
</head>
<body onload="javascript:obtenerUsuarios();">
	<%
		UsuarioBean bean = (UsuarioBean) session.getAttribute("beanUsuario");
		ArrayList< UsuarioBean > listaUsuarios = (ArrayList< UsuarioBean >) session.getAttribute( "listaUsuarios" );
		int i;
	%>
	<h1 align="center">Selecciona el email del usuario a eliminar</h1>
	<br>
	<form action="../EliminarUsuarioServlet" method="post">
		<table align="center">
			<tr>
				<td align="center">
					Selecciona el usuario a eliminar:
				</td>
			</tr>
			<tr>
				<td>
					<select id="idUsuario" name="idUsuario">
						<option value="0">-Usuarios-</option>
						<%
						for ( i=0; i< listaUsuarios.size() ; i++ ){
						
							int idUsuario = listaUsuarios.get(i).getId_Usuario();
							String emailUsuario = listaUsuarios.get(i).getEmail();
							String nombreUsuario = listaUsuarios.get(i).getNombre();
						
						%>
						<option value="<%=idUsuario %>"><%=emailUsuario  + " - " +nombreUsuario%></option>
						<%
						}
						%>
					</select>
				</td>
			</tr>
			<!-- 
			<tr>
				<td>
					Nombre:
				</td>
				<td>
					<input type="text" name="emailUsuario" id="emailUsuario" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
					Password:
				</td>
				<td>
					<input type="password" name="passwordUsuario" id="passwordUsuario" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
					Rol:
				</td>
				<td>
					<input type="text" name="rolUsuario" id="rolUsuario" readonly="readonly" /><%=bean.getId_Rol() %>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
			</tr>
			 -->
			 <tr>
			 	<td>
			 		&nbsp;
			 	</td>
			 </tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Eliminar Usuario" />
				</td>
			</tr>
		</table>
	</form>
	<%@ include file="../regresarPagina.jsp" %>
</body>
</html>