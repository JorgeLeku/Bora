package Comida;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Pedido {

	//Propiedades
	private Date fecha;
	private int numTargeta;
	private ArrayList<Comida> productos;
	private double dineroGastado;
	//Metodos
	public Pedido(Date fecha, int ntarjeta, ArrayList<Comida>productos,double dineroGastado) {
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

	public ArrayList<Comida> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Comida> productos) {
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

	
	public double getImporte() {
		return 0;
	}
	
	
	@Override
	public String toString() {
		return "Pedido [fecha=" + fecha + ", numTargeta=" + numTargeta + ", productos=" + productos + ", dineroGastado="
				+ dineroGastado + "]";
	}

	public static void main(String[] args) {
	
	}
	

}
