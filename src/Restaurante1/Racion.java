package Restaurante1;

public class Racion extends Producto {
		String tamano;
	
		public Racion(double precio, String nombre, double iva, String tamano) {
		super(precio, nombre, iva);
		// TODO Auto-generated constructor stub
		this.tamano=tamano;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	
}
