	<%@page import="java.util.ArrayList"%>
<%@page import="com.umeni.db.bean.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../metaData.jsp" %>
	<script language="javascript" type="text/javascript" src="../js/ajaxFunctions.js"></script>
	<title>Bajas de Usuario</title>
</head>
<body onload="javascript:obtenerUsuarios();">
	<%@ include file="../header.jsp" %>	
	<%
		usuarioBean = (UsuarioBean) session.getAttribute("beanUsuario");
		ArrayList< UsuarioBean > listaUsuarios = (ArrayList< UsuarioBean >) session.getAttribute( "listaUsuarios" );
		int i;
	%>
	<h2 align="center">Selecciona el email del usuario a eliminar</h2>
	<br>
	<section id="formasUsuario">
		<div class="container">
			<form action="../EliminarUsuarioServlet" method="post">
				 <div class="row">
		            <div class="col col-md-4 mx-auto">
	                    <label for="rolIdUsuario">Usuario a eliminar:</label>
	                    <select id="idUsuario" name="idUsuario" class="form-control">
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
	                </div>
                </div>
                <div class="row">
                	<div class="col col-md-4 mx-auto">
	            		<button type="submit" class="btn btn-outline-info btn-block">Eliminar Usuario</button>
	            	</div>
	            </div>
			</div>
		</form>
	</section>
	<%@ include file="../jQueryFooter.jsp"%>
	<%@ include file="../regresarPagina.jsp" %>
	<%@ include file="../copyright.jsp"%>
</body>
</html>