package Comida;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.jndi.toolkit.url.Uri;




public class BD {
	private static Exception lastError = null;  // Información de último error SQL ocurrido
	private static final String HOST = "ec2-54-247-74-131.eu-west-1.compute.amazonaws.com:5432/dchj8qn2eclus4";
	private static final String USERNAME= "cozwxagqcksbyh";
	private static final String PASSWORD ="fe8cbfe6ece6701368e303cdb2f46cd77fb4abdc30e7e7de2ae7bc7edbf759b3" ;
	
	
	/**metodo para iniciar conexion con BD
	 * @return conexion de la base de datos
	 */
	public static Connection initBD() {
		  try {
			Class.forName("org.postgresql.Driver");//conectamos con el jdbc de postgreSQL
		
		    Connection con = DriverManager.getConnection("jdbc:postgresql://"+ HOST +"?sslmode=require",USERNAME,PASSWORD);
			log(Level.INFO, "base de datos conectada",null );		
		   return con;
		  } catch (ClassNotFoundException | SQLException  e) {
			lastError = e;
			log( Level.SEVERE, "Error en conexión de base de datos ", e );			
			e.printStackTrace();
			return null;
		  }	
	}

	
	
	/** Devuelve statement para usar la base de datos
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			return statement;
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en uso de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}
			
	/** Cierra la base de datos abierta
	 * @param con	Conexión abierta de la BD
	 * @param st	Sentencia abierta de la BD
	 */
	public static boolean cerrarBD( final Connection con, final Statement st ) {
		
			try {
				if (st!=null) st.close();
				if (con!=null) con.close();
				log( Level.INFO, "Cierre de base de datos", null );
				return true;
			} catch (SQLException e) {
				lastError = e;
				log( Level.SEVERE, "Error en cierre de base de datos", e );
				e.printStackTrace();
				return false;
			}		
	}
	
	
	
	/** Devuelve la información de excepción del último error producido por cualquiera 
	 * de los métodos de gestión de base de datos
	 */
	public static Exception getLastError() {
		return lastError;
	}
	
	
	
	
	// Devuelve el string "securizado" para volcarlo en SQL
	// (Implementación 1) Sustituye ' por '' y quita saltos de línea
	// (Implementación 2) Mantiene solo los caracteres seguros en español
	private static String secu( String string ) {
		// Implementación (1)
		// return string.replaceAll( "'",  "''" ).replaceAll( "\\n", "" );
		// Implementación (2)
		StringBuffer ret = new StringBuffer();
		for (char c : string.toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZñÑáéíóúüÁÉÍÓÚÚ.,:;-_(){}[]-+*=<>'\"¿?¡!&%$@#/\\0123456789".indexOf(c)>=0) ret.append(c);
		}
		return ret.toString().replaceAll("'", "''");
	}
	

	
	
	/////////////////////////////////////////////////////////////////////
	//                          Operaciones                            //
	/////////////////////////////////////////////////////////////////////
	
	/** Añade valores  a la tabla abierta de BD, usando la sentencia INSERT de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente)
	 * @param valor valor de lo que se quiere meter( en nuestro caso metemos el toString de Bebida o Comida)
	 * @param nombreTabla nombre de la tabla a seleccionar
	 
	 */
	public static boolean Insert( final Statement st, final String valor, String nombreTabla ) {
		
			String sentSQL = "";
			try {
				sentSQL = "insert into "+ nombreTabla + " values(" + valor + ")";
				int val = st.executeUpdate( sentSQL );
				log( Level.INFO, "BD añadida " + val + " fila\t" + sentSQL, null );
				if (val!=1) {  // Se tiene que añadir 1 - error si no
					log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				}
				return true;
			} catch (SQLException e) {
				log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
				lastError = e;
				e.printStackTrace();
				return false;//ha ocurrido un problema
			}		
	}

	/** Busca un valor de la tabla abierta de BD, usando la sentencia SELECT de SQL
	 * (Atención: esta operación es síncrona, no devuelve el control hasta que se ejecuta completamente en base de datos)
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente)
	 * @param condicion condicion completa desde el where
	 * @param nombre Tabla
	 * @return Contador de filas(-1 si no se encuentra)
	 */
	public static boolean Select( Statement st, String condicion , String nombreTabla) {
		String sentSQL = "";
		ResultSet rs = null;
		try {
			sentSQL = "select * from "+ nombreTabla+ " where " + condicion ;//coje el valor de la BD
			log( Level.INFO, "BD\t" + sentSQL, null );
			rs = st.executeQuery( sentSQL );
			if(rs.next()){
				return true;
			}else{
				return false;
			}			
		} catch (Exception e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}		
	}
	
