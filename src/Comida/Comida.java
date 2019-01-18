package Comida;

public class Comida extends Alimentos {
	
	protected int numeroPlato;
	
	public Comida() {
		this.numeroPlato = 0;
	
	}

	public Comida(Comida a) {
		super(a);
		this.numeroPlato = a.numeroPlato;
	}

	public Comida(int id, String nombre, double precio, int numeroPlato) {
		super(id, nombre, precio);
		this.numeroPlato = numeroPlato;
		// TODO Auto-generated constructor stub
	}

	
	
	public int getNumeroPlato() {
		return numeroPlato;
	}

	public void setNumeroPlato(int numeroPlato) {
		this.numeroPlato = numeroPlato;
	}


	
	//creado para conectar con la BD
	@Override
	public String toString() {
		return id+",'"+ nombre+ "', "+ precio+", " +numeroPlato ; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
