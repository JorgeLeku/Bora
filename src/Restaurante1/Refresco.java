package Restaurante1;

public class Refresco extends Bebida {

	public Refresco(double precio, String nombre, double iva) {
		super(precio, nombre, iva);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean isAlcoholic() {
		// TODO Auto-generated method stub
		return false;
	}

}
