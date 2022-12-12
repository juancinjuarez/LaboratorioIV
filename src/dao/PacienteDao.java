package dao;

import java.util.ArrayList;

import entidad.Paciente;

public interface PacienteDao {
	public boolean insert(Paciente paciente);
	public boolean update(Paciente paciente,int dni);
	public Paciente buscarPorDNI(int dni);
	public ArrayList<Paciente> obtenerPacientes();
	public boolean delete(int dni);
}
