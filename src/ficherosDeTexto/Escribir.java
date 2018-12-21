package ficherosDeTexto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JOptionPane;


//seria bueno implemetar logger en estas clases donde ahora aparecen los syso
//existe alguna manera de escribir todo entero y no linea a linea?
public class Escribir {

	public Escribir(String linea) {
		FileWriter archivo = null;
		PrintWriter pw = null;

		try {
			archivo = new FileWriter("src/ficherosDeTexto/carta.txt");
			pw = new PrintWriter(archivo);
			
			pw.println("linea");
			System.out.println(pw.toString());
			pop("se ha escrito correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		//	System.err.println("no encontrado");
			pop("no encontrado");
		}finally {
			pw.close();
			try {
				archivo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.err.println("no se cerró");
				pop("no se cerró");
			}
		}
	}
	//crea el popup
	public void pop(String mensaje) {
		 JOptionPane.showMessageDialog(null, mensaje);
	
	}
	public static void main(String[] args) {
		//new Escribir("ejemplo");
	}

}
