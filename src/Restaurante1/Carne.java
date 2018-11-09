package Restaurante1;

public class Carne extends Producto{

	String tipoCarne;
	
	public Carne(double precio, String nombre, double iva, String tipoCarne) {
		super(precio, nombre, iva);
		// TODO Auto-generated constructor stub
		this.tipoCarne=tipoCarne;
	}

	public String getTipoCarne() {
		return tipoCarne;
	}

	public void setTipoCarne(String tipoCarne) {
		this.tipoCarne = tipoCarne;
	}
	
	
}
