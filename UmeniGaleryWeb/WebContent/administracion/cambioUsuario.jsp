<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<%@ include file="../metaData.jsp" %>
	<%@ include file="../jQueryFooter.jsp"%>
	<title>UMENI - Cambios en el Usuario</title>
  </head>

<body>
	<%@ include file="../header.jsp" %>
	<hr>
	<%
		usuarioBean = (UsuarioBean) session.getAttribute("beanUsuario");
		ArrayList< UsuarioBean > listaUsuarios = (ArrayList< UsuarioBean >) session.getAttribute( "listaUsuarios" );
		ArrayList < RolBean > listRolBean = ( ArrayList< RolBean > ) session.getAttribute( "listBeanRol" );
		if( usuarioBean.getNombre().equals( null ) || listRolBean.equals( null ) ) {
			
			out.print("Fuera perro!");
			
		}
		int i;
	%>
	<h2 align="center">Selecciona el email del usuario para modificar</h2>
	<br>
	<section id="formasUsuario">
		<div class="container">
			<form action="#" method="GET">
				<div class="row">
					<div class="col col-md-4 mx-auto">
						<label for="rolIdUsuario">Selecciona el usuario:</label>
						<select id="selectUsuario" name="nombreUsuario" class="form-control">
							<%
								for ( i=0; i< listaUsuarios.size() ; i++ ){
								
									int idUsuario = listaUsuarios.get(i).getId_Usuario();
									String emailUsuario = listaUsuarios.get(i).getEmail();
									String nombreUsuario = listaUsuarios.get(i).getNombre();
								
								%>
							<option value="<%=idUsuario%>"><%=emailUsuario  + " - " +nombreUsuario%></option>
							<%
								}
							%>
						</select>

					</div>
				</div>
			
			</form>
		</div>
		<div class="container" id="formdata">
		                <form action="../CambiaUsuarioServlet" method="post" onsubmit="javascript:return validaNuevoUsuario();">
		                  
		                   <div class="row" hidden>
		                        <div class="col col-md-4 mx-auto">		                            
		                            <input type="text" class="form-control" name="idUsuario" id="idUsuario">
		                        </div>
		                    </div>
		                    <div class="row">
		                        <div class="col col-md-4 mx-auto">
		                            <label for="nombreUsuario">Nombre de Usuario</label>
		                            <input type="text" class="form-control" name="nombreUsuario" id="nombreUsuario"
		                                placeholder="Juan Perez">
		                        </div>
		                    </div>
		                    <div class="row">
		                        <div class="col col-md-4 mx-auto">
		                            <label for="emailUsuario">Email del nuevo Usuario</label>
		                            <input type="email" class="form-control" name="emailUsuario" id="emailUsuario"
		                                placeholder="micorreo@gmail.com">
		                        </div>
		                    </div>
		                    <div class="row">
		                        <div class="col col-md-4 mx-auto">
		                            <label for="passwordUsuario">Password</label>
		                            <input type="password" class="form-control" name="passwordUsuario" id="passwordUsuario" placeholder="123qweASD" readonly="readonly">
		                        </div>
		                    </div>
		                    <div class="row">
		                        <div class="col col-md-4 mx-auto">
		                            <label for="rolIdUsuario">Rol de Usuario</label>
		                            <select id="rolIdUsuario" name="idRol" class="form-control">
		                                <option value="0">- Selecciona -</option>
		                                <% 
									for ( i=0; i< listRolBean.size() ; i++ ){
										
										int id_rol = listRolBean.get( i ).getId_rol();
										String nombreRol = listRolBean.get( i ).getNombre(); 
									%>
		                                <option value="<%= id_rol %>"><%= nombreRol %></option>
		                                <% } %>
		                            </select>
		                        </div>
		                    </div>
		                    <div class="row">
		                        <div class="col col-md-4 mx-auto">
		                            <button type="submit" class="btn btn-outline-info btn-block">Cambiar usuario</button>
		                        </div>
		                    </div>
		                </form>
		            </div>
	</section>
	<script type="text/javascript">
	$( document ).ready(function() {
		$('#formdata').hide();

	});
		$('#selectUsuario').change(function a(b) {
			var str = b;
			console.log(b);
			var host = window.location.origin;
			var url =  host+"/UmeniGaleryWeb/CambiaUsuarioServlet?nombreUsuario=";
			console.log(url);
			$('#selectUsuario option:selected').each(function () {
				$('#formdata').hide();
				var id =this.value;
				$.ajax({
					
			        type: "GET",  
			         url: host+"/UmeniGaleryWeb/CambiaUsuarioServlet?nombreUsuario="+id,
			     timeout: 300000,
			 contentType: "application/json; charset=utf-8",
			     success: success,
			       error: failure
			});

			function failure(response) {
			    alert(response);
			}
			function success(response) {
				$('#idUsuario').val(response.id_usuario);
				$('#nombreUsuario').val(response.nombre);
				$('#emailUsuario').val(response.email );
				$('#passwordUsuario').val( response.password );
				$('#rolIdUsuario').val( response.id_rol ).change();
				$('#formdata').show();
				
				
				
			}
		
			});
			
		});



	</script>


	</section>


	<%@ include file="../jQueryFooter.jsp"%>
	<%@ include file="../regresarPagina.jsp" %>
	<%@ include file="../copyright.jsp"%>
</body>

</html>