package Restaurante1;

public class Postre extends Producto {
	
	String tipo_Postre;
	
	public Postre(double precio, String nombre, double iva, String tipo_Postre) {
		super(precio, nombre, iva);
		// TODO Auto-generated constructor stub
		this.tipo_Postre=tipo_Postre;
	}

	public String getTipo_Postre() {
		return tipo_Postre;
	}

	public void setTipo_Postre(String tipo_Postre) {
		this.tipo_Postre = tipo_Postre;
	}

}
