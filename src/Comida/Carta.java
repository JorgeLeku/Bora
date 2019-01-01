package Comida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

import com.sun.javafx.fxml.expression.Expression.Parser.Token;

import jdk.nashorn.internal.parser.TokenStream;
import sun.security.jgss.TokenTracker;

public class Carta {
	/* Clase carta,
	 * objetivo leer y escribir en la BD   */
	
	public HashSet<Comida> comidas;
	public HashSet<Bebida>bebidas;
	
	
	public Carta(HashSet<Comida> comidas, HashSet<Bebida> bebidas) {
		super();
		this.comidas = comidas;
		this.bebidas = bebidas;
	}
	public Carta(Carta c) {
		
		this.comidas = c.comidas;
		this.bebidas = c.bebidas;
	}
	public Carta() {
		super();
		this.comidas = new HashSet<>();
		this.bebidas = new HashSet<>();
	}


	public HashSet<Comida> getComidas() {
		return comidas;
	}
	public void setComidas(HashSet<Comida> comidas) {
		this.comidas = comidas;
	}
	public HashSet<Bebida> getBebidas() {
		return bebidas;
	}
	public void setBebidas(HashSet<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
	
	//Añadir comida/bebida
	public void addComida(Comida c) {
		this.comidas.add(c);
		
	}
	public void addBebida(Bebida b) {
		this.bebidas.add(b);
	}
	
	
	
	
	//metodos para conectar con la base de datos
	public void cargarCarta() {
		/* como se guarda la comida : id, nombre, precio,ingrediente1, ingrediente2, ...
		 * como se guardan las bebidas : id, nombre, precio,descripcion, ml, alcoholica;
		*/
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
//
			   while((linea=br.readLine())!=null) {//mientras no este vacio el fichero
				   String[]tockens = linea.split(","); //separamos en tockens las distintas partes
				   if( tockens.length == 6) {//bebida completada
					   //es bebida
					   Bebida b = new Bebida();
					   b.id = Integer.parseInt(tockens[0]);
					   b.nombre = tockens[1];
					   b.precio = Double.parseDouble(tockens[2]);
					   b.setDescripcion(tockens[3]);
					   b.setmL(Integer.parseInt(tockens[4]));
					   b.setAlcoholica(Boolean.parseBoolean(tockens[5]));
					  this.bebidas.add(b);
				   }else {
					   //es comida
					   Comida c = new Comida();
					   c.id = Integer.parseInt(tockens[0]) ;
					   c.nombre = tockens[1];
					   c.precio =  Double.parseDouble(tockens[2]) ;
					   //a partir de ahora todo lo demas son ingredientes
					   HashSet<String> ingredientes = new HashSet<>();
					  for (int i = 0; i < tockens.length; i++) {
						ingredientes.add(tockens[i]);
					  }
					  c.setIngredientes(ingredientes);
					  
					  this.comidas.add(c);
					  
				   }
				   
		            
			   	}
				//crea el popup
			
					 JOptionPane.showMessageDialog(null, "carga completada");
				
				
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
	
	public void guardarCarta() {
		//metodo para escribir en el fichero de texto los cambios en la carta
		FileWriter archivo = null;
		PrintWriter pw = null;

		try {
			archivo = new FileWriter("src/ficherosDeTexto/carta.txt");
			pw = new PrintWriter(archivo);
			for (Bebida bebida : bebidas) {
				pw.println(bebida.toString());
			}
			for (Comida comida : comidas) {
				pw.println(comida.toString());
			}
			 JOptionPane.showMessageDialog(null,"se ha escrito correctamente" );
		
		} catch (Exception e) {
			e.printStackTrace();
		//	System.err.println("no encontrado");
			 JOptionPane.showMessageDialog(null,"no encontrado","error",0 );
		}finally {
			pw.close();
			try {
				archivo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.err.println("no se cerró");
				 JOptionPane.showMessageDialog(null,"no se cerró","error",0 );
			}
		}
	}
	
	
	public static void main(String[] args) {
		/*Carta c = new Carta();
		c.cargarCarta();
		c.guardarCarta();
		 */
	}

}
