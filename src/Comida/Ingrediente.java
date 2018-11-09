package Comida;

public class Ingrediente {
	//Propiedades
	private String nombre;
	private double precio;
	private double calorias;
	
	//constructores
	public Ingrediente(String nombre,  double precio, double calorias) {
		this.nombre = nombre;
		this.precio = precio;
		this.calorias = calorias;
	}
		
	public Ingrediente() {
			this.nombre = "Sin nombre";
			this.precio = 0;
			this.calorias =0;
	}
	
	public Ingrediente(Ingrediente i) {
		this.nombre = i.nombre;
		this.calorias = i.calorias;
		this.precio = i.precio;
	}
	
	// Getters & Setters
	public String getNombre() {
		return nombre;
	}

	

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	//to string 
	@Override
	public String toString() {
		return  nombre  + ", " + precio + ", " + calorias;
	}


	
	
	
}
