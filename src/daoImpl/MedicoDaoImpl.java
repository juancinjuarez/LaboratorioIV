package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.MedicoDao;
import entidad.Medico;
import entidad.Paciente;

public class MedicoDaoImpl implements MedicoDao{

	private static final String insert = "INSERT INTO medicos (DNI,Nombre,Apellido,Sexo,Nacionalidad,FechaNac,Direccion,Localidad,Provincia,Email,Telefono,Especialidad,Horario,Dia) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM medicos  WHERE Dni = ?";
	private static final String update = "UPDATE medicos set Nombre=?, Apellido=?, Sexo=?, Nacionalidad=?, FechaNac=?, Direccion=?, Localidad=?, Provincia=?, Email=?, Telefono=?, Especialidad=?, Horario=?, Dia=? WHERE DNI = ?";
	private static final String select = "SELECT DNI, Nombre, Apellido, Sexo, Nacionalidad, FechaNac, Direccion, Localidad, Provincia, Email, Telefono, Horario, Dia FROM medicos WHERE DNI=?";
	private static final String selectAll = "SELECT DNI, Nombre, Apellido, Sexo, Nacionalidad, FechaNac, Direccion, Localidad, Provincia, Email, Telefono, Especialidad, Horario, Dia FROM medicos";
	
	@Override
	public boolean insert(Medico medico) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, medico.getDNI());
			statement.setString(2,medico.getNombre());
			statement.setString(3,medico.getApellido());
			statement.setString(4,medico.getSexo());
			statement.setString(5,medico.getNacionalidad());
			statement.setString(6,medico.getFechaNacimiento());
			statement.setString(7,medico.getDireccion());
			statement.setString(8,medico.getLocalidad());
			statement.setString(9,medico.getProvincia());
			statement.setString(10,medico.getCorreoElectronico());
			statement.setInt(11,medico.getTelefono());
			statement.setTime(12, medico.getHorario());
			statement.setDate(13, medico.getDia());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return isInsertExitoso;
	}

	@Override
	public boolean update(Medico medico, int dni) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		
		try 
		{
			statement = conexion.prepareStatement(update);
			
			statement.setString(1, medico.getNombre());
			statement.setString(2, medico.getApellido());
			statement.setString(3, medico.getSexo());
			statement.setString(4, medico.getNacionalidad());
			statement.setString(5, medico.getFechaNacimiento());
			statement.setString(6, medico.getDireccion());
			statement.setString(7, medico.getLocalidad());
			statement.setString(8, medico.getProvincia());
			statement.setString(9, medico.getCorreoElectronico());
			statement.setInt(10, medico.getTelefono());
			statement.setTime(11, medico.getHorario());
			statement.setDate(12, medico.getDia());
			statement.setInt(13,dni);
			
			if(statement.executeUpdate()>0)
			{
				conexion.commit();
				isUpdateExitoso = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isUpdateExitoso;
	}

	@Override
	public Medico buscarPorDNI(int dni) {
		PreparedStatement st;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Medico medi = new Medico();
		ResultSet rs;
		
		try {
			st = conexion.prepareStatement(select);
			st.setInt(1, dni);
			rs = st.executeQuery();
			while(rs.next()) {
				if(rs.getInt("DNI")==dni)
				{	
					medi.setDNI(rs.getInt("DNI"));
					medi.setNombre(rs.getString("Nombre"));
					medi.setApellido(rs.getString("Apellido"));
					medi.setSexo(rs.getString("Sexo"));
					medi.setNacionalidad(rs.getString("Nacionalidad"));
					medi.setFechaNacimiento(rs.getString("FechaNac"));
					medi.setDireccion(rs.getString("Direccion"));
					medi.setLocalidad(rs.getString("Localidad"));
					medi.setProvincia(rs.getString("Provincia"));
					medi.setCorreoElectronico(rs.getString("Email"));
					medi.setTelefono(rs.getInt("Telefono"));
					medi.setEspecialidad(rs.getString("Especialidad"));
					medi.setHorario(rs.getTime("Horario"));
					medi.setDia(rs.getDate("Dia"));
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return medi;
	}

	@Override
	public ArrayList<Medico> obtenerMedicos() {
		PreparedStatement st;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<Medico> listaMedicos = new ArrayList<Medico>();
		ResultSet rs;
		Medico medicosRS = new Medico();
		
		try {
			st = conexion.prepareStatement(selectAll);
			rs = st.executeQuery();
			while(rs.next())
			{
				medicosRS.setDNI(rs.getInt("DNI"));
				medicosRS.setNombre(rs.getString("Nombre"));
				medicosRS.setApellido(rs.getString("Apellido"));
				medicosRS.setSexo(rs.getString("Sexo"));
				medicosRS.setNacionalidad(rs.getString("Nacionalidad"));
				medicosRS.setFechaNacimiento(rs.getString("FechaNac"));
				medicosRS.setDireccion(rs.getString("Direccion"));
				medicosRS.setLocalidad(rs.getString("Localidad"));
				medicosRS.setProvincia(rs.getString("Provincia"));
				medicosRS.setCorreoElectronico(rs.getString("Email"));
				medicosRS.setTelefono(rs.getInt("Telefono"));
				medicosRS.setHorario(rs.getTime("Horario"));
				medicosRS.setDia(rs.getDate("Dia"));
				
				listaMedicos.add(medicosRS);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listaMedicos;
	}

	@Override
	public boolean delete(int dni) {
		PreparedStatement st;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isDeleteExitoso = false;
		
		try {
			st = conexion.prepareStatement(delete);
			st.setInt(1, dni);
			
			if(st.executeUpdate()>0)
			{
				conexion.commit();
				isDeleteExitoso = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isDeleteExitoso;
	}
	
}
