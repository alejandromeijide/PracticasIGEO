
function anadeRegistro(id) {
	console.log('anadeRegistro>' + id);
	alert('Será redireccionado a un formulario para añadir el registro.');

	if (id != null) {
		location.href = 'crear-cliente?id=' + id; //-> editar 
	} else {
		location.href = 'crear-cliente';
	}
}


function eliminaRegistro(idFila) {
	console.log("eliminaRegistro" + idFila);
	if (!confirm("¿Seguro que quieres eliminar en post?8")) {
		return;
	}

	//$.post("eliminar-cliente/" + idFila);

	$.post("eliminar-cliente/" + idFila)
		.done(function(data) {
			console.log("Data Loaded: " + data);

			if (data == true) {
				var fila = document.getElementById("fila" + idFila);
				fila.parentNode.removeChild(fila);
			}
		});

	//$.get("eliminar-cliente/" + idFila);


	// 	var fila =document.getElementById(idFila);
	//	fila.parentNode.removeChild(fila);

	console.log("Fila eliminada")
}



function init() {
	console.log("init")
}

function ocultarMostrar() {

	if (document.fcontacto.Conocido[1].checked == true) {

		document.getElementById('desdeotro').style.display = 'block';

	} else {

		document.getElementById('desdeotro').style.display = 'none';
	}
}


function myFunction() {
	console.log("myfunction");
	var x = document.getElementById("div1");
	if (x.style.display === "none") {
		x.style.display = "block";
	} else {
		x.style.display = "none";
	}
}