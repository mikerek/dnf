<%@page import="com.umeni.db.bean.UsuarioBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../metaData.jsp" %>
	<%@ include file="../jQueryFooter.jsp"%>
    <title>UMENI - Reporte de Compras</title> 
	<script language="javascript" type="text/javascript" src="../js/validation.js"></script>
	<script language="javascript" type="text/javascript" src="../js/jsontables.js"></script>
	<script language="javascript" type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
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
				
					<form action="#" method="GET">
						<button id="todasLasCompras" type="submit" class="btn  btn-secondary btn-block">TODAS las compras</button>
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
		<div class="container" id="dataTable">
	        <table id="table" data-height="460" class="table">
		        <thead>
		            <tr>
		                <th data-field="id_compra">Item ID</th>
		                <th data-field="id_articulo">Item </th>
		                <th data-field="cantidad">Item Qty</th>
		                <th data-field="precio_unitario">Price</th>
		                <th data-field="precio_total">Total Price</th>
		                <th data-field="detalles_compra">Details</th>
		            </tr>
		        </thead>
		    </table>
	    </div>
		
	</section>
	<script type="text/javascript">
	$( document ).ready(function() {
		$('#dataTable').hide();

	});
		$( '#todasLasCompras' ).click( function a( b ) {
			
			var str = b;
			console.log( b );
			var host = window.location.origin;
			var url = host+"/UmeniGaleryWeb/ReporteCompletoServlet"
			console.log( url );
			$.ajax({
					
			        type: "GET",  
			         url: host+"/UmeniGaleryWeb/ReporteCompletoServlet",
			     timeout: 300000,
			 contentType: "application/json; charset=utf-8",
			     success: success,
			       error: failure
			       
			});

			function failure( response ) {
				
			    alert( response );
			    
			}
			function success( response ) {
				
				//var jsonTable = new JSONTable();
				//var tableData = jsonTable.toJSON();
				//tableData.push = response; 
				//jsonTable.fromJSON( tableData );
				$( '#dataTable' ).DataTable();
				
			}
		
		});



	</script>
	
	<hr>
	<%@ include file="../jQueryFooter.jsp"%>
	<%@ include file="../regresarPagina.jsp" %>
	<%@ include file="../copyright.jsp"%>
</body>
</html>