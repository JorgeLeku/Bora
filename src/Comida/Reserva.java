package Comida;

import java.sql.Date;
import java.sql.Time;

public class Reserva {
	private String username;
	protected Date fecha;
	protected Time hora;
	private String entrante,primero,segundo,postre,bebida;
	public Reserva() {
		this.username ="";
		this.fecha = new Date(System.currentTimeMillis());
		this.hora = new Time(System.currentTimeMillis());
		this.entrante = "";
		this.primero  = "";
		this.segundo  = "";
		this.postre   = "";
		this.bebida   = "";
	}
	public Reserva(String username, Date fecha, Time hora, String entrante, String primero, String segundo,
			String postre, String bebida) {
		super();
		this.username = username;
		this.fecha = fecha;
		this.hora = hora;
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
		this.hora = r.hora;
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
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
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
		return  username + ",'" + fecha + "', '" + hora + "', '" + entrante
				+ "', '" + primero + "', '" + segundo + "', '" + postre + "', '" + bebida + "'";
	}
	

}
