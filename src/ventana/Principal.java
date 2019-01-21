package ventana;
//17:04 commit
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import com.sun.xml.internal.fastinfoset.sax.Properties;

import Comida.*;



public class Principal extends JFrame {
	
	JCheckBox ch;
	Carta carta = new Carta();
	JMenu menuUsuario, menuUsuario2;
	JMenuItem usern, passw, name, surname, cancel, other;
	//JMenuBar menuBar;
	Boolean bpedido=false, bpregistro=false, bpbebidacomida=false, bpBebida = false, bpComida=false, bpAdmin = false,bpquitbotonComida=false,bpaddboton=false,bprecogerdomicilio=false, bprecogida=false, bpdomicilio=false,bpreserva=false, esnomentr=false;
	JButton  bPanelReserva, bPanelAdmin, bAddBoton, bQuitBoton, bPanelMesa, bPrimerPlato,  botonPruebas, bPanelRecogerDomicilio, bReturn, cbb1, bSelImg, bConfirmarDomicilio, bConfirmarRecogida, bConfirmarRegistro;
	Pedido pedido = new Pedido();
	Usuario usuario = new Usuario();
	Reserva reserva = new Reserva();
	Botones confirmarFactura;
	MaskFormatter mascarafecha, mascaraHora;
	BotonesGrandes bPanelRecogida,bPanelDomicilio,bPanelQuitBebida, bPanelQuitComida, bPanelBebidaComida, bPanelAddBoton;
	JLabel  lfechaEntrega, lQuitBebida, lQuitComida, lValidarTlfn,lUsuario, lContraseña, lNombrarProd, lTituloPAddBoton, lSelImagen, cbl5, fl1, fl2, facTotal, lTipo, lHoraR, lPrimerPlato, lCalle, lEdificio, lPiso, lLetra, lHora,precio,iva, precioTotal, lURegistro, lCRegistro, lNRegistro, lARegistro, lTRegistro, lgastado;
	Date fechaentrega,fechaentregares;
	Time horaentregares;
	JComboBox cOrden, cHoraReserva;
	JTextField tQuitBebida, tQuitComida, tUsuario, tPassword, tNombreProd, cbt2, tCalle, tEdificio, tPiso, tLetra, tURegistro, tCRegistro, tNRegistro, tARegistro, tTRegistro;
	JFormattedTextField tFecha,tHora;
	Font fuente;
	int anyo, mes, dia, hora, minuto,x = 1,numeroTF=0,queidentr=0,valorAmeterfe=3, valorAmeterce=3, valorAmeterfp=3,valorAmetercp=3,valorAmeterfs=3,valorAmetercs=3,valorAmeterfpo=3,valorAmetercpo=3,valorAmeterfb=3,valorAmetercb=3,contEntrantes= 0, contPrimero=0,contSegundo = 0, contPostre = 0, contcontbebida=0,enQuePlato= 0, pruebae =0, prueba = 0, pruebas =0, pruebap =0,pruebab =0, borrarbi = 0, borrarbo = 0, enQuePanel =0;
	double crafilasentr =0, creacolentr =0,creafilasprim =0, creafilasseg=0,creafilaspos=0, creafilasbeb=0, creacolprim=0,creacolseg=0,creacolpos=0,creacolbeb=0;
	String direccion,nombreUsuario, platoEntrantes, platoPrimero, platoSegundo, platoPostre, platoBebida;
	JButton bReturne = null,bReturna=null;

