/**
 * Forma dedicada a la validacion en totalidad del Login Page
 * @author Miguel Rdz
 * @date 06/03/14
 */
function validaLogin() {
	
	if( validaUsuarioLogin() == true ) {
		
		if( validaPasswordLogin() == true ) {
			
			return true;
		
		}
		else {
			
			return false;
	
		}
	}
	else {
		
		return false;
		
	}
}

/**
* Funcion dedicada a la validacion exclusiva del nombre de usuario en el Login
* @author Miguel Rdz
*/
function validaUsuarioLogin() {
	
	var nombreDeUsuario = document.getElementById( "loginId" ).value;
	if( nombreDeUsuario.length == 0 ) {
		
		alert( "El nombre de usuario NO puede ir VACIO!!" );
		document.getElementById( "nombreUsuario" ).focus();
		return false;
		
	}
	/*
	else if( nombreDeUsuario.length > 15 ) {
		
		alert( "El nombre de usuario NO puede tener una longitud mayor de 15 caracteres!" );
		document.getElementById( "nombreUsuario" ).focus();
		return false;
		
	}
	*/
	else {
		
		var patron = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/; 
		if( nombreDeUsuario.match( patron ) ){
			
			return true;
			
		}
		else {
			
			alert( "Esto no es una direccion de correo electronico!!!" );
			return false;
			
		}
		
	}
}

/**
* Funcion dedicada a la validacion exclusiva del password de usuario en el Login
* @author Miguel Rdz
*/
function validaPasswordLogin() {
	
	var passwordDeUsuario = document.getElementById( "passwordUsuario" ).value;
	if( passwordDeUsuario.length == 0  ) {
		
		alert( "El password de usuario NO puede ir VACIO!!" );
		document.getElementById( "passwordUsuario" ).focus();
		return false;
		
	}
	else if( passwordDeUsuario.length > 15 ) {
		
		alert( "El password de usuario NO puede tener una longitud mayor de 15 caracteres!" );
		document.getElementById( "passwordUsuario" ).focus();
		return false;
		
	}
	else {
		
		return true;
		
	}
}

function validaNuevoUsuario() {
	
	var nombreUsuario = document.getElementById( "nombreUsuario" ).value;
	var passwordUsuario = document.getElementById( "passwordUsuario" ).value;
	var emailUsuario = document.getElementById( "emailUsuario" ).value;
	var rolidUsuario = document.getElementById( "rolIdUsuario" ).value;
	
	if( nombreUsuario.length == 0 ) {
		
		alert( "El nombre de usuario NO puede ir VACIO!!" );
		document.getElementById( "nombreUsuario" ).focus();
		return false;
		
	}
	if( emailUsuario.length > 0 ) {
			
		var patron = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/; 
		if( emailUsuario.match( patron ) ){
			
			if( rolidUsuario == 0 ) {
				
				alert( "El Rol del Usuario tiene que ser seleccionado!" );
				document.getElementById( "rolIdUsuario" ).focus();
				return false;
				
			}
			else {
				
				return true;
				
			}
			
		}
		else {
			
			alert( "Esto no es una direccion de correo electronico!!!" );
			document.getElementById( "emailUsuario" ).focus();
			return false;
			
		}
			
	}
}