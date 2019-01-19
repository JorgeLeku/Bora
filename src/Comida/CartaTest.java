package Comida;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartaTest {

	@Test
	public void testCargarCarta() {
		Carta carta = new Carta();
		assertTrue(comprobarConexion());
		
	}
	
	public static boolean comprobarConexion() {
		Connection conn = BD.initBD();
		if(conn == null) {
			return false;
		}else {
			return true;
		}
	}
}

