<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Actualizar
</title>
</head>
<body>
<table>
<tr>
<td>
<center>Código</center>
</td>
<td>
<center>Nombre completo</center>
</td>
<td>
<center>Teléfono</center>
</td>
<td>
<center>Dirección</center>
</td>
</tr>
<html:form action="/actualizar">
<logic:iterate id="tabla" indexId="index" name="clientes" property="tabla">
<tr>
<td>
<html:text name="tabla" property="id" readonly="true" />
</td>
<td>
<html:text name="tabla" property="name" readonly="true" />
</td>
<td>
<html:text name="tabla" property="phone" />
</td>
<td>
<html:text name="tabla" property="address" />
</td>
</tr>
</logic:iterate>
</table>
<html:submit />
</html:form>
</body>
</html>
