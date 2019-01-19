package Comida;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


import jdk.nashorn.internal.parser.TokenStream;
import sun.security.jgss.TokenTracker;

public class Carta {
	/* Clase carta,
	 * objetivo leer y escribir en la BD   */
	
	public HashSet<Comida> entrantes;
	public HashSet<Comida> primeros;
	public HashSet<Comida> segundos;
	public HashSet<Comida> postres;
	public HashSet<Bebida>bebidas;
	
	

	public Carta(HashSet<Comida> entrantes, HashSet<Comida> primeros, HashSet<Comida> segundos, HashSet<Comida> postres,
			HashSet<Bebida> bebidas) {
		super();
		this.entrantes = entrantes;
		this.primeros = primeros;
		this.segundos = segundos;
		this.postres = postres;
		this.bebidas = bebidas;
	}
	public Carta(Carta c) {
		this.entrantes = c.entrantes;
		this.primeros = c.primeros;
		this.segundos = c.segundos;
		this.postres = c.postres;
		this.bebidas = c.bebidas;
	}
	public Carta() {
		super();
		this.entrantes = new HashSet<>();
		this.primeros = new HashSet<>();
		this.segundos = new HashSet<>();
		this.postres = new HashSet<>();
		this.bebidas = new HashSet<>();
	}



