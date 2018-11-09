package Restaurante1;

public class Factura implements Cobrar{
	Producto pedido[];

	public Factura(Producto[] pedido) {
		super();
		this.pedido = pedido;
	}

	public Producto[] getPedido() {
		return pedido;
	}

	public void setPedido(Producto[] pedido) {
		this.pedido = pedido;
	}

	@Override
	public void pagarTarjeta() {
		
		// TODO Auto-generated method stub
		System.out.println("Pedido pagado con tarjeta total " + calcularImporte());
		
	}

	@Override
	public void pagarEfectivo() {
		// TODO Auto-generated method stub
		System.out.println("Pedido pagado con efectivo");
	}
	
	private double calcularImporte () {
		double total=0;
		// Por ejemplo
				for (int i=0; i<pedido.length;i++) {
					total=total + pedido[i].getPrecio();
				}
				return total;
	}
}
