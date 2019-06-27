<%@page import="com.umeni.db.bean.UsuarioBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../metaData.jsp" %>
    <title>UMENI - Reporte de Ventas</title> 
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

	<h2 align="center">Selecciona los filtros de búsqueda</h2>
	<br>
	<section id="formasUsuario">
		
		<div class="container">
			
			<div class="row">
				<div class="col col-md-4 mx-auto">
				
					<form action="../ReporteCompletoServlet">
						<button type="submit" class="btn  btn-secondary btn-block">TODAS las Ventas</button>
					</form>
					
				</div>
			</div>
			
		</div>
		<hr>
		<div class="container">
			
			<form action="../ReporteFiltradoComprasServlet">
				<div class="row">
					<div class="col col-md-4 mx-auto">
						<label for="compraDesde">Fechas Desde</label>
						<input class="form-control" type="date" id="compraDesde" name="compraDesde">
					</div>
					
					<div class="col col-md-4 mx-auto">
						<label for="compraHasta">Fechas Hasta</label>
						<input class="form-control" type="date" id="compraHasta" name="compraHasta">
					</div>
			
					<div class="col col-md-4 mx-auto">
						<label for="nombreProducto">Escribe el id del producto a filtrar</label>
						<input  type="text" class="form-control" name="nombreProducto" id="nombreProducto" onchange="javascript:obtenerPinturaAjax( this.value )"/>
					</div>
				</div>
				
				<div class="row">
					<div class="col col-md-4 mx-auto">
						<button type="submit" class="btn btn-outline-info btn-block">Buscar filtrado</button>
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