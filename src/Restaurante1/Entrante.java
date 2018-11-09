package Restaurante1;

public class Entrante extends Producto{
	
	boolean	tipo;
	
	// Incluir todos los constructores
	public Entrante(double precio, String nombre, double iva, boolean tipo) {
		super(precio, nombre, iva);
		this.tipo=tipo;
		// TODO Auto-generated constructor stub
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	
	
	
}
