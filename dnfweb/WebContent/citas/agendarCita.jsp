<%@page import="com.dnf.db.bean.ServicioBean"%>
<%@page import="com.dnf.db.bean.SucursalBean"%>
<%@page import="com.dnf.db.bean.BarberoBean"%>
<%@page import="com.dnf.db.bean.ClienteBean"%>
<%@page import="com.dnf.db.bean.ArticuloBean"%>
<%@page import="java.util.Date"%>
<%@page import="com.dnf.db.bean.UsuarioBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../metaData.jsp" %>
    <title>DNF - Agendar una Cita</title> 
	<script language="javascript" type="text/javascript" src="/dnfweb/js/validation.js"></script>
	<script language="javascript" type="text/javascript" src="/dnfweb/js/horasDeCita.js"></script>
	
	<script>
	/*
	$(
		    function(){

		        $('#fechaCita').click(function(){
		                  var time = new Date();                
		                  $('#fechaCita').val(time.toLocaleDateString())
		        });

		    }
		);
	*/
	</script>
	
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<jsp:include page="../ObtenerClientesServlet"></jsp:include>
	<jsp:include page="../ObtenerBarberosServlet"></jsp:include>
	<jsp:include page="../ObtenerSucursalesServlet"></jsp:include>
	<jsp:include page="../ObtenerServiciosServlet"></jsp:include>
	<%
			usuarioBean = (UsuarioBean) session.getAttribute("beanUsuario");
			ArrayList< ClienteBean > listaClientes = (ArrayList< ClienteBean >) request.getAttribute( "listaClientes" );
			ArrayList< BarberoBean > listaBarberos = (ArrayList< BarberoBean >) request.getAttribute( "listaBarberos" );
			ArrayList< SucursalBean > listaSucursales = (ArrayList< SucursalBean >) request.getAttribute( "listaSucursales" );
			ArrayList< ServicioBean > listaServicios = (ArrayList< ServicioBean >) request.getAttribute( "listaServicios" );
			
			ArrayList < RolBean > listRolBean = ( ArrayList< RolBean > ) session.getAttribute( "listBeanRol" );
	%>

	<h2 align="center">Favor de llenar los datos del cliente para su cita</h2>
	<br>
	<section id="formasUsuario">
		<div class="container">
			
			<!-- form action="../RealizarCompraServlet" -->
			<form action="../AgendarCitaServlet" method="POST">
				<div class="row">
					<div class="col col-md-4 mx-auto">
						<label for="cita">Cliente:</label>	                    
	                    <select id="idClienteCita" name="idClienteCita" class="form-control">
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
					<div class="col col-md-4 mx-auto" inline="true">
						<label for="fechaCita">Fecha:</label>
	                    <input type="date" class="form-control" name="fechaCita" id="fechaCita" placeholder="---">	                    
					</div>
				</div>
				<div class="row">
					<div class="col col-md-4 mx-auto">
	                    <label for="comentarios">Barbero:</label>
	                    <select id="idBarberoCita" name="idBarberoCita" class="form-control">
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
	                
	                <div class="col col-md-4 mx-auto">
	                    <label for="horaCita">Hora:</label>
	                    <select class="form-control" id="horaCita" name="horaCita" >
	                    </select>
	                </div>
                </div>
                <div class="row">
                	<div class="col col-md-4 mx-auto">
                      <label for="servicios">Tipo de Servicio:</label>
                      <select id="idServicioCita" name="idServicioCita" class="form-control">
		              <%
		                for ( int i=0; i< listaServicios.size() ; i++ ){
		                
		                  int idServicio = listaServicios.get(i).getIdServicio();
		                  String servicio = listaServicios.get(i).getServicio();
		                  String precio = listaServicios.get(i).getPrecio();
		                  String duracion = listaServicios.get(i).getDuracion();
		                
		                %>
		              <option value="<%=idServicio%>"><%=servicio%> - $<%=precio%> : <%=duracion%></option>
		              <%
		                }
		              %>
		            </select>
		            </div>
                
                	<!-- div class="col col-md-4 mx-auto">
	                    <label for="comentarios">Comentarios:</label>
	                    <textarea class="md-textarea form-control" rows="3" name="comentarios" id="comentarios" placeholder="Detalles de la compra"></textarea>
	                </div -->
                </div>
                
                <div class="row">
	                <div class="col col-md-4 mx-auto">
	                    <label for="id_usuario">Usuario:</label>
	                    <label><b><%=usuarioBean.getNombre() %></b></label>
	                    <input type="hidden" class="form-control" name="id_usuario" id="id_usuario" value="<%=usuarioBean.getId_Usuario() %>">
	                </div>

	                <div class="col col-md-4 mx-auto">
	                    <label for="fecha">Fecha de registro de cita:</label>
	                    <input type="text" class="form-control" name="fecha" id="fecha" value="<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()) %>" disabled="disabled">
	                </div>
                </div>
                
                <div class="row">
                	<div class="col col-md-4 mx-auto">
	            		<button type="submit" class="btn btn-secondary btn-block">Registrar Cita</button>
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