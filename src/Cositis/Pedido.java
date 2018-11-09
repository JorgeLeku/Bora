package Cositis;

import java.util.Arrays;

public class Pedido {

	//Propiedades
	private String fecha;
	private String ntarjeta;
	private Producto[] productos;
	
	//Metodos
	public Pedido(String fecha, String ntarjeta, Producto[] productos) {
		this.fecha = fecha;
		this.ntarjeta = ntarjeta;
		this.productos = productos;
	}
		
	public Pedido() {
		this.fecha = "Sin fecha";
		this.ntarjeta = "Sin ntarjeta";
		this.productos = null;
	}
	
	public Pedido(Pedido p) {
		this.fecha = p.fecha;
		this.ntarjeta = p.ntarjeta;
		this.productos = p.productos;
	}
	
	//G&S
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNtarjeta() {
		return ntarjeta;
	}

	public void setNtarjeta(String ntarjeta) {
		this.ntarjeta = ntarjeta;
	}

	public Producto[] getProductos() {
		return productos;
	}

	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}

	//StoS
	public String toString() {
		return "Pedido [fecha=" + fecha + ", ntarjeta=" + ntarjeta + ", productos=" + Arrays.toString(productos) + "]";
	}

	public double getImporte() {
		double resultado = 0;
		
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] != null)
				resultado = resultado + productos[i].getPrecio();
		}
		return resultado;
	}
	
	
	public static void main(String[] args) {
		Producto[] prods; 
		Pedido mipedido;
		
		prods = new Producto[10];
		
		prods[0] = new Producto(1, "Tomate", 1.35);
		
		
		mipedido = new Pedido();
		mipedido.setNtarjeta("4502 1233 4353 7899");
		mipedido.setProductos(prods);
		
		System.out.println(mipedido.getImporte());
	}
	

}
