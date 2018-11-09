package Cositis;

public class Producto {

	//Propiedades
	private int id;
	private String nombre;
	private double precio;
	
	//Metodos
	public Producto(int id, String nombre, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public Producto() {
		this.id = 0;
		this.nombre = "Sin nombre";
		this.precio = 0;
	}
	
	public Producto(Producto p) {
		this.id = p.id;
		this.nombre = p.nombre;
		this.precio = p.precio;
	}

	//G&S
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	//StoS
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

	
}
