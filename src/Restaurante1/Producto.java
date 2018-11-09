package Restaurante1;

 public class Producto {
	double Precio;
	String Nombre;
	double Iva;
	
	public Producto(double precio, String nombre, double iva) {
		super();
		Precio = precio;
		Nombre = nombre;
		Iva = iva;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public double getIva() {
		return Iva;
	}

	public void setIva(double iva) {
		Iva = iva;
	}
	
	
	
}
