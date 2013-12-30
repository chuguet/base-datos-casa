<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
	<meta name="description" content="Pantalla de acceso al sistema" />
	<title>La Bibliofilmoteca</title>
	
	<link href="resources/imgs/favicon.ico" rel="shortcut icon" type="image/x-icon" />
	
	<link href="resources/css/jquery-ui.min.css" rel="stylesheet" type="text/css" />
	<link href="resources/css/generic.css" rel="stylesheet" type="text/css" />
	<link href="resources/css/jquery.alerts.css" rel="stylesheet" type="text/css">
	
	<script src="resources/js/jquery.min.js" type="text/javascript"></script>
	<script src="resources/js/jquery-ui.min.js" type="text/javascript"></script>
	<script src="resources/js/jquery.alerts.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		function load(){
			<c:if test="${not empty error}">
				jAlert('${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}', 'Error');
			</c:if>
			<c:if test="${noAccess}">
				jAlert('No tiene acceso a la administraci&oacute;n del sistema', 'Acceso prohibido');
			</c:if>
			<c:if test="${errorLogin}">
				jAlert('Usuario o contraseña incorrectos.', 'Error de acceso');
			</c:if>
			$("#submit").button();
			$("#reset").button();
			$("#user").focus();
		}
	</script>
</head>

<body onload="load()" class="web">
	<form name="f" id="f" action="<c:url value='j_spring_security_check' />" method="POST" class="login">
		<div >
			<img src="resources/imgs/login.png">
			<h2>Acceso</h2>
			<span>Usuario:</span>
			<input id="user" type="text" name="j_username" class="text ui-widget-content ui-corner-all" />
			<span>Contrase&ntilde;a:</span>
			<input id="pass" type="password" name="j_password" class="text ui-widget-content ui-corner-all" />
			<input id="submit" type="submit" value="Aceptar" class="btn" />
			<input id="reset" type="reset" value="Cancelar" class="btn" />
		</div>
	</form>
</body>

</html>