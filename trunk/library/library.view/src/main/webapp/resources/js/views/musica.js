var musica = {
	'rowID' : null,
	'formatList' : function() {
		$("#lista").jqGrid({
			datatype : 'local',
			data : [],
			colNames : [
					"Id", "T&iacute;tulo", "Artista", "Disc&oacute;grafica", "G&eacute;nero", "A&ntilde;o publicaci&oacute;n", "Pa&iacute;s"
			],
			colModel : [
					{
						name : 'id',
						index : 'id',
						width : 0,
						hidden : true
					}, {
						name : 'titulo',
						index : 'titulo',
						width : 40,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					}, {
						name : 'artista',
						index : 'artista',
						width : 25,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					},  {
						name : 'discografica',
						index : 'discografica',
						width : 35,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					},{
						name : 'genero',
						index : 'genero',
						width : 20,
						sorttype : 'string',
						sortable : true,
						align : 'right'
					},{
						name : 'annoPublicacion',
						index : 'annoPublicacion',
						width : 15,
						sorttype : 'string',
						sortable : true,
						align : 'right'
					},{
						name : 'pais',
						index : 'pais',
						width : 15,
						sorttype : 'string',
						sortable : true,
						align : 'right'
					}
			],
			rowNum : 9,
			rowList : [
					3,6,9
			],
			height: "100%",
			pager : '#paginadorLista',
			sortname : 'titulo',
			sortorder : 'asc',
			viewrecords : true,
			rownumbers : false,
			scroll : false,
			onSelectRow : function(rowid, status) {
				$("#btnVerFicha").button("enable");
				$("#btnEditar").button("enable");
				$("#btnEliminar").button("enable");
				musica.rowID = rowid;
			},
			ondblClickRow : function(rowid){
				generic.getDetail('musica', rowid);
			}
		});
		$(window).bind('resize', function() {
			$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
		}).trigger('resize');
		
		/**
		 * *****Configuración de los botones del formulario de musicas **********
		 */
		$("#btnAlta").button().click(function() {
			generic.getForm('musica');
		});
		
		$("#btnEditar").button().click(function() {
			generic.getForm('musica', $('#lista').jqGrid('getRowData', musica.rowID).id);
		});
		$("#btnEditar").button("disable");
		
		$("#btnVerFicha").button().click(function() {
			generic.getDetail('musica', $('#lista').jqGrid('getRowData', musica.rowID).id);
		});
		$("#btnVerFicha").button("disable");

		$("#btnEliminar").button().click(function() {
			generic.delete('musica', $('#lista').jqGrid('getRowData', musica.rowID).id, function() {
				generic.getList('musica');
			});
		});
		$("#btnEliminar").button("disable");
		
		$("#btnReset").button().click(function(){
			$("input[id=titulo]").val("");
			$("input[id=artista]").val("");
			$("input[id=decada]").val("");
			musica.busqueda(null);
		});
	
		generic.get('musica/decadas', null, function(){
			$("#decada").autocomplete({
				source:arguments[0],
				minLength: 0,
				select:function(event, ui){
					musica.busqueda(ui.item.value);
				}
			}).click(function(){
				 $(this).autocomplete('search', "");
			});
		});
		$(".text").keyup(function(){
			musica.busqueda(null);
		});
	},
	'formatForm' : function() {
		$("#btnCancel").button().click(function() {
			generic.getList('musica');
		});

		$("#btnSaveMusica").button().click(function() {
			musica.getParams();
		});
		
		generic.get('musica/paises', null, function(){
			$("#pais").autocomplete({
				source:arguments[0]
			});
		});
	},
	'formatDetail' : function() {
		$("#btnCancel").button().click(function() {
			generic.getList('musica');
		});
	},
	'getParams' : function() {
		var id = ($("#id").val()) ? $("#id").val() : null;
		var titulo = $("input[id=titulo]").val();
		var artista = $("input[id=artista]").val();
		var discografica = $("input[id=discografica]").val();
		var duracion = $("input[id=duracion]").val();
		var genero = $("input[id=genero]").val();
		var pistas = $("input[id=pistas]").val();
		var annoPublicacion = $("input[id=annoPublicacion]").val();
		var pais = $("input[id=pais]").val();
		var errores = '';
		if (titulo == '') {
			errores += '- Debe introducir el t&iacute;tulo<br/>';
		}
		if (artista == '') {
			errores += '- Debe introducir el nombre de el/la artista<br/>';
		}
		if (discografica == '') {
			errores += '- Debe introducir el nombre de la discogr&aacute;fica<br/>';
		}
		if (duracion == '') {
			errores += '- Debe introducir una duraci&oacute;n<br/>';
		}
		if (genero == '') {
			errores += '- Debe introducir el genero<br/>';
		}
		if (pistas == '' || !isNumber(pistas)) {
			errores += '- Debe introducir el n&uacute;mero de pistas con formato num&eacute;rico<br/>';
		}
		if (annoPublicacion == '' || !isNumber(annoPublicacion) || annoPublicacion.length != 4) {
			errores += '- Debe introducir un a&ntilde;o de publicaci&oacute;n de longitud 4 y formato num&eacute;rico<br/>';
		}
		if (pais == '') {
			errores += '- Debe introducir un pais<br/>';
		}
		if (errores != '') {
			jAlert(errores, "Validaci&oacute;n");
		}
		else {
			var data = {
				id : id,
				titulo : titulo,
				artista : artista,
				discografica : discografica,
				duracion : duracion,
				genero : genero,
				pistas : pistas,
				annoPublicacion : annoPublicacion,
				pais : pais
			};
			var entity = (id != null) ? 'musica/' + id : 'musica';
			generic.post(entity, data, function() {
				generic.getList('musica');
			});
		};
	},
	'busqueda' : function (value){
		var titulo = $("input[id=titulo]").val();
		var artista = $("input[id=artista]").val();
		var decada;
		if(value != null){
			decada = value;
		}else{
			decada = $("input[id=decada]").val();
		}
		var data = {
				titulo : titulo,
				artista : artista,
				decada : decada
		};
		generic.get('musica/busqueda',data,generic.showInformation);
	}
};

function isNumber(n) {
	  return !isNaN(parseFloat(n)) && isFinite(n);
}