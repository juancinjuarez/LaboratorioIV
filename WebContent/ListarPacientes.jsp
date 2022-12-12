<%@page import="entidad.Paciente"%>
<%@page import= "java.util.ArrayList"%>

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
	<input type="submit" name="btnMostrarTodosLosPacientes" value="Mostrar pacientes">
</form>
<%
	ArrayList<Paciente> listaPacientes = null;
	if(request.getAttribute("listaPacientes")!=null) 
	{
		listaPacientes =(ArrayList<Paciente>)request.getAttribute("listaPacientes");
		
	}
%>
	<table border="1">

	<tr> 
		<th>DNI </th> 
		<th>Nombre </th> 
		<th>Apellido </th> 
		<th>Sexo </th> 
		<th>Nacionalidad </th> 
		<th>FechaNac </th> 
		<th>Direccion </th> 
		<th>Localidad </th> 
		<th>Provincia </th> 
		<th>Email </th>
		<th>Telefono </th>
	</tr>
	<%	if(listaPacientes!= null)
		for(Paciente paciente : listaPacientes) 
		{%>
	<tr> 
		<form action="ServletPaciente" method="post">
		 <td><%=paciente.getDNI() %></td>
	 	 <td><%=paciente.getNombre() %></td>
	 	 <td><%=paciente.getApellido() %></td> 
	 	 <td><%=paciente.getSexo() %></td> 
	 	 <td><%=paciente.getNacionalidad() %></td> 
	 	 <td><%=paciente.getFechaNacimiento() %></td> 
	 	 <td><%=paciente.getDireccion() %></td> 
	 	 <td><%=paciente.getLocalidad() %></td> 
	 	 <td><%=paciente.getProvincia() %></td> 
	 	 <td><%=paciente.getCorreoElectronico() %></td>
	 	 <td><%=paciente.getTelefono() %></td>
		</form> 
	</tr>
	<%} %>
</table>
</body>
</html>