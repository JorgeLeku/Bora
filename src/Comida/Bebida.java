package Comida;

public class Bebida extends Alimentos {
	protected String descripcion;
	protected int ml;
	protected boolean alcoholica;
	public Bebida() {
		this.descripcion = "";
		this.ml =0;
		this.alcoholica = false;
	}

	public Bebida(Bebida  a) {
		super(a);
		this.descripcion =a.descripcion ;
		this.ml =a.ml;
		this.alcoholica = a.alcoholica;	
		}

	public Bebida(int id, String nombre, double precio,  String descripcion, int mL, boolean alcoholica) {
		super(id, nombre, precio);
		this.descripcion = descripcion;
		this.ml = mL;
		this.alcoholica = alcoholica;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getmL() {
		return ml;
	}

	public void setmL(int mL) {
		this.ml = mL;
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
		return id + ",' " + nombre + "', '" + descripcion + "', " + ml + ", " + alcoholica + ", "
				 + precio;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
