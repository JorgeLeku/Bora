package Comida;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Testear {
	static Connection conn = BD.initBD();
	@Test
	public void testCargarCarta() {
		Carta carta = new Carta();
		assertTrue(comprobarConexion());
	
	}

	@Test
	public void testUsuarios() {
		Statement st;
		try {
			st = conn.createStatement();
			assertTrue(BD.verificarPersona(st, "leku", "eneko", "usuario"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testFechas() {
		Time fecha = new Time(System.currentTimeMillis());
		Date da = new Date(System.currentTimeMillis());
		System.out.println(da.toString());
		System.out.println(fecha.toString());
	}
	
	
	@Test
	public void testPedido() {
		Carta c = new Carta();
		c.cargarCarta();
		//se carga el pedido
		Pedido p = new Pedido();
		/*p.addAlCarrito(c.entrantes.first());
		p.addAlCarrito(c.primeros.first());
		p.addAlCarrito(c.segundos.first());
		p.addAlCarrito(c.postres.first());
		p.addAlCarrito(c.bebidas.first());
		
		*/
		}
	public static boolean comprobarConexion() {
		
		if(conn == null) {
			return false;
		}else {
			return true;
		}
	}
}

