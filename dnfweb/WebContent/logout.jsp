<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Logout de DNF</title>

	<link rel="stylesheet" type="text/css" href="css/estilos.css">
	<%@ include file="bsHead.jsp"%>
	
</head>
<body>
	<%
		session.invalidate();
	%>
	<section id="logout">
		<div class="alert alert-danger mt-5 mx-5 text-center" role="alert">
			<h4 class="alert-heading">¡Cerraste tu Sesión con éxito!</h4>
		</div>
		<div class="container text-center">
			<p class="logout">
				<a href="/dnfweb/logout.jsp"><i class="fa fa-sign-out fa-2x"
					aria-hidden="true"></i></a>
			</p>
		</div>
		<div class="container text-center">
			<a class="nav-link" href="login.jsp">Regresar al sistema</a></a>
			<p class="mt-5 mb-3 text-muted">DNF Barbería &copy;2021</p>
		</div>
	</section>	 
</body>
</html>