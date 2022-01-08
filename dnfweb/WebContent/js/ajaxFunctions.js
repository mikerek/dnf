function checkUserAjax(email) {

	var xmlhttp;
	if (window.XMLHttpRequest) {

		xmlhttp = new XMLHttpRequest();

	} else {

		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");

	}
	xmlhttp.onreadystatechange = function() {

		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

			document.getElementById("notificationDivFather").style.display = "";
			document.getElementById("notificationDiv").innerHTML = xmlhttp.responseText;

		}
	}
	xmlhttp.open("GET", "ValidaUsuarioAjaxServlet?loginId=" + email, true);
	xmlhttp.send();
}

function obtenerUsuarios() {

	var xmlhttp;
	if (window.XMLHttpRequest) {

		xmlhttp = new XMLHttpRequest();

	} else {

		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");

	}
	xmlhttp.onreadystatechange = function() {

		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			alert( "Tenemos datos!" );
		}
	}
	xmlhttp.open("GET", "ObtenUsuariosServlet", true);
	xmlhttp.send();

}

function obtenerPinturaAjax( nombrePintura ) {
	
	var xmlhttp;
	if (window.XMLHttpRequest) {

		xmlhttp = new XMLHttpRequest();

	} else {

		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");

	}
	xmlhttp.onreadystatechange = function() {

		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			
			document.getElementById("notificationDivFather").style.display = "";
			document.getElementById("notificationDiv").innerHTML = xmlhttp.responseText;
			
		}
	}
	xmlhttp.open("GET", "ObtenerPinturaAjaxServlet?nombrePintura=" + nombrePintura, true);
	xmlhttp.send();
	
}