<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>Añadir Cliente</title>
<link rel="stylesheet" href="resources/css/estilos.css"/> 
<script type="text/javascript" src="resources/js/proyectobasic.js"></script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

</head>
<body>
	
	<c:set var="esEdicion" value="false"/>
	${ cliente.id }
	<c:if test="${ cliente.id != null }">
		<c:set var="esEdicion" value="true"/>
	</c:if>
	
	<c:choose>
		<c:when test="${ esEdicion == true }">
			<h1>Editar Cliente</h1>
		</c:when>
		<c:when test="${ esEdicion == false }">
			<h1>Crear Cliente</h1>
		</c:when>
		<c:otherwise>
			NOSE
		</c:otherwise>
	</c:choose>
	

     <form:form method="POST" class="caja" 
          action="/Proyectoweb2/crear-cliente" modelAttribute="cliente" >
          <form:hidden path="id"/>
          
          <div>
          	<form:errors cssClass="formErroresGlobales" element="div" path="*" />
          </div>
          
             <table>
                <tr>
                    <td><form:label path="codigo" >Código</form:label> </td>
                    <td><form:input path="codigo"/></td>
                    <td><form:errors path="codigo" cssClass="msgErrorForm" element="span" /><td>
                </tr>
                <tr>
                    <td><form:label path="nombre">Nombre</form:label></td>
                    <td><form:input path="nombre"/></td>
                    <td><form:errors path="nombre" cssClass="msgErrorForm" element="span" /><td>
                </tr>
                <tr>
                    <td><form:label path="delegacion">Delegación</form:label></td>
                    <td><form:input path="delegacion"/></td>
                    <td><form:errors path="delegacion" cssClass="msgErrorForm" element="span" /><td>
                </tr>
                 <tr>
                    <td><form:label path="provincia">Provincia</form:label></td>
                    <td><form:input path="provincia"/></td>
                    <td><form:errors path="provincia" cssClass="msgErrorForm" element="span" /><td>
                </tr>
                
                 <tr>
                    <td><form:label path="localidad">Localidad</form:label></td>
                    <td><form:input path="localidad"/></td>
                    <td><form:errors path="localidad" cssClass="msgErrorForm" element="span" /><td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
    
 