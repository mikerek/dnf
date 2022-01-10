function populate(selector) {
    var select = $(selector);
    /*
    var hours, minutes, ampm;
    for (var i = 480; i <= 1200; i += 30) {
        hours = Math.floor(i / 60);
        minutes = i % 30;
        console.log( "Minutos: " + minutes );
        //if ( minutes  )
        if (minutes < 10) {
            minutes = '0' + minutes; // adding leading zero to minutes portion
        }
        //add the value to dropdownlist
        select.append($('<option></option>')
            .attr('value', hours)
            .text(hours + ':' + minutes));
    }
    */
    var hora;
	for (var i = 8 ; i <= 20; i += 1) {
	    for ( var y = 0 ; y < 60; y += 30) {
	        if( y == 0 ) {
	            hora = i + ":00";
	            console.log( hora );
	            select.append($('<option></option>')
	            	.attr('value', hora)
	            	.text(hora));
	        }
	        else {
	            hora = i + ":" + y;
	            select.append($('<option></option>')
	            	.attr('value', hora)
	            	.text(hora));
	        }
	    }
	}
    
}
//Calling the function on pageload
window.onload = function (e) {
    populate('#horaCita');
}