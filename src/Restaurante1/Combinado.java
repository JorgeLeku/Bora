package Restaurante1;

public class Combinado extends Bebida {
		boolean alcohol;
	public Combinado(double precio, String nombre, double iva, boolean alcohol) {
		super(precio, nombre, iva);
		// TODO Auto-generated constructor stub
		this.alcohol=alcohol;
	}

	@Override
	boolean isAlcoholic() {
		// TODO Auto-generated method stub
		return alcohol;
	}
	
}
