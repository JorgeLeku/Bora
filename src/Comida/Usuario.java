package Comida;

public class Usuario {
	private String username, password,nombre,apellidos;
	private int tf;	
	public Usuario() {
		this.username="";
		this.password = "";
		this.nombre = "";
		this.apellidos = "";
		this.tf= 0;
	}
	public Usuario(String username,String contraseña,String nombre, String apellidos, int tf) {
		super();
		this.username = username;
		this.password = contraseña;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tf = tf;
	}

	public Usuario(Usuario u) {
		super();
		this.username = u.username;
		this.password = u.password;
		this.nombre = u.nombre;
		this.apellidos =u.apellidos;
		this.tf = u.tf;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getTf() {
		return tf;
	}
	public void setTf(int tf) {
		this.tf = tf;
	}

//to string modificado para conectar con la BD
	@Override
	public String toString() {
		return  "'" + username + "', '" +password+"', '"+nombre+"', '"+apellidos+"', "+ tf ;
	}
}
