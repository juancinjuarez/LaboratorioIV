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

Ingrese el DNI del paciente: <input type="text" required name="busquedaDNI">
	<p><input type="submit" name="btnBuscarPaciente" value="Buscar"></input></p>
</form>

<% if(request.getAttribute("DniIncorrecto")!=null) {%>
		<%=request.getAttribute("DniIncorrecto") %>
	<%}%>
</body>
</html>