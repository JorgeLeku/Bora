package Comida;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartaTest {
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
	
	
	public static boolean comprobarConexion() {
		
		if(conn == null) {
			return false;
		}else {
			return true;
		}
	}
}

