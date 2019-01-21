      package Comida;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Pedido {

	//Propiedades
	private int cod;
	private Calendar fecha;
	private double dineroGastado;
	private String direccion;
	private ArrayList<Alimentos> productos;
	
	//Metodos
	public Pedido() {
		this.cod =0;
		this.fecha = new GregorianCalendar();
		this.productos = null;
		this.dineroGastado = 0;
		this.direccion ="";
	}
	
	public Pedido(int cod, Calendar fechaPedido, String direccion ,ArrayList<Alimentos> productos) {
		super();
		this.cod = cod;
		this.fecha = fechaPedido;
		this.dineroGastado = getImporte();
		this.productos = productos;
		this.direccion = direccion;
	}

	public Pedido(Pedido p) {
		this.cod = p.cod;
		this.fecha = p.fecha;
		this.productos = p.productos;
		this.dineroGastado = p.dineroGastado;
		this.direccion = p.direccion;
	}
	
	//G&S
	
	public int getCod() {
		return cod;
	}


	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public void setDineroGastado(double dineroGastado) {
		this.dineroGastado = dineroGastado;
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

	public Calendar getFecha() {
		return fecha;
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
	
	/**
	 * inserta un pedido en la Base de datos
	 * @param Coduser codigo del usuario que esta haciendo la transaccion
	 */
	public void insertPedido(String Username) {
		Connection conn = BD.initBD();
		String sentSQL = "";
		try {
	
			Statement st = conn.createStatement();
			BD.Insert(st, this.toString()+ ", "+ Username  , "pedido");//se introduce el pedido con el codigo del usuario
			//unir el pedido a las comidas y bebidas
			/*for (Alimentos seleccionado : productos) {
				if(seleccionado.getClass().equals(Comida.class)) {//es una comida
					if(BD.Select(st, "Cod_p = "+ this.cod+" and nombreComida = "+ seleccionado.nombre, "ContieneC")) {//si ya existia en la BD significa que la cantidad >1
					ResultSet rs = 	st.executeQuery("select cantidad from ContieneC where Cod_p = "+ this.cod+" and nombreComida = "+ seleccionado.nombre );			
					String cant = ""+rs.getInt("cantidad");
					BD.Update(st, "cantidad",cant,  "Cod_p = "+ this.cod+" and nombreComida = "+ seleccionado.nombre, "ContieneC");
					}else {
						 BD.Insert(st, this.cod+", "+seleccionado.nombre, "ContieneC");//si no hay una fila de esto
					}
				}else if(seleccionado.getClass().equals(Bebida.class)){//es una bebida
					if(BD.Select(st, "Cod_p = "+ this.cod+" and nombreBebida = "+ seleccionado.nombre, "ContieneB")) {//si ya existia en la BD significa que la cantidad >1
						ResultSet rs = 	st.executeQuery("select cantidad from ContieneB where Cod_p = "+ this.cod+" and nombreBebida = "+ seleccionado.nombre );			
						String cant = ""+rs.getInt("cantidad");
						BD.Update(st, "cantidad",cant,  "Cod_p = "+ this.cod+" and nombreBebida = "+ seleccionado.nombre, "ContieneB");
						}else {
							 BD.Insert(st, this.cod+", "+seleccionado.nombre, "ContieneB");//si no hay una fila de esto
						}
				}				
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	//to string modificado para subirlo a la BD.
	@Override
	public String toString() {

		return cod + ", '" +  fecha.get(Calendar.DAY_OF_MONTH)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.YEAR)+ "', '"+fecha.get(Calendar.HOUR_OF_DAY)+":"+fecha.get(Calendar.MINUTE)+"', '" + direccion +"', '" + productos.get(0).getNombre()+"', '"+productos.get(1).getNombre()+"', '"+productos.get(2).getNombre()+"', '"

				+ productos.get(3).getNombre()+"', '" +productos.get(4).getNombre()+"'";

				


	}

	public static void main(String[] args) {
	
	}

}
