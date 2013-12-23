<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
	.table{display:inline-block; vertical-align:top;}
  	textarea{vertical-align: top; display:block;}
  	input{vertical-align: top; display:block;} 
</style>
<script type="text/javascript">
	pelicula.formatForm();
	<c:if test="${operacion == 'edit'}">
		function showInformationIntoView(pelicula){
			$('input[id=id]').val(pelicula.id);
			$('input[id=titulo]').val(pelicula.titulo);
			$('input[id=director]').val(pelicula.director);
			$('input[id=genero]').val(pelicula.genero);
			$('input[id=fechaEstreno]').val(pelicula.fechaEstreno);
			$('input[id=interpretes]').val(pelicula.interpretes);
			$('input[id=distribuidora]').val(pelicula.distribuidora);
			$('input[id=formato]').val(pelicula.formato);
			$('input[id=duracion]').val(pelicula.duracion);
			$('#sinopsis').val(pelicula.sinopsis);
		};
	</c:if>
</script>
<form id="alta">
	<fieldset>
		<legend>
		<c:choose>
			<c:when test="${operacion == 'new'}">Alta de Pel&iacute;cula</c:when>
			<c:otherwise>Edici&oacute;n de Pel&iacute;cula</c:otherwise>
		</c:choose>
		</legend>
		<div class="table">
			<input type="hidden" id="id" />
			<p>
				<label for="titulo">T&iacute;tulo</label>
				<input id="titulo" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="director">Director</label>
				<input id="director" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="fechaEstreno">Fecha estreno</label>
				<input id="fechaEstreno" readonly=true type="textbox" maxlength="3" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="distribuidora">Distribuidora</label>
				<input id="distribuidora" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="duracion">Duraci&oacute;n</label>
				<input id="duracion" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="table">
			<p>
				<label for="genero">G&eacute;nero</label>
				<input id="genero" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="formato">Formato</label>
				<input id="formato" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="interpretes">Int&eacute;rpretes</label>
				<textarea id="interpretes" cols="50" rows="7" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="table">
			<p>
				<label for="sinopsis">Sinopsis</label>
				<textarea id="sinopsis" cols="50" rows="14" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
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