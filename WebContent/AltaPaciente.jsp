<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="ServletPaciente">
<fieldset>
<legend>Registro de paciente</legend>
	<p>DNI: <input type="number" required name="DNI"></input></p>
	<p>Nombre: <input type="text" placeholder="Ingrese su nombre" required name="Nombre"></input></p>
	<p>Apellido: <input type="text" required placeholder="Ingrese su apellido" name="Apellido"></input></p>
	<p>Sexo: <input type="text" required name="Sexo"></input></p>
	<p>Nacionalidad: <input type="text" required name="Nacionalidad"></input></p>
	<p>Fecha de nacimiento: <input type="date" required pattern="\d{1,2}/\d{1,2}/\d{2}" placeholder="Debe ser de la forma dd/mm/aaaa" name="FechaNac"></input></p>
	<p>Direccion: <input type="text" required name="Direccion"></input></p>
	<p>Localidad: <input type="text" required name="Localidad"></input></p>
	<p>Provincia: <input type="text" required name="Provincia"></input></p>
	<p>Correo Electronico: <input type="email" required name="Email"></input></p>
	<p>Telefono: <input type="tel" required name="Telefono"></input></p>
	<p><input type="submit" name="btnRegistrarPaciente" value="Registrar"></input></p>
</fieldset>
</form>

</body>
</html>