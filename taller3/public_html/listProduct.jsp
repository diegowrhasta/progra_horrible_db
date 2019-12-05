<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
PRODUCTOS
</title>
</head>
<body>
<table>
<tr>
<td>
<center>Código</center>
</td>
<td>
<center>Nombre</center>
</td>
<td>
<center>Descripción Corta</center>
</td>
<td>
<center>Precio</center>
</td>
</tr>
<logic:iterate id="tabla" indexId="index" name="productos" property="tabla">
<tr>
<td>
<html:text name="tabla" property="id" readonly="true" />
</td>
<td>
<html:text name="tabla" property="name" readonly="true" />
</td>
<td>
<html:text name="tabla" property="short_desc" readonly="true" />
</td>
<td>
<html:text name="tabla" property="suggested_whlsl_price" readonly="true" />
</td>
</tr>
</logic:iterate>
</table>
</body>
</html>