	public static void getProp(String Username) {
		File archivo = new File("config.properties");
		try {
			FileOutputStream fis = new FileOutputStream(archivo);
			Properties PropConfig = new Properties();
			//PropConfig.set
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Principal() {
	
		fechaentrega=new Date();
		try {
			mascarafecha=new MaskFormatter("##/##/####");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		mascarafecha.setPlaceholderCharacter('_');
		
		try {
			mascaraHora=new MaskFormatter("##:##");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		mascaraHora.setPlaceholderCharacter('_');
		
		List<JButton>bReturns = new ArrayList<>();
		
		carta.cargarCarta();
		 ImageIcon imagenbAtr = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bAtr.png"));
		 bReturn = new JButton (imagenbAtr);
//	paneles = new ArrayList<>();
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(999999999);
	    formatter.setAllowsInvalid(false);
	    formatter.setCommitsOnValidEdit(true);
	    
		InputStream cogerFuente;
		 try {
	           cogerFuente = this.getClass().getResource("Stingray.otf").openStream();
	        }
	        catch (IOException e1) {
	            e1.printStackTrace();
	            return;
	        }
       try {
	            this.fuente = Font.createFont(0, cogerFuente);
	        }
	        catch (FontFormatException | IOException e) {
	            return;
	        }
       Font newFont = fuente.deriveFont(fuente.getSize() * 15F);
       Font titulos = fuente.deriveFont(fuente.getSize()*30F);
       ch= new JCheckBox();
       ch.setFont(newFont);
       ch.setText("Es alcoholica?");
       ch.setBounds(100, 400, 200, 50);
       JFrame frame = new JFrame();
       
       ImageIcon imagenInicio = new ImageIcon(this.getClass().getClassLoader().getResource("frame/fondoBienvenida.jpg"));
       JPanel panelBienvenida =  new JPanel(){
			public void paintComponent(Graphics g) {
		        Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
		        Graphics bufferGraphics = bufferImage.getGraphics();
		        bufferGraphics.drawImage(imagenInicio.getImage(), 0, 0, 1080, 720, null);
		        g.drawImage(bufferImage, 0, 0, this);
		       
		    }
       };
       ArrayList<Paneles> todosPaneles= new ArrayList<>();
       Paneles panelInicioSesion = new Paneles();
       panelInicioSesion.setNombre("panelInicioSesion");
       panelInicioSesion.setName("panelInicioSesion");
       todosPaneles.add(panelInicioSesion);
       
       Paneles panelInicio = new Paneles();//primer panel (el panel que pone bora)
       panelInicio.setName("panelInicio");
       panelInicio.setNombre("panelInicio");
       todosPaneles.add(panelInicio);
       
       Paneles panelAdmin = new Paneles();//En este panel eliges si comer en el restaurante o pedir la comida para llevar (tambien esta el boton admin)
       panelAdmin.setName("panelAdmin");
       panelAdmin.setNombre("panelAdmin");
       todosPaneles.add(panelAdmin);
       
       Paneles panelQuitBebida = new Paneles();
       panelQuitBebida.setName("panelQuitBebida");
       panelQuitBebida.setNombre("panelQuitBebida");
       todosPaneles.add(panelQuitBebida);
       
       Paneles panelBebidaComida = new Paneles();
       panelBebidaComida.setName("panelBebidaComida");
       panelBebidaComida.setNombre("panelBebidaComida");
       todosPaneles.add(panelBebidaComida);
       
       Paneles panelQuitComida = new Paneles(); //En este panel el admin puede quitar platos del menu
       panelQuitComida.setName("panelQuitComida");
       panelQuitComida.setNombre("panelQuitComida");
       todosPaneles.add(panelQuitComida);
       
       Paneles panelAddBoton = new Paneles (); //En este panel el admin puede añadir platos a la comida
       panelAddBoton.setName("panelAddBoton");
       panelAddBoton.setNombre("panelAddBoton");
       todosPaneles.add(panelAddBoton);
       
       //Nko
       Paneles panelRegistrarse = new Paneles();
       panelRegistrarse.setName("panelRegistrarse");
       panelRegistrarse.setNombre("panelRegistrarse");
       todosPaneles.add(panelRegistrarse);
       
       Paneles panelReserva = new Paneles();
       panelReserva.setName("panelReserva");
       panelReserva.setNombre("panelReserva");
       todosPaneles.add(panelReserva);
       
       Paneles panelMesa = new Paneles();
       panelMesa.setName("panelMesa");
       panelMesa.setNombre("panelMesa");
       todosPaneles.add(panelMesa);
       
       Paneles panelRecogerDomicilio = new Paneles();
       panelRecogerDomicilio.setName("panelRecogerDomicilio");
       panelRecogerDomicilio.setNombre("panelRecogerDomicilio");
       todosPaneles.add(panelRecogerDomicilio);
       
       Paneles panelRecogida = new Paneles();
       panelRecogida.setName("panelRecogida");
       panelRecogida.setNombre("panelRecogida");
       todosPaneles.add(panelRecogida);
       
       Paneles panelDomicilio = new Paneles ();
       panelDomicilio.setName("panelDomicilio");
       panelDomicilio.setNombre("panelDomicilio");
       todosPaneles.add(panelDomicilio);
       
       
       
       Paneles panelCambioContraseña = new Paneles();
       panelCambioContraseña.setName("panelCambioContraseña");
       panelCambioContraseña.setNombre("panelCambioContraseña");
       todosPaneles.add(panelCambioContraseña);
       
       Paneles panelCambioUsuario= new Paneles();
       panelCambioUsuario.setName("panelCambioUsuario");
       panelCambioUsuario.setNombre("panelCambioUsuario");
       todosPaneles.add(panelCambioUsuario);
       
       Paneles panelCambioNombre = new Paneles();
       panelCambioNombre.setName("panelCambioNombre");
       panelCambioNombre.setNombre("panelCambioNombre");
       todosPaneles.add(panelCambioNombre);
       
       Paneles panelCambioApellido = new Paneles();
       panelCambioApellido.setName("panelCambioApellido");
       panelCambioApellido.setNombre("panelCambioApellido");
       todosPaneles.add(panelCambioApellido);
       
       Paneles panelFactura = new Paneles();
       panelFactura.setName("panelFactura");
       panelFactura.setNombre("panelFactura");
       todosPaneles.add(panelFactura);
       
       CrearPanel(panelBienvenida);
       CrearPanel(panelInicioSesion);
       //CrearPanel(panelInicio);
       CrearPanel(panelBebidaComida);
       CrearPanel(panelQuitBebida);
       CrearPanel(panelAdmin);
       CrearPanel(panelInicio);
       CrearPanel(panelQuitComida);
       CrearPanel(panelAddBoton);
       
       CrearPanel(panelReserva);
       CrearPanel(panelMesa);
       
       //Nko
       CrearPanel(panelRegistrarse);
        
       CrearPanel(panelRecogerDomicilio);
       CrearPanel(panelRecogida);
       CrearPanel(panelDomicilio);
       
     
       CrearPanel(panelQuitBebida);
       
       CrearPanel(panelFactura);

       CrearPanel(panelCambioContraseña);
       CrearPanel(panelCambioUsuario);
       CrearPanel(panelCambioNombre);
       CrearPanel(panelCambioApellido);
       panelBienvenida.setVisible(true);
       panelBienvenida.setEnabled(true);

       List<String>idbeb = new ArrayList<>();
		
		for (Bebida bebida : carta.getBebidas()) {
			idbeb.add(bebida.getNombre());
		}
		
		List<String>identr = new ArrayList<>();
		
		for (Comida entrantes : carta.getEntrantes()) {
			identr.add(entrantes.getNombre());
		}
		
		List<String>idprim = new ArrayList<>();
		
		for (Comida primero : carta.getPrimeros()) {
			idprim.add(primero.getNombre());
		}
		
		List<String>idseg = new ArrayList<>();
		
		for (Comida segundo : carta.getSegundos()) {
			idseg.add(segundo.getNombre());
		}
		
		List<String>idpos = new ArrayList<>();
		
		for (Comida postre : carta.getPostres()) {
			idpos.add(postre.getNombre());
		}
		
		
       ImageIcon imagenp1b2 = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b2.jpg"));
       ImageIcon imagenp1b1 = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b1.jpg"));
       ImageIcon imagenp1b2bn = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b2b-n.jpg"));
       ImageIcon imagenp1b1bn = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b1b-n.jpg"));
       
       ImageIcon imagenbAb = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bAb.png"));
      
       ImageIcon imagenbAtrbn = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bAtrb-n.png"));
       ImageIcon imagenbAbbn = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bAbb-n.png"));
       ImageIcon imagencbb2 = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bs1.png"));
       ImageIcon imagencbb2bn = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bs1b-n.png"));


       //sad
       //Creacion objetos
       //Objetos panelInicial
       bPanelRecogerDomicilio = new JButton(imagenp1b1);
       bPanelReserva = new JButton(imagenp1b2);
       bPanelAdmin = new JButton();
       
       //Objetos panelAdmin
       bPanelBebidaComida = new BotonesGrandes();
       bPanelAddBoton = new BotonesGrandes();
       
       //Objetos panelAddBoton
       bAddBoton = new JButton();
       bSelImg = new JButton(imagencbb2);
       bSelImg.setRolloverIcon(imagencbb2bn);
       lNombrarProd = new JLabel();
       tNombreProd = new JTextField();
       tNombreProd.setName("texto");
       lTituloPAddBoton = new JLabel();
     

       lTipo = new JLabel();
       cOrden = new JComboBox();
       
       //Objetos panelQuitBoton
       bQuitBoton = new JButton();

       //Objetos panelReserva

       lHoraR = new JLabel();
       lHoraR = new JLabel();
       lHoraR.setFont(newFont);
       lHoraR.setText("Hora de la reserva");

       cHoraReserva=new JComboBox();
       
       ImageIcon imagenBotonBlancoPeq = new ImageIcon(this.getClass().getClassLoader().getResource("p4/boton.jpg"));

       //Objetos PanelRecogerDomicilio
       bPanelRecogida = new BotonesGrandes();
       bPanelDomicilio = new BotonesGrandes();
       
       //Nko
       //Objetos panelRegistrarse
       lURegistro = new JLabel();
       lCRegistro = new JLabel();
       lNRegistro = new JLabel();
       lARegistro = new JLabel();
       lTRegistro = new JLabel();
       tURegistro = new JTextField();
       tURegistro.setName("texto");
       tCRegistro = new JTextField();
       tCRegistro.setName("texto");
       tNRegistro = new JTextField();
       tNRegistro.setName("texto");
       tARegistro = new JTextField();
       tARegistro.setName("texto");
       tTRegistro = new JTextField();
       tTRegistro.setName("texto");
       bConfirmarRegistro = new JButton();
       

       //Objetos panelRecogida
       lHora = new JLabel();
       tHora = new JFormattedTextField(mascaraHora);
       tTRegistro.setName("texto");

       lValidarTlfn = new JLabel();

     
       
       

       bConfirmarRecogida = new JButton();
       
       //Objetos panelDomicilio
       lCalle = new JLabel();
       tCalle = new JTextField();
       tCalle.setName("texto");
       lEdificio = new JLabel();
       tEdificio = new JTextField();
       tEdificio.setName("texto");
       lPiso = new JLabel();
       tPiso = new JTextField();
       tPiso.setName("texto");
       lLetra = new JLabel();
       tLetra = new JTextField();
       tLetra.setName("texto");


       bConfirmarDomicilio = new JButton();
       

       //Objetos panelFactura (NO estan aqui todos los objetos¡¡¡)
       precio = new JLabel();
       iva = new JLabel();
       
       //objetos panelQuitBoton
       lQuitComida = new JLabel();
       tQuitComida = new JTextField();
       tQuitComida.setName("texto");
      

       //Objetos panelMesa, de momento vamos a obviar el panelMesa
       bPrimerPlato = new JButton() {
    	   public void paintComponent(Graphics g) {
    		   
		        Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
		        Graphics bufferGraphics = bufferImage.getGraphics();
		        bufferGraphics.drawImage(imagenBotonBlancoPeq.getImage(), 0, 0, 300, 75, null);
		        g.drawImage(bufferImage, 0, 0, this);

		        }
		    
      };
       
       Botones bPanelMesa = new Botones();
       bPanelMesa.setNombre("Aceptar");
       //Objetos panelPrimerPlato
       lPrimerPlato = new JLabel ();
       lPrimerPlato.setFont(titulos);
       lPrimerPlato.setForeground(Color.WHITE);
       lPrimerPlato.setSize(50, 50);
       lPrimerPlato.setText("Primer Plato");
       

      
       cbb1 = new JButton(imagenbAb);

       cbb1.setRolloverIcon(imagenbAbbn);
       bReturn.setRolloverIcon(imagenbAtrbn);

       bPanelRecogerDomicilio.setRolloverIcon(imagenp1b1bn);
       bPanelReserva.setRolloverIcon(imagenp1b2bn);

       lUsuario = new JLabel();
       lUsuario.setFont(newFont);
       lUsuario.setText("Usuario");
       lUsuario.setBounds(250, 250, 200, 40);
       
       lContraseña = new JLabel();
       lContraseña.setFont(newFont);
       lContraseña.setText("Contraseña");
       lContraseña.setBounds(250, 400, 200, 40);
       Botones bIniciar = new Botones();
       Botones bRegistrarse = new Botones();
       CrearBoton(bIniciar);
       CrearBoton(bRegistrarse);
       bIniciar.setNombre("Iniciar Sesion");
       bRegistrarse.setNombre("Registrarse");
       bIniciar.setBounds(150, 580,300, 75);
       bRegistrarse.setBounds(600, 580,300, 75);
       tUsuario = new JTextField();
       tUsuario.setName("texto");
       tPassword = new JTextField();
       tPassword.setName("texto");
       tUsuario.setBounds(550, 250, 200, 40);
       tPassword.setBounds(550, 400, 200, 40);
       
       CrearBoton(bPanelRecogerDomicilio);
       CrearBoton(bPanelReserva);
       //CrearBoton(bPanelAdmin);
       
       CrearBoton(bPanelBebidaComida);
       bPanelBebidaComida.setNombre("Eliminar Plato");
       CrearBoton(bPanelAddBoton);
       bPanelAddBoton.setNombre("Añadir Plato");
       
       CrearBoton(bAddBoton);
       CrearBoton(bSelImg);
       
       CrearBoton(bQuitBoton);
       
       CrearBoton(bPanelMesa);
       
       CrearBoton(bPrimerPlato);
       
      // CrearBoton(bPanelRecogida);

       //PanelRecogerDomicilio
       bPanelRecogida.setBounds(93, 185, 400, 350);
       bPanelRecogida.setNombre("Recogida");
       
       bPanelDomicilio.setBounds(566, 185, 400, 350);
       bPanelDomicilio.setFont(newFont);
       bPanelDomicilio.setNombre("Domicilio");
       
       //Nko
       //panelRegistrarse
       lURegistro.setBounds(260, 200, 200, 40);
       lURegistro.setFont(newFont);
       lURegistro.setText("Username");
       tURegistro.setBounds(200, 250, 200, 40);
       
       lCRegistro.setBounds(700, 200, 200, 40);
       lCRegistro.setFont(newFont);
       lCRegistro.setText("Contraseña");
       tCRegistro.setBounds(700, 250, 200, 40);
       
       lNRegistro.setBounds(260, 325, 200, 40);
       lNRegistro.setFont(newFont);
       lNRegistro.setText("Nombre");
       tNRegistro.setBounds(200, 375, 200, 40);
       
       lARegistro.setBounds(760, 325, 200, 40);
       lARegistro.setFont(newFont);
       lARegistro.setText("Apellidos");
       tARegistro.setBounds(700, 375, 200, 40);
       
       lTRegistro.setBounds(260, 450, 200, 40);
       lTRegistro.setFont(newFont);
       lTRegistro.setText("Telefono");
       tTRegistro.setBounds(200, 500, 200, 40);
       

       
       bConfirmarRegistro.setBounds(390, 585, 300, 75);
       bConfirmarRegistro.setFont(newFont);
       bConfirmarRegistro.setText("Confirmar");

     //PANEL RECOGIDA LABEL Y TF
       lHora.setBounds(360, 250, 200, 40);
       lHora.setFont(newFont);
       lHora.setText("Hora");
       tHora.setBounds(300, 300, 200, 40);
       

       
       bConfirmarRecogida.setBounds(390, 585, 300, 75);
       bConfirmarRecogida.setFont(newFont);
       bConfirmarRecogida.setText("Confirmar");
       
       
      //PANEL DOMICILIO LABEL Y TF 
      lCalle.setBounds(260, 200, 200, 40);
      lCalle.setFont(newFont);
      lCalle.setText("Calle");
      tCalle.setBounds(200, 250, 200, 40);
      
      lEdificio.setBounds(700, 200, 200, 40);
      lEdificio.setFont(newFont);
      lEdificio.setText("Nombre Edificio");
      tEdificio.setBounds(700, 250, 200, 40);
      
      lPiso.setBounds(260, 325, 200, 40);
      lPiso.setFont(newFont);
      lPiso.setText("Piso");
      tPiso.setBounds(200, 375, 200, 40);
      
      lLetra.setBounds(760, 325, 200, 40);
      lLetra.setFont(newFont);
      lLetra.setText("Letra");
      tLetra.setBounds(700, 375, 200, 40);
      
      lfechaEntrega = new JLabel();
      lfechaEntrega.setFont(newFont);
      lfechaEntrega.setText("Fecha entrega");
      lfechaEntrega.setBounds(220, 450, 200, 40);
      
      tFecha = new JFormattedTextField(mascarafecha);
      tFecha.setName("texto");
      tFecha.setBounds(200, 500, 200, 40);

      
      bConfirmarDomicilio.setBounds(390, 585, 300, 75);
      bConfirmarDomicilio.setFont(newFont);
      bConfirmarDomicilio.setText("Confirmar");

      
      // panelFactura Label
      precio.setBounds(200, 450, 200, 40);
      precio.setFont(newFont);
      precio.setText("Precio: ");
      
      iva.setBounds(200, 500, 200, 40);
      iva.setFont(newFont);
      iva.setText("IVA: ");
      lgastado = new JLabel();
      //PanelBebidaComida
      bPanelQuitBebida = new BotonesGrandes();
      CrearBoton(bPanelQuitBebida);
      bPanelQuitBebida.setNombre("Eliminar Bebida");
      
      bPanelQuitComida = new BotonesGrandes();
      CrearBoton(bPanelQuitComida);
      bPanelQuitComida.setNombre("Eliminar Comida");
     
      bPanelQuitBebida.setBounds(93, 185, 400, 350);
      bPanelQuitComida.setBounds(566, 185, 400, 350);
      //panelQuitComida
      lQuitComida.setBounds(200, 300, 300, 75);
      lQuitComida.setFont(newFont);
      lQuitComida.setText("Nombre del Plato: ");
      
      tQuitComida.setBounds(500, 310, 350, 60);
      tQuitComida.setFont(newFont);
      tQuitComida.setText("");
      //
      Botones bQuitComida = new Botones();
      CrearBoton(bQuitComida);
      bQuitComida.setNombre("Aceptar");
      bQuitComida.setBounds(390, 585, 300, 75);
      
      
      //Panel QuitBebida
      lQuitBebida = new JLabel();
      lQuitBebida.setBounds(200, 300, 300, 75);
      lQuitBebida.setFont(newFont);
      lQuitBebida.setText("Nombre de la bebida: ");
      
      tQuitBebida = new JTextField();
      tQuitBebida.setName("texto");
      tQuitBebida.setBounds(500, 310, 350, 60);
      tQuitBebida.setFont(newFont);
      tQuitBebida.setText("");
      
      Botones bQuitBebida = new Botones();
      CrearBoton(bQuitBebida);
      bQuitBebida.setNombre("Aceptar");
      bQuitBebida.setBounds(390, 585, 300, 75);
      
      
      // CrearBoton(bPanelDomicilio);

       CrearBoton(bReturn);
       CrearBoton(cbb1);
       CrearBoton(bSelImg);
       
      bPanelRecogerDomicilio.setBounds(93, 185, 400, 350);
      bPanelReserva.setBounds(566, 185, 400, 350);
      bPanelAdmin.setBounds(500, 5, 50, 50);
      
     
             
      bPanelAddBoton.setBounds(93, 185, 400, 350);
      bPanelBebidaComida.setBounds(566, 185, 400, 350);

       
       tNombreProd.setBounds(300, 250, 200, 40);
       
       cbt2 = new JTextField();
       cbt2.setName("texto");
       cbt2.setBounds(300, 340, 200, 40);
       
      
       lNombrarProd.setBounds(25, 250, 400, 40);
       lNombrarProd.setFont(newFont);
       lNombrarProd.setText("Nombra  el  producto");
       
       lTituloPAddBoton.setBounds(450, 100, 400, 40);
       lTituloPAddBoton.setFont(newFont);
       lTituloPAddBoton.setForeground(Color.white);
       lTituloPAddBoton.setText("Crear boton");
       
    
     
       
       lTipo.setBounds(700, 250, 300, 40);
       lTipo.setFont(newFont);
       lTipo.setText("Posicion del plato");
     
       cOrden.setFont(newFont);
       cOrden.addItem("Entrantes");
       cOrden.addItem("Primero");
       cOrden.addItem("Segundo");
       cOrden.addItem("Postre");
       cOrden.addItem("Bebida");
       cOrden.setBounds(705, 300, 200, 50);
       
       cOrden.addActionListener(new ActionListener() {
   		
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			// TODO Auto-generated method stub
   			if (cOrden.getSelectedIndex()==4) {
   				ch.setVisible(true);
   				ch.setEnabled(true);
   			}else {
   				ch.setVisible(false);
   				ch.setEnabled(false);
   			}
   		}
   	});
       
       //Panel Reserva
       bPanelMesa.setBounds(390, 585, 300, 75);

       lHoraR.setBounds(420, 350, 300, 40);
       cHoraReserva.setBounds(380,400, 300, 40);
       //Esto es para crear el combo box de la reserva
       int cantidadHoras = 7; //Sustituir el 7 por la cantidad de horas libres cogidas de la bd
       for (int i = 0; i < cantidadHoras; i++) {
		cHoraReserva.addItem("p"+i);// Sustituir el "p"+i por los items de la tabla de la bd
	}
       

       //PanelRecogidaDomicilio
       bPanelRecogida.setBounds(93, 185, 400, 350);
       bPanelDomicilio.setBounds(566, 185, 400, 350);


       //Panel Mesa
       bPrimerPlato.setBounds(390, 585, 300, 75);
       
       
       //PanelPrimerPlato
       lPrimerPlato.setBounds(400, 50, 1000, 40);
       
       cbl5 = new JLabel();
       cbl5.setBounds(25, 340, 400, 40);
       cbl5.setFont(newFont);
       cbl5.setText("Precio");
       
       fl1 = new JLabel();
       fl1.setBounds(440, 90, 500, 50);	//esta es la de panelFactura??
       fl1.setFont(titulos);
       fl1.setForeground(Color.white);
       fl1.setText("Factura");
      
       fl2 = new JLabel();
       fl2.setBounds(400, 600, 200, 40);
       fl2.setFont(newFont);
       fl2.setForeground(Color.white);
       fl2.setText("Total:");
       
       facTotal = new JLabel();
       facTotal.setBounds(450, 600, 200, 40);
       facTotal.setFont(newFont);
       facTotal.setForeground(Color.white);
       facTotal.setText("€"); //LABEL para poner precio final
      
       bReturn.setBounds(30, 30, 80, 80);
       cbb1.setBounds(500, 580, 80, 80);
       bSelImg.setBounds(250, 420, 300, 75);

       confirmarFactura = new Botones();
       confirmarFactura.setNombre("Confirmar factura");
       CrearBoton(confirmarFactura);
       confirmarFactura.setBounds(390, 585, 300, 75);
       //EL MENU 
       JMenuBar menuBar = new JMenuBar();
       
       menuUsuario = new JMenu("Ajustes de usuario");
       menuUsuario2 = new JMenu("Ajustes de pedido");
       
       usern = new JMenuItem("Cambiar nombre de usuario");
       passw = new JMenuItem("Cambiar contraseña");
       name = new JMenuItem("Cambiar nombre");
       surname = new JMenuItem("Cambiar apellidos");
       other = new JMenuItem("Otro pedido");
       cancel = new JMenuItem("Cambiar de usuario");
       
       menuUsuario.add(usern);
       menuUsuario.add(passw);
       menuUsuario.add(name);
       menuUsuario.add(surname);
       menuUsuario2.add(other);
       menuUsuario2.add(cancel);
       
       //menuUsuario.setMnemonic(KeyEvent.VK_A);
       menuBar.add(menuUsuario);

       menuBar.add(menuUsuario2);
       
       menuBar.setVisible(false);
       menuBar.setEnabled(false);
       frame.setJMenuBar(menuBar);
              
        //Action Listeners
       usern.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/*for (int i = 0; i < frame.getCom; i++) {
				
			}
			CambiarPanel(, panelCambioUsuario);*/
			
		}
	});
       frame.addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			if (panelBienvenida.isEnabled()) {
				CambiarPanel(panelBienvenida, panelInicioSesion);
			}
			
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
	
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
	
			
		}
	});
      
       
		
		
       
       bIniciar.addActionListener(new ActionListener () {

   		@Override
   		public void actionPerformed(ActionEvent arg0) {
   			
   			
   			nombreUsuario=tUsuario.getText();
   			Connection conn = BD.initBD();
   			
   			Statement st=null;
   			try {
				st = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch bl	ock
				e1.printStackTrace();
			}
   			
   			if (BD.verificarPersona(st, tUsuario.getText(), tPassword.getText(), "usuario ")==true) {
   				//aha
   				frame.setSize(1080, 740);
   				CambiarPanel(panelInicioSesion, panelInicio);
   				bPanelAdmin.setEnabled(false);
   				bPanelAdmin.setVisible(false);
   				menuBar.setVisible(true);
   	   			menuBar.setEnabled(true);
   				panelInicio.updateUI();
			}else if(BD.verificarPersona(st, tUsuario.getText(), tPassword.getText(), "administrador")==true){
				CambiarPanel(panelInicioSesion, panelInicio);
				JOptionPane.showMessageDialog(null, "Bienvenido administrador <3");
				
				menuBar.setVisible(true);
	   			menuBar.setEnabled(true);
	   			frame.setSize(1080, 740);	
			}else {
			
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
			}
   			
   			
   		}
       	   
          });
       bRegistrarse.addActionListener(new ActionListener () {

   		@Override
   		public void actionPerformed(ActionEvent arg0) {
 
   			// TODO Auto-generated method stub
   			CambiarPanel(panelInicioSesion, panelRegistrarse );

   			if (bpregistro==false) {
				
   				bpregistro=true;
				bReturne = new JButton("bpRegistrarse");
				CrearBoton(bReturne);
				bReturne.setIcon(imagenbAtr);
				bReturne.setRolloverIcon(imagenbAtrbn);
				bReturne.setBounds(30, 30, 80, 80);
				bReturns.add(bReturne);
				panelRegistrarse.add(bReturne);
				
				
			}
   		
			bReturne.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CambiarPanel(panelRegistrarse,panelInicioSesion); 
				}
			});
   			
   		}
       	   
          });
       
       bConfirmarRegistro.addActionListener(new ActionListener () {
    	   @Override
      		public void actionPerformed(ActionEvent arg0) {
    		Connection conn = BD.initBD();
   			
   			Statement st=null;
   		
   			try {
   				st = conn.createStatement();
   			} catch (SQLException e1) {
   				// TODO Auto-generated catch block
   				e1.printStackTrace();
   			}
   				numeroTF=Integer.parseInt(tTRegistro.getText());
    		   	BD.Insert(st, "'"+ tURegistro.getText()+"'"+" , "+"'"+ tCRegistro.getText()+"'"+" , "+"'"+ tNRegistro.getText()+"'"+" , "+"'"+ tARegistro.getText()+"'"+" , "+numeroTF, "usuario");
      			
    		   	CambiarPanel(panelRegistrarse, panelInicioSesion );
      		}
       });
       
       bPanelAdmin.addActionListener(new ActionListener () {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			CambiarPanel(panelInicio, panelAdmin);
		
			if (bpAdmin == false) {
				bpAdmin=true;
				bReturne = new JButton("bpAdmin");
				CrearBoton(bReturne);
				bReturne.setIcon(imagenbAtr);
				bReturne.setRolloverIcon(imagenbAtrbn);
				bReturne.setBounds(30, 30, 80, 80);
				bReturns.add(bReturne);
				panelAdmin.add(bReturne);
				
			}

			bReturne.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CambiarPanel(panelAdmin, panelInicio); 
				}
			});
		}//
    	   
       });
      
       bPanelRecogerDomicilio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CambiarPanel(panelInicio, panelRecogerDomicilio);
				
				if (bprecogerdomicilio==false) {
					bprecogerdomicilio=true;
					bReturna = new JButton("bprecogerdomicilio");
					CrearBoton(bReturna);
					bReturna.setIcon(imagenbAtr);
					bReturna.setRolloverIcon(imagenbAtrbn);
					bReturna.setBounds(30, 30, 80, 80);
					bReturns.add(bReturna);
					panelRecogerDomicilio.add(bReturna);
					
					
				}
				bReturna.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						CambiarPanel(panelRecogerDomicilio,panelInicio); 
					}
				});
				
			}

       });
       
       bPanelRecogida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelRecogerDomicilio, panelRecogida);
				panelRecogida.add(bPanelMesa);
				panelRecogida.add(tFecha);
				panelRecogida.add(lfechaEntrega);
				panelRecogida.add(lHora);
				panelRecogida.add(tHora);
				if (bprecogida==false) {
					
					bprecogida=true;
					
					bReturne = new JButton("bprecogida");
					CrearBoton(bReturne);
					bReturne.setIcon(imagenbAtr);
					bReturne.setRolloverIcon(imagenbAtrbn);
					bReturne.setBounds(30, 30, 80, 80);
					bReturns.add(bReturne);
					panelRecogida.add(bReturne);
					
					
				}
				bPanelMesa.setVisible(true);
				bPanelMesa.setEnabled(true);
				tFecha.setVisible(true);
				tFecha.setEnabled(true);
				lfechaEntrega.setVisible(true);
				lfechaEntrega.setEnabled(true);
				lfechaEntrega.setLocation(260, 300);
				tFecha.setLocation(200, 350);
				lHora.setLocation(760, 300);
				tHora.setLocation(700, 350);
				lHora.setVisible(true);
				lHora.setEnabled(true);
				tHora.setVisible(true);
				tHora.setEnabled(true);
				bpedido=true;
				bReturne.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						CambiarPanel(panelRecogida, panelRecogerDomicilio); 
					}
				});	
			}

      });
       
       bPanelDomicilio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelRecogerDomicilio, panelDomicilio);
				panelDomicilio.add(tFecha);
				panelDomicilio.add(bPanelMesa);
				panelDomicilio.add(lfechaEntrega);
				panelDomicilio.add(lHora);
				panelDomicilio.add(tHora);
				if (bpdomicilio==false) {
					
					bpdomicilio=true;
					
					 bReturne = new JButton("bpdomicilio");
					CrearBoton(bReturne);
					bReturne.setIcon(imagenbAtr);
					bReturne.setRolloverIcon(imagenbAtrbn);
					bReturne.setBounds(30, 30, 80, 80);
					bReturns.add(bReturne);
					panelDomicilio.add(bReturne);
					
					
				}
				/*
      
      lfechaEntrega = new JLabel();
      lfechaEntrega.setFont(newFont);
      lfechaEntrega.setText("Fecha entrega");
      lfechaEntrega.setBounds(220, 450, 200, 40);
      
      tFecha = new JFormattedTextField(mascarafecha);
      
      tFecha.setBounds(200, 500, 200, 40);*/
				bPanelMesa.setVisible(true);
				bPanelMesa.setEnabled(true);
				tFecha.setVisible(true);
				tFecha.setEnabled(true);
				lfechaEntrega.setVisible(true);
				lfechaEntrega.setEnabled(true);
				lHora.setLocation(760, 450); //260, , 200, 40
				tHora.setLocation(700, 500);
				lfechaEntrega.setLocation(220, 450);
				tFecha.setLocation(200, 500);
				lHora.setVisible(true);
				lHora.setEnabled(true);
				tHora.setVisible(true);
				tHora.setEnabled(true);
				bpedido=true;
				bReturne.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						CambiarPanel(panelDomicilio,panelRecogerDomicilio); 
					}
				});
			}

     }); 

       bPanelReserva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelInicio, panelReserva);
				panelReserva.add(bPanelMesa);
				panelReserva.add(tFecha);
				panelReserva.add(lfechaEntrega);
				panelReserva.add(lHora);
				panelReserva.add(tHora);
				if (bpreserva==false) {
					
					
					bpreserva=true;
					
					bReturne = new JButton("bpReserva");
					panelReserva.add(bReturne);
					CrearBoton(bReturne);
					bReturne.setIcon(imagenbAtr);
					bReturne.setRolloverIcon(imagenbAtrbn);
					bReturne.setBounds(30, 30, 80, 80);
					bReturns.add(bReturne);
					
					
					
				}
				bPanelMesa.setVisible(true);
				bPanelMesa.setEnabled(true);
				tFecha.setVisible(true);
				tFecha.setEnabled(true);
				lfechaEntrega.setVisible(true);
				lfechaEntrega.setEnabled(true);
				lfechaEntrega.setLocation(260, 300);
				tFecha.setLocation(200, 350);
				lHora.setLocation(760, 300);
				tHora.setLocation(700, 350);
				lHora.setVisible(true);
				lHora.setEnabled(true);
				tHora.setVisible(true);
				tHora.setEnabled(true);
				bpedido=false;
				bReturne.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						CambiarPanel(panelReserva,panelInicio); 
					}
				});
				
			}

       });
      
       bPanelBebidaComida.addActionListener(new ActionListener () {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 
			CambiarPanel(panelAdmin, panelBebidaComida);
			
			
			

			if (bpbebidacomida==false) {
				
				
				bpbebidacomida=true;
			
				
				bReturne = new JButton("bpBebidaComida");
				
				CrearBoton(bReturne);
				bReturne.setIcon(imagenbAtr);
				bReturne.setRolloverIcon(imagenbAtrbn);
				bReturne.setBounds(30, 30, 80, 80);
				bReturns.add(bReturne);
				panelBebidaComida.add(bReturne);
				
				
			}
			bReturne.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CambiarPanel(panelBebidaComida,panelAdmin); 
				}
			});
			
		}
    	   
       });
       bPanelQuitBebida.addActionListener(new ActionListener () {

   		@Override
   		public void actionPerformed(ActionEvent e) {
   			// TODO Auto-generated method stub
   			CambiarPanel(panelBebidaComida, panelQuitBebida);
   			
   			
   			if (bpBebida==false) {
				
				bpBebida=true;
				bReturne = new JButton("bpBebida");
				CrearBoton(bReturne);
				bReturne.setIcon(imagenbAtr);
				bReturne.setRolloverIcon(imagenbAtrbn);
				bReturne.setBounds(30, 30, 80, 80);
				bReturns.add(bReturne);
				panelQuitBebida.add(bReturne);
				
				
			}
			bReturne.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CambiarPanel(panelQuitBebida, panelBebidaComida); 
				}
			});
   			
   			
   		}
       	   
       });
       bPanelQuitComida.addActionListener(new ActionListener () {

      		@Override
      		public void actionPerformed(ActionEvent e) {
      			// TODO Auto-generated method stub
      			CambiarPanel(panelBebidaComida, panelQuitComida);
      			
      			
      			if (bpquitbotonComida==false) {
    				
      				bpquitbotonComida=true;
    				
    				bReturne = new JButton("bpQuitComida");
    				CrearBoton(bReturne);
    				bReturne.setIcon(imagenbAtr);
    				bReturne.setRolloverIcon(imagenbAtrbn);
    				bReturne.setBounds(30, 30, 80, 80);
    				bReturns.add(bReturne);
    				panelQuitComida.add(bReturne);
    				
    				
    			}
    			bReturne.addActionListener(new ActionListener() {
    				
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					// TODO Auto-generated method stub
    					CambiarPanel(panelQuitComida,panelBebidaComida); 
    				}
    			});
      		}
          	   
         });
       bQuitBebida.addActionListener(new ActionListener () {

     		@Override
     		public void actionPerformed(ActionEvent e) {
     			// TODO Auto-generated method stub
     			Connection conn = BD.initBD();
    			
    			Statement st=null;
    		
    			try {
    				st = conn.createStatement();
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
     			if (BD.borrarAlimento(st, tQuitBebida.getText(), "bebida")) {
     				
				JOptionPane.showMessageDialog(null, "Bebida Eliminada");
				} else {
				JOptionPane.showMessageDialog(null, "Bebida no eliminada");
				}
     		
     			
     		}
         	   
        });
       bQuitComida.addActionListener(new ActionListener () {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			Connection conn = BD.initBD();
    			
    			Statement st=null;
    		
    			try {
    				st = conn.createStatement();
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    			if (BD.borrarAlimento(st, tQuitComida.getText(), "comida")) {
				JOptionPane.showMessageDialog(null, "Plato eliminado");
				} else {
				JOptionPane.showMessageDialog(null, "Plato no eliminado");
				}
    		
    			
    		}
        	   
       });
       bPanelAddBoton.addActionListener(new ActionListener () {

   		@Override
   		public void actionPerformed(ActionEvent e) {
   			// TODO Auto-generated method stub
   			CambiarPanel(panelAdmin, panelAddBoton);
   			
   			if (bpaddboton==false) {
				
				bpaddboton=true;
				
				bReturne = new JButton("bpAddBoton");
				CrearBoton(bReturne);
				bReturne.setIcon(imagenbAtr);
				bReturne.setRolloverIcon(imagenbAtrbn);
				bReturne.setBounds(30, 30, 80, 80);
				bReturns.add(bReturne);
				panelAddBoton.add(bReturne);
				
				
			}
			bReturne.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CambiarPanel(panelAddBoton,panelAdmin); 
				}
			});
			if (cOrden.getSelectedIndex()!=4) {
				ch.setVisible(false);
			    ch.setEnabled(false);
			}
			
   		}
       	   
        });
       
		
		

		
			
			
			
			
		
       	
		List<JButton> botonesentrantes, botonesprimero, botonessegundo, botonespostre, botonesbebida;//Arraylist de botones para guardar todos los botones creados
		List<JButton> cambioentrantea, cambioprimeroa,cambiosegundoa,cambiopostrea,cambiobebidaa,cambioentrantes, cambioprimero, cambiosegundo, cambiopostre, cambiobebida;//Arraylist de botones para guardar todos los botones de cambio de panel
		List<JPanel> panelesentrantes, panelesprimero, panelessegundo, panelespostre, panelesbebida;//Arraylist de paneles para guardar todos los paneles creados
		
		
		List<String>nombrebeb = new ArrayList<>();
		
		for (Bebida bebida : carta.getBebidas()) {
			nombrebeb.add(bebida.getNombre());
		}
		
		
		List<String>nombreentr = new ArrayList<>();
		
		for (Comida entrantes : carta.getEntrantes()) {
			nombreentr.add(entrantes.getNombre());
		}
		List<String>nombreprimero = new ArrayList<>();
		
		for (Comida primero : carta.getPrimeros()) {
			nombreprimero.add(primero.getNombre());
		}
		List<String>nombresegundo = new ArrayList<>();
		
		for (Comida segundo : carta.getSegundos()) {
			nombresegundo.add(segundo.getNombre());
		}
		List<String>nombrepostre = new ArrayList<>();
		
		for (Comida postre : carta.getPostres()) {
			nombrepostre.add(postre.getNombre());
		}
		
		
		crafilasentr =(double) nombreentr.size();
		creacolentr =(double) nombreentr.size();
		
		creafilasprim =(double) nombreprimero.size();
		creacolprim =(double) nombreprimero.size();
		
		creafilasseg =(double) nombresegundo.size();
		creacolseg =(double) nombresegundo.size();
		
		creafilaspos =(double) nombrepostre.size();
		creacolpos =(double) nombrepostre.size();
		
		creafilasbeb =(double) nombrebeb.size();
		creacolbeb =(double) nombrebeb.size();
		System.out.println(creafilasseg);
		System.out.println(creacolseg);
		System.out.println(nombresegundo.size());
		List<Double>preciobeb = new ArrayList<>();
		
		for (Bebida bebida : carta.getBebidas()) {
			preciobeb.add(bebida.getPrecio());
		}
		List<Double>precioentr = new ArrayList<>();
		
		for (Comida entrantes : carta.getEntrantes()) {
			precioentr.add(entrantes.getPrecio());
		}
		List<Double>precioprimero = new ArrayList<>();
		
		for (Comida primero : carta.getPrimeros()) {
			precioprimero.add(primero.getPrecio());
		}
		List<Double>preciosegundo = new ArrayList<>();
		
		for (Comida segundo : carta.getSegundos()) {
			preciosegundo.add(segundo.getPrecio());
		}
		List<Double>preciopostre = new ArrayList<>();
		
		for (Comida postre : carta.getPostres()) {
			preciopostre.add(postre.getPrecio());
		}

		
		botonesentrantes = new ArrayList<>();
		cambioentrantes = new ArrayList<>();
		cambioentrantea = new ArrayList<>();
		panelesentrantes= new ArrayList<>();
		
		botonesprimero = new ArrayList<>();
		cambioprimero = new ArrayList<>();
		cambioprimeroa = new ArrayList<>();
		panelesprimero = new ArrayList<>();
		
		botonessegundo = new ArrayList<>();
		cambiosegundo = new ArrayList<>();
		cambiosegundoa = new ArrayList<>();
		panelessegundo = new ArrayList<>();
		
		botonespostre = new ArrayList<>();
		cambiopostre = new ArrayList<>();
		cambiopostrea = new ArrayList<>();
		panelespostre = new ArrayList<>();
		
		botonesbebida = new ArrayList<>();
		cambiobebida = new ArrayList<>();
		cambiobebidaa = new ArrayList<>();
		panelesbebida = new ArrayList<>();
		
		
		
			bPanelMesa.addActionListener(new ActionListener () {
				
				
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Paneles panel1e =  new Paneles();
					
					CrearPanel(panel1e);
					
					
					panelesentrantes.add(panel1e);
					frame.getContentPane().add(panel1e);
					panelesentrantes.get(0).updateUI();
					todosPaneles.add(panel1e);
					
					
					//(int)Math.ceil((double)nombreentr.size()/9)
					
					
					int se= 40;
					
					int pe = 185;
					if (panelReserva.isEnabled()==true) {
						CambiarPanel(panelReserva, panelesentrantes.get(0));
					} else if (panelDomicilio.isEnabled()==true) {
						CambiarPanel(panelDomicilio, panelesentrantes.get(0));
					} else if (panelRecogida.isEnabled()==true) {
						CambiarPanel(panelRecogida, panelesentrantes.get(0));
					}
					
					for (int x = 0; x <(int)Math.ceil((double)nombreentr.size()/9); x++) { //creamos 40 paneles (eso tiene que cambiar con la bd)
						Paneles panelesMultent = new Paneles();  //creamos mas paneles
						JLabel lentrantes = new JLabel();
						lentrantes.setBounds(400, 50, 1000, 40);
						
					    lentrantes.setFont(titulos);
					    lentrantes.setForeground(Color.WHITE);
					    lentrantes.setSize(500, 50);
					    lentrantes.setText("Entrantes");
						panelesMultent.setName("panelesMult" + x); //le ponemos un nombre
						CrearPanel(panelesMultent);  //Le damoslos datos basicos
						frame.getContentPane().add(panelesMultent); //lo añadimos al frame
						panelesentrantes.add(panelesMultent);  //Lo metemos en el array de paneles
						todosPaneles.add(panelesMultent);
						panelesentrantes.get(x).add(lentrantes);
						Botones botonSiguientePanelentrantes = new Botones(); //Creamos el boton para pasar al siguiente panel
						botonSiguientePanelentrantes.setBounds(240,575, 300, 75); //La posicion del boton
						
						botonSiguientePanelentrantes.setNombre("siguiente panel");  //Ponemos nombre al boton
						Botones botonAnteriorPanelEntrantes = new Botones(); //Creamos el boton para pasar al siguiente panel
						botonAnteriorPanelEntrantes.setBounds(640, 575, 300, 75); //La posicion del boton
						botonAnteriorPanelEntrantes.setNombre("Anterior panel");
						
						if ((int)Math.ceil((double)nombreentr.size()/9)-(x+1)>0) {
							cambioentrantes.add(botonSiguientePanelentrantes);  //Lo añadimos al array de botones
							panelesentrantes.get(x).add(cambioentrantes.get(x)); //añadimos el boton para cambiar de panel a cada panel
							panelesentrantes.get(x).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
							cambioentrantea.add(botonAnteriorPanelEntrantes);  //Lo añadimos al array de botones
							panelesentrantes.get(x+1).add(botonAnteriorPanelEntrantes); //añadimos el boton para cambiar de panel a cada panel
							panelesentrantes.get(x+1).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
								
						}
					
						
						botonSiguientePanelentrantes.addActionListener(new ActionListener() {
					
							@Override
							public void actionPerformed(ActionEvent arg0) {
								//  TODO Auto-generated method stub
								
								CambiarPanel(panelesentrantes.get(pruebae), panelesentrantes.get(pruebae+1)); //Cambiamos de paneles prueba elige el numero de panel
								
								pruebae++; //Incrementamos prueba para que se pueda pasar de panel
								enQuePanel = pruebae;
								
							}
							
						});
						botonAnteriorPanelEntrantes.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								CambiarPanel(panelesentrantes.get(pruebae), panelesentrantes.get(pruebae-1)); //Cambiamos de paneles prueba elige el numero de panel
								
								pruebae--; //Incrementamos prueba para que se pueda pasar de panel
								enQuePanel = pruebae;
								
							}
							
						});
						if (x==0&&(int)Math.ceil((double)nombreentr.size()/9)-(x+1)>0) {  //si es el primer panel se añade un boton a panel1 para pasar al panel siguiente
							panel1e.add(cambioentrantes.get(0)); 
						} 
						if (crafilasentr/3>3) {
							crafilasentr=crafilasentr-9;
						} else {
							valorAmeterfe=(int)Math.ceil(crafilasentr/3);
						}
						
						for (int i = 0; i < valorAmeterfe; i++) {//son filas columnas de botones por panel
							if (creacolentr>3) {
								creacolentr=creacolentr-3;
							} else {
								valorAmeterce=(int)Math.ceil(creacolentr);
							}
				
							for (int o = 0; o < valorAmeterce; o++) {//son tres columnas de botones por panel
								
								Botones pp2e = new Botones(); //Creamos el boton del plato
								//CrearBoton(pp2);
								
								pp2e.setBounds(se, pe,300, 75); // con s y p vamos cambiando la posicion del siguiente boton
								pp2e.setNombre(nombreentr.get(contEntrantes)); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
								
								botonesentrantes.add(pp2e); //añadimos el boton al arraylist de botones
								se=320+se; //Incrementamos s para que el boton siguiente este a la izquierda
								panelesentrantes.get(x).add(pp2e); //añadimos el boton al panel correspondiente
								panelesentrantes.get(x).updateUI(); //actualizamos el panel para que muestre los botones
								pp2e.setName(nombreentr.get(contEntrantes));	//nombramos el boton para saber cual es (sacar de la bd)
								contEntrantes++;
								panel1e.updateUI(); //actualizamos el panel1 a parte creo que esto sobra pero soy gilipollas y no tengo tiempo para mirarlo
								pp2e.addActionListener(new ActionListener () {

							
									@Override
									public void actionPerformed(ActionEvent arg0) {
										// TODO Auto-generated method stub
										//me cago en dioooooooooooooooooooooososososoossos
										enQuePanel=0;
										platoEntrantes=pp2e.getNombre();
										
											Paneles panel1primero =  new Paneles();
											CrearPanel(panel1primero);
											for (int j = 0; j < panelesentrantes.size(); j++) {
												panelesentrantes.get(j).setVisible(false);
												panelesentrantes.get(j).setEnabled(false);
											}
											for (int j = 0; j < botonesentrantes.size(); j++) {
												botonesentrantes.get(j).setEnabled(false);
												botonesentrantes.get(j).setVisible(false);
											}
											for (int k = 0; k < cambioentrantes.size(); k++) {
												cambioentrantes.get(k).setEnabled(false);
												cambioentrantes.get(k).setVisible(false);
											}
											enQuePlato++;
											panelesprimero.add(panel1primero);
											frame.getContentPane().add(panel1primero);
											panelesprimero.get(0).updateUI();
											todosPaneles.add(panel1primero);
						
											int spr= 40;
											
											int ppr = 185;
											
											for (int x = 0; x <(int)Math.ceil((double)nombreprimero.size()/9) ; x++) { //creamos 40 paneles (eso tiene que cambiar con la bd)
												JLabel lprimero = new JLabel();
												lprimero.setBounds(400, 50, 1000, 40);
												
											       lprimero.setFont(titulos);
											       lprimero.setForeground(Color.WHITE);
											       lprimero.setSize(500, 50);
											       lprimero.setText("Primer Plato");
											       

												Paneles panelesMultprim = new Paneles();  //creamos mas paneles
												panelesMultprim.setName("panelesMult" + x); //le ponemos un nombre
												CrearPanel(panelesMultprim);  //Le damoslos datos basicos
												frame.getContentPane().add(panelesMultprim); //lo añadimos al frame
												panelesprimero.add(panelesMultprim);  //Lo metemos en el array de paneles
												todosPaneles.add(panelesMultprim);
												Botones botonSiguientePanelprimero = new Botones(); //Creamos el boton para pasar al siguiente panel
												botonSiguientePanelprimero.setBounds(240,575, 300, 75); //La posicion del boton
												Botones botonAnteriorPanelprimero = new Botones(); //Creamos el boton para pasar al siguiente panel
												botonAnteriorPanelprimero.setBounds(640, 575, 300, 75); //La posicion del boton
												botonAnteriorPanelprimero.setNombre("Anterior panel");
												
												
												botonSiguientePanelprimero.setNombre("Siguiente panel");  //Ponemos nombre al boton
												panelesprimero.get(x).add(lprimero);
												if ((int)Math.ceil((double)nombreprimero.size()/9)-(x+1)>0) {
													cambioprimero.add(botonSiguientePanelprimero);  //Lo añadimos al array de botones
													panelesprimero.get(x).add(botonSiguientePanelprimero); //añadimos el boton para cambiar de panel a cada panel
													panelesprimero.get(x).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
													
													cambioprimeroa.add(botonAnteriorPanelprimero);  //Lo añadimos al array de botones
													panelesprimero.get(x+1).add(botonAnteriorPanelprimero); //añadimos el boton para cambiar de panel a cada panel
													panelesprimero.get(x+1).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
														
													
													
												}
												
												botonSiguientePanelprimero.addActionListener(new ActionListener() {
												
													@Override
													public void actionPerformed(ActionEvent arg0) {
														// TODO Auto-generated method stub
														CambiarPanel(panelesprimero.get(prueba), panelesprimero.get(prueba+1)); //Cambiamos de paneles prueba elige el numero de panel
														
														prueba++; //Incrementamos prueba para que se pueda pasar de panel
														enQuePanel = prueba;
														
													}
													
												});
												botonAnteriorPanelprimero.addActionListener(new ActionListener() {
													
													@Override
													public void actionPerformed(ActionEvent arg0) {
														// TODO Auto-generated method stub
														CambiarPanel(panelesprimero.get(prueba), panelesprimero.get(prueba-1)); //Cambiamos de paneles prueba elige el numero de panel
														
														prueba--; //Incrementamos prueba para que se pueda pasar de panel
														enQuePanel = prueba;
														
													}
													
												});
												if (x==0&&(int)Math.ceil((double)nombreprimero.size()/9)-(x+1)>0) {  //si es el primer panel se añade un boton a panel1 para pasar al panel siguiente
													panel1primero.add(cambioprimero.get(0)); 
												} 
												/*System.out.println("filasprim"+creafilasprim);
												System.out.println("ValorfilaPrim"+valorAmeterfp);*/
												if (creafilasprim/3>3) {
													creafilasprim=creafilasprim-9;
												} else {
													valorAmeterfp=(int)Math.ceil(creafilasprim/3);
												}
												for (int i = 0; i < valorAmeterfp; i++) {//son filas columnas de botones por panel
													/*System.out.println("Columnasprim"+creacolprim);
													System.out.println("ValorColPrim"+ valorAmetercp);*/
													if (creacolprim>3) {
														creacolprim=creacolprim-3;
													} else {
														valorAmetercp=(int)Math.ceil(creacolprim);
													}
										
													for (int o = 0; o < valorAmetercp; o++) {//son tres columnas de botones por panel
														
														Botones pp2primero = new Botones(); //Creamos el boton del plato
														//CrearBoton(pp2);
														
														
														pp2primero.setBounds(spr, ppr,300, 75); // con s y p vamos cambiando la posicion del siguiente boton
														pp2primero.setNombre(nombreprimero.get(contPrimero)); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
														contPrimero++;
														
														botonesprimero.add(pp2primero); //añadimos el boton al arraylist de botones
														spr=320+spr; //Incrementamos s para que el boton siguiente este a la izquierda
														panelesprimero.get(x).add(pp2primero); //añadimos el boton al panel correspondiente
														panelesprimero.get(x).updateUI(); //actualizamos el panel para que muestre los botones
														pp2primero.setName("prueba"+x+i+o);	//nombramos el boton para saber cual es (sacar de la bd)
														panel1primero.updateUI(); //actualizamos el panel1 a parte creo que esto sobra pero soy gilipollas y no tengo tiempo para mirarlo
														pp2primero.addActionListener(new ActionListener () {
						
													
															@Override
															public void actionPerformed(ActionEvent arg0) {
																// TODO Auto-generated method stub
																//me cago en dioooooooooooooooooooooososososoossos
																//CambiarPanel(panelesprimero.get(enQuePanel), panelSegundo);
																platoPrimero=pp2primero.getNombre();
																
															
																for (int j = 0; j < panelesprimero.size(); j++) {
																	panelesprimero.get(j).setVisible(false);
																	panelesprimero.get(j).setEnabled(false);
																}
																for (int j = 0; j < botonesprimero.size(); j++) {
																	botonesprimero.get(j).setEnabled(false);
																	botonesprimero.get(j).setVisible(false);
																}
																for (int k = 0; k < cambioprimero.size(); k++) {
																	cambioprimero.get(k).setEnabled(false);
																	cambioprimero.get(k).setVisible(false);
																}
																enQuePanel=0;
																enQuePlato++;
																Paneles panel1s =  new Paneles(){
																	public void paintComponent(Graphics g) {
																        Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
																        Graphics bufferGraphics = bufferImage.getGraphics();
																        bufferGraphics.drawImage(imagenInicio.getImage(), 0, 0, 1080, 720, null);
																        g.drawImage(bufferImage, 0, 0, this);
																       
																    }
														       };
																CrearPanel(panel1s);
																
																
																panelessegundo.add(panel1s);
																frame.getContentPane().add(panel1s);
																panelessegundo.get(0).updateUI();
																todosPaneles.add(panel1s);
																int ss= 40;
																
																int ps = 185;
																
																for (int x = 0; x <(int)Math.ceil((double)nombresegundo.size()/9) ; x++) { //creamos 40 paneles (eso tiene que cambiar con la bd)
																	Paneles panelesMultseg = new Paneles();  //creamos mas paneles
																	JLabel lsegundo = new JLabel();
																	lsegundo.setBounds(400, 50, 1000, 40);
																    lsegundo.setFont(titulos);
																    lsegundo.setForeground(Color.WHITE);
																    lsegundo.setSize(500, 50);
																    lsegundo.setText("Segundo plato");
																	panelesMultseg.setName("panelesMult" + x); //le ponemos un nombre
																	CrearPanel(panelesMultseg);  //Le damoslos datos basicos
																	frame.getContentPane().add(panelesMultseg); //lo añadimos al frame
																	panelessegundo.add(panelesMultseg);  //Lo metemos en el array de paneles
																	panelessegundo.get(x).add(lsegundo);
																	todosPaneles.add(panelesMultseg);
																	Botones botonSiguientePanelsegundo = new Botones(); //Creamos el boton para pasar al siguiente panel
																	botonSiguientePanelsegundo.setBounds(240,575, 300, 75); //La posicion del boton
																	Botones botonAnteriorPanelSegundo= new Botones(); //Creamos el boton para pasar al siguiente panel
																	botonAnteriorPanelSegundo.setBounds(640, 575, 300, 75); //La posicion del boton
																	botonAnteriorPanelSegundo.setNombre("Anterior panel");
																	
																	
																	botonSiguientePanelsegundo.setNombre("siguiente panel");  //Ponemos nombre al boton
																	if ((int)Math.ceil((double)nombresegundo.size()/9)-(x+1)>0) {
																		cambiosegundo.add(botonSiguientePanelsegundo);  //Lo añadimos al array de botones
																		panelessegundo.get(x).add(botonSiguientePanelsegundo); //añadimos el boton para cambiar de panel a cada panel
																		panelessegundo.get(x).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
																		cambiosegundoa.add(botonAnteriorPanelSegundo);  //Lo añadimos al array de botones
																		panelessegundo.get(x+1).add(botonAnteriorPanelSegundo); //añadimos el boton para cambiar de panel a cada panel
																		panelessegundo.get(x+1).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
																			
																	}
																	
																	botonSiguientePanelsegundo.addActionListener(new ActionListener() {
																	
																		@Override
																		public void actionPerformed(ActionEvent arg0) {
																			// TODO Auto-generated method stub
																			
																			CambiarPanel(panelessegundo.get(pruebas), panelessegundo.get(pruebas+1)); //Cambiamos de paneles prueba elige el numero de panel
																			
																			pruebas++; //Incrementamos prueba para que se pueda pasar de panel
																			enQuePanel = pruebas;
																			
																		}
																		
																	});
																	botonAnteriorPanelSegundo.addActionListener(new ActionListener() {
																		
																		@Override
																		public void actionPerformed(ActionEvent arg0) {
																			// TODO Auto-generated method stub
																			CambiarPanel(panelessegundo.get(pruebas), panelessegundo.get(pruebas-1)); //Cambiamos de paneles prueba elige el numero de panel
																			
																			pruebas--; //Incrementamos prueba para que se pueda pasar de panel
																			enQuePanel = pruebas;
																			
																		}
																		
																	});
																	if (x==0&&(int)Math.ceil((double)nombresegundo.size()/9)-(x+1)>0) {  //si es el primer panel se añade un boton a panel1 para pasar al panel siguiente
																		panel1s.add(cambiosegundo.get(0)); 
																	} 
																	if (creafilasseg/3>3) {
																		creafilasseg=creafilasseg-9;
																	} else {
																		valorAmeterfs=(int)Math.ceil(creafilasseg/3);
																	}
																	for (int i = 0; i < valorAmeterfs; i++) {//son filas columnas de botones por panel
																		if (creacolseg>3) {
																			creacolseg=creacolseg-3;
																		} else {
																			valorAmetercs=(int)Math.ceil(creacolseg);
																		}
																		
																		for (int o = 0; o < valorAmetercs; o++) {//son tres columnas de botones por panel
																			
																			Botones pp2s = new Botones(); //Creamos el boton del plato
																			//CrearBoton(pp2);
																			
																			pp2s.setBounds(ss, ps,300, 75); // con s y p vamos cambiando la posicion del siguiente boton
																			pp2s.setNombre(nombresegundo.get(contSegundo)); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
																			contSegundo++;
																			botonessegundo.add(pp2s); //añadimos el boton al arraylist de botones
																			ss=320+ss; //Incrementamos s para que el boton siguiente este a la izquierda
																			panelessegundo.get(x).add(pp2s); //añadimos el boton al panel correspondiente
																			panelessegundo.get(x).updateUI(); //actualizamos el panel para que muestre los botones
																			pp2s.setName("prueba"+x+i+o);	//nombramos el boton para saber cual es (sacar de la bd)
																			panel1s.updateUI(); //actualizamos el panel1 a parte creo que esto sobra pero soy gilipollas y no tengo tiempo para mirarlo
																			pp2s.addActionListener(new ActionListener () {
						
																		
																				@Override
																				public void actionPerformed(ActionEvent arg0) {
																					// TODO Auto-generated method stub
																					//me cago en dioooooooooooooooooooooososososoossos
																					enQuePanel=0;
																					platoSegundo=pp2s.getNombre();
																					for (int j = 0; j < panelessegundo.size(); j++) {
																						panelessegundo.get(j).setVisible(false);
																						panelessegundo.get(j).setEnabled(false);
																					}
																					for (int j = 0; j < botonessegundo.size(); j++) {
																						botonessegundo.get(j).setEnabled(false);
																						botonessegundo.get(j).setVisible(false);
																					}
																					for (int k = 0; k < cambiosegundo.size(); k++) {
																						cambiosegundo.get(k).setEnabled(false);
																						cambiosegundo.get(k).setVisible(false);
																					}
																					enQuePlato++;
																					Paneles panel1p =  new Paneles(){
																						public void paintComponent(Graphics g) {
																					        Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
																					        Graphics bufferGraphics = bufferImage.getGraphics();
																					        bufferGraphics.drawImage(imagenInicio.getImage(), 0, 0, 1080, 720, null);
																					        g.drawImage(bufferImage, 0, 0, this);
																					       
																					    }
																			       };
																					CrearPanel(panel1p);
																					
																					
																					panelespostre.add(panel1p);
																					frame.getContentPane().add(panel1p);
																					panelespostre.get(0).updateUI();
																					todosPaneles.add(panel1p);
																					int sp= 40;
																					
																					int pp = 185;
																					CambiarPanel(panelessegundo.get(enQuePanel), panelespostre.get(0));
																					for (int x = 0; x <(int)Math.ceil((double)nombrepostre.size()/9) ; x++) { //creamos 40 paneles (eso tiene que cambiar con la bd)
																						Paneles panelesMultpos = new Paneles();  //creamos mas paneles
																						JLabel lpostre = new JLabel();
																						lpostre.setBounds(400, 50, 1000, 40);
																						
																					       lpostre.setFont(titulos);
																					       lpostre.setForeground(Color.WHITE);
																					       lpostre.setSize(500, 50);
																					       lpostre.setText("Postre");
																						panelesMultpos.setName("panelesMult" + x); //le ponemos un nombre
																						CrearPanel(panelesMultpos);  //Le damoslos datos basicos
																						frame.getContentPane().add(panelesMultpos); //lo añadimos al frame
																						panelespostre.add(panelesMultpos);  //Lo metemos en el array de paneles
																						panelespostre.get(x).add(lpostre);
																						Botones botonSiguientePanelpostre = new Botones(); //Creamos el boton para pasar al siguiente panel
																						botonSiguientePanelpostre.setBounds(240,575, 300, 75); //La posicion del boton
																						botonSiguientePanelpostre.setNombre("siguiente panel");
																						Botones botonAnteriorPanelPostre= new Botones(); //Creamos el boton para pasar al siguiente panel
																						botonAnteriorPanelPostre.setBounds(640, 575, 300, 75); //La posicion del boton
																						botonAnteriorPanelPostre.setNombre("Anterior panel");
																						
																						todosPaneles.add(panelesMultpos);
																						if ((int)Math.ceil((double)nombrepostre.size()/9)-(x+1)>0) {
																							cambiopostre.add(botonSiguientePanelpostre);  //Lo añadimos al array de botones
																							panelespostre.get(x).add(botonSiguientePanelpostre); //añadimos el boton para cambiar de panel a cada panel
																							panelespostre.get(x).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
																							cambiopostrea.add(botonAnteriorPanelPostre);  //Lo añadimos al array de botones
																							panelespostre.get(x+1).add(botonAnteriorPanelPostre); //añadimos el boton para cambiar de panel a cada panel
																							panelespostre.get(x+1).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
																								
																						}
																						
																						
																						botonSiguientePanelpostre.addActionListener(new ActionListener() {
																						
																							@Override
																							public void actionPerformed(ActionEvent arg0) {
																								// TODO Auto-generated method stub
																								
																								CambiarPanel(panelespostre.get(pruebap), panelespostre.get(pruebap+1)); //Cambiamos de paneles prueba elige el numero de panel
																								
																								pruebap++; //Incrementamos prueba para que se pueda pasar de panel
																								enQuePanel = pruebap;
																								
																							}
																							
																						});
																						botonAnteriorPanelPostre.addActionListener(new ActionListener() {
																							
																							@Override
																							public void actionPerformed(ActionEvent arg0) {
																								// TODO Auto-generated method stub
																								CambiarPanel(panelespostre.get(pruebap), panelespostre.get(pruebap-1)); //Cambiamos de paneles prueba elige el numero de panel
																								
																								pruebap--; //Incrementamos prueba para que se pueda pasar de panel
																								enQuePanel = pruebap;
																								
																							}
																							
																						});
																						if (x==0&&(int)Math.ceil((double)nombrepostre.size()/9)-(x+1)>0) {  //si es el primer panel se añade un boton a panel1 para pasar al panel siguiente
																							panel1p.add(cambiopostre.get(0)); 
																						}
																						if (creafilaspos/3>3) {
																							creafilaspos=creafilaspos-9;
																						} else {
																							valorAmeterfpo=(int)Math.ceil(creafilaspos/3);
																						}
																						for (int i = 0; i < valorAmeterfpo; i++) {//son filas columnas de botones por panel
																							if (creacolpos>3) {
																								creacolpos=creacolpos-3;
																							} else {
																								valorAmetercpo=(int)Math.ceil(creacolpos);
																							}
																				
																							for (int o = 0; o < valorAmetercpo; o++) {//son tres columnas de botones por panel
																								
																								Botones pp2p = new Botones(); //Creamos el boton del plato
																								//CrearBoton(pp2);
																								
																								pp2p.setBounds(sp, pp,300, 75); // con s y p vamos cambiando la posicion del siguiente boton
																								pp2p.setNombre(nombrepostre.get(contPostre)); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
																								contPostre++;
																								botonespostre.add(pp2p); //añadimos el boton al arraylist de botones
																								sp=320+sp; //Incrementamos s para que el boton siguiente este a la izquierda
																								panelespostre.get(x).add(pp2p); //añadimos el boton al panel correspondiente
																								panelespostre.get(x).updateUI(); //actualizamos el panel para que muestre los botones
																								pp2p.setName("prueba"+x+i+o);	//nombramos el boton para saber cual es (sacar de la bd)
																								panel1p.updateUI(); //actualizamos el panel1 a parte creo que esto sobra pero soy gilipollas y no tengo tiempo para mirarlo
																								pp2p.addActionListener(new ActionListener () {
						
																							
																									@Override
																									public void actionPerformed(ActionEvent arg0) {
																										// TODO Auto-generated method stub
																										//me cago en dioooooooooooooooooooooososososoossos
																										enQuePanel=0;
																										platoPostre=pp2p.getNombre();
																										for (int j = 0; j < panelespostre.size(); j++) {
																											panelespostre.get(j).setEnabled(false);
																											panelespostre.get(j).setVisible(false);
																										}
																										for (int j = 0; j < botonespostre.size(); j++) {
																											botonespostre.get(j).setEnabled(false);
																											botonespostre.get(j).setVisible(false);
																										}
																										for (int k = 0; k < cambiopostre.size(); k++) {
																											cambiopostre.get(k).setEnabled(false);
																											cambiopostre.get(k).setVisible(false);
																										}
																										enQuePlato++;
																										Paneles panel1b =  new Paneles(){
																											public void paintComponent(Graphics g) {
																										        Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
																										        Graphics bufferGraphics = bufferImage.getGraphics();
																										        bufferGraphics.drawImage(imagenInicio.getImage(), 0, 0, 1080, 720, null);
																										        g.drawImage(bufferImage, 0, 0, this);
																										       
																										    }
																								       };
																										CrearPanel(panel1b);
																										
																										
																										panelesbebida.add(panel1b);
																										frame.getContentPane().add(panel1b);
																										panelesbebida.get(0).updateUI();
																										todosPaneles.add(panel1b);
																										int sb= 40;
																										
																										int pb = 185;
																										
																										for (int x = 0; x <(int)Math.ceil((double)nombrebeb.size()/9); x++) { //creamos 40 paneles (eso tiene que cambiar con la bd)
																											Paneles panelesMultbeb = new Paneles();  //creamos mas paneles
																											JLabel lbebida = new JLabel();
																											lbebida.setBounds(400, 50, 1000, 40);
																											
																										       lbebida.setFont(titulos);
																										       lbebida.setForeground(Color.WHITE);
																										       lbebida.setSize(500, 50);
																										       lbebida.setText("Bebida");
																											panelesMultbeb.setName("panelesMult" + x); //le ponemos un nombre
																											CrearPanel(panelesMultbeb);  //Le damoslos datos basicos
																											frame.getContentPane().add(panelesMultbeb); //lo añadimos al frame
																											panelesbebida.add(panelesMultbeb);  //Lo metemos en el array de paneles
																											panelesbebida.get(x).add(lbebida);
																											todosPaneles.add(panelesMultbeb);
																											Botones botonSiguientePanelbebida = new Botones(); //Creamos el boton para pasar al siguiente panel
																											botonSiguientePanelbebida.setBounds(240,575, 300, 75); //La posicion del boton
																											botonSiguientePanelbebida.setNombre("siguiente panel");
																											Botones botonAnteriorPanelBebida= new Botones(); //Creamos el boton para pasar al siguiente panel
																											botonAnteriorPanelBebida.setBounds(640, 575, 300, 75); //La posicion del boton
																											botonAnteriorPanelBebida.setNombre("Anterior panel");
																											
																											if ((int)Math.ceil((double)nombrepostre.size()/9)-(x+1)>0) {
																												cambiobebida.add(botonSiguientePanelbebida);  //Lo añadimos al array de botones
																												panelesbebida.get(x).add(botonSiguientePanelbebida); //añadimos el boton para cambiar de panel a cada panel
																												panelesbebida.get(x).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
																												cambiobebidaa.add(botonAnteriorPanelBebida);  //Lo añadimos al array de botones
																												panelesbebida.get(x+1).add(botonAnteriorPanelBebida); //añadimos el boton para cambiar de panel a cada panel
																												panelesbebida.get(x+1).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
																													
																											}
																											
																											botonSiguientePanelbebida.addActionListener(new ActionListener() {
																										
																												@Override
																												public void actionPerformed(ActionEvent arg0) {
																													// TODO Auto-generated method stub
																													
																													CambiarPanel(panelesbebida.get(pruebab), panelesbebida.get(pruebab+1)); //Cambiamos de paneles prueba elige el numero de panel
																													pruebab++; //Incrementamos prueba para que se pueda pasar de panel
																													enQuePanel = pruebab;
																													
																												}
																												
																											});
																											botonAnteriorPanelBebida.addActionListener(new ActionListener() {
																												
																												@Override
																												public void actionPerformed(ActionEvent arg0) {
																													// TODO Auto-generated method stub
																													CambiarPanel(panelespostre.get(pruebab), panelespostre.get(pruebab-1)); //Cambiamos de paneles prueba elige el numero de panel
																													
																													pruebab--; //Incrementamos prueba para que se pueda pasar de panel
																													enQuePanel = pruebab;
																													
																												}
																												
																											});
																											if (x==0&&(int)Math.ceil((double)nombrepostre.size()/9)-(x+1)>0) {  //si es el primer panel se añade un boton a panel1 para pasar al panel siguiente
																												panel1b.add(cambiobebida.get(0)); 
																											}
																											if (creafilasbeb/3>3) {
																												creafilasbeb=creafilasbeb-9;
																											} else {
																												valorAmeterfb=(int)Math.ceil(creafilasbeb/3);
																											}
																											for (int i = 0; i < valorAmeterfb; i++) {//son filas columnas de botones por panel
																												if (creacolbeb>3) {
																													creacolbeb=creacolbeb-3;
																												} else {
																													valorAmetercb=(int)Math.ceil(creacolbeb);
																												}
																									
																												for (int o = 0; o < valorAmetercb; o++) {//son tres columnas de botones por panel
																													
																													Botones pp2b = new Botones(); //Creamos el boton del plato
																													//CrearBoton(pp2);
																													
																													pp2b.setBounds(sb, pb,300, 75); // con s y p vamos cambiando la posicion del siguiente boton
																													pp2b.setNombre(nombrebeb.get(contcontbebida)); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
																													contcontbebida++;
																													botonesbebida.add(pp2b); //añadimos el boton al arraylist de botones
																													sb=320+sb; //Incrementamos s para que el boton siguiente este a la izquierda
																													panelesbebida.get(x).add(pp2b); //añadimos el boton al panel correspondiente
																													panelesbebida.get(x).updateUI(); //actualizamos el panel para que muestre los botones
																													pp2b.setName("prueba"+x+i+o);	//nombramos el boton para saber cual es (sacar de la bd)
																													panel1b.updateUI(); //actualizamos el panel1 a parte creo que esto sobra pero soy gilipollas y no tengo tiempo para mirarlo
																													pp2b.addActionListener(new ActionListener () {
						
																												
																														@Override
																														public void actionPerformed(ActionEvent arg0) {
																															// TODO Auto-generated method stub
																															//me cago en dioooooooooooooooooooooososososoossos
																															platoBebida=pp2b.getNombre();
																															for (int j = 0; j < panelesbebida.size(); j++) {
																																panelesbebida.get(j).setVisible(false);
																																panelesbebida.get(j).setEnabled(false);
																															}
																															for (int j = 0; j < botonesbebida.size(); j++) {
																																botonesbebida.get(j).setEnabled(false);
																																botonesbebida.get(j).setVisible(false);
																															}
																															for (int k = 0; k < cambiobebida.size(); k++) {
																																cambiobebida.get(k).setEnabled(false);
																																cambiobebida.get(k).setVisible(false);
																															}
																															enQuePanel=0;
																															
																															lgastado.setFont(newFont);
																															lgastado.setBounds(300, 200, 200, 200);
																															lgastado.setFont(newFont);
																															
																															//pedido.addAlCarrito(pp2e.getNombre());
																															//Comida(501,pp2e.getNombre(),30,0);
																															//carta.setEntrantes(pp2e.getNombre());
																															/*Connection conn = BD.initBD();
																															Statement st=null;
																															try {
																																st = conn.createStatement();
																															} catch (SQLException e) {
																																// TODO Auto-generated catch block
																																e.printStackTrace();
																															}*/
																															
																															double precioentrante =precioentr.get(enquepos(nombreentr, platoEntrantes));
																															double precioprimero =precioentr.get(enquepos(nombreentr, platoPrimero));
																															double preciosegundo =precioentr.get(enquepos(nombreentr, platoSegundo));
																															double preciopostre =precioentr.get(enquepos(nombreentr, platoPostre));
																															double preciobebida =precioentr.get(enquepos(nombreentr, platoBebida));
																															JLabel nomentr =new JLabel();
																																nomentr.setFont(newFont);
																																nomentr.setText(platoEntrantes);
																																//nomentr.setBounds(,,,);
																																panelFactura.add(nomentr);
																															JLabel precentr = new JLabel();
																																precentr.setFont(newFont);
																																precentr.setText("-"+precioentrante);
																																//precentr.setBounds(,,,);
																																panelFactura.add(nomentr);
																																
																															JLabel nomprim = new JLabel();
																																nomprim.setFont(newFont);
																																nomprim.setText(platoPrimero);
																																//nomprim.setBounds(,,,);
																																panelFactura.add(nomprim);
																																//entr.setBounds(x, y, width, height);
																															lgastado.setText(pp2e.getNombre()+ "\n"+ pp2primero.getNombre() + "\n"+pp2s.getNombre()+"\n"+pp2p.getNombre()+"\n"+pp2b.getNombre());
																															//
																															//BD.Insert(st, "109, 'Alubias', 13, 1", "comida");a
																															panelFactura.updateUI();
																															
																															CambiarPanel(panelesbebida.get(enQuePanel), panelFactura);
																															
																														}
																														
																													});
																													//pp2.setActionCommand(pp2.getText());	//Aqui hay que coger de la base de datos el nombre
																													//mikel
																													//entrantes
																													
																											
																										    	}
																													
																											
																												pb=pb+100;//aumentamos la y de los botones
																												sb=40;//iniciamos la columna de nuevo
																												//he borrado borrarbi++;
																											}
																											sb=40;//iniciamos la columna de nuevo
																											pb=185; //iniciamos
																										}
																										CambiarPanel(panelespostre.get(enQuePanel), panelesbebida.get(0));
																																	
																								
																									}
																									
																								});
																									
																								//pp2.setActionCommand(pp2.getText());	//Aqui hay que coger de la base de datos el nombre
																								
																								//he borrado borrarbo++;
																								
																					    	}
																						
																							pp=pp+100;//aumentamos la y de los botones
																							sp=40;//iniciamos la columna de nuevo
																							//he borrado borrarbi++;
																						}
																						sp=40;//iniciamos la columna de nuevo
																						pp=185; //iniciamos
																					}
																					CambiarPanel(panelessegundo.get(enQuePanel), panelespostre.get(0));
																					
																				}
																				
																			});
																			
																			
																    	}
																	
																		ps=ps+100;//aumentamos la y de los botones
																		ss=40;//iniciamos la columna de nuevo
																		//he borrado borrarbi++;
																	}
																	ss=40;//iniciamos la columna de nuevo
																	ps=185; //iniciamos
																}
																CambiarPanel(panelesprimero.get(enQuePanel), panelessegundo.get(0));
																
															}
															
														});
														//pp2.setActionCommand(pp2.getText());	//Aqui hay que coger de la base de datos el nombre
														
														//he borrado borrarbo++;
														
											    	}
												
													ppr=ppr+100;//aumentamos la y de los botones
													spr=40;//iniciamos la columna de nuevo
													//he borrado borrarbi++;
												}
												
												spr=40;//iniciamos la columna de nuevo
												ppr=185; //iniciamos
											}
											CambiarPanel(panelesentrantes.get(enQuePanel), panelesprimero.get(0));
										}
				
			});
			//pp2.setActionCommand(pp2.getText());	//Aqui hay que coger de la base de datos el nombre
			
			//he borrado borrarbo++;
			
    						}
	
								pe=pe+100;//aumentamos la y de los botones
								se=40;//iniciamos la columna de nuevo
								//he borrado borrarbi++;
							}
								se=40;//iniciamos la columna de nuevo
								pe=185; //iniciamos
							}
								


											
											
						
				}
		    	   
				
			});
			
					
				
			
		
		/*	confirmarFactura.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String nombreElegido =platoEntrantes;
					String fechacom[] = tFecha.getText().split("/"); 




				   String horacom[] = tHora.getText().split(":");


				   mes =Integer.parseInt(fechacom[0]); 

				   dia =Integer.parseInt(fechacom[1]); 

				   anyo=Integer.parseInt(fechacom[2]); 

				   hora =Integer.parseInt(horacom[0]); 

				   minuto =Integer.parseInt(horacom[1]); 
				       Calendar calendario = new GregorianCalendar(anyo, mes, dia, hora, minuto); 
				       //se colocan las fechas
				       
				     //  horaentregares = calendario.getTime();

				       if (bpedido==true) {
				    	   for (Comida entrante : carta.entrantes) {
								if(entrante.getNombre().equals(nombreElegido)) {
									pedido.setEntrante(entrante);
								}
							} 
							//primero
							nombreElegido = platoPrimero;
							for (Comida primero : carta.primeros) {
								if(primero.getNombre().equals(nombreElegido)) {
									pedido.setPrimero(primero);
								}
							}
							//segundo
							nombreElegido = platoSegundo;
							for (Comida segundo : carta.segundos) {
								if(segundo.getNombre().equals(nombreElegido)) {
									pedido.setSegundo(segundo);
								}																																																										
							}
							//postre
							nombreElegido = platoPostre;
							for (Comida postre : carta.postres) {
								if(postre.getNombre().equals(nombreElegido)) {
									pedido.setPostre(postre);
								}
							}
							//bebida
							nombreElegido = platoBebida;
							for (Bebida bebida : carta.bebidas) {
								if(bebida.getNombre().equals(nombreElegido)) {
									pedido.setBebida(bebida);
								}
							}
						 System.out.println(fechaentrega); 
						       

						//pedido.setFecha(fechaentrega); 

				    	pedido.insertPedido(nombreUsuario);
					}else {
						
						//reserva.setFecha(fechaentrega);

						 pedido.setFecha(calendario);
						 //direcciones
						 String dir = tCalle.getText() +" "+ tEdificio+" "+tPiso+" "+ tLetra;
						 pedido.setDireccion(dir);
						 pedido.setDineroGastado();
						 pedido.insertPedido(nombreUsuario);
				    
				    	
					}else {//se introducen los valores
						reserva.setFecha(calendario);				

						reserva.setBebida(platoBebida);
						reserva.setEntrante(platoEntrantes);
						reserva.setPrimero(platoPrimero);
						reserva.setSegundo(platoSegundo);
						reserva.setPostre(platoPostre);
						reserva.setUsername(nombreUsuario);
						Connection conn = BD.initBD();
						
					
						try {
							Statement st = conn.createStatement();
							BD.Insert(st, reserva.toString(), "reserva");//se sube a la BD
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("'"+nombreUsuario+"','"+fechaentregares+"',"+null+",'"+platoEntrantes+"','"+platoPrimero+"','"+platoSegundo+"','"+platoPostre+"','"+platoBebida+"'");
						//BD.Insert(st, "'"+nombreUsuario+"','"+fechaentregares+"',"+null+",'"+platoEntrantes+"','"+platoPrimero+"','"+platoSegundo+"','"+platoPostre+"','"+platoBebida+"'", "reserva");
						//String username, Date fecha, Time hora, String entrante, String primero, String segundo,
						//String postre, String bebida
						// reserva.setFecha(fechaentrega); 
					}
					
				      
					//pedido.setFecha()
				}
				
			});*/
		     
		       

			
     
       
       
      

       
       cbb1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Connection conn = BD.initBD();
			
			Statement st=null;
		
			try {
				st = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			//System.out.println(nombreentr);
			//System.out.println(tNombreProd.getText());
			if (cOrden.getSelectedIndex()==0) {
				for (int i = 0; i < nombreentr.size(); i++) {
					if (tNombreProd.getText().isEmpty()==true||nombreentr.get(i).toUpperCase().equals(tNombreProd.getText().toUpperCase())||esNumerico(cbt2.getText())==false) {
						esnomentr=true;
					}
				}
				if (esnomentr==false) {
					
					BD.Insert(st, "'"+ tNombreProd.getText()+"'"+" , "+cbt2.getText()+" , "+(cOrden.getSelectedIndex()+1), "comida");
					
				}else {
					JOptionPane.showMessageDialog(null, "Ya existe un producto con ese nombre o el formato del precio no es valido");
				}
				
				
			}else if (cOrden.getSelectedIndex()==1) {
				
				for (int i = 0; i < nombreprimero.size(); i++) {
					if (tNombreProd.getText().isEmpty()==true||nombreprimero.get(i).toUpperCase().equals(tNombreProd.getText().toUpperCase())||esNumerico(cbt2.getText())==false) {
						esnomentr=true;
					}
				}
				if (esnomentr==false) {
					BD.Insert(st, "'"+ tNombreProd.getText()+"'"+" , "+cbt2.getText()+" , "+(cOrden.getSelectedIndex()+1), "comida");
					
				}else {
					JOptionPane.showMessageDialog(null, "Ya existe un producto con ese nombre");
				}
				
				
			}else if (cOrden.getSelectedIndex()==2) {
				for (int i = 0; i < nombresegundo.size(); i++) {
					if (tNombreProd.getText().isEmpty()==true||nombresegundo.get(i).toUpperCase().equals(tNombreProd.getText().toUpperCase())||esNumerico(cbt2.getText())==false) {	
						esnomentr=true;
					}
				}
				if (esnomentr==false) {
					
					BD.Insert(st, "'"+ tNombreProd.getText()+"'"+" , "+cbt2.getText()+" , "+(cOrden.getSelectedIndex()+1), "comida");
					
				}else {
					JOptionPane.showMessageDialog(null, "Ya existe un producto con ese nombre");
				}

				
			}else if (cOrden.getSelectedIndex()==3) {
				for (int i = 0; i < nombrepostre.size(); i++) {
					if (tNombreProd.getText().isEmpty()==true||nombrepostre.get(i).toUpperCase().equals(tNombreProd.getText().toUpperCase())||esNumerico(cbt2.getText())==false) {
						esnomentr=true;
					}
				}
				if (esnomentr==false) {
					;
					BD.Insert(st, "'"+ tNombreProd.getText()+"'"+" , "+cbt2.getText()+" , "+(cOrden.getSelectedIndex()+1), "comida");
					
				}else {
					JOptionPane.showMessageDialog(null, "Ya existe un producto con ese nombre");
				}
			}else if (cOrden.getSelectedIndex()==4) {
				for (int i = 0; i < nombrebeb.size(); i++) {
					if (tNombreProd.getText().isEmpty()==true||nombrebeb.get(i).toUpperCase().equals(tNombreProd.getText().toUpperCase())||esNumerico(cbt2.getText())==false) {
						esnomentr=true;
					}
				}
				if (esnomentr==false) {
					
					if (rootPaneCheckingEnabled) {
						
					}
					BD.Insert(st, "'"+ tNombreProd.getText()+"'"+" , "+cbt2.getText()+" , "+ch.isSelected(), "bebida");
					
				}else {
					JOptionPane.showMessageDialog(null, "Ya existe un producto con ese nombre");
				}
			}
			tNombreProd.setText("");
			esnomentr=false;
		}
	});
    
    usern.addActionListener(new ActionListener() {
   		
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			String a =JOptionPane.showInputDialog(null, "Introduzca nuevo usuario", "Cambiar nombre de usuario", 1);
   			Connection conn = BD.initBD();
			
			Statement st=null;
		
			try {
				st = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
   			if ((a != null) && (a.length() > 0)) {
   			 BD.Update(st, " username", "'"+a+"'", "username ='"+nombreUsuario+"'", "usuario");
   			}

   		}
   	});   
    
    passw.addActionListener(new ActionListener() {
		
		@Override//
		public void actionPerformed(ActionEvent e) {

			Connection conn = BD.initBD();
			
			Statement st=null;
		
			try {
				st = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			   

			String b =JOptionPane.showInputDialog(null, "Introduzca nueva contraseña", "Cambiar contraseña", 1);
			if ((b != null) && (b.length() > 0)) {
			    BD.Update(st, " password", "'"+b+"'", "username ='"+nombreUsuario+"'", "usuario");
			}
		
		}
	});    
       
    name.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Connection conn = BD.initBD();
			
			Statement st=null;
		
			try {
				st = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String c =JOptionPane.showInputDialog(null, "Introduzca nuevo nombre", "Cambiar nombre", 1);
			if ((c != null) && (c.length() > 0)) {
				 BD.Update(st, "nombre", "'"+c+"'", "username ='"+nombreUsuario+"'", "usuario");
			    
			}

		}
	}); 
    
    surname.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Connection conn = BD.initBD();
			
			Statement st=null;
		
			try {
				st = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String d =JOptionPane.showInputDialog(null, "Introduzca nuevos apellidos", "Cambiar apellidos", 1);
			if ((d != null) && (d.length() > 0)) {
				 BD.Update(st, "apellidos", "'"+d+"'", "username ='"+nombreUsuario+"'", "usuario");
			}

		}
	});
    other.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int panelsito =enquepan(todosPaneles);
			for (int i = 0; i < todosPaneles.size(); i++) {
				for (Component sp : todosPaneles.get(i).getComponents() ){
			        sp.setEnabled(false);
			        sp.setVisible(false);
			        
				}
			}
			CambiarPanel(todosPaneles.get(panelsito), panelInicio);
		}
	});
     cancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int panelsito =enquepan(todosPaneles);
			for (int i = 0; i < todosPaneles.size(); i++) {
				for (Component sp : todosPaneles.get(i).getComponents() ){
			        sp.setEnabled(false);
			        sp.setVisible(false);
				}
			}
			CambiarPanel(todosPaneles.get(panelsito), panelInicioSesion);
			nombreUsuario="";
		}
	});
    
       
       panelInicio.add(bPanelRecogerDomicilio);
       panelInicio.add(bPanelReserva);
       
       panelInicio.add(bPanelAdmin);
       
       panelAdmin.add(bPanelBebidaComida);
       panelAdmin.add(bPanelAddBoton);
       
      
       
      
       panelReserva.updateUI();
       panelRecogerDomicilio.add(bPanelRecogida);

       panelRecogerDomicilio.add(bPanelDomicilio);       

       panelRecogerDomicilio.add(bPanelDomicilio);  
       
       //Nko
       //panelRecogida
       panelRegistrarse.add(lURegistro);
       panelRegistrarse.add(lCRegistro);
       panelRegistrarse.add(lNRegistro);
       panelRegistrarse.add(lARegistro);
       panelRegistrarse.add(lTRegistro);
       panelRegistrarse.add(tURegistro);
       panelRegistrarse.add(tCRegistro);
       panelRegistrarse.add(tNRegistro);
       panelRegistrarse.add(tARegistro);
       panelRegistrarse.add(tTRegistro);
       panelRegistrarse.add(bConfirmarRegistro);
       
       panelDomicilio.add(lCalle);
       panelDomicilio.add(lEdificio);
       panelDomicilio.add(lPiso);
       panelDomicilio.add(lLetra);
      
       panelDomicilio.add(lfechaEntrega);

       panelDomicilio.add(tCalle);
       panelDomicilio.add(tEdificio);
       panelDomicilio.add(tPiso);
       panelDomicilio.add(tLetra);
   
       panelDomicilio.updateUI();
       
      
       panelRecogida.updateUI();
       
       panelFactura.add(precio);
       panelFactura.add(iva);
       panelFactura.add(lgastado);
       panelFactura.add(confirmarFactura);
       
       panelBebidaComida.add(bPanelQuitComida);
       panelBebidaComida.add(bPanelQuitBebida);
       
       panelQuitComida.add(lQuitComida);
       panelQuitComida.add(tQuitComida);
       panelQuitComida.add(bQuitComida);
       
       panelQuitBebida.add(lQuitBebida);
       panelQuitBebida.add(tQuitBebida);
       panelQuitBebida.add(bQuitBebida);
       
       panelMesa.add(bPrimerPlato);
       
    
       
       panelAddBoton.add(cbb1);
       panelAddBoton.add(tNombreProd);
       panelAddBoton.add(cbt2);
       panelAddBoton.add(lNombrarProd);
       panelAddBoton.add(lTituloPAddBoton);
       panelAddBoton.add(ch);
       panelAddBoton.add(cbl5);
       panelAddBoton.add(lTipo);
       panelAddBoton.add(cOrden);
       
       panelAddBoton.updateUI();
       
       panelInicioSesion.add(lUsuario);
       panelInicioSesion.add(lContraseña);
       panelInicioSesion.add(bRegistrarse);
       panelInicioSesion.add(bIniciar);
       panelInicioSesion.add(tUsuario);
       panelInicioSesion.add(tPassword);
       panelFactura.add(fl1);
       panelFactura.add(fl2);
       panelFactura.add(confirmarFactura);
       
       ImageIcon imagenIcono = new ImageIcon(this.getClass().getClassLoader().getResource("frame/Captura de pantalla (43).png"));
       frame.setIconImage(imagenIcono.getImage());
       frame.setBounds(350, 300, 1080, 720);
       frame.setVisible(true);
       frame.setTitle("Insertar nombre");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       frame.setLayout(null);  
       frame.setTitle("Bora");
       frame.getContentPane().add(panelInicioSesion);
       frame.getContentPane().add(panelBienvenida);
       frame.getContentPane().add(panelInicio);
       frame.getContentPane().add(panelAdmin);
       frame.getContentPane().add(panelCambioContraseña);
       frame.getContentPane().add(panelCambioUsuario);
       frame.getContentPane().add(panelCambioNombre);
       frame.getContentPane().add(panelCambioApellido);
  
       frame.getContentPane().add(panelQuitComida);
       frame.getContentPane().add(panelQuitBebida);
       frame.getContentPane().add(panelBebidaComida);
       frame.getContentPane().add(panelAddBoton);
       
       frame.getContentPane().add(panelReserva);
       frame.getContentPane().add(panelMesa);
       
       //Nko
       frame.getContentPane().add(panelRegistrarse); //??????????????????????????????????
       
       frame.getContentPane().add(panelRecogerDomicilio);
       frame.getContentPane().add(panelRecogida);
       frame.getContentPane().add(panelDomicilio);
       
      
       frame.getContentPane().add(panelQuitBebida);

       frame.getContentPane().add(panelFactura);
       //frame.getContentPane().add(menuBar);
   		
   		System.out.println(enQuePanel(frame));
	}
	
	public void CrearBoton(JButton g) {

		g.setOpaque(false);
		g.setContentAreaFilled(false);
		g.setBorderPainted(false);
	}
	
	public void CambiarPanel(JPanel g, JPanel h) {
		g.setVisible(false);
		g.setEnabled(false);
		h.setVisible(true);
		h.setEnabled(true);
		for (Component cp : g.getComponents() ){
			cp.setEnabled(false);
			cp.setVisible(false);
		}
		for (Component sp : h.getComponents() ){
	        sp.setEnabled(true);
	        sp.setVisible(true);
		}
		
			//h.add(bReturn);
		
		
	}
	public String enQuePanel(Frame a) {
		
		for (Component cp :a.getComponents()  ){
			if (a.isEnabled()==true) {
				
				cp.getName();
			}
		}
		return " ";
		
			//h.add(bReturn);
		
		
	}
	public static boolean esNumerico(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)&&c!='.') return false;
	    }
	    return true;
	}
	
	

	public void CrearPanel(JPanel g) {
		g.setLayout(null);
		g.setVisible(false);
		g.setEnabled(false);
		g.setBounds(0, 0, 1080, 720);
		
		

	}
	
	public int enquepos(List<String> g, String n) {
		for (int i = 0; i < g.size(); i++) {
			if (g.get(i).equals(n)) {
				x=i;
			}
		}
		return x;
		
	}	
	public int enquepan(ArrayList<Paneles> g) {
		for (int i = 0; i < g.size(); i++) {
			if (g.get(i).isEnabled()==true) {
				x=i;
			}
		}
		return x;
		
	}	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Principal();

			}

		});
	}
}