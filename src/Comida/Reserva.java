package Comida;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Reserva {
	private String username;
	Calendar fecha;
	private String entrante,primero,segundo,postre,bebida;
	public Reserva() {
		this.username ="";
		this.fecha = new GregorianCalendar();
		this.entrante = "";
		this.primero  = "";
		this.segundo  = "";
		this.postre   = "";
		this.bebida   = "";
	}
	public Reserva(String username, Calendar fecha, Time hora, String entrante, String primero, String segundo,
			String postre, String bebida) {
		super();
		this.username = username;
		this.fecha = fecha;
		this.entrante = entrante;
		this.primero = primero;
		this.segundo = segundo;
		this.postre = postre;
		this.bebida = bebida;
	}
	public Reserva(Reserva r) {
		super();
		this.username = r.username;
		this.fecha = r.fecha;
		this.entrante = r.entrante;
		this.primero = r.primero;
		this.segundo = r.segundo;
		this.postre = r.postre;
		this.bebida = r.bebida;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Calendar getFecha() {
		return fecha;
	}
	
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	
	public String getEntrante() {
		return entrante;
	}
	public void setEntrante(String entrante) {
		this.entrante = entrante;
	}
	public String getPrimero() {
		return primero;
	}
	public void setPrimero(String primero) {
		this.primero = primero;
	}
	public String getSegundo() {
		return segundo;
	}
	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}
	public String getPostre() {
		return postre;
	}
	public void setPostre(String postre) {
		this.postre = postre;
	}
	public String getBebida() {
		return bebida;
	}
	public void setBebida(String bebida) {
		this.bebida = bebida;
	}
	@Override
	public String toString() {
		return  username + ",'" + fecha.get(Calendar.DAY_OF_MONTH)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.YEAR)+ "', '"+fecha.get(Calendar.HOUR_OF_DAY)+":"+fecha.get(Calendar.MINUTE)+"', '" + entrante
				+ "', '" + primero + "', '" + segundo + "', '" + postre + "', '" + bebida + "'";
	}
	

}
