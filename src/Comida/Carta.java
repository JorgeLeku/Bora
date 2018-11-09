package Comida;

import java.util.HashSet;

public class Carta {
	/* Clase carta,
	 * objetivo leer y escribir en la BD   */
	
	public HashSet<Comida> comidas;
	public HashSet<Bebida>bebidas;
	
	public Carta(HashSet<Comida> carta) {
		super();
		this.comidas = carta;
	}
	public Carta(Carta c) {
		super();
		this.comidas = c.comidas;
	}
	public Carta() {
		super();
		this.comidas = new  HashSet<Comida>();
	}


	public HashSet<Comida> getComidas() {
		return comidas;
	}
	public void setComidas(HashSet<Comida> comidas) {
		this.comidas = comidas;
	}
	public HashSet<Bebida> getBebidas() {
		return bebidas;
	}
	public void setBebidas(HashSet<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
	
	//Añadir comida/bebida
	public void addComida(Comida c) {
		this.comidas.add(c);
		
	}
	public void addBebida(Bebida b) {
		this.bebidas.add(b);
	}
	
	
	
	
	//metodos para conectar con la base de datos
	public void cargarCarta() {
		
	}
	
	public void guardarCarta() {
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
