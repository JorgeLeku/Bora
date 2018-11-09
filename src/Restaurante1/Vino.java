package Restaurante1;

public class Vino extends Bebida{
	
	String tipoVino;
	
	public Vino(double precio, String nombre, double iva, String tipoVino) {
		super(precio, nombre, iva);
		// TODO Auto-generated constructor stub
		this.tipoVino=tipoVino;
	}

	@Override
	boolean isAlcoholic() {
		// TODO Auto-generated method stub
		return true;
	}

}
