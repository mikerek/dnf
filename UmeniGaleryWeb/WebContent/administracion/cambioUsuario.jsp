<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../metaData.jsp" %>	
	<title>Cambios en el Usuario</title>
</head>
<body>
	<%@ include file="../header.jsp" %>	
	<hr>
	<%
		usuarioBean = (UsuarioBean) session.getAttribute("beanUsuario");
		ArrayList< UsuarioBean > listaUsuarios = (ArrayList< UsuarioBean >) session.getAttribute( "listaUsuarios" );
		ArrayList < RolBean > listRolBean = ( ArrayList< RolBean > ) session.getAttribute( "listBeanRol" );
		if( usuarioBean.getNombre().equals( null ) || listRolBean.equals( null ) ) {
			
			out.print("Fuera perro!");
			
		}
		int i;
	%>
	<h2 align="center">Selecciona el email del usuario para modificar</h2>
	<br>
	<section id="formasUsuario">
		<div class="container">
			<form action="../UsuarioDataServlet" method="post">
				 <div class="row">
		            <div class="col col-md-4 mx-auto">
	                    <label for="rolIdUsuario">Selecciona el usuario:</label>
	                    <select id="nombreUsuario" name="nombreUsuario" class="form-control" onchange="javascript:submit();">
	                       <%
								for ( i=0; i< listaUsuarios.size() ; i++ ){
								
									int idUsuario = listaUsuarios.get(i).getId_Usuario();
									String emailUsuario = listaUsuarios.get(i).getEmail();
									String nombreUsuario = listaUsuarios.get(i).getNombre();
								
								%>
								<option value="<%=nombreUsuario %>"><%=emailUsuario  + " - " +nombreUsuario%></option>
								<%
								}
							%>
	                    </select>
	                </div>
                </div>
                <!-- >div class="row">
                	<div class="col col-md-4 mx-auto">
	            		<button type="submit" class="btn btn-outline-info btn-block"> Usuario</button>
	            	</div>
	            </div-->
			</div>
		</form>
		<div class="container">
			<form action="../CambiaUsuarioServlet" method="post" onsubmit="javascript:return validaNuevoUsuario();">
	            <div class="row">
	                <div class="col col-md-4 mx-auto">
	                    <label for="nombreUsuario">Nombre de Usuario</label>
	                    <input type="text" class="form-control" name="nombreUsuario" id="nombreUsuario" placeholder="Juan Perez">
	                </div>
                </div>
                <div class="row">
	                <div class="col col-md-4 mx-auto">
	                    <label for="emailUsuario">Email del nuevo Usuario</label>
	                    <input type="email" class="form-control" name="emailUsuario" id="emailUsuario" placeholder="micorreo@gmail.com">
	                </div>
	            </div>
	            <div class="row">
		            <div class="col col-md-4 mx-auto">
		                <label for="passwordUsuario">Password</label>
		                <input type="password" class="form-control" name="passwordUsuario" id="passwordUsuario" placeholder="123qweASD">
		            </div>
		        </div>
                <div class="row">
		            <div class="col col-md-4 mx-auto">
	                    <label for="rolIdUsuario">Rol de Usuario</label>
	                    <select id="rolIdUsuario" name="rolIdUsuario" class="form-control">
	                        <option value="0">- selecciona -</option>
							<% 
							for ( i=0; i< listRolBean.size() ; i++ ){
								
								int id_rol = listRolBean.get( i ).getId_rol();
								String nombreRol = listRolBean.get( i ).getNombre(); 
							%>
							<option value="<%= id_rol %>"><%= nombreRol %></option>
							<% } %>
	                    </select>
	                </div>
                </div>
                <div class="row">
                	<div class="col col-md-4 mx-auto">
	            		<button type="submit" class="btn btn-outline-info btn-block">Agregar usuario</button>
	            	</div>
	            </div>
	        </form>
		</div>
	</section>
	<%@ include file="../jQueryFooter.jsp"%>
	<%@ include file="../regresarPagina.jsp" %>
	<%@ include file="../copyright.jsp"%>
</body>
</html>