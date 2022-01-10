<%@page import="com.dnf.db.bean.ConsultaCitaBean"%>
<!DOCTYPE html>
<html>
<head>

	<%@ include file="../metaData.jsp" %>
	<title>DNF - Resultados de la Búsqueda de Citas</title>
	<script language="javascript" type="text/javascript" src="../js/validation.js"></script>
	<script language="javascript" type="text/javascript" src="../js/jsontables.js"></script>
	
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<%
		usuarioBean = (UsuarioBean) session.getAttribute("beanUsuario");
		ArrayList < RolBean > listRolBean = ( ArrayList< RolBean > ) session.getAttribute( "listBeanRol" );
		ArrayList < ConsultaCitaBean > listaDeCitas = ( ArrayList < ConsultaCitaBean > ) request.getAttribute( "listaDeCitas" ); 
		
		if( usuarioBean.getNombre().equals( null ) || listRolBean.equals( null ) ) {
			
			out.print("Fuera perro!");
			
		}
	%>
	
	<h2 align="center">Resultados de la búsqueda</h2>
	<br>
	<section id="retultadoBusqueda">
		
		<div class="container">
			<div class="row">
				<div class="container mx-auto px-auto" id="filtroCitas">
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
							<% for ( ConsultaCitaBean beanCita : listaDeCitas ) { %>
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
	</section>
	
	<%@ include file="../jQueryFooter.jsp"%>
	<%@ include file="../regresarPagina.jsp" %>
	<%@ include file="../copyright.jsp"%>
	
</body>
</html>