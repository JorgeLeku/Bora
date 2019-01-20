package Comida;

import static org.junit.Assert.*;

import java.sql.Connection;


import org.junit.Test;

public class CartaTest {

	@Test
	public void testCargarCarta() {
		@SuppressWarnings("unused")
		Carta carta = new Carta();
		assertTrue(comprobarConexion());
		
	}
	//s
	public static boolean comprobarConexion() {
		Connection conn = BD.initBD();
		if(conn == null) {
			return false;
		}else {
			return true;
		}
	}
}

