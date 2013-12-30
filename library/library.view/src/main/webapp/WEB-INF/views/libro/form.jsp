<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
	.table{display:inline-block; padding-left:35px; padding-right:35px;}
	input.text{vertical-align: top; display:block; width:350px !important;}
</style>

<script type="text/javascript">
	libro.formatForm();
	<c:if test="${operacion == 'edit'}">
		function showInformationIntoView(libro){
			$('input[id=id]').val(libro.id);
			$('input[id=titulo]').val(libro.titulo);
			$('input[id=autores]').val(libro.autores);
			$('input[id=coleccion]').val(libro.coleccion);
			$('input[id=descripcion]').val(libro.descripcion);
			$('input[id=edicion]').val(libro.edicion);
			$('input[id=encuadernacion]').val(libro.encuadernacion);
			$('input[id=fechaEdicion]').val(libro.fechaEdicion);
			$('input[id=fechaImpresion]').val(libro.fechaImpresion);
			$('input[id=isbn13]').val(libro.isbn13);
			$('input[id=isbn10]').val(libro.isbn10);
			$('input[id=lenguaPublicacion]').val(libro.lenguaPublicacion);
			$('input[id=lenguaTraduccion]').val(libro.lenguaTraduccion);
			$('input[id=materias]').val(libro.materias);
			$('input[id=publicacion]').val(libro.publicacion);
			$('input[id=precio]').val(libro.precio);
		};
	</c:if>
</script>

<form id="alta">
	<fieldset>
		<legend>
		<c:choose>
			<c:when test="${operacion == 'new'}">Alta de Libro</c:when>
			<c:otherwise>Edici&oacute;n de Libro</c:otherwise>
		</c:choose>
		</legend>
		<div class="table">
			<input type="hidden" id="id" />
			<p>
				<label for="titulo">T&iacute;tulo:</label>
				<input id="titulo" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="autores">Autore/s:</label>
				<input id="autores" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="coleccion">Colecci&oacute;n:</label>
				<input id="coleccion" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="descripcion">Descripci&oacute;n:</label>
				<input id="descripcion" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="edicion">Edici&oacute;n:</label>
				<input id="edicion" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="table">
			<p>
				<label for="encuadernacion">Encuadernaci&oacute;n:</label>
				<input id="encuadernacion" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="fechaEdicion">Fecha edici&oacute;n:</label>
				<input id="fechaEdicion" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="fechaImpresion">Fecha impresi&oacute;n:</label>
				<input id="fechaImpresion" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="isbn13">ISBN 13:</label>
				<input id="isbn13" type="textbox" maxlength="13" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="isbn10">ISBN10:</label>
				<input id="isbn10" type="textbox" maxlength="10" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="table">
			<p>
				Lengua publicaci&oacute;n:
				<input id="lenguaPublicacion" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				Lengua traducci&oacute;n:
				<input id="lenguaTraduccion" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="materias">Materia/s:</label>
				<input id="materias" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="publicacion">Publicaci&oacute;n:</label>
				<input id="publicacion" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="precio">Precio:</label>
				<input id="precio" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="botonera">
			<c:choose>
				<c:when test="${operacion == 'new'}">
					<input type="button" id="btnSaveLibro" value="Guardar" />
				</c:when>
				<c:otherwise>
					<input type="button" id="btnSaveLibro" value="Modificar" />
				</c:otherwise>
			</c:choose>
			<input type="button" id="btnCancel" value="Cancelar" />
		</div>
	</fieldset>
</form>