package Comida;

public class Ingrediente {
	//Propiedades
	private String nombre;
	private double precio;
	
	
	//constructores
	public Ingrediente(String nombre,  double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
		
	public Ingrediente() {
			this.nombre = "Sin nombre";
			this.precio = 0;
			
	}
	
	public Ingrediente(Ingrediente i) {
		this.nombre = i.nombre;
		
		this.precio = i.precio;
	}
	
	// Getters & Setters
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
		this.precio = precio;
	}
	//to string 
	@Override
	public String toString() {
		return  nombre  + ": " + precio ;
	}


	
	
	
}
