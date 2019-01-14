package Comida;

public abstract class Alimentos  {
	protected int id;
	protected String nombre;
	protected double precio;
	
	
	public Alimentos() {
	
		this.precio = 0;
		this.nombre = "";
		this.id = 0;
	}
	public Alimentos (Alimentos a ) {
		
		this.precio = a.precio;
		this.nombre = a.nombre;
		this.id = a.id;
	}
	public Alimentos(int id,  String nombre,double precio ) {
		super();
		this.id = id ;
		this.nombre = nombre;
		this.precio = precio;
		
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

	//to string modificado para ayudar en la BD, las comillas las deja colocadas para que los valores entren directamente en la BD
	@Override
	public String toString() {
		return id + ",'" + nombre + "'," + precio ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
