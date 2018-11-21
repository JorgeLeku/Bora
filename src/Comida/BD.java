package Comida;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;



public class BD {
	private static Exception lastError = null;  // Información de último error SQL ocurrido
	
	
	
	/**metodo para iniciar conexion con BD
	 * 
	 * @param nombreBD
	 * @return conexion de la base de datos
	 */
	public static Connection initBD(String nombreBD) {
		  try {
			Class.forName("org.sqlite.JDBC");
		    Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
		    log(Level.INFO, "base de datos "+nombreBD ,null );
		   return con;
		  } catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			
			lastError = e;
			log( Level.SEVERE, "Error en conexión de base de datos " + nombreBD, e );
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
	
	
	
	/** Crea las tablas de la base de datos. Si ya existen, las deja tal cual
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table teclaspulsadas " +
					"(tecla string, pulsaciones int)");
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			try {
				statement.executeUpdate("create table pulsaciones " +
					"(tecla string, pulsada bool, tiempo bigint)");
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			log( Level.INFO, "Creada base de datos", null );
			return statement;
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en creación de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}
	
	/** Reinicia en blanco las tablas de la base de datos. 
	 * UTILIZAR ESTE MËTODO CON PRECAUCIÓN. Borra todos los datos que hubiera ya en las tablas
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se borra correctamente, null si hay cualquier error
	 */
	public static Statement reiniciarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			statement.executeUpdate("drop table if exists *");
			
			log( Level.INFO, "Reiniciada base de datos", null );
			return usarCrearTablasBD( con );
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en reinicio de base de datos", e );
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	/** Cierra la base de datos abierta
	 * @param con	Conexión abierta de la BD
	 * @param st	Sentencia abierta de la BD
	 */
	public static void cerrarBD( final Connection con, final Statement st ) {
		
			try {
				if (st!=null) st.close();
				if (con!=null) con.close();
				log( Level.INFO, "Cierre de base de datos", null );
			} catch (SQLException e) {
				lastError = e;
				log( Level.SEVERE, "Error en cierre de base de datos", e );
				e.printStackTrace();
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
	 * @param valor valor de lo que se quiere meter
	 * @param nombreTabla nombre de la tabla a seleccionar
	 
	 */
	public static void teclaInsert( final Statement st, final String valor, String nombreTabla ) {
		
			String sentSQL = "";
			try {
				sentSQL = "insert into "+ nombreTabla + " values(" +
						"'" + secu(valor) + "', " +
						
						")";
				int val = st.executeUpdate( sentSQL );
				log( Level.INFO, "BD añadida " + val + " fila\t" + sentSQL, null );
				if (val!=1) {  // Se tiene que añadir 1 - error si no
					log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				}
			} catch (SQLException e) {
				log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
				lastError = e;
				e.printStackTrace();
			}
		
	}

	/** Busca un valor de la tabla abierta de BD, usando la sentencia SELECT de SQL
	 * (Atención: esta operación es síncrona, no devuelve el control hasta que se ejecuta completamente en base de datos)
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente)
	 * @param condicion condicion completa desde el where
	 * @param nombre Tabla
	 * @return Contador de pulsaciones de esa tecla (-1 si no se encuentra)
	 */
	public static void teclaSelect( Statement st, String condicion , String nombreTabla) {
		String sentSQL = "";
		try {
			sentSQL = "select * from "+ nombreTabla+ " where '" + secu(condicion) + "'";
			log( Level.INFO, "BD\t" + sentSQL, null );
			ResultSet rs = st.executeQuery( sentSQL );
				
				rs.close();
			
		} catch (Exception e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
		}
	}
	
	/** Modifica un valor de la tabla abierta de BD, usando la sentencia UPDATE de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente)
	 * @param valor	valor a introducir
	 * @param nombreCol nombre de la columna a editar
	 * @param nombreTabla nombre de la tabla
	 */
	public static void teclaActualiza( final Statement st, String nombreCol,final String valor , String condicion ,String nombreTabla) {
		
			String sentSQL = "";
			try {
				sentSQL = "update "+ nombreTabla+" set" +
						secu(nombreCol) + " = " + secu(valor) + 
						" where '" + condicion + "'";
				int val = st.executeUpdate( sentSQL );
				log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
				if (val!=1) {  // Se tiene que modificar 1 - error si no
					log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				}
			} catch (SQLException e) {
				log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
				lastError = e;
				e.printStackTrace();
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