	/** Modifica un valor de la tabla abierta de BD, usando la sentencia UPDATE de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente)
	 * @param i	valor a introducir
	 * @param nombreCol nombre de la columna a editar
	 * @param nombreTabla nombre de la tabla
	 * @return boolean para saber si la transaccion ha sido correcta o no
	 */
	public static boolean Update(  Statement st, String nombreCol,  String i , String condicion ,String nombreTabla) {
		
			String sentSQL = "";
			try {
				sentSQL = "update "+ nombreTabla+" set" +
						secu(nombreCol) + " = " + i + 
						" where " + condicion ;
				int val = st.executeUpdate( sentSQL );
				log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
				if (val!=1) {  // Se tiene que modificar 1 - error si no
					log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
					return false;
				}
				return true;
			} catch (SQLException e) {
				log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
				lastError = e;
				e.printStackTrace();
				return false;
			}		
	}
	
/**Modifica los valores de una fila en la tabla comida
 * 
 * @param st Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente)
 * @param comida el objeto que se quiere actualizar
 * @return boolean nos indica si se ha cumplido o no la transaccion
 */
	public static boolean comidaUpdate( Statement st, Comida comida ) {
		String sentSQL = "";
		try {
			sentSQL = "update comida set" +
					" nombre= '" + comida.getNombre()+ "', " +
					" precio=" + comida.getPrecio() + ", "+
					" numeroPlato=" +comida.getNumeroPlato() + ", "+
					" where cod= " + comida.getId() ;
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @param st Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente)
	 * @param bebida objeto que queremos actualizar
	 * @return boolean nos indica si la transferencia ha sido correcta
	 */
	public static boolean bebidaUpdate( Statement st, Bebida bebida) {
		String sentSQL = "";
		try {
			sentSQL = "update comida set" +
					" nombre= '" + bebida.getNombre()+ "', " +
					" precio=" + bebida.getPrecio() + ", "+
					" alcoholica=" +bebida.alcoholica + 
					" where cod= " + bebida.getId() ;
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 
	 * @param st Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente)
	 * @param username nombre del usuario a comprobar
	 * @param password contraseña de la cuenta
	 * @param nombreTabla el nombre de la tabla a consultar("Administrador" si es un admin o "Usuario" si es un cliente)
	 * @return devuelve si la contraseña corresponde o no al usuario
	 */
	public static boolean verificarPersona(Statement st ,String username, String password, String nombreTabla) {
		String SentSQL = "select * from "+nombreTabla+ "where username= "+username;
		try {
			ResultSet rs = st.executeQuery(SentSQL);
			log( Level.INFO, "BD\t" + SentSQL, null );
				String contraseña = rs.getString("password");
				if(contraseña == password) {
					return true;
				}else return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log( Level.SEVERE, "Error en BD\t" + SentSQL, e );
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
	/////////////////////////////////////////////////////////////////////
	//                      Logging                                    //
	/////////////////////////////////////////////////////////////////////
	
	private static Logger logger = null;
	// Método público para asignar un logger externo
	/** Asigna un logger ya creado para que se haga log de las operaciones de base de datos
	 * @param logger	Logger ya creado
	 */
	public static void setLogger( Logger logger ) {
		BD.logger = logger;
	}
	
	// Método local para loggear (si no se asigna un logger externo, se asigna uno local)
	private static void log( Level level, String msg, Throwable excepcion ) {
		if (logger==null) {  // Logger por defecto local:
			logger = Logger.getLogger( BD.class.getName() );  // Nombre del logger - el de la clase
			logger.setLevel( Level.ALL );  // Loguea todos los niveles
			try {
				// logger.addHandler( new FileHandler( "bd-" + System.currentTimeMillis() + ".log.xml" ) );  // Y saca el log a fichero xml
				logger.addHandler( new FileHandler( "bd.log.xml", true ) );  // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		}
		if (excepcion==null) {
			logger.log( level, msg );
		}else {
			logger.log( level, msg, excepcion );
		}
	}
}
