<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INGRESAR AL SISTEMA</title>
</head>
<body bgcolor="#c5dec9" >
<h1 align="center">INGRESAR AL SISTEMA</h1>
<form action="ControladorUsuario" method="post"></form>
<table border="2" align="center">

<tr>
<td>Nombre</td>
<td><input type="text" name="nombre"></td>
</tr>

<tr>
<td>Contraseña</td>
<td><input type="text" name="contraseña"></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Ingresar"></td>
</tr>


</table>

</body>
</html>