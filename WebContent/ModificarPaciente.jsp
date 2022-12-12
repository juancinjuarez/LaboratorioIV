<%@page import="entidad.Paciente"%>

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
<legend>Modificar datos del paciente</legend>	
	<table border=1>
		<tr>
			<th>DNI</th>
			<th>NOMBRE</th>
			<th>APELLIDO</th>
			<th>SEXO</th>
			<th>NACIONALIDAD</th>
			<th>FECHA DE NACIMIENTO</th>
			<th>DIRECCION</th>
			<th>LOCALIDAD</th>
			<th>PROVINCIA</th>
			<th>CORREO ELECTRONICO</th>
			<th>TELEFONO</th>
		</tr>
		<tr>
			<%Paciente pacient = (Paciente)request.getAttribute("paci");%>
			<td><%=pacient.getDNI()%><input type="hidden" name="DNIpaciente" value="<%=pacient.getDNI()%>"></td>
			<td><%=pacient.getNombre()%></td>
			<td><%=pacient.getApellido()%></td>
			<td><%=pacient.getSexo()%></td>
			<td><%=pacient.getNacionalidad()%></td>
			<td><%=pacient.getFechaNacimiento()%></td>
			<td><%=pacient.getDireccion()%></td>
			<td><%=pacient.getLocalidad()%></td>
			<td><%=pacient.getProvincia()%></td>
			<td><%=pacient.getCorreoElectronico()%></td>
			<td><%=pacient.getTelefono()%></td>
		</tr>
	</table>
	
	<p>Nombre: <input type="text" placeholder="Ingrese su nombre" required name="Nombre"></input></p>
	<p>Apellido: <input type="text" required placeholder="Ingrese su apellido" name="Apellido"></input></p>
	<p>Sexo: <input type="text" required  name="Sexo"></input></p>
	<p>Nacionalidad: <input type="text" required name="Nacionalidad"></input></p>
	<p>Fecha de nacimiento: <input type="text" required placeholder="Debe ser de la forma dd/mm/aa" name="FechaNac"></input></p>
	<p>Direccion: <input type="text" required name="Direccion"></input></p>
	<p>Localidad: <input type="text" required name="Localidad"></input></p>
	<p>Provincia: <input type="text" required name="Provincia"></input></p>
	<p>Correo Electronico: <input type="email" required name="Email"></input></p>
	<p>Telefono: <input type="tel" required name="Telefono"></input></p>
	<p><input type="submit" name="btnModificarPaciente" value="Modificar"></input></p>
</fieldset>
</form>
</body>
</html>