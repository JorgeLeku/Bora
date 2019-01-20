package Comida;

public class Bebida extends Alimentos {
	protected boolean alcoholica;
	public Bebida() {

		this.alcoholica = false;
	}

	public Bebida(Bebida  a) {
		super(a);

		this.alcoholica = a.alcoholica;	
		}

	public Bebida(String nombre, double precio, boolean alcoholica) {
		super(nombre, precio);

		this.alcoholica = alcoholica;
	}



	public boolean isAlcoholica() {
		return alcoholica;
	}

	public void setAlcoholica(boolean alcoholica) {
		this.alcoholica = alcoholica;
	}

	//to string preparado para ayudar con la BD
	@Override
	public String toString() {
		return"'" + nombre + "',  "+ precio +"," + alcoholica 
				 ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
