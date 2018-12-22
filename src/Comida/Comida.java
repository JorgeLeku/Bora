package Comida;

import java.util.ArrayList;
import java.util.HashSet;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Comida extends Alimentos {

//Propiedades
	
	private HashSet<String> ingredientes;
	
	
//constructores


	public Comida() {
		super();
		this.ingredientes = new HashSet<String>();
	}
	
	public Comida(int id, String nombre, double precio,  HashSet<String> ingredientes) {
	super( precio, nombre, id);
	this.ingredientes = ingredientes;
}

	public Comida(Comida p) {
	
		this.nombre = p.nombre;
		this.precio = p.precio;
		this.ingredientes = p.ingredientes;

		this.precio = p.precio;
	}

	
	//getters y setters
	public HashSet<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(HashSet<String> ingredientes) {
		this.ingredientes = ingredientes;
	}
	

//to string
	@Override
	public String toString() {
		return id + ", " + nombre + ", " +precio + ", " +ingredientes.toString() ;
	}
	
	public static void main(String[] args) {
		Comida c = new Comida();
		System.out.println(c.getId());
	}

	
}
