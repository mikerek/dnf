<%@page import="com.umeni.db.bean.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UsuarioBean bean = (UsuarioBean) session.getAttribute( "beanUsuario" );
	String menu = (String) session.getAttribute( "menu" );
%>
<jsp:useBean id="date" class="java.util.Date" />
<p align="right" class="minimo">
	Bienvenido <%=bean.getNombre() %>
	<br>
	Hoy es: <%= new java.text.SimpleDateFormat("dd/mm/yyyy").format(new java.util.Date()) %>
</p>
<hr>