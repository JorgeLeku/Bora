package Restaurante2;

import java.util.ArrayList;

public class Pizza {
	private int tamanyo;
	private String tipo;
	private ArrayList<String> extras;
	
	public Pizza(int tamanyo, String tipo, ArrayList<String> extras) {
		super();
		this.tamanyo = tamanyo;
		this.tipo = tipo;
		this.extras = extras;
	}

	public int getTamanyo() {
		return tamanyo;
	}

	public void setTamanyo(int tamanyo) {
		this.tamanyo = tamanyo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<String> getExtras() {
		return extras;
	}

	public void setExtras(ArrayList<String> extras) {
		this.extras = extras;
	}
	
	public double getPrecio() {
		double resultado = 0;
		
		if (this.tamanyo == 0) {
			resultado = 8;
		} else if (this.tamanyo == 1) {
			resultado = 12;
		} else {
			resultado = 16;
		}
		
		resultado = resultado + this.extras.size() * 0.5;
		
		return resultado;
	}

	@Override
	public String toString() {
		String sTam = "";
		
		if (this.tamanyo == 0) {
			sTam = "pequeña";
		} else if (this.tamanyo == 1) {
			sTam = "mediana";
		} else {
			sTam = "grande";
		}
		
		return "pizza " + sTam + ", " + tipo + ", extras: " + extras + ", precio: " + this.getPrecio();
	}
	
	
}
