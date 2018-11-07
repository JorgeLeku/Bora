package Comida;

import java.util.ArrayList;
import java.util.HashSet;

public class Comida {

	//Propiedades
	private int id;
	private String nombre;
	private double precio;
	private HashSet<Ingrediente> ingredientes;
	//Metodos
	public Comida(int id, String nombre, double precio,HashSet<Ingrediente> ingredientes) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.ingredientes = ingredientes;
	}
	
	public Comida() {
		this.id = 0;
		this.nombre = "Sin nombre";
		this.precio = 0;
		this.ingredientes = new HashSet<Ingrediente>();
	}
	
	public Comida(Comida p) {
		this.id = p.id;
		this.nombre = p.nombre;
		this.precio = p.precio;
		this.ingredientes = p.ingredientes;
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

	public HashSet<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(HashSet<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public void setPrecio(double precio) {
		if (precio >= 0) {
			this.precio = precio;
		}
		this.precio = precio;
	}

	@Override
	public String toString() {
		return   id + ", " + nombre + ", " + precio + ", " + ingredientes.toString();
	}


	
}
