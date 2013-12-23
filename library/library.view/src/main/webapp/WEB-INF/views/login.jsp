<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Nutricional Coach Tracing</title>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="description" content="Pantalla de acceso al sistema" />

<link href="resources/css/login.css" rel="stylesheet" type="text/css" />
<link href="resources/css/jquery.alerts.css" rel="stylesheet" type="text/css">

<script src="resources/js/jquery.alerts.js" type="text/javascript"></script>

<script type="text/javascript">
	<c:if test="${not empty error}">;
	jAlert('${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}', 'Error');
	</c:if>;
	<c:if test="${noAccess}">;
	jAlert('No tiene acceso a la administraci&oacute;n del sistema',
			'Acceso prohibido');
	</c:if>;
</script>

</head>
<body onload='document.f.j_username.focus();'>

	<form name='login' id='login' action="<c:url value='j_spring_security_check' />" method='POST'>
	
	    <h1 id="ff-proof" class="ribbon">Nutricional Coach &nbsp;&nbsp;</h1>
	
	    <fieldset id="inputs">
	
	        <input name='j_username' id="username" type="text" onblur="if(this.value==&#39;&#39;)this.value=&#39;Usuario&#39;;" onfocus="if(this.value==&#39;Usuario&#39;)this.value=&#39;&#39;;" value="Usuario">
	
	        <input name="j_password" id="password" type="text" onblur="if(this.value==&#39;&#39;)this.value=&#39;Contraseña&#39;;" onfocus="if(this.value==&#39;Contraseña&#39;)this.value=&#39;&#39;;" value="Contraseña">
	
	    </fieldset>
	
	    <fieldset id="actions">
	
	        <input type="submit" id="submit" value="Entrar">
	
	       <p class="option"><a href="http://www.freshdesignweb.com/wp-content/uploads/downloads/2012/12/apple-dev-login.html#">Recuperar Contraseña</a>&nbsp;&nbsp;|<a href="http://www.freshdesignweb.com/wp-content/uploads/downloads/2012/12/apple-dev-login.html#">Registrarse</a></p>
	
	    </fieldset>
	
	</form>

</body>

</html>