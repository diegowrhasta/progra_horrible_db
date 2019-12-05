<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
¡Hola de nuevo!
</title>
</head>
<body>
<h2>¡Bienvenido de vuelta, <%=session.getAttribute("nombre")%>!</h2>
<html:form action="/menu">
<html:submit property="boton" value="PRODUCTOS" />
<html:submit property="boton" value="ORDENES" />
<html:submit property="boton" value="ACTUALIZAR DATOS" />
<html:submit property="boton" value="SALIR" />
</html:form>
</body>
</html>
