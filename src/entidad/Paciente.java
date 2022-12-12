package entidad;


public class Paciente {
	private int DNI;
	private String nombre;
	private String apellido;
	private String sexo;
	private String nacionalidad;
	private String fechaNacimiento;
	private String direccion;
	private String localidad;
	private String provincia;
	private String correoElectronico;
	private int telefono;
	
	//CONSTRUCTORES
	
	public Paciente()
	{
		
	}
	public Paciente(int DNI, String nombre, String apellido, String sexo, String nacionalidad,
			String fechaNacimiento, String direccion, String localidad, String provincia, String correoElectronico,
			int telefono) {
		super();
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
	}
	
	//GETTERS AND SETTERS
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dni) {
		DNI = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	//Metodo ToString()
	@Override
	public String toString() {
		return "Paciente [DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", nacionalidad=" + nacionalidad + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", provincia=" + provincia + ", correoElectronico=" + correoElectronico
				+ ", telefono=" + telefono + "]";
	}
	
	
}