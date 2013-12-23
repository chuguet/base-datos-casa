<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
 	textarea{vertical-align: top; display:block;}
 	input{vertical-align: top; display:block;}
 	label{width:100%}
	td {margin-left:140px; vertical-align: top; text-align:center;}
</style>
<script type="text/javascript">
	pelicula.formatForm();
	<c:if test="${operacion == 'edit'}">
		function showInformationIntoView(pelicula){
			$('input[id=id]').val(pelicula.id);
			$('input[id=nombre]').val(pelicula.nombre);
			$('input[id=apellidos]').val(pelicula.apellidos);
			$('input[id=email]').val(pelicula.email);
			$('input[id=fechaNacimiento]').val(pelicula.fechaNacimiento);
			$('input[id=telefono]').val(pelicula.telefono);
			$('input[id=altura]').val(pelicula.altura);
			$('#objetivo').val(pelicula.objetivo);
			$('#enfermedades').val(pelicula.enfermedades);
			$('#costumbres').val(pelicula.costumbres);
		};
	</c:if>
</script>
<form id="alta">
	<fieldset>
		<legend>
		<c:choose>
			<c:when test="${operacion == 'new'}">Alta de Pelicula</c:when>
			<c:otherwise>Edici&oacute;n de Pelicula</c:otherwise>
		</c:choose>
		</legend>
		<table>
			<tr>
				<input type="hidden" id="id" />
				<td>
					<p>
						<label for="nombre">Nombre</label>
						<input id="nombre" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
					</p>
					<p>
						<label for="apellidos">Apellidos</label>
						<input id="apellidos" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
					</p>
					<p>
						<label for="fechaNacimiento">Fecha Nacimiento</label>
						<input id="fechaNacimiento" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
					</p>
					<p>
						<label for="altura">Altura</label>
						<input id="altura" type="textbox" maxlength="3" class="text ui-widget-content ui-corner-all" />
					</p>
					<p>
						<label for="telefono">Telefono</label>
						<input id="telefono" type="textbox" maxlength="9" class="text ui-widget-content ui-corner-all" />
					</p>
					<p>
						<label for="email">Email</label>
						<input id="email" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
					</p>
				</td>
				<td>
					<p>
						<label for="objetivo">Objetivo</label>
						<textarea id="objetivo" cols="50" rows="8" class="text ui-widget-content ui-corner-all" />
					</p>
					<p>
						Patologías, alergias y tratamientos
						<textarea id="enfermedades" cols="50" rows="7" class="text ui-widget-content ui-corner-all" />
					</p>
				</td>
				<td>
					<p>
						<label for="costumbres">Costumbres</label>
						<textarea id="costumbres" cols="50" rows="18" class="text ui-widget-content ui-corner-all" />
					</p>
				</td>
			</tr>
		</table>
		<div class="botonera">
			<c:choose>
				<c:when test="${operacion == 'new'}">
					<input type="button" id="btnSavePelicula" value="Guardar" />
				</c:when>
				<c:otherwise>
					<input type="button" id="btnSavePelicula" value="Modificar" />
				</c:otherwise>
			</c:choose>
			<input type="button" id="btnCancel" value="Cancelar" />
		</div>
	</fieldset>
</form>