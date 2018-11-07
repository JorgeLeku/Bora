package Comida;

public class Ingrediente {
	//Propiedades
	private String nombre;
	private double peso;
	private double precio;
	private double calorias;
	
	//Metodos
	public Ingrediente(String nombre, double peso, double precio, double calorias) {
		this.nombre = nombre;
		this.peso = peso;
		this.precio = precio;
		this.calorias = calorias;
	}
		
	public Ingrediente() {
			this.nombre = "Sin nombre";
			this.peso = 0;
			this.precio = 0;
			this.calorias =0;
	}
	
	public Ingrediente(Ingrediente i) {
		this.nombre = i.nombre;
		this.peso = i.peso;
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

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
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
		return  nombre + ", " + peso + ", " + precio + ", " + calorias;
	}


	
	
	
}
