package ficherosDeTexto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class Escribir {

	public Escribir() {
		FileWriter archivo = null;
		PrintWriter pw = null;

		try {
			archivo = new FileWriter("src/ficherosDeTexto/carta.txt");
			pw = new PrintWriter(archivo);
			
			pw.println("prueba 1");
			System.out.println(pw.toString());
			System.out.println("escrito");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("no encontrado");
		}finally {
			pw.close();
			try {
				archivo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("no se cerró");
			}
		}
	}

	public static void main(String[] args) {
		new Escribir();
	}

}
