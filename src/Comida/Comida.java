package Comida;

import java.util.ArrayList;
import java.util.HashSet;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Comida extends Alimentos {

//Propiedades
	
	private HashSet<Ingrediente> ingredientes;
	
	
//constructores


	public Comida() {
		super();
		this.ingredientes = new HashSet<Ingrediente>();
	}
	
	public Comida(int id, String nombre,double calorias, double precio,  HashSet<Ingrediente> ingredientes) {
	super(calorias, precio, nombre, id);
	this.ingredientes = ingredientes;
}

	public Comida(Comida p) {
	
		this.nombre = p.nombre;
		this.precio = p.precio;
		this.ingredientes = p.ingredientes;
		this.calorias = p.calorias;
		this.precio = p.precio;
	}

	
	//getters y setters
	public HashSet<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(HashSet<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}


//to string

	@Override
	public String toString() {
		return "Comida [ingredientes=" + ingredientes + ", calorias=" + calorias + ", precio=" + precio + ", nombre="
				+ nombre + ", id=" + id + "]";
	}

	public static void main(String[] args) {
		Comida c = new Comida();
		System.out.println(c.getId());
	}
}
