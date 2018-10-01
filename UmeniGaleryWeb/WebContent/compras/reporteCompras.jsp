<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="../js/ajaxFunctions.js"></script>
<title>Revisión de Compras - Umeni</title>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<h1>Selecciona los filtros de búsqueda</h1>
	<form action="ReporteCompletoServlet">
		<input type="submit" value="TODAS las compras" />
	</form>
	<hr>
	<form action="ReporteFiltradoComprasServlet">
		<table>
			<tr>
				<td>
					<label for="compraDesde">Fechas desde - hasta</label>
				</td>
				<td>
					<input type="date" id="compraDesde" name="compraDesde" />
				</td>
				<td>
					<input type="date" id="compraHasta" name="compraHasta" />
				</td>
			</tr>
			<tr>
				<td>
					<label for="">Escribe el id del producto a filtrar</label>
				</td>
				<td colspan="2">
					<input type="text" name="nombreProducto" id="nombreProducto" onchange="javascript:obtenerPinturaAjax( this.value )"/>
				</td>
			</tr>
			<tr>
				<td>
					<div id="notificationDivFather" style="display: none" align="center">
					<div id="notificationDiv">
					</div>
				</div>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="Buscar"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>