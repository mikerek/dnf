function sendUserBean() {

	var xhttp = new XMLHttpRequest();
	var URL = "http://localhost:8080/UmeniGaleryServices/api/json/usuario/verifyEmail";
	var JSONObject = "{" + "\"email\" : " + "\""
			+ document.getElementById("loginId").value + "\", "
			+ "\"password\" : " + "\""
			+ document.getElementById("passwordUsuario").value + "\"" 
			+ "}";
	alert( JSONObject );
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			alert( this.responseText );
		}
	};

	xhttp.open("POST", URL, true);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send( JSONObject );

}