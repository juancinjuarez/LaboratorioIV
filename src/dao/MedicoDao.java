package dao;

import java.util.ArrayList;

import entidad.Medico;

public interface MedicoDao {
	public boolean insert(Medico paciente);
	public boolean update(Medico medico,int dni);
	public Medico buscarPorDNI(int dni);
	public ArrayList<Medico> obtenerMedicos();
	public boolean delete(int dni);
}
