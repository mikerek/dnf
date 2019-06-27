<%@page import="java.util.Date"%>
<%@page import="com.umeni.db.bean.UsuarioBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../metaData.jsp" %>
    <title>UMENI - Realizar una Compra</title> 
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

	<h2 align="center">Favor de llenar los detalles de la compra realizada</h2>
	<br>
	<section id="formasUsuario">
		<div class="container">
			
			<form action="../RealizarCompraServlet">
			
				<div class="row">
	                <div class="col col-md-4 mx-auto">
	                    <label for="compra">Costo de la compra:</label>
	                    <input type="text" class="form-control" name="compra" id="compra" placeholder="$$$$$$">
	                </div>
                
	                <div class="col col-md-4 mx-auto">
	                    <label for="comentarios">Comentarios Generarles:</label>
	                    <textarea class="md-textarea form-control" rows="3" name="comentarios" id="comentarios" placeholder="Detalles de la compra"></textarea>
	                </div>
                </div>
                
                <div class="row">
	                <div class="col col-md-4 mx-auto">
	                    <label for="id_usuario">Usuario Comprador:</label>
	                    <label><b><%=usuarioBean.getNombre() %></b></label>
	                    <input type="hidden" class="form-control" name="id_usuario" id="id_usuario" value="<%=usuarioBean.getId_Usuario() %>">
	                </div>

	                <div class="col col-md-4 mx-auto">
	                    <label for="fecha">Fecha de registro de compra:</label>
	                    <input type="text" class="form-control" name="fecha" id="fecha" value="<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()) %>" disabled="disabled">
	                </div>
                </div>
                
                <div class="row">
                	<div class="col col-md-4 mx-auto">
	            		<button type="submit" class="btn btn-secondary btn-block">Registrar Compra</button>
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