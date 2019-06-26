<%@page import="java.util.ArrayList"%>
<%@page import="com.umeni.db.bean.RolBean"%>
<%@page import="com.umeni.db.bean.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    
    
    <title>Bienvenido a UMENI!</title>
    
 	<link rel="stylesheet" type="text/css" href="css/estilos.css">
 	<link rel="stylesheet" type="text/css" href="css/inside.css" >
	<link rel="stylesheet" href="css/font-awesome-4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Roboto+Mono&display=swap" rel="stylesheet">

    <%@ include file="bsHead.jsp"%>

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="css/inside.css" type="text/css" > 
</head>
<body>
	<%@ include file="header.jsp" %>
	<section id="centro">
		<div class="container text-center">
			<h1>Bienvenido al Sistema administrativo de Umeni</h1>
			<p class="lead">
				* Revisa las opcines del men� superior de acuerdo a los permisos de tu usuario *
				<br>
				<br>
				<img alt="Umeni Galeria" src="img/logoUmeni.svg" width="530" height="300">
			</p>
		</div>
	</section>
	<hr>
	<%@ include file="jQueryFooter.jsp"%>
	<%@ include file="copyright.jsp"%>
	<hr>
</body>
</html>