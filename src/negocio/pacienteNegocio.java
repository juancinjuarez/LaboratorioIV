package negocio;

import java.util.ArrayList;

import entidad.Paciente;

public interface pacienteNegocio {
	public boolean insert(Paciente paciente);
	public boolean delete(int dni);
	public boolean update(Paciente paciente,int dni);
	public ArrayList<Paciente> obtenerPacientes();
	public Paciente buscarPorDNI(int dni);
}
