package negocio;

import java.util.ArrayList;

import entidad.Medico;

public interface medicoNegocio {
	public boolean insert(Medico medico);
	public boolean delete(int dni);
	public boolean update(Medico medico,int dni);
	public ArrayList<Medico> obtenerMedicos();
	public Medico buscarPorDNI(int dni);
}
