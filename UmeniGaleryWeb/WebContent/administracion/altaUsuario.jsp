<%@page import="com.umeni.db.bean.RolBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umeni.db.bean.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../metaData.jsp" %>
    <title>UMENI - Alta de Usuario</title> 
	<script language="javascript" type="text/javascript" src="../js/validation.js"></script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<%
		usuarioBean = (UsuarioBean) session.getAttribute("beanUsuario");
		ArrayList < RolBean > listRolBean = ( ArrayList< RolBean > ) session.getAttribute( "listBeanRol" );
		if( usuarioBean.getNombre().equals( null ) || listRolBean.equals( null ) ) {
			
			out.print("Fuera perro!");
			
		}
	%>
	
	<h1 align="center">Llena los campos del usuario nuevo del sistema</h1>
	<br>	
	<hr>
	<section id="formaAltaUsuario">
		<div class="container">
	        <form action="../NewUserServlet" method="post" onsubmit="javascript:return validaNuevoUsuario();">
	            <div class="row">
	                <div class="col col-md-4">
	                    <label for="nombreUsuario">Nombre de Usuario</label>
	                    <input type="text" class="form-control" id="nombreUsuario" placeholder="Juan Perez">
	                </div>
                </div>
                <div class="row">
	                <div class="col col-md-4">
	                    <label for="emailUsuario">Email del nuevo Usuario</label>
	                    <input type="email" class="form-control" id="emailUsuario" placeholder="micorreo@gmail.com">
	                </div>
	            </div>
	            <div class="row">
		            <div class="col col-md-4">
		                <label for="passwordUsuario">Password</label>
		                <input type="password" class="form-control" id="passwordUsuario" placeholder="123qweASD">
		            </div>
		        </div>
                <div class="row">
		            <div class="col col-md-4">
	                    <label for="rolIdUsuario">Rol de Usuario</label>
	                    <select id="rolIdUsuario" class="form-control">
	                        <option value="0">- selecciona -</option>
							<% 
							for ( int i=0; i< listRolBean.size() ; i++ ){
								
								int id_rol = listRolBean.get( i ).getId_rol();
								String nombreRol = listRolBean.get( i ).getNombre(); 
							%>
							<option value= "<%= id_rol %>"><%= nombreRol %></option>
							<% } %>
	                    </select>
	                </div>
                </div>
                <div class="row">
                	<div class="col col-md-4">
	            		<button type="submit" class="btn btn-outline-info btn-block">Agregar usuario</button>
	            	</div>
	            </div>
	        </form>
	    </div>
    </section>
    <hr>
	<%@ include file="../jQueryFooter.jsp"%>
	<%@ include file="../regresarPagina.jsp" %>
	<%@ include file="../copyright.jsp"%>
</body>
</html>