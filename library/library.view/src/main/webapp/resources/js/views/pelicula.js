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
			generic.getForm('pelicula', $('#lista').jqGrid('getRowData', paciente.rowID).id);
		});
		$("#btnEditar").button("disable");

		$("#btnEliminar").button().click(function() {
			generic.delete('pelicula', $('#lista').jqGrid('getRowData', paciente.rowID).id, function() {
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
			generic.getList('paciente');
		});

		$("#btnSavePelicula").button().click(function() {
			paciente.getParams();
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
		$("#fechaNacimiento").datepicker(datePickerParams);
	},
	'getParams' : function() {
		var id = ($("#id").val()) ? $("#id").val() : null;
		var nombre = $("input[id=nombre]").val();
		var apellidos = $("input[id=apellidos]").val();
		var email = $("input[id=email]").val();
		var telefono = $("input[id=telefono]").val();
		var altura = $("input[id=altura]").val();
		var fechaNacimiento = $("input[id=fechaNacimiento]").val();
		var enfermedades = $("#enfermedades").val();
		var objetivo = $("#objetivo").val();
		var costumbres = $("#costumbres").val();
		var errores = '';
		if (nombre == '') {
			errores += '- Debe introducir el nombre<br/>';
		}
		if (apellidos == '') {
			errores += '- Debe introducir los apellidos<br/>';
		}
		if (!validarEmail(email)){
			errores += '- Debe introducir un correo electronico correcto<br/>';
		}
		if (telefono == '' && telefono.length == 9) {
			errores += '- Debe introducir un telefono correcto<br/>';
		}
		if (altura == '' && altura.length == 3) {
			errores += '- Debe introducir una altura correcta<br/>';
		}
		if (fechaNacimiento == '') {
			errores += '- Debe introducir una fecha';
		}
		if (objetivo == '') {
			errores += '- Debe introducir un objetivo';
		}
		if (enfermedades == '') {
			errores += '- Debe introducir las enfermedades del paciente';
		}
		if (costumbres == '') {
			errores += '- Debe introducir las costumbres del paciente';
		}
		if (errores != '') {
			jAlert(errores, "Validaci&oacute;n");
		}
		else {
			var data = {
				id : id,
				nombre : nombre,
				apellidos : apellidos,
				email : email,
				telefono : telefono,
				altura : altura,
				fechaNacimiento : fechaNacimiento,
				objetivo : objetivo,
				enfermedades : enfermedades,
				costumbres : costumbres
			};
			var entity = (id != null) ? 'paciente/' + id : 'paciente';
			generic.post(entity, data, function() {
				generic.getList('paciente');
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