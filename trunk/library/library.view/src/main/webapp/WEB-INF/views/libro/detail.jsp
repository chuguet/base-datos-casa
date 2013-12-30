<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
	.table{display:inline-block; vertical-align:top; padding-left:35px; padding-right:35px;}
	input.text{vertical-align: top; display:block; width:350px !important;}
	h2{padding-left:35px;}
</style>

<script type="text/javascript">
	libro.formatDetail();
	function showInformationIntoView(libro){
		$('input[id=id]').val(libro.id);
		$('h2').text(libro.titulo);
		$('input[id=autores]').val(libro.autores);
		$('input[id=coleccion]').val(libro.coleccion);
		$('input[id=descripcion]').val(libro.descripcion);
		$('input[id=edicion]').val(libro.edicion);
		$('input[id=encuadernacion]').val(libro.encuadernacion);
		$('input[id=fechaEdicion]').val(libro.fechaEdicion);
		$('input[id=fechaImpresion]').val(libro.fechaImpresion);
		var isbn13 = libro.isbn13.substring(0,3)+"-"
					+libro.isbn13.substring(3,5)+"-"
					+libro.isbn13.substring(5,8)+"-"
					+libro.isbn13.substring(8,12)+"-"
					+libro.isbn13.substring(12,13);
		$('input[id=isbn13]').val(isbn13);
		var isbn10 = libro.isbn10.substring(0,2)+"-"
					+libro.isbn10.substring(2,5)+"-"
					+libro.isbn10.substring(5,9)+"-"
					+libro.isbn10.substring(9,10);
		$('input[id=isbn10]').val(isbn10);
		$('input[id=lenguaPublicacion]').val(libro.lenguaPublicacion);
		$('input[id=lenguaTraduccion]').val(libro.lenguaTraduccion);
		$('input[id=materias]').val(libro.materias);
		$('input[id=publicacion]').val(libro.publicacion);
		$('input[id=precio]').val(libro.precio+" €");
	};
</script>

<form id="alta">
	<fieldset>
		<legend>Ficha de Libro</legend>
		<h2></h2>
		<div class="table">
			<input type="hidden" id="id" />
			<p>
				<label for="autores">Autore/s:</label>
				<input id="autores" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="coleccion">Colecci&oacute;n:</label>
				<input id="coleccion" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="descripcion">Descripci&oacute;n:</label>
				<input id="descripcion" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="edicion">Edici&oacute;n:</label>
				<input id="edicion" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="encuadernacion">Encuadernaci&oacute;n:</label>
				<input id="encuadernacion" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="table">
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
				<input id="isbn13" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="isbn10">ISBN10:</label>
				<input id="isbn10" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				Lengua publicaci&oacute;n:
				<input id="lenguaPublicacion" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="table">
			<p>
				Lengua traducci&oacute;n:
				<input id="lenguaTraduccion" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="materias">Materia/s:</label>
				<input id="materias" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="publicacion">Publicaci&oacute;n:</label>
				<input id="publicacion" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="precio">Precio:</label>
				<input id="precio" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="botonera">
			<input type="button" id="btnCancel" value="Cancelar" />
		</div>
	</fieldset>
</form>