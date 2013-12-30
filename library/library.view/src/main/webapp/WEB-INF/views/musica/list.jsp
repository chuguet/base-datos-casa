<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script type="text/javascript">
	musica.formatList();
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

<fieldset id="parent">
	<legend>Listado de M&uacute;sica</legend>
	<fieldset>
		<legend>Buscador de M&uacute;sica</legend>
		<div class="buscador">
			<p>
				<label for="titulo">T&iacute;tulo:</label> 
				<input id="titulo" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
				<label for="artista">Artista:</label> 
				<input id="artista" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
				<label for="decada">D&eacute;cada:</label> 
				<input id="decada" readonly=true type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
				<input id="btnReset" type="button" value="Reset" />
			</p>
		</div>
	</fieldset>
	<div class="botonera">
		<sec:authorize ifAnyGranted="ROLE_ADMIN">
			<input type="button" id="btnAlta" value="Alta" />
			<input type="button" id="btnEditar" value="Editar" />
		</sec:authorize>
		<input type="button" id="btnVerFicha" value="Ver ficha" />
		<sec:authorize ifAnyGranted="ROLE_ADMIN">
			<input type="button" id="btnEliminar" value="Eliminar" />
		</sec:authorize>
	</div>
	<table id="lista"></table>
	<div id=paginadorLista></div>
</fieldset>