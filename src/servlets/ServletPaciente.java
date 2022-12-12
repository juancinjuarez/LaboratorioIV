package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Paciente;
import negocioImpl.PacienteNegocioImpl;

/**
 * Servlet implementation class ServletPaciente
 */
@WebServlet("/ServletPaciente")
public class ServletPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaciente() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		Paciente paciente = new Paciente();
		PacienteNegocioImpl  pacNego = new PacienteNegocioImpl();
		//Agregar Paciente
		if(request.getParameter("btnRegistrarPaciente")!=null)
		{
			paciente.setDNI(Integer.parseInt(request.getParameter("DNI")));
			paciente.setNombre(request.getParameter("Nombre"));
			paciente.setApellido(request.getParameter("Apellido"));
			paciente.setSexo(request.getParameter("Sexo"));
			paciente.setNacionalidad(request.getParameter("Nacionalidad"));
			paciente.setFechaNacimiento(request.getParameter("FechaNac"));
			paciente.setDireccion(request.getParameter("Direccion"));
			paciente.setLocalidad(request.getParameter("Localidad"));
			paciente.setProvincia(request.getParameter("Provincia"));
			paciente.setCorreoElectronico(request.getParameter("Email"));
			paciente.setTelefono(Integer.parseInt(request.getParameter("Telefono")));
			
			pacNego.insert(paciente);
			
			RequestDispatcher rd = request.getRequestDispatcher("/AltaPaciente.jsp");
			rd.forward(request,response);
		}
		
		//Buscar Paciente
		if(request.getParameter("btnBuscarPaciente")!=null)
		{
			paciente = null;
			paciente = pacNego.buscarPorDNI(Integer.parseInt(request.getParameter("busquedaDNI")));
			
			if(paciente.getDNI()>0)
			{
				request.setAttribute("paci", paciente);
				RequestDispatcher rd = request.getRequestDispatcher("/ModificarPaciente.jsp");	
				rd.forward(request, response);
			}
			else
			{
				String resultado = "El DNI no es valido o no existe. Por favor intente nuevamente.";
				request.setAttribute("DniIncorrecto", resultado);
				RequestDispatcher rd = request.getRequestDispatcher("/BuscarPaciente.jsp");
				rd.forward(request, response);
			}
		}
		
		//Modificar paciente
		if(request.getParameter("btnModificarPaciente")!=null)
		{
			int dni = Integer.parseInt(request.getParameter("DNIpaciente"));
			paciente.setNombre(request.getParameter("Nombre"));
			paciente.setApellido(request.getParameter("Apellido"));
			paciente.setSexo(request.getParameter("Sexo"));
			paciente.setNacionalidad(request.getParameter("Nacionalidad"));
			paciente.setFechaNacimiento(request.getParameter("FechaNac"));
			paciente.setDireccion(request.getParameter("Direccion"));
			paciente.setLocalidad(request.getParameter("Localidad"));
			paciente.setProvincia(request.getParameter("Provincia"));
			paciente.setCorreoElectronico(request.getParameter("Email"));
			paciente.setTelefono(Integer.parseInt(request.getParameter("Telefono")));

			pacNego.update(paciente,dni);
				
			RequestDispatcher rd = request.getRequestDispatcher("/Inicio.jsp");
			rd.forward(request, response);	
		}
		
		//Eliminar Paciente
		if(request.getParameter("btnEliminarPacientes")!=null)
		{
			ArrayList<Paciente> lista = pacNego.obtenerPacientes();
			
			request.setAttribute("listaP", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/EliminarPaciente.jsp");
			rd.forward(request, response);
		}
		
		//Eliminar Paciente
		if(request.getParameter("btnEliminar")!=null)
		{
			int dni = Integer.parseInt(request.getParameter("dniPaciente"));
			
			pacNego.delete(dni);
			
			ArrayList<Paciente> lista = pacNego.obtenerPacientes();
			request.setAttribute("listaP", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Inicio.jsp");
			rd.forward(request, response);
		}
		
		//Mostrar Pacientes
		if(request.getParameter("btnMostrarTodosLosPacientes")!=null)
		{
			ArrayList<Paciente> lista = pacNego.obtenerPacientes();
			request.setAttribute("listaPacientes", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarPacientes.jsp");
			rd.forward(request, response);
		}
	}
}
