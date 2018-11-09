package Comida;

public class Bebida extends Alimentos {
	private String descripcion;
	private int mL;
	private boolean alcoholica;
	public Bebida() {
		this.descripcion = "";
		this.mL =0;
		this.alcoholica = false;
	}

	public Bebida(Bebida  a) {
		super(a);
		this.descripcion =a.descripcion ;
		this.mL =a.mL;
		this.alcoholica = a.alcoholica;	
		}

	public Bebida(double calorias, double precio, String nombre, int id,String descripcion, int mL, boolean alcoholica) {
		super(calorias, precio, nombre, id);
		this.descripcion = descripcion;
		this.mL = mL;
		this.alcoholica = alcoholica;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getmL() {
		return mL;
	}

	public void setmL(int mL) {
		this.mL = mL;
	}

	public boolean isAlcoholica() {
		return alcoholica;
	}

	public void setAlcoholica(boolean alcoholica) {
		this.alcoholica = alcoholica;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