	public HashSet<Comida> getEntrantes() {
		return entrantes;
	}
	public void setEntrantes(HashSet<Comida> entrantes) {
		this.entrantes = entrantes;
	}
	public HashSet<Comida> getPrimeros() {
		return primeros;
	}
	public void setPrimeros(HashSet<Comida> primeros) {
		this.primeros = primeros;
	}
	public HashSet<Comida> getSegundos() {
		return segundos;
	}
	public void setSegundos(HashSet<Comida> segundos) {
		this.segundos = segundos;
	}
	public HashSet<Comida> getPostres() {
		return postres;
	}
	public void setPostres(HashSet<Comida> postres) {
		this.postres = postres;
	}
	public HashSet<Bebida> getBebidas() {
		return bebidas;
	}
	public void setBebidas(HashSet<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
	
	//Añadir comida/bebida
	public void addComida(Comida c) {
		if(c.numeroPlato == 1) {
			entrantes.add(c);
		}else if(c.numeroPlato == 2) {
			primeros.add(c);
		}else if(c.numeroPlato == 3) {
			segundos.add(c);
		}else if(c.numeroPlato == 4) {
			postres.add(c);
		}
	}
	public void addBebida(Bebida b) {
		this.bebidas.add(b);
	}
	
	//introducimos todos los datos en la BD
	//primero habra que saber si ya existe para hacer un insert o un update
	public void guardarCarta() {
		boolean resultBebidas= false;
		boolean	resultComidas= false; 
		
		Connection conn = BD.initBD();
		
		
		try {
			Statement st = conn.createStatement();
			for (Bebida bebida : bebidas) {
			//creamos una conexion y mediante el metodo siguiente introducimos los valores en la BD
			if(BD.Select(st, "cod = "+ bebida.id, "bebida")) {//comprobamos si existe esta comida o no para actualizarla
				resultBebidas = BD.bebidaUpdate(st, bebida);//existe y actualizamos
			}else{
				resultBebidas  = BD.Insert(st,  bebida.toString() , "bebida");//no existe y creamos
			}
				
			}
			
			 for (Comida comida : entrantes) {
				 if(BD.Select(st, "cod = "+comida.id,"comida")) {//comprobamos si existe esta comida
					 resultComidas = BD.comidaUpdate(st, comida);//existe y actualizamos					 
				 }else{
					 resultComidas = BD.Insert(st, comida.toString(), "comida");//no existe y creamos
				 }
			}
			 for (Comida comida : primeros) {
				 if(BD.Select(st, "cod = "+comida.id,"comida")) {//comprobamos si existe esta comida
					 resultComidas = BD.comidaUpdate(st, comida);//existe y actualizamos					 
				 }else{
					 resultComidas = BD.Insert(st, comida.toString(), "comida");//no existe y creamos
				 }
			} for (Comida comida : segundos) {
				 if(BD.Select(st, "cod = "+comida.id,"comida")) {//comprobamos si existe esta comida
					 resultComidas = BD.comidaUpdate(st, comida);//existe y actualizamos					 
				 }else{
					 resultComidas = BD.Insert(st, comida.toString(), "comida");//no existe y creamos
				 }
			} for (Comida comida : postres) {
				 if(BD.Select(st, "cod = "+comida.id,"comida")) {//comprobamos si existe esta comida
					 resultComidas = BD.comidaUpdate(st, comida);//existe y actualizamos					 
				 }else{
					 resultComidas = BD.Insert(st, comida.toString(), "comida");//no existe y creamos
				 }
			}
			BD.cerrarBD(conn, st);//se cierra la BD
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}			
		
		
	
		
	}
	
	//leer en fichero de texto
//		File archivo = null;
//		FileReader fr = null;
//		BufferedReader br = null;
//		ArrayList<String> todo = new ArrayList<>();
//		try {//buscar el arrchivo
//			archivo = new File("src/ficherosDeTexto/carta.txt");
//			fr = new FileReader(archivo);//path
//			System.out.println("encontrado");
//			br = new BufferedReader(fr);
//			String linea ;
////
//			   while((linea=br.readLine())!=null) {//mientras no este vacio el fichero
//				   String[]tockens = linea.split(","); //separamos en tockens las distintas partes
//				   if( tockens.length == 6) {//bebida completada
//					   //es bebida
//					   Bebida b = new Bebida();
//					   b.id = Integer.parseInt(tockens[0]);
//					   b.nombre = tockens[1];
//					   b.precio = Double.parseDouble(tockens[2]);
//					   b.setDescripcion(tockens[3]);
//					   b.setmL(Integer.parseInt(tockens[4]));
//					   b.setAlcoholica(Boolean.parseBoolean(tockens[5]));
//					  this.bebidas.add(b);
//				   }else {
//					   //es comida
//					   Comida c = new Comida();
//					   c.id = Integer.parseInt(tockens[0]) ;
//					   c.nombre = tockens[1];
//					   c.precio =  Double.parseDouble(tockens[2]) ;
//					  
//				   }
//				   
//		            
//			   	}
//				//crea el popup
//			
//					 JOptionPane.showMessageDialog(null, "carga completada");
//				
//				
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("no encontrado");
//		}finally {
//			try {
//				 if( null != fr ){   
//		               fr.close();     
//		            } 
//				System.out.println("cerrando");
//				System.out.println(todo.toString());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
	
	
	public boolean cargarCarta() {
		String sentSQL= "";
		Connection conn = BD.initBD();
		try {
			Statement st = conn.createStatement();
			//cargamos las bebidas y las guardamos
			sentSQL = "select * from bebida";
			ResultSet rs = st.executeQuery(sentSQL);
			boolean res = rs.wasNull();
			while(rs.next()) {//mientras el rs tenga elementos los almacenamos 
				//creamos una nueva bebida vacia y le colocamos los valores correspondientes
				Bebida b = new Bebida();
				b.id = rs.getInt("cod");
				b.nombre = rs.getString("nombre");
				b.precio = rs.getDouble("precio");
				b.alcoholica = rs.getBoolean("alcoholica");
				this.addBebida(b);
			}
			
			//cargamos las comidas
			sentSQL = "select * from comida";
			rs = st.executeQuery(sentSQL);
			while(rs.next()) {
				Comida c = new Comida();
				c.id = rs.getInt("cod");
				c.nombre = rs.getString("nombre");
				c.precio = rs.getDouble("precio");
				c.numeroPlato = rs.getInt("numeroPlato");
				this.addComida(c);
			}
			BD.cerrarBD(conn, st);
			return res;//nos devuelve true si esta vacio

		} catch (SQLException e) {
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return true;
		}
		
		
	}

	
	//escribir fichero de texto
//		//metodo para escribir en el fichero de texto los cambios en la carta
//		FileWriter archivo = null;
//		PrintWriter pw = null;
//
//		try {
//			archivo = new FileWriter("src/ficherosDeTexto/carta.txt");
//			pw = new PrintWriter(archivo);
//			for (Bebida bebida : bebidas) {
//				pw.println(bebida.toString());
//			}
//			for (Comida comida : comidas) {
//				pw.println(comida.toString());
//			}
//			 JOptionPane.showMessageDialog(null,"se ha escrito correctamente" );
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		//	System.err.println("no encontrado");
//			 JOptionPane.showMessageDialog(null,"no encontrado","error",0 );
//		}finally {
//			pw.close();
//			try {
//				archivo.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				//System.err.println("no se cerró");
//				 JOptionPane.showMessageDialog(null,"no se cerró","error",0 );
//			}
//		}
	
	
	
	public static void main(String[] args) {
		/*Carta c = new Carta();
		c.cargarCarta();
		c.guardarCarta();
		 */
	}

}
