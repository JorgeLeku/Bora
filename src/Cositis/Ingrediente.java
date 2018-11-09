package Cositis;

public class Ingrediente {
	//Propiedades
	private String nombre;
	private double peso;
	private double precio;
	
	//Metodos
	public Ingrediente(String nombre, double peso, double precio) {
		this.nombre = nombre;
		this.peso = peso;
		this.precio = precio;
	}
		
	public Ingrediente() {
			this.nombre = "Sin nombre";
			this.peso = 0;
			this.precio = 0;
	}
	
	public Ingrediente(Ingrediente i) {
		this.nombre = i.nombre;
		this.peso = i.peso;
		this.precio = i.precio;
	}
	
	// G & S
	public String getNombre() {
		return nombre;
	}

	// setNombre BORRADO, para que nadie pueda cambiarlo

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

	//StoS
	public String toString() {
		return "Ingrediente [nombre=" + nombre + ", peso=" + peso + ", precio=" + precio + "]";
	}
	
	
	
}
