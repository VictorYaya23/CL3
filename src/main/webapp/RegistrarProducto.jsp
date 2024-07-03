<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRAR PRODUCTO</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center">REGISTRAR PRODUCTO</h1>
<form action="ControladorProducto" method="post"></form>
<table border="2" align="center">

<tr>
<td>Nombre</td>
<td><input type="text" name="nombre"></td>
</tr>


<tr>
<td>Precio</td>
<td><input type="text" name="precio"></td>
</tr>



<tr>
<td>PrecioVen</td>
<td><input type="text" name="precioVen"></td>
</tr>


<tr>
<td>Estado</td>
<td><input type="text" name="estado"></td>
</tr>


<tr>
<td>Descrip</td>
<td><input type="text" name="descrip"></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Registrar Producto"></td>
</tr>


</table>

</body>
</html>