package Comida;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Pedido {

	//Propiedades
	private Date fecha;
	private int numTargeta;
	private ArrayList<Alimentos> productos;
	private double dineroGastado;
	//Metodos
	public Pedido(Date fecha, int ntarjeta, ArrayList<Alimentos>productos,double dineroGastado) {
		this.fecha = fecha;
		this.numTargeta = ntarjeta;
		this.productos = productos;
		this.dineroGastado = getImporte();
	}
		
	public Pedido() {
		this.fecha =new Date();
		this.numTargeta =0;
		this.productos = null;
		this.dineroGastado = getImporte();
	}
	
	public Pedido(Pedido p) {
		this.fecha = p.fecha;
		this.numTargeta = p.numTargeta;
		this.productos = p.productos;
		this.dineroGastado = p.dineroGastado;
	}
	
	//G&S
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Alimentos> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Alimentos> productos) {
		this.productos = productos;
	}


	public int getNumTargeta() {
		return numTargeta;
	}

	public void setNumTargeta(int numTargeta) {
		this.numTargeta = numTargeta;
	}

	public double getDineroGastado() {
		return dineroGastado;
	}

	//metodo que devuelte el importe delos productos seleccionados
	public double getImporte() {
		double importe = 0;
		for (Alimentos seleccionado : productos) {
			importe = importe + seleccionado.getPrecio();
		}
		return importe;
	}
	//metodo para añadir comida al pedido
	public void addComida(Comida c) {
		this.productos.add(c); //se añade el producto
		this.dineroGastado = getImporte();
	}
	//metodo para quitar a un producto del pedido
/*	public void deleteComida(Comida c) {
		this.productos.remove(c);
		this.dineroGastado = getImporte();
	}*/   //este metodo borraria todos o solo 1???
	
	//to string 
	@Override
	public String toString() {
		return "Pedido [fecha=" + fecha + ", numTargeta=" + numTargeta + ", productos=" + productos + ", dineroGastado="
				+ dineroGastado + "]";
	}

	public static void main(String[] args) {
	
	}
	

}
