package Comida;

public abstract class Alimentos  {
	protected String nombre;
	protected double precio;
	
	
	public Alimentos() {
	
		this.precio = 0;
		this.nombre = "";
	}
	public Alimentos (Alimentos a ) {
		
		this.precio = a.precio;
		this.nombre = a.nombre;
	}
	public Alimentos( String nombre,double precio ) {
		super();
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

	
	//to string modificado para ayudar en la BD, las comillas las deja colocadas para que los valores entren directamente en la BD
	@Override
	public String toString() {
		return "'" + nombre + "'," + precio ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
