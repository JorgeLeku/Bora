package Comida;

public class Comida extends Alimentos {
	
	private int numeroPlato,tipoImagen;
	
	public Comida() {
		this.numeroPlato = 0;
		this.tipoImagen = 0;
	}

	public Comida(Comida a) {
		super(a);
		this.numeroPlato = a.numeroPlato;
		this.tipoImagen = a.tipoImagen;
	}

	public Comida(int id, String nombre, double precio, int numeroPlato, int tipoImagen) {
		super(id, nombre, precio);
		this.numeroPlato = numeroPlato;
		this.tipoImagen = tipoImagen;
		// TODO Auto-generated constructor stub
	}

	
	
	public int getNumeroPlato() {
		return numeroPlato;
	}

	public void setNumeroPlato(int numeroPlato) {
		this.numeroPlato = numeroPlato;
	}

	public int getTipoImagen() {
		return tipoImagen;
	}

	public void setTipoImagen(int tipoImagen) {
		this.tipoImagen = tipoImagen;
	}

	
	//creado para conectar con la BD
	@Override
	public String toString() {
		return id+",'"+ nombre+ "', "+ precio+", " +numeroPlato+ ", "+tipoImagen ; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
