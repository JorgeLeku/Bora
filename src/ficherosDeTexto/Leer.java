package ficherosDeTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leer {

	public  Leer() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> todo = new ArrayList<>();
		try {//buscar el arrchivo
			archivo = new File("src/ficherosDeTexto/carta.txt");
			fr = new FileReader(archivo);//path
			System.out.println("encontrado");
			br = new BufferedReader(fr);
			String linea ;

			   while((linea=br.readLine())!=null) {
		            System.out.println(linea);
		      }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("no encontrado");
		}finally {
			try {
				 if( null != fr ){   
		               fr.close();     
		            } 
				System.out.println("cerrando");
				System.out.println(todo.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Leer();

	}

}
