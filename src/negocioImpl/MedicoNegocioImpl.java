package negocioImpl;

import java.util.ArrayList;

import dao.MedicoDao;
import daoImpl.MedicoDaoImpl;
import entidad.Medico;
import negocio.medicoNegocio;

public class MedicoNegocioImpl implements medicoNegocio{

	MedicoDao medi = new MedicoDaoImpl();

	public boolean insert(Medico medico) {
		boolean estado = false;
		estado = medi.insert(medico);
		return estado;
	}

	public boolean update(Medico medico, int dni) {
		boolean estado = false;
			estado=medi.update(medico,dni);
		return estado;
	}
	
	public Medico buscarPorDNI(int dni) {
		Medico medico = new Medico();
		medico = medi.buscarPorDNI(dni);
		return medico;
	}
	
	public ArrayList<Medico> obtenerMedicos() {
		ArrayList<Medico> lista = new ArrayList<Medico>();
		lista = medi.obtenerMedicos();
		return lista;
	}

	public boolean delete(int dni) {
		boolean estado = false;
		estado = medi.delete(dni);
		return estado;
	}
}
