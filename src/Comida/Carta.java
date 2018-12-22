package Comida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
	
	public Carta(HashSet<Comida> carta) {
		super();
		this.comidas = carta;
	}
	public Carta(Carta c) {
		super();
		this.comidas = c.comidas;
	}
	public Carta() {
		super();
		this.comidas = new  HashSet<Comida>();
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

			   while((linea=br.readLine())!=null) {//mientras no este vacio el fichero
				   String[]tockens = linea.split(":"); //separamos en tockens las distintas partes
				   if(tockens.length == 4) {
					   //es comida
					   Comida c = new Comida();
					   c.id = Integer.parseInt(tockens[0]) ;
					   c.nombre = tockens[1];
					   c.precio =  Double.parseDouble(tockens[2]) ;
					  
					   
					   //cargar los ingredientes (separados pos :)
					   HashSet<Ingrediente> setDeIngredientes=  new HashSet<>();
					   //separar el tocken de los ingredientes cojuntos en tockens mas pequeños
					   String[] ingredientes = tockens[2].split("]");
					   for (int i = 0; i < ingredientes.length; i++) {
						   
					}
					   
					   
					   
					   
					   
				   }else if( tockens.length == 6) {//bebida completada
					   //es bebida
					   Bebida b = new Bebida();
					   b.id = Integer.parseInt(tockens[0]);
					   b.nombre = tockens[1];
					   b.precio = Double.parseDouble(tockens[2]);
					   b.setDescripcion(tockens[3]);
					   b.setmL(Integer.parseInt(tockens[4]));
					   b.setAlcoholica(Boolean.parseBoolean(tockens[5]));
					  this.bebidas.add(b);
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
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
