<%@page import="java.util.ArrayList"%>
<%@page import="com.dnf.db.bean.RolBean"%>
<%@page import="com.dnf.db.bean.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%
		UsuarioBean usuarioBean = (UsuarioBean) session.getAttribute( "beanUsuario" );
		String menu = (String) session.getAttribute( "menu" );
	%>
	<nav class="navbar navbar-dark bg-dark">
	 	<a class="navbar-brand" href="#">Menu de Opciones</a>
	 	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menuBar" aria-controls="menuBar" aria-expanded="false" aria-label="Toggle navigation">
	   		<span class="navbar-toggler-icon"></span>
	  	</button>
	
	  	<div class="collapse navbar-collapse" id="menuBar">
	  		<nav class="navbar-expand-sm">
				<%= menu %>
			</nav>
		</div>
	</nav>
	<hr>
	<jsp:useBean id="date" class="java.util.Date" />
	<p align="right" class="minimo">
		Bienvenido <%=usuarioBean.getNombre() %>
		<br>
		Hoy es: <%= new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()) %>
	</p>
