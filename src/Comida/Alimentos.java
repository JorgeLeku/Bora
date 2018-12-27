package Comida;

public abstract class Alimentos  {
	
	
	protected double precio;
	protected String nombre;
	protected int id;
	
	public Alimentos() {
	
		this.precio = 0;
		this.nombre = "";
		this.id = 0;
	}
	public Alimentos (Alimentos a ) {
		
		this.precio = a.precio;
		this.nombre = a.nombre;
		this.id = a.id;
	}
	public Alimentos( double precio, String nombre, int id) {
		super();
	
		this.precio = precio;
		this.nombre = nombre;
		this.id = id ;
	}



	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio >= 0) {
			this.precio = precio;
		}
		this.precio = precio;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
