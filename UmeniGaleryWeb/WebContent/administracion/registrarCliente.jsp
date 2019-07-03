<%@page import="com.umeni.db.bean.RolBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umeni.db.bean.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../metaData.jsp" %>
    <title>UMENI - Registrar Cliente</title> 
	<script language="javascript" type="text/javascript" src="../js/validation.js"></script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<%
		usuarioBean = (UsuarioBean) session.getAttribute("beanUsuario");
		ArrayList < RolBean > listRolBean = ( ArrayList< RolBean > ) session.getAttribute( "listBeanRol" );
		ArrayList < TipoClienteBean > listaTipoCliente = ( ArrayList< TipoClienteBean > ) session.getAttribute( "listaTipoCliente" );
		if( usuarioBean.getNombre().equals( null ) || listRolBean.equals( null ) ) {
			
			out.print("Fuera perro!");
			
		}
	%>
	
	<h2 align="center">Llena los campos del usuario nuevo del sistema</h2>
	<br>	
	<hr>
	<section id="formasUsuario">
		<div class="container">
		
			<div class="row">
				<div class="col col-md-4 mx-auto">
					<label for="nombreCliente">Nombre de Cliente</label>
	                <input type="text" class="form-control" name="nombreCliente" id="nombreCliente" placeholder="Muebleria Guadalajara SA de CV">
				</div>
				<div class="col col-md-4 mx-auto">
					<label for="rfcCliente">RFC Cliente</label>
	                <input type="text" class="form-control" name="rfcCliente" id="rfcCliente" placeholder="MUEB12356Y09 **">
				</div>
			</div>
			
			<div class="row">
				<div class="col col-md-4 mx-auto">
					<label for="puntoContacto">Punto Contacto</label>
	                <input type="text" class="form-control" name="puntoContacto" id="puntoContacto" placeholder="Juan Perez">
				</div>
				<div class="col col-md-4 mx-auto">
					<label for="telefonoCliente">Teléfono</label>
	                <input type="text" class="form-control" name="telefonoCliente" id="telefonoCliente" placeholder="+52 (33) 1234 1234">
				</div>
			</div>
			
			<div class="row">
				<div class="col col-md-4 mx-auto">
					<label for="emailContacto">Email Contacto</label>
	                <input type="text" class="form-control" name="emailContacto" id="emailContacto" placeholder="JuanPerez@muebleria.net">
				</div>
				<div class="col col-md-4 mx-auto">
					<label for="cargoCliente">Cargo</label>
	                <input type="text" class="form-control" name="cargoCliente" id="cargoCliente" placeholder="Gerente Compras">
				</div>
			</div>
			
			<div class="row">
				<div class="col col-md-4 mx-auto">
					<label for="tipoCliente">Tipo de Cliente</label>
	                <select id="rolIdUsuario" name="rolIdUsuario" class="form-control">
                        <option value="0">- selecciona -</option>
						<% 
						for ( int i=0; i< listRolBean.size() ; i++ ){
							
							int id_rol = listRolBean.get( i ).getId_rol();
							String nombreRol = listRolBean.get( i ).getNombre(); 
						%>
						<option value="<%= id_rol %>"><%= nombreRol %></option>
						<% } %>
                    </select>
				</div>
				<div class="col col-md-4 mx-auto">
					<label for="cargoCliente">Cargo</label>
	                <input type="text" class="form-control" name="cargoCliente" id="cargoCliente" placeholder="Gerente Compras">
				</div>
			</div>						
		
		</div>
	</section>


</body>
</html>