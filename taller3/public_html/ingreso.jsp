<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Bienvenido
</title>
</head>
<body>
<html:form action="/ingreso">
<h2>Código: </h2>
<html:text property="codigo" />
<br>
<h2>Nombre: </h2>
<html:text property="nombre" />
<br><br>
<html:submit />
</html:form>
</body>
</html>
