<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de clientes.</title>
<link rel="stylesheet" href="resources/css/estilos.css" />
<script type="text/javascript" src="resources/js/proyectobasic.js"></script>
<script src="resources/js/lib/jquery.min.js"></script>


</head>
<body onload="init()">

	<h1 class="feo" id="titulo">Listado Clientes</h1>

	<table id="tablaClientes">
		<tr id="Cabecera">
			<th class="feo">Código</th>
			<th class="feo">Nombre</th>
			<th class="feo">Delegación</th>
			<th class="feo">Provincia</th>
			<th class="feo">Localidad</th>
			<th class="feo">Acciones</th>

			<c:forEach items="${ listaClientes }" var="cliente" varStatus="loop">
		</tr>
		<tr id="fila${cliente.codigo}">
			<td>${ cliente.codigo }</td>
			<td>${ cliente.nombre }</td>
			<td>${ cliente.delegacion }</td>
			<td>${ cliente.provincia }</td>
			<td>${ cliente.localidad }</td>
			<td>
				<button onclick="anadeRegistro(${cliente.id})">Editar Registro</button>
				
				<button onclick="eliminaRegistro(${cliente.id})">Eliminar</button>
			</td>
		</tr>
		<tr id="fila2">

		</tr>
		</c:forEach>
		<!-- loop -->
	</table>
	
	<div id="titulo">    
	<button  onclick="anadeRegistro()" >Añadir Registro </button>
	
	
	    </div>
	

	<!-- 	<!-- comentarios que se ven-->
	<%-- 	<%-- comentarios que no se ven --%>
	<!-- 	******************** -->
	<%-- 	<c:forEach var="i" begin="1" end="5"> --%>
	<%--          Item <c:out value="${i}" /> --%>
	<!-- 		<p> -->
	<%-- 	</c:forEach> --%>
	<!-- 	********************* -->


</body>
</html>