<%@page import="com.dnf.db.bean.UsuarioBean"%>
<%@page import="com.dnf.db.bean.CitaBean"%>
<%@page import="com.dnf.db.bean.ServicioBean"%>
<%@page import="com.dnf.db.bean.SucursalBean"%>
<%@page import="com.dnf.db.bean.BarberoBean"%>
<%@page import="com.dnf.db.bean.ClienteBean"%>
<%@page import="com.dnf.db.bean.ArticuloBean"%>
<%@page import="com.dnf.db.bean.ConsultaCitaBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../metaData.jsp" %>
	<%@ include file="../jQueryFooter.jsp"%>
    <title>DNF - Reporte de Citas</title> 
	<script language="javascript" type="text/javascript" src="../js/validation.js"></script>
	<script language="javascript" type="text/javascript" src="../js/jsontables.js"></script>
	<script>
		function mostrarCitasDelMes() {
			
			document.getElementById("citasDelMesDiv").style.display = "inline";
			
		}
		
		function setTipoBusqueda( valor ) {
			
			document.getElementById("tipoBusqueda").value = valor;
			
		}
	</script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<jsp:include page="../ObtenerCitasDelMesServlet"></jsp:include>
	<jsp:include page="../ObtenerClientesServlet"></jsp:include>
	<jsp:include page="../ObtenerBarberosServlet"></jsp:include>
	<jsp:include page="../ObtenerSucursalesServlet"></jsp:include>
	<jsp:include page="../ObtenerServiciosServlet"></jsp:include>
	
	<%
		usuarioBean = (UsuarioBean) session.getAttribute("beanUsuario");
		ArrayList < RolBean > listRolBean = ( ArrayList< RolBean > ) session.getAttribute( "listBeanRol" );
		ArrayList < ConsultaCitaBean > listaDeCitasDelMes = ( ArrayList < ConsultaCitaBean > ) request.getAttribute( "listaDeCitasDelMes" ); 
		ArrayList< ClienteBean > listaClientes = (ArrayList< ClienteBean >) request.getAttribute( "listaClientes" );
		ArrayList< BarberoBean > listaBarberos = (ArrayList< BarberoBean >) request.getAttribute( "listaBarberos" );
		ArrayList< SucursalBean > listaSucursales = (ArrayList< SucursalBean >) request.getAttribute( "listaSucursales" );
		ArrayList< ServicioBean > listaServicios = (ArrayList< ServicioBean >) request.getAttribute( "listaServicios" );
		if( usuarioBean.getNombre().equals( null ) || listRolBean.equals( null ) ) {
			
			out.print("Fuera perro!");
			
		}
	%>

	<h2 align="center">Selecciona los filtros de búsqueda</h2>
	<br>
	<section id="formasUsuario">
		
		<div class="container">
			
			<div class="row mx-auto">
				<div class="container mx-auto">
				
					<form action="#" method="GET">
						<button id="todasLasCompras" type="button" class="btn  btn-secondary btn-block" onclick="mostrarCitasDelMes()">TODAS Las Citas Faltantes</button>
					</form>
					
				</div>
				<div class="container mx-auto px-auto" id="citasDelMesDiv" style="display: none;" >

						<table class="table table-hover table-bordered mx-auto">
							<thead class="thead-dark">
								<tr>
									<th scope="col">Cliente</th>
								    <th scope="col">Día</th>
								    <th scope="col">Hora</th>
								    <th scope="col">Barbero</th>
								    <th scope="col">Tipo de Servicio</th>
								    <th scope="col">Precio</th>
								</tr>
							</thead>
							<% for ( ConsultaCitaBean beanCita : listaDeCitasDelMes ) { %>
							<tr>
								<td><%=beanCita.getNombreCliente() %></td>
								<td><%=beanCita.getDia() %></td>
								<td><%=beanCita.getHora() %></td>
								<td><%=beanCita.getNombreBarbero() %></td>
								<td><%=beanCita.getTipoServicio()%></td>
								<td><%=beanCita.getPrecio()%></td>
							</tr>
							<% } %>
						</table>
					</div>
					
				</div>
		</div>
		<hr>
		<div class="container">
			
			<form action="../ObtenerCitasServlet" method="GET">
			
				<div class="row">
					<div class="col col-md-4 mx-auto">
						<label for="compraDesde">Fecha de Interés:</label>
						<input class="form-control" type="date" id="fechaFiltro" name="fechaFiltro">
						<input type="hidden" id="tipoBusqueda" name="tipoBusqueda"> 
					</div>
				</div>
				<div class="row">
					<div class="col col-md-4 mx-auto">
						<button type="submit" class="btn btn-outline-info btn-block" onclick="setTipoBusqueda(1)">Buscar</button>
					</div>
				</div>
				<hr>
				<div class="row">					
					<div class="col col-md-4 mx-auto">
						<label for="compraHasta">Barbero:</label>
						<select id="idBarberoCita" name="idBarberoCita" class="form-control">
							<option value="-">----</option>
							<%
								for ( int i=0; i< listaBarberos.size() ; i++ ){
								
									int idBarbero = listaBarberos.get(i).getIdBarbero();
									String nombreBarbero = listaBarberos.get(i).getNombre();
								
							%>
								<option value="<%=idBarbero%>"><%=nombreBarbero%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col col-md-4 mx-auto">
						<button type="submit" class="btn btn-outline-info btn-block" onclick="setTipoBusqueda(2)">Buscar</button>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col col-md-4 mx-auto">
						<label for="compraDesde">Fecha de Interés:</label>
						<input class="form-control" type="date" id="fechaFiltro" name="fechaFiltro">
					</div>
					<div class="col col-md-4 mx-auto">
						<label for="cita">Cliente:</label>	                    
	                    <select id="idClienteCita" name="idClienteCita" class="form-control">
	                    	<option value="-">----</option>
							<%
								for ( int i=0; i< listaClientes.size() ; i++ ){
								
									int idCliente = listaClientes.get(i).getIdCliente();
									String nombreCliente = listaClientes.get(i).getNombre();
								
								%>
							<option value="<%=idCliente%>"><%=nombreCliente%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col col-md-4 mx-auto">
						<button type="submit" class="btn btn-outline-info btn-block" onclick="setTipoBusqueda(3)">Buscar</button>
					</div>
				</div>
			</form>
								
		</div>
		
		<div class="container" id="dataTable">
	        <table id="table" data-height="460" class="table">
		        <thead>
		            <tr>
		                <th>Cliente</th>
					    <th>Día</th>
					    <th>Hora</th>
					    <th>Barbero</th>
					    <th>Tipo de Servicio</th>
		            </tr>
		        </thead>
		        <tbody>
		        
		        </tbody>
		    </table>
	    </div>
		
	</section>
	<script type="text/javascript">
	/*
	$( document ).ready(function() {
		$('#dataTable').hide();

	});
		$( '#todasLasCompras' ).click( function a( b ) {
			
			var str = b;
			console.log( b );
			var host = window.location.origin;
			var url = host+"/dnfweb/ReporteCompletoServlet"
			console.log( url );
			$.ajax({
					
			        type: "GET",  
			         url: host+"/dnfweb/ReporteCompletoServlet",
			     timeout: 300000,
			 contentType: "application/json; charset=utf-8",
			     success: success,
			       error: failure
			       
			});

			function failure( response ) {
				
			    alert( response );
			    
			}
			function success( response ) {
				
				//var jsonTable = new JSONTable("#dataTable");
				//var tableData = jsonTable.toJSON();tableData.push( response );
				
				//tableData.push = response; 
				//jsonTable.fromJSON( tableData );
				
				$( '#dataTable' ).DataTable();
				$( '#dataTable' ).show();
				
			}
		
		});
	*/


	</script>
	
	<hr>
	<%@ include file="../jQueryFooter.jsp"%>
	<%@ include file="../regresarPagina.jsp" %>
	<%@ include file="../copyright.jsp"%>
</body>
</html>