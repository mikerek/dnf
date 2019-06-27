<%@page import="com.umeni.db.bean.UsuarioBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umeni.db.bean.ProductoMedidaBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../metaData.jsp" %>
    <title>UMENI - Crear Nueva Pintura</title> 
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
		ArrayList< ProductoMedidaBean > beanMedidas = ( ArrayList ) session.getAttribute( "listaMedidaPinturas" );
	%>
	<h2 align="center">Momento de registrar una nueva pintura en el sistema</h2>
	<br>
	<section id="formasUsuario">
		
		<div class="container">
				
			<form action="../CreaNuevaPinturaServlet">
				<div class="row">
					<div class="col col-md-4 mx-auto">
						<label for="productoVenta">Escribe el identificador del Pintura:</label>
						<input class="form-control" name="productoVenta" id="productoVenta" type="text" >
					</div>
					<div class="col col-md-4 mx-auto" >
						 <label for="medidaPintura">Medida Pintura</label>
                   		 <select id="medidaPintura" name="medidaPintura" class="form-control">
                       		<option value="0">- selecciona -</option>
								<% 
								for ( int i=0; i< beanMedidas.size() ; i++ ){
									
									int id_producto_medida = beanMedidas.get( i ).getId_producto_medida();
									String medida = beanMedidas.get( i ).getMedida(); 
								%>
								<option value= "<%= id_producto_medida %>"><%= medida %></option>
								<% } %>
							</select>
					</div>
				</div>
				<div class="row">
					<div class="col col-md-10 mx-auto">
						
						<textarea class="md-textarea form-control" rows="3" cols="8" name="comentarios" id="comentarios" placeholder="Detalles de la nueva Pinturas, comentarios en general"></textarea>
					
					</div>
				</div>
					
				<div class="row">
	                <div class="col col-md-4 mx-auto">
	                    <label for="id_usuario">Usuario:</label>
	                    <label><b><%=usuarioBean.getNombre() %></b></label>
	                    <input type="hidden" class="form-control" name="id_usuario" id="id_usuario" value="<%=usuarioBean.getId_Usuario() %>">
	                </div>

	                <div class="col col-md-4 mx-auto">
	                    <label for="fecha">Fecha de registro de Pintura:</label>
	                    <input type="text" class="form-control" name="fecha" id="fecha" value="<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()) %>" disabled="disabled">
	                </div>
                </div>
                
                <div class="row">
                	<div class="col col-md-4 mx-auto">
	            		<button type="submit" class="btn btn-secondary btn-block">Registrar Nueva Pintura</button>
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