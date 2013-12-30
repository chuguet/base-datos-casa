<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
	.table{display:inline-block; padding-left:35px; padding-right:35px;}
	input.text{vertical-align: top; display:block; width:350px !important;}
</style>

<script type="text/javascript">
	musica.formatForm();
	<c:if test="${operacion == 'edit'}">
		function showInformationIntoView(musica){
			$('input[id=id]').val(musica.id);
			$('input[id=titulo]').val(musica.titulo);
			$('input[id=artista]').val(musica.artista);
			$('input[id=discografica]').val(musica.discografica);
			$('input[id=pistas]').val(musica.pistas);
			$('input[id=duracion]').val(musica.duracion);
			$('input[id=genero]').val(musica.genero);
			$('input[id=annoPublicacion]').val(musica.annoPublicacion);
			$('input[id=pais]').val(musica.pais);
		};
	</c:if>
</script>

<form id="alta">
	<fieldset>
		<legend>
		<c:choose>
			<c:when test="${operacion == 'new'}">Alta de M&uacute;sica</c:when>
			<c:otherwise>Edici&oacute;n de M&uacute;sica</c:otherwise>
		</c:choose>
		</legend>
		<div class="table">
			<input type="hidden" id="id" />
			<p>
				<label for="titulo">T&iacute;tulo:</label>
				<input id="titulo" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="artista">Artista:</label>
				<input id="artista" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="discografica">Discogr&aacute;fica:</label>
				<input id="discografica" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="pistas">Pistas:</label>
				<input id="pistas" type="textbox" maxlength="2" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="table">
			<p>
				<label for="duracion">Duraci&oacute;n:</label>
				<input id="duracion" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="genero">G&eacute;nero:</label>
				<input id="genero" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="annoPublicacion">A&ntilde;o publicaci&oacute;n</label>
				<input id="annoPublicacion" type="textbox" maxlength="4" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="pais">Pa&iacute;s:</label>
				<input id="pais" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="botonera">
			<c:choose>
				<c:when test="${operacion == 'new'}">
					<input type="button" id="btnSaveMusica" value="Guardar" />
				</c:when>
				<c:otherwise>
					<input type="button" id="btnSaveMusica" value="Modificar" />
				</c:otherwise>
			</c:choose>
			<input type="button" id="btnCancel" value="Cancelar" />
		</div>
	</fieldset>
</form>