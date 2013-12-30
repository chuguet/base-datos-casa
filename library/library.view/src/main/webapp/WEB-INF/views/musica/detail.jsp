<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
	.table{display:inline-block; vertical-align:top; padding-left:35px; padding-right:35px;}
	input.text{vertical-align: top; display:block; width:350px !important;}
	h2{padding-left:35px;}
</style>

<script type="text/javascript">
	musica.formatDetail();
	function showInformationIntoView(musica){
		$('input[id=id]').val(musica.id);
		$('h2').text(musica.titulo);
		$('input[id=artista]').val(musica.artista);
		$('input[id=discografica]').val(musica.discografica);
		$('input[id=pistas]').val(musica.pistas);
		$('input[id=duracion]').val(musica.duracion);
		$('input[id=genero]').val(musica.genero);
		$('input[id=annoPublicacion]').val(musica.annoPublicacion);
		$('input[id=pais]').val(musica.pais);
	};
</script>

<form id="alta">
	<fieldset>
		<legend>Ficha de M&uacute;sica</legend>
		<h2></h2>
		<div class="table">
			<input type="hidden" id="id" />
			<p>
				<label for="artista">Artista:</label>
				<input id="artista" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="discografica">Discogr&aacute;fica:</label>
				<input id="discografica" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="pistas">Pistas:</label>
				<input id="pistas" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="duracion">Duraci&oacute;n:</label>
				<input id="duracion" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="table">
			<p>
				<label for="genero">G&eacute;nero:</label>
				<input id="genero" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="annoPublicacion">A&ntilde;o publicaci&oacute;n</label>
				<input id="annoPublicacion" readonly=true type="textbox" maxlength="4" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="pais">Pa&iacute;s:</label>
				<input id="pais" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="botonera">
			<input type="button" id="btnCancel" value="Cancelar" />
		</div>
	</fieldset>
</form>