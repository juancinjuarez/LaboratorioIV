package negocioImpl;

import java.util.ArrayList;

import dao.PacienteDao;
import daoImpl.PacienteDaoImpl;
import entidad.Paciente;
import negocio.pacienteNegocio;

public class PacienteNegocioImpl implements pacienteNegocio{

	PacienteDao paci = new PacienteDaoImpl();

	public boolean insert(Paciente paciente) {
		boolean estado = false;
		estado = paci.insert(paciente);
		return estado;
	}

	public boolean update(Paciente paciente, int dni) {
		boolean estado = false;
			estado=paci.update(paciente,dni);
		return estado;
	}
	
	public Paciente buscarPorDNI(int dni)
	{
		Paciente paciente = new Paciente();
		paciente = paci.buscarPorDNI(dni);
		return paciente;
	}

	public ArrayList<Paciente> obtenerPacientes() {
		ArrayList<Paciente> lista = new ArrayList<Paciente>();
		lista = paci.obtenerPacientes();
		return lista;
	}

	public boolean delete(int dni) {
		boolean estado = false;
		estado = paci.delete(dni);
		return estado;
	}
}
