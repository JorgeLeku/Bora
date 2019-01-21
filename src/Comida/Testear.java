package Comida;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
			assertTrue(BD.verificarPersona(st, "a", "z", "administrador"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	@Test
//	public void testFechas() {
//		Time fecha = new Time(System.currentTimeMillis());
//		Date da = new Date(System.currentTimeMillis());
//		System.out.println(da.toString());
//		System.out.println(fecha.toString());
//		
//		
//		//usaremos calendar
//		Calendar cal = new GregorianCalendar();
//	System.out.println(cal.get(Calendar.MINUTE));	
//	System.out.println(cal.getTime());
//	System.out.println(cal.get(Calendar.HOUR_OF_DAY));
//	}
	
	@Test
	public void testCodigos() {
		int cod = BD.crearCodigo("pedido");
		assertNotEquals(0, cod);
	}
	

	public static boolean comprobarConexion() {
		
		if(conn == null) {
			return false;
		}else {
			return true;
		}
	}
}

