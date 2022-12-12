package daoImpl;

import dao.PacienteDao;
import entidad.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class PacienteDaoImpl implements PacienteDao{
	
	private static final String insert = "INSERT INTO pacientes (DNI,Nombre,Apellido,Sexo,Nacionalidad,FechaNac,Direccion,Localidad,Provincia,Email,Telefono) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM pacientes  WHERE Dni = ?";
	private static final String update = "UPDATE pacientes set Nombre=?, Apellido=?, Sexo=?, Nacionalidad=?, FechaNac=?, Direccion=?, Localidad=?, Provincia=?, Email=?, Telefono=? WHERE DNI = ?";
	private static final String select = "SELECT DNI, Nombre, Apellido, Sexo, Nacionalidad, FechaNac, Direccion, Localidad, Provincia, Email, Telefono FROM pacientes WHERE DNI=?";
	private static final String selectAll = "SELECT DNI, Nombre, Apellido, Sexo, Nacionalidad, FechaNac, Direccion, Localidad, Provincia, Email, Telefono FROM pacientes";
	
	@Override
	public boolean insert(Paciente paciente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, paciente.getDNI());
			statement.setString(2,paciente.getNombre());
			statement.setString(3,paciente.getApellido());
			statement.setString(4,paciente.getSexo());
			statement.setString(5,paciente.getNacionalidad());
			statement.setString(6,paciente.getFechaNacimiento());
			statement.setString(7,paciente.getDireccion());
			statement.setString(8,paciente.getLocalidad());
			statement.setString(9,paciente.getProvincia());
			statement.setString(10,paciente.getCorreoElectronico());
			statement.setInt(11,paciente.getTelefono());
			
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
	public boolean update(Paciente paciente,int dni) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		
		try 
		{
			statement = conexion.prepareStatement(update);
			
			statement.setString(1, paciente.getNombre());
			statement.setString(2, paciente.getApellido());
			statement.setString(3, paciente.getSexo());
			statement.setString(4, paciente.getNacionalidad());
			statement.setString(5, paciente.getFechaNacimiento());
			statement.setString(6, paciente.getDireccion());
			statement.setString(7, paciente.getLocalidad());
			statement.setString(8, paciente.getProvincia());
			statement.setString(9, paciente.getCorreoElectronico());
			statement.setInt(10, paciente.getTelefono());
			statement.setInt(11,dni);
			
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
	
	
	public Paciente buscarPorDNI(int dni)
	{
		PreparedStatement st;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Paciente paci = new Paciente();
		ResultSet rs;
		
		try {
			st = conexion.prepareStatement(select);
			st.setInt(1, dni);
			rs = st.executeQuery();
			while(rs.next()) {
				if(rs.getInt("DNI")==dni)
				{	
					paci.setDNI(rs.getInt("DNI"));
					paci.setNombre(rs.getString("Nombre"));
					paci.setApellido(rs.getString("Apellido"));
					paci.setSexo(rs.getString("Sexo"));
					paci.setNacionalidad(rs.getString("Nacionalidad"));
					paci.setFechaNacimiento(rs.getString("FechaNac"));
					paci.setDireccion(rs.getString("Direccion"));
					paci.setLocalidad(rs.getString("Localidad"));
					paci.setProvincia(rs.getString("Provincia"));
					paci.setCorreoElectronico(rs.getString("Email"));
					paci.setTelefono(rs.getInt("Telefono"));
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return paci;
	}

	@Override
	public ArrayList<Paciente> obtenerPacientes()
	{
		PreparedStatement st;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();
		ResultSet rs;
		Paciente pacienteRs = new Paciente();
		
		try {
			st = conexion.prepareStatement(selectAll);
			rs = st.executeQuery();
			while(rs.next())
			{
				pacienteRs.setDNI(rs.getInt("DNI"));
				pacienteRs.setNombre(rs.getString("Nombre"));
				pacienteRs.setApellido(rs.getString("Apellido"));
				pacienteRs.setSexo(rs.getString("Sexo"));
				pacienteRs.setNacionalidad(rs.getString("Nacionalidad"));
				pacienteRs.setFechaNacimiento(rs.getString("FechaNac"));
				pacienteRs.setDireccion(rs.getString("Direccion"));
				pacienteRs.setLocalidad(rs.getString("Localidad"));
				pacienteRs.setProvincia(rs.getString("Provincia"));
				pacienteRs.setCorreoElectronico(rs.getString("Email"));
				pacienteRs.setTelefono(rs.getInt("Telefono"));
				
				listaPaciente.add(pacienteRs);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listaPaciente;
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
