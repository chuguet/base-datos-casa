<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
	.table{display:inline-block; vertical-align:top; padding-left:35px; padding-right:35px;}
  	textarea{vertical-align: top; display:block;}
  	input{vertical-align: top; display:block;}
  	h2{padding-left:35px;}
</style>

<script type="text/javascript">
	pelicula.formatDetail();
	function showInformationIntoView(pelicula){
		$('h2').text(pelicula.titulo);
		$('input[id=id]').val(pelicula.id);
		$('input[id=titulo]').val(pelicula.titulo);
		$('input[id=director]').val(pelicula.director);
		$('input[id=fechaEstreno]').val(pelicula.fechaEstreno);
		$('input[id=distribuidora]').val(pelicula.distribuidora);
		$('input[id=duracion]').val(pelicula.duracion +" minutos aprox.");
		$('input[id=nacionalidad]').val(pelicula.nacionalidad);
		$('input[id=calificacion]').val(pelicula.calificacion);
		$('input[id=genero]').val(pelicula.genero);
		$('input[id=formato]').val(pelicula.formato);
		$('input[id=interpretes]').val(pelicula.interpretes);
		$('#interpretes').val(pelicula.interpretes);
		$('#sinopsis').val(pelicula.sinopsis);
	};
</script>

<form id="alta">
	<fieldset>
		<legend>Detalle de pel&iacute;cula</legend>
		<h2></h2>
		<div class="table">
			<input type="hidden" id="id" />
			<p>
				<label for="director">Director</label>
				<input id="director" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="fechaEstreno">Fecha estreno</label>
				<input id="fechaEstreno" readonly=true type="textbox" maxlength="3" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="distribuidora">Distribuidora</label>
				<input id="distribuidora" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="duracion">Duraci&oacute;n</label>
				<input id="duracion" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="table">
			<p>
				<label for="nacionalidad">Nacionalidad</label>
				<input id="nacionalidad" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="calificacion">Calificaci&oacute;n</label>
				<input id="calificacion" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="genero">G&eacute;nero</label>
				<input id="genero" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="formato">Formato</label>
				<input id="formato" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="table">
			<p>
				<label for="interpretes">Int&eacute;rpretes</label>
				<textarea id="interpretes" readonly=true cols="50" rows="4" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="sinopsis">Sinopsis</label>
				<textarea id="sinopsis" readonly=true cols="50" rows="8" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="botonera">
			<input type="button" id="btnCancel" value="Volver" />
		</div>
	</fieldset>
</form>