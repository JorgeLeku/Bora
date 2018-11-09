package Cositis;

public class Pizza {
	//Propiedades
	private String nombre; 
	private int tamaño; //1individual 2mediana 3grande
	private int masa; //1normal 2fina 3pan
	private Ingrediente[] ingredientes;
	
	//Metodos
	public Pizza(String nombre, int tamaño, int masa, Ingrediente[] ingredientes) {
		this.nombre = nombre;
		this.tamaño = tamaño;
		this.masa = masa;
		this.ingredientes = new Ingrediente [5];
		for (int i = 0; i < ingredientes.length; i++) {
			if (ingredientes [i] != null) {
				this.ingredientes[i] = new Ingrediente(ingredientes[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		Ingrediente[] ingredientesCarbonara = new Ingrediente[5];
		
		ingredientesCarbonara[0] = new Ingrediente("Jamon", 25, 1.77);
		ingredientesCarbonara[1] = new Ingrediente("Nata", 50, 2.7);
		
		Pizza pizzaCarbonara = new Pizza("Carbonara", 1, 1, ingredientesCarbonara);
		
		
	} 
}
