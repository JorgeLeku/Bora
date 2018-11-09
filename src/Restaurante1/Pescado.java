package Restaurante1;

public class Pescado extends Producto {
	String tipo_Pescado;
	
	public Pescado(double precio, String nombre, double iva, String tipo_Pescado) {
		super(precio, nombre, iva);
		// TODO Auto-generated constructor stub
		this.tipo_Pescado=tipo_Pescado;
	}

	public String getTipo_Pescado() {
		return tipo_Pescado;
	}

	public void setTipo_Pescado(String tipo_Pescado) {
		this.tipo_Pescado = tipo_Pescado;
	}

	
	
	
}
