package Comida;

public abstract class Alimentos  {
	
	protected double calorias;
	protected double precio;
	protected String nombre;
	protected int id;
	
	public Alimentos() {
		this.calorias = 0;
		this.precio = 0;
		this.nombre = "";
		this.id = 0;
	}
	public Alimentos (Alimentos a ) {
		this.calorias = a.calorias;
		this.precio = a.precio;
		this.nombre = a.nombre;
		this.id = a.id;
	}
	public Alimentos(double calorias, double precio, String nombre, int id) {
		super();
		this.calorias = calorias;
		this.precio = precio;
		this.nombre = nombre;
		this.id = id ;
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio >= 0) {
			this.precio = precio;
		}
		this.precio = precio;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
