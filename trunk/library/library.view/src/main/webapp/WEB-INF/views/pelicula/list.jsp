<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fieldset id="parent">
	<legend>Listado de Pel&iacute;culas</legend>
	<fieldset>
		<legend>Buscador de Pel&iacute;culas</legend>
		<div class="buscador">
			<p>
				<label for="titulo">T&iacute;tulo:</label> 
				<input id="titulo" onkeyup="pelicula.buscar($('input[id=nombre]').val(),$('input[id=apellidos]').val())" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
				<label for="director">Director:</label>
				<input id="director" onkeyup="pelicula.buscar($('input[id=nombre]').val(),$('input[id=apellidos]').val())" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" /> 
				<label for="interpretes">Int&eacute;rpretes:</label>
				<input id="interpretes" onkeyup="pelicula.buscar($('input[id=nombre]').val(),$('input[id=apellidos]').val())" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
				<label for="distribuidora">Distribuidora:</label>
				<input id="distribuidora" onkeyup="pelicula.buscar($('input[id=distribuidora]').val(),$('input[id=apellidos]').val())" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
				<label for="genero">G&eacute;nero:</label>
				<input id="genero" onkeyup="pelicula.buscar($('input[id=genero]').val(),$('input[id=apellidos]').val())" type="textbox" readonly="true" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
	</fieldset>
	<div class="botonera">
		<input type="button" id="btnAlta" value="Alta" />
		<input type="button" id="btnEditar" value="Editar" />
		<input type="button" id="btnEliminar" value="Eliminar" />
	</div>
	<table id="lista"></table>
	<div id=paginadorLista></div>
</fieldset>

<script type="text/javascript">
pelicula.formatList();
function showInformationIntoView(information){
	$("#lista").jqGrid("clearGridData", true).trigger("reloadGrid");
	$("#lista").setGridParam({
		data : information
	}).trigger('reloadGrid');
	$(window).bind('resize', function() {
		$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
	}).trigger('resize');
};
</script>