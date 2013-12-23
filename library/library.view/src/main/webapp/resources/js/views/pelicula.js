var pelicula = {
	'rowID' : null,
	'formatList' : function() {
		
		$("#lista").jqGrid({
			datatype : 'local',
			data : [],
			colNames : [
					"Id", "T&iacute;tulo", "Director", "Distribuidora", "G&eacute;nero", "Calificaci&oacute;n"
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
						name : 'director',
						index : 'director',
						width : 30,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					},  {
						name : 'distribuidora',
						index : 'distribuidora',
						width : 40,
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
						name : 'calificacion',
						index : 'calificacion',
						width : 20,
						sorttype : 'string',
						sortable : true,
						align : 'right'
					}
			],
			rowNum : 6,
			rowList : [
					3,6
			],
			pager : '#paginadorLista',
			sortname : 'titulo',
			sortorder : 'asc',
			viewrecords : true,
			rownumbers : false,
			scroll : false,
			onSelectRow : function(rowid, status) {
				$("#btnEditar").button("enable");
				$("#btnEliminar").button("enable");
				pelicula.rowID = rowid;
			}
		});
		$(window).bind('resize', function() {
			$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
		}).trigger('resize');
		
		/**
		 * *****Configuración de los botones del formulario de
		 * peliculas**********
		 */
		$("#btnAlta").button().click(function() {
			generic.getForm('pelicula');
		});
		$("#btnEditar").button().click(function() {
			generic.getForm('pelicula', $('#lista').jqGrid('getRowData', pelicula.rowID).id);
		});
		$("#btnEditar").button("disable");

		$("#btnEliminar").button().click(function() {
			generic.delete('pelicula', $('#lista').jqGrid('getRowData', pelicula.rowID).id, function() {
				generic.getList('pelicula');
			});
		});
		$("#btnEliminar").button("disable");
	},

	'formatForm' : function() {
		$(window).bind('resize', function() {
			$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
		}).trigger('resize');
		
		$("#btnCancel").button().click(function() {
			generic.getList('pelicula');
		});

		$("#btnSavePelicula").button().click(function() {
			pelicula.getParams();
		});
		
		var datePickerParams = {
                "dateFormat" : 'dd/mm/yy',
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
        		changeYear: true,
        };
		$("#fechaEstreno").datepicker(datePickerParams);
	},
	'getParams' : function() {
		var id = ($("#id").val()) ? $("#id").val() : null;
		var titulo = $("input[id=titulo]").val();
		var director = $("input[id=director]").val();
		var fechaEstreno = $("input[id=fechaEstreno]").val();
		var distribuidora = $("input[id=distribuidora]").val();
		var duracion = $("input[id=duracion]").val();
		var genero = $("input[id=genero]").val();
		var formato = $("input[id=formato]").val();
		var interpretes = $("#interpretes").val();
		var sinopsis = $("#sinopsis").val();
		var errores = '';
		if (titulo == '') {
			errores += '- Debe introducir el t&iacute;tulo<br/>';
		}
		if (director == '') {
			errores += '- Debe introducir el nombre del director<br/>';
		}
		if (fechaEstreno == ''){
			errores += '- Debe introducir la fecha de estreno<br/>';
		}
		if (distribuidora == '') {
			errores += '- Debe introducir la distribuidora de la pel&iacute;cula<br/>';
		}
		if (duracion == '' || !isNumber(duracion)) {
			errores += '- Debe introducir una duraci&oacute;n correcta<br/>';
		}
		if (genero == '') {
			errores += '- Debe introducir el g&eacute;nero de la pel&iacute;cula<br/>';
		}
		if (formato == '') {
			errores += '- Debe introducir un formato de pel&iacute;cula<br/>';
		}
		if (interpretes == '') {
			errores += '- Debe introducir los int&eacute;rpretes de la pel&iacute;cula<br/>';
		}
		if (sinopsis == '') {
			errores += '- Debe introducir la sinopsis de la pel&iacute;cula';
		}
		if (errores != '') {
			jAlert(errores, "Validaci&oacute;n");
		}
		else {
			var data = {
				id : id,
				titulo : titulo,
				director : director,
				fechaEstreno : fechaEstreno,
				distribuidora : distribuidora,
				duracion : duracion,
				genero : genero,
				formato : formato,
				interpretes : interpretes,
				sinopsis : sinopsis
			};
			var entity = (id != null) ? 'pelicula/' + id : 'pelicula';
			generic.post(entity, data, function() {
				generic.getList('pelicula');
			});
		};
	},
	'buscar' : function(nombre, apellidos) {
		var data = {
				titulo : titulo,
				director : director,
				interpretes : interpretes,
				distribuidora : distribuidora,
				genero : genero
			};
			generic.get('pelicula/busqueda',data,generic.showInformation);
	}
};
function isNumber(n) {
	  return !isNaN(parseFloat(n)) && isFinite(n);
}