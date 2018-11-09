package Restaurante1;

public abstract class Bebida extends Producto {
	abstract boolean isAlcoholic ();
	public Bebida(double precio, String nombre, double iva) {
		super(precio, nombre, iva);
		// TODO Auto-generated constructor stub
	}

}
