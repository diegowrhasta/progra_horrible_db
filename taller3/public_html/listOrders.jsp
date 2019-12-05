<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Órdenes
</title>
</head>
<body>
<table>
<tr>
<td>
<center>Código</center>
</td>
<td>
<center>Nombre (cliente)</center>
</td>
<td>
<center>Fecha de orden</center>
</td>
<td>
<center>Fecha de entrega</center>
</td>
</tr>
<logic:iterate id="tabla" indexId="index" name="ordenes" property="tabla">
<tr>
<td>
<html:text name="tabla" property="codigo" readonly="true" />
</td>
<td>
<html:text name="tabla" property="nombre" readonly="true" />
</td>
<td>
<html:text name="tabla" property="fecha_orden" readonly="true" />
</td>
<td>
<html:text name="tabla" property="fecha_entrega" readonly="true" />
</td>
</tr>
</logic:iterate>
</table>
</body>
</html>
