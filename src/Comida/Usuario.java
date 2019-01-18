package Comida;

public class Usuario {
	private int codigo;
	private String username;
	private int tf;	
	
	public Usuario(int codigo, String username, int tf) {
		super();
		this.codigo = codigo;
		this.username = username;
		this.tf = tf;
	}



	public Usuario(Usuario u) {
		super();
		this.codigo = u.codigo;
		this.username = u.username;
		this.tf =u. tf;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
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
		return codigo + ", '" + username + "', " + tf ;
	}

 

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

}
