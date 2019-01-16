package Comida;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Pedido {

	//Propiedades
	private int cod;
	private Date fechaPedido, fechaEntrega;
	private double dineroGastado;
	private String direccion;
	private ArrayList<Alimentos> productos;
	
	//Metodos

	public Pedido() {
		this.cod =0;
		this.fechaPedido = new Date();
		this.fechaEntrega =new Date();	
		this.productos = null;
		this.dineroGastado = 0;
		this.direccion ="";
	}
	
	public Pedido(int cod, Date fechaPedido, Date fechaEntrega,String direccion ,ArrayList<Alimentos> productos) {
		super();
		this.cod = cod;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.dineroGastado = getImporte();
		this.productos = productos;
		this.direccion = direccion;
	}

	public Pedido(Pedido p) {
		this.fechaEntrega = p.fechaEntrega;
		this.cod = p.cod;
		this.productos = p.productos;
		this.dineroGastado = p.dineroGastado;
		this.direccion = p.direccion;
	}
	
	//G&S

	public int getCod() {
		return cod;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	public ArrayList<Alimentos> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Alimentos> productos) {
		this.productos = productos;
	}

	public double getDineroGastado() {
		return dineroGastado;
	}

	public void setDineroGastado() {
		this.dineroGastado = getImporte();
	}

	/**
	 * Metodo que devuelve el importe del pedido
	 * @return
	 */
	public double getImporte() {
		double importe = 0;
		for (Alimentos seleccionado : productos) {
			importe = importe + seleccionado.getPrecio();
		}
		return importe;
	}
	
	/**
	 * Metodo para anyadir comida o bebida al carrito
	 * @param c Comida que queremos añadir
	 */
	public void addAlCarrito(Alimentos c) {
		this.productos.add(c); //se añade el producto
	}


	public static void main(String[] args) {
	
	}
	//to string modificado para subirlo a la BD.
	@Override
	public String toString() {
		return cod + ", '" + fechaPedido + "', '" + fechaEntrega
				+ "', " + dineroGastado;
	}
	

}
