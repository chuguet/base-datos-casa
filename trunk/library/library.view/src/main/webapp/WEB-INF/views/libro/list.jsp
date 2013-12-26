<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script type="text/javascript">
	libro.formatList();
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
	<legend>Listado de Libros</legend>
	<fieldset>
		<legend>Buscador de Libros</legend>
		<div class="buscador">
			<p>
				<label for="titulo">T&iacute;tulo:</label> 
				<input id="titulo" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
				<label for="autores">Autores:</label> 
				<input id="autores" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
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