package Restaurante1;

public class RestauranteP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto producto[]=new Producto [3];
		
		producto [0]= new Entrante(20, "ensalada", 7, false);
		producto [1]= new Entrante (10, "jamon", 7, false);
		producto [2]=new Pescado (30, "merluza", 7, "azul");
		
		Factura factura=new Factura (producto);
		factura.pagarTarjeta();
	}
	
	
}
