var libro = {
	'rowID' : null,
	'formatList' : function() {
		$("#lista").jqGrid({
			datatype : 'local',
			data : [],
			colNames : [
					"Id", "T&iacute;tulo", "Autore/s", "Materia/s", "Edici&oacute;n", "Precio"
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
						name : 'autores',
						index : 'autores',
						width : 40,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					},  {
						name : 'materias',
						index : 'materias',
						width : 40,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					},{
						name : 'edicion',
						index : 'edicion',
						width : 20,
						sorttype : 'string',
						sortable : true,
						align : 'right'
					},{
						name : 'precio',
						index : 'precio',
						width : 10,
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
				libro.rowID = rowid;
			},
			ondblClickRow : function(rowid){
				generic.getDetail('libro', rowid);
			}
		});
		$(window).bind('resize', function() {
			$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
		}).trigger('resize');
		
		/**
		 * *****Configuración de los botones del formulario de libros **********
		 */
		$("#btnAlta").button().click(function() {
			generic.getForm('libro');
		});
		
		$("#btnEditar").button().click(function() {
			generic.getForm('libro', $('#lista').jqGrid('getRowData', libro.rowID).id);
		});
		$("#btnEditar").button("disable");
		
		$("#btnVerFicha").button().click(function() {
			generic.getDetail('libro', $('#lista').jqGrid('getRowData', libro.rowID).id);
		});
		$("#btnVerFicha").button("disable");

		$("#btnEliminar").button().click(function() {
			generic.delete('libro', $('#lista').jqGrid('getRowData', libro.rowID).id, function() {
				generic.getList('libro');
			});
		});
		$("#btnEliminar").button("disable");
	
		$(".text").keyup(function(){
			var titulo = $("input[id=titulo]").val();
			var autores = $("input[id=autores]").val();
			var data = {
					titulo : titulo,
					autores : autores
			};
			generic.get('libro/busqueda',data,generic.showInformation);
		});
	},
	'formatForm' : function() {
		$("#btnCancel").button().click(function() {
			generic.getList('libro');
		});

		$("#btnSaveLibro").button().click(function() {
			libro.getParams();
		});
		
		var datePickerParams = {
                "dateFormat" : 'mm/yy',
                "yearRange":"-90:+0",
                "dayNamesMin" : [
                                "D", "L", "M", "X", "J", "V", "S"
                ],
                "firstDay" : 1,
                "monthNames" : [
                                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
                ],
                monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
                                  'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        		changeMonth: true,
        		changeYear: true
        };
		$("#fechaEdicion").datepicker(datePickerParams);
		$("#fechaImpresion").datepicker(datePickerParams);
		
		generic.get('libro/lenguajes', null, function(){
			$("#lenguaTraduccion").autocomplete({
				source:arguments[0]
			});
			$("#lenguaPublicacion").autocomplete({
				source:arguments[0]
			});
		});
	},
	'formatDetail' : function() {
		$("#btnCancel").button().click(function() {
			generic.getList('libro');
		});
	},
	'getParams' : function() {
		var id = ($("#id").val()) ? $("#id").val() : null;
		var titulo = $("input[id=titulo]").val();
		var autores = $("input[id=autores]").val();
		var coleccion = $("input[id=coleccion]").val();
		var descripcion = $("input[id=descripcion]").val();
		var edicion = $("input[id=edicion]").val();
		var encuadernacion = $("input[id=encuadernacion]").val();
		var fechaEdicion = $("input[id=fechaEdicion]").val();
		var fechaImpresion = $("input[id=fechaImpresion]").val();
		var isbn10 = $("input[id=isbn10]").val();
		var isbn13 = $("input[id=isbn13]").val();
		var lenguaPublicacion = $("input[id=lenguaPublicacion]").val();
		var lenguaTraduccion = $("input[id=lenguaTraduccion]").val();
		var materias = $("input[id=materias]").val();
		var publicacion = $("input[id=publicacion]").val();
		var precio = $("input[id=precio]").val();
		var errores = '';
		if (titulo == '') {
			errores += '- Debe introducir el t&iacute;tulo<br/>';
		}
		if (autores == '') {
			errores += '- Debe introducir el nombre de el/los autor/es<br/>';
		}
		if (precio != '' && !isNumber(precio)) {
			errores += '- Debe introducir un precio correcto<br/>';
		}
		if (isbn10 != '' && (!isNumber(isbn10) || isbn10.length != 10)) {
			errores += '- Debe introducir un ISBN de longitud 10 y formato num&eacute;rico<br/>';
		}
		if (isbn13 != '' && (!isNumber(isbn13) || isbn13.length != 13)) {
			errores += '- Debe introducir un ISBN de longitud 13 y formato num&eacute;rico<br/>';
		}
		if (errores != '') {
			jAlert(errores, "Validaci&oacute;n");
		}
		else {
			var data = {
				id : id,
				titulo : titulo,
				autores : autores,
				coleccion : coleccion,
				descripcion : descripcion,
				edicion : edicion,
				encuadernacion : encuadernacion,
				fechaEdicion : fechaEdicion,
				fechaImpresion : fechaImpresion,
				isbn10 : isbn10,
				isbn13 : isbn13,
				lenguaPublicacion : lenguaPublicacion,
				lenguaTraduccion : lenguaTraduccion,
				materias : materias,
				publicacion : publicacion,
				precio : precio
			};
			var entity = (id != null) ? 'libro/' + id : 'libro';
			generic.post(entity, data, function() {
				generic.getList('libro');
			});
		};
	}
};

function isNumber(n) {
	  return !isNaN(parseFloat(n)) && isFinite(n);
}