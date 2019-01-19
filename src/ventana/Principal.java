package ventana;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.PanelUI;
import javax.swing.text.NumberFormatter;

import Comida.*;

import sun.applet.AppletPanel;

public class Principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Carta carta = new Carta();
	Boolean bpAdmin = false,bpquitbotonComida=false,bpaddboton=false,bprecogerdomicilio=false, bprecogida=false, bpdomicilio=false,bpreserva=false;
	JButton  bPanelReserva, bPanelAdmin, bAddBoton, bQuitBoton, bPanelMesa, bPrimerPlato,  botonPruebas, bPanelRecogerDomicilio, bReturn, cbb1, bSelImg, bConfirmarDomicilio, bConfirmarRecogida;

	BotonesGrandes bPanelRecogida,bPanelDomicilio,bPanelQuitBebida, bPanelQuitComida, bPanelBebidaComida, bPanelAddBoton;

	JLabel  lQuitBebida, lQuitComida, lValidarTlfn,lUsuario, lContraseña, lNombrarProd, lTituloPAddBoton, lSelImagen, cbl5, fl1, fl2, facTotal, lTipo, lNombreC, lApellidoC, lHoraR, lPrimerPlato, lCalle, lEdificio, lPiso, lLetra, lNombre, lApellido, lHora, lTlfn, lNombre2, lApellido2, precio,iva, precioTotal;
	JComboBox cOrden, cHoraReserva;
	JTextField tQuitBebida, tQuitComida, tUsuario, tPassword, tNombreProd, cbt2, tNombreReserva, tApellidosReserva, tCalle, tEdificio, tPiso, tLetra, tNombre, tApellido, tHora, tTlfn, tNombre2, tApellido2;

	Font fuente;
	int contEntrantes= 0, contPrimero=0,contSegundo = 0, contPostre = 0, contcontbebida=0,enQuePlato= 0, pruebae =0, prueba = 0, pruebas =0, pruebap =0,pruebab =0, borrarbi = 0, borrarbo = 0, enQuePanel =0;
	private List<JButton> botonesprimero;
	//private List<JPanel> paneles;
	//Pruebas2
	
	int x = 1;
	public Principal() {
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
       Paneles panelInicioSesion = new Paneles();
       panelInicioSesion.setName("panelInicioSesion");
       Paneles panelInicio = new Paneles();//primer panel (el panel que pone bora)
       panelInicio.setName("panelInicio");
       Paneles panelAdmin = new Paneles();//En este panel eliges si comer en el restaurante o pedir la comida para llevar (tambien esta el boton admin)
       Paneles panelQuitBebida = new Paneles();
       Paneles panelBebidaComida = new Paneles();
       Paneles panelQuitComida = new Paneles(); //En este panel el admin puede quitar platos del menu
       Paneles panelAddBoton = new Paneles (); //En este panel el admin puede añadir platos a la comida
      
       Paneles panelReserva = new Paneles();

       Paneles panelMesa = new Paneles();
       
       Paneles panelRecogerDomicilio = new Paneles();
       Paneles panelRecogida = new Paneles();
       Paneles panelDomicilio = new Paneles ();
    
       Paneles panelEntrantes = new Paneles();
       Paneles panelPrimero = new Paneles();
       Paneles panelSegundo = new Paneles();
       Paneles panelPostre = new Paneles();
       
       
       Paneles panelFactura = new Paneles();
       
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
       
       CrearPanel(panelRecogerDomicilio);
       CrearPanel(panelRecogida);
       CrearPanel(panelDomicilio);
       
       CrearPanel(panelEntrantes);
       CrearPanel(panelPrimero);
       CrearPanel(panelSegundo);
       CrearPanel(panelPostre);
       CrearPanel(panelQuitBebida);
       
       CrearPanel(panelFactura);

       panelBienvenida.setVisible(true);
       panelBienvenida.setEnabled(true);

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
       lTituloPAddBoton = new JLabel();
       lSelImagen = new JLabel();
       lTipo = new JLabel();
       cOrden = new JComboBox();
       
       //Objetos panelQuitBoton
       bQuitBoton = new JButton();

       //Objetos panelReserva
       lNombreC = new JLabel ();
       lNombreC.setFont(newFont);
       lNombreC.setText("Nombre");
       lApellidoC = new JLabel ();
       lApellidoC.setFont(newFont);
       lApellidoC.setText("Apellidos");
       lHoraR = new JLabel();
       lHoraR = new JLabel();
       lHoraR.setFont(newFont);
       lHoraR.setText("Hora de la reserva");
       tApellidosReserva = new JTextField();
       tNombreReserva = new JTextField();
       cHoraReserva=new JComboBox();
       
       ImageIcon imagenBotonBlancoPeq = new ImageIcon(this.getClass().getClassLoader().getResource("p4/boton.jpg"));

       //Objetos PanelRecogerDomicilio
       bPanelRecogida = new BotonesGrandes();
       bPanelDomicilio = new BotonesGrandes();
       

       //Objetos panelRecogida
       lHora = new JLabel();
       tHora = new JTextField();
       lTlfn = new JLabel();
       lValidarTlfn = new JLabel();
       tTlfn = new JFormattedTextField(formatter);
     
       
       
       lNombre2 = new JLabel();
       tNombre2 = new JTextField();
       lApellido2 = new JLabel();
       tApellido2 = new JTextField();
       bConfirmarRecogida = new JButton();
       
       //Objetos panelDomicilio
       lCalle = new JLabel();
       tCalle = new JTextField();
       lEdificio = new JLabel();
       tEdificio = new JTextField();
       lPiso = new JLabel();
       tPiso = new JTextField();
       lLetra = new JLabel();
       tLetra = new JTextField();
       lNombre = new JLabel();
       tNombre = new JTextField();
       lApellido = new JLabel();
       tApellido = new JTextField();
       bConfirmarDomicilio = new JButton();
       

       //Objetos panelFactura (NO estan aqui todos los objetos¡¡¡)
       precio = new JLabel();
       iva = new JLabel();
       
       //objetos panelQuitBoton
       lQuitComida = new JLabel();
       tQuitComida = new JTextField();
      

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
       tPassword = new JTextField();
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
       

     //PANEL RECOGIDA LABEL Y TF
       lHora.setBounds(360, 250, 200, 40);
       lHora.setFont(newFont);
       lHora.setText("Hora");
       tHora.setBounds(300, 300, 200, 40);
       
       lTlfn.setBounds(660, 250, 200, 40);
       lTlfn.setFont(newFont);
       lTlfn.setText("Telefono");
       tTlfn.setBounds(600, 300, 200, 40);
       lValidarTlfn.setBounds(600, 350, 150, 20);
       lValidarTlfn.setForeground(Color.red);
       
       lNombre2.setBounds(360, 400, 200, 40);
       lNombre2.setFont(newFont);
       lNombre2.setText("Nombre");
       tNombre2.setBounds(300, 450, 200, 40);
       
       lApellido2.setBounds(660, 400, 200, 40);
       lApellido2.setFont(newFont);
       lApellido2.setText("Apellido");
       tApellido2.setBounds(600, 450, 200, 40);
       
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
      
      lNombre.setBounds(260, 450, 200, 40);
      lNombre.setFont(newFont);
      lNombre.setText("Nombre");
      tNombre.setBounds(200, 500, 200, 40);
      
      lApellido.setBounds(760, 450, 200, 40);
      lApellido.setFont(newFont);
      lApellido.setText("Apellido");
      tApellido.setBounds(700, 500, 200, 40);
      
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
       cbt2.setBounds(300, 340, 200, 40);
       
      
       lNombrarProd.setBounds(25, 250, 400, 40);
       lNombrarProd.setFont(newFont);
       lNombrarProd.setText("Nombra  el  producto");
       
       lTituloPAddBoton.setBounds(450, 100, 400, 40);
       lTituloPAddBoton.setFont(newFont);
       lTituloPAddBoton.setForeground(Color.white);
       lTituloPAddBoton.setText("Crear boton");
       
       
       lSelImagen.setBounds(25, 430, 400, 40);
       lSelImagen.setFont(newFont);
       lSelImagen.setText("Elegir imagen");
       
       lTipo.setBounds(700, 250, 300, 40);
       lTipo.setFont(newFont);
       lTipo.setText("Posicion del plato");
       
       cOrden.setFont(newFont);
       cOrden.addItem("1");
       cOrden.addItem("2");
       cOrden.addItem("3");
       cOrden.addItem("4");
       cOrden.addItem("5");
       cOrden.setBounds(705, 300, 200, 50);
 
       
       //Panel Reserva
       bPanelMesa.setBounds(390, 585, 300, 75);
       lNombreC.setBounds(240, 200, 400, 40);
       lApellidoC.setBounds(710, 200, 400, 40);    
       tNombreReserva.setBounds(130, 250, 300, 40);
       tApellidosReserva.setBounds(620, 250, 300, 40);
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

		
       
       frame.addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			CambiarPanel(panelBienvenida, panelInicioSesion);
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
      
       
		
		
       
       bIniciar.addActionListener(new ActionListener () {

   		@Override
   		public void actionPerformed(ActionEvent arg0) {
   			// TODO Auto-generated method stub
   			CambiarPanel(panelInicioSesion, panelInicio);
   			
   			
   		}
       	   
          });
       bRegistrarse.addActionListener(new ActionListener () {

   		@Override
   		public void actionPerformed(ActionEvent arg0) {
   			// TODO Auto-generated method stub
   			CambiarPanel(panelInicioSesion, panelInicio);
   		}
       	   
          });
       bPanelAdmin.addActionListener(new ActionListener () {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			CambiarPanel(panelInicio, panelAdmin); 
			if (bpAdmin == false) {
				panelAdmin.add(bReturn);
				bpAdmin=true;
			}
			
		}
    	   
       });
      
       bPanelRecogerDomicilio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelInicio, panelRecogerDomicilio); 
				if (bprecogerdomicilio==false) {
					panelRecogerDomicilio.add(bReturn);
					bprecogerdomicilio=true;
				}
				
			}

       });
       
       bPanelRecogida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelRecogerDomicilio, panelRecogida);
				if (bprecogida==false) {
					panelRecogida.add(bPanelMesa);
					panelRecogida.add(bReturn);
					bprecogida=true;
				}
				
			}

      });
       
       bPanelDomicilio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelRecogerDomicilio, panelDomicilio);
				if (bpdomicilio==false) {
					panelDomicilio.add(bPanelMesa);
					panelDomicilio.add(bReturn);
					bpdomicilio=true;
				}
				
			}

     }); 

       bPanelReserva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelInicio, panelReserva);
				if (bpreserva==false) {
					panelReserva.add(bPanelMesa);
					panelReserva.add(bReturn);
					bpreserva=true;
				}
				
				
			}

       });
      
       bPanelBebidaComida.addActionListener(new ActionListener () {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			CambiarPanel(panelAdmin, panelBebidaComida);
			
			/*if (bpquitboton==false) {
				panelQuitBoton.add(bReturn);
				bpquitboton=true;
			}*/
			//carta.getEntrantes()
			
		}
    	   
       });
       bPanelQuitBebida.addActionListener(new ActionListener () {

   		@Override
   		public void actionPerformed(ActionEvent e) {
   			// TODO Auto-generated method stub
   			CambiarPanel(panelBebidaComida, panelQuitBebida);
   			
   			/*if (bpquitboton==false) {
   				panelQuitBoton.add(bReturn);
   				bpquitboton=true;
   			}*/
   		
   			
   		}
       	   
       });
       bPanelQuitComida.addActionListener(new ActionListener () {

      		@Override
      		public void actionPerformed(ActionEvent e) {
      			// TODO Auto-generated method stub
      			CambiarPanel(panelBebidaComida, panelQuitComida);
      			
      			if (bpquitbotonComida==false) {
      				
      				panelQuitComida.add(bReturn);
      				bpquitbotonComida=true;
      			}
      			
      		}
          	   
         });
       bQuitBebida.addActionListener(new ActionListener () {

     		@Override
     		public void actionPerformed(ActionEvent e) {
     			// TODO Auto-generated method stub
     			/*if (poner que si existe un plato se haga esto) {
				JOptionPane.showMessageDialog(null, "Bebida Eliminada");
				} else {
				JOptionPane.showMessageDialog(null, "Bebida no eliminada");
				}*/
     			JOptionPane.showMessageDialog(null, "Bebida eliminada");
     			
     		}
         	   
        });
       bQuitComida.addActionListener(new ActionListener () {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			/*if (poner que si existe una bebida se haga esto) {
				JOptionPane.showMessageDialog(null, "Plato eliminado");
				} else {
				JOptionPane.showMessageDialog(null, "Plato no eliminado");
				}*/
    			JOptionPane.showMessageDialog(null, "Plato eliminado");
    			
    		}
        	   
       });
       bPanelAddBoton.addActionListener(new ActionListener () {

   		@Override
   		public void actionPerformed(ActionEvent e) {
   			// TODO Auto-generated method stub
   			CambiarPanel(panelAdmin, panelAddBoton);
   			if (bpaddboton==false) {
   				panelAddBoton.add(bReturn);
   				
   				bpaddboton=true;
			}
   			
   		}
       	   
        });
       
		
		

		
			
			
			
			
		
       	
		List<JButton> botonesentrantes, botonesprimero, botonessegundo, botonespostre, botonesbebida;//Arraylist de botones para guardar todos los botones creados
		List<JButton> cambioentrantes, cambioprimero, cambiosegundo, cambiopostre, cambiobebida;//Arraylist de botones para guardar todos los botones de cambio de panel
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
		panelesentrantes= new ArrayList<>();
		
		botonesprimero = new ArrayList<>();
		cambioprimero = new ArrayList<>();
		panelesprimero = new ArrayList<>();
		
		botonessegundo = new ArrayList<>();
		cambiosegundo = new ArrayList<>();
		panelessegundo = new ArrayList<>();
		
		botonespostre = new ArrayList<>();
		cambiopostre = new ArrayList<>();
		panelespostre = new ArrayList<>();
		
		botonesbebida = new ArrayList<>();
		cambiobebida = new ArrayList<>();
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
						panelesentrantes.get(x).add(lentrantes);
						JButton botonSiguientePanelentrantes = new JButton("siguiente panel"); //Creamos el boton para pasar al siguiente panel
						botonSiguientePanelentrantes.setBounds(390, 575, 300, 75); //La posicion del boton
						
						botonSiguientePanelentrantes.setName("bSiguiente"+x);  //Ponemos nombre al boton
						cambioentrantes.add(botonSiguientePanelentrantes);  //Lo añadimos al array de botones
						panelesentrantes.get(x).add(botonSiguientePanelentrantes); //añadimos el boton para cambiar de panel a cada panel
						panelesentrantes.get(x).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
						
						botonSiguientePanelentrantes.addActionListener(new ActionListener() {
					
							@Override
							public void actionPerformed(ActionEvent arg0) {
								//  TODO Auto-generated method stub
								
								CambiarPanel(panelesentrantes.get(pruebae), panelesentrantes.get(pruebae+1)); //Cambiamos de paneles prueba elige el numero de panel
								
								pruebae++; //Incrementamos prueba para que se pueda pasar de panel
								enQuePanel = pruebae;
								panelesentrantes.get(pruebae).add(botonSiguientePanelentrantes); //Añadimos el boton al panel es necesario repetir??(mirar arriba)
								panelesentrantes.get(pruebae).updateUI(); //Actualizamos el panel para que aparezca el boton, es realmente necesario repetirlo??
								
							}
							
						});
						if (x==0) {  //si es el primer panel se añade un boton a panel1 para pasar al panel siguiente
							panel1e.add(cambioentrantes.get(0)); 
						} else if (x>0) {//si no es el primer panel ponemos un boton al panel el cual sirva para pasar al siguiente panel
							//he quitadp panelesMult.getName();
							panelesMultent.add(cambioentrantes.get(x));
						}
						for (int i = 0; i < 3; i++) {//son filas columnas de botones por panel
							
				
							for (int o = 0; o < 3; o++) {//son tres columnas de botones por panel
								
								Botones pp2e = new Botones(); //Creamos el boton del plato
								//CrearBoton(pp2);
								
								pp2e.setBounds(se, pe,300, 75); // con s y p vamos cambiando la posicion del siguiente boton
								pp2e.setNombre("prueba"+enQuePlato+x+i+o); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
								botonesentrantes.add(pp2e); //añadimos el boton al arraylist de botones
								se=320+se; //Incrementamos s para que el boton siguiente este a la izquierda
								panelesentrantes.get(x).add(pp2e); //añadimos el boton al panel correspondiente
								panelesentrantes.get(x).updateUI(); //actualizamos el panel para que muestre los botones
								pp2e.setName("prueba"+x+i+o);	//nombramos el boton para saber cual es (sacar de la bd)
								panel1e.updateUI(); //actualizamos el panel1 a parte creo que esto sobra pero soy gilipollas y no tengo tiempo para mirarlo
								pp2e.addActionListener(new ActionListener () {

							
									@Override
									public void actionPerformed(ActionEvent arg0) {
										// TODO Auto-generated method stub
										//me cago en dioooooooooooooooooooooososososoossos
										enQuePanel=0;
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
										
						
											int spr= 40;
											
											int ppr = 185;
											
											for (int x = 0; x <40 ; x++) { //creamos 40 paneles (eso tiene que cambiar con la bd)
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
												JButton botonSiguientePanelprimero = new JButton("siguiente panel"); //Creamos el boton para pasar al siguiente panel
												botonSiguientePanelprimero.setBounds(390, 575, 300, 75); //La posicion del boton

												Paneles panelesMult = new Paneles();  //creamos mas paneles
												panelesMult.setName("panelesMult" + x); //le ponemos un nombre
												CrearPanel(panelesMult);  //Le damoslos datos basicos
												frame.getContentPane().add(panelesMult); //lo añadimos al frame
												panelesprimero.add(panelesMult);  //Lo metemos en el array de paneles
												JButton botonSiguientePanel = new JButton("siguiente panel"); //Creamos el boton para pasar al siguiente panel
												botonSiguientePanel.setBounds(390, 575, 300, 75); //La posicion del boton

												
												botonSiguientePanelprimero.setName("bSiguiente"+x);  //Ponemos nombre al boton
												panelesprimero.get(x).add(lprimero);
												cambioprimero.add(botonSiguientePanelprimero);  //Lo añadimos al array de botones
												panelesprimero.get(x).add(botonSiguientePanelprimero); //añadimos el boton para cambiar de panel a cada panel
												panelesprimero.get(x).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
												
												botonSiguientePanelprimero.addActionListener(new ActionListener() {
												
													@Override
													public void actionPerformed(ActionEvent arg0) {
														// TODO Auto-generated method stub
														CambiarPanel(panelesprimero.get(prueba), panelesprimero.get(prueba+1)); //Cambiamos de paneles prueba elige el numero de panel
														
														prueba++; //Incrementamos prueba para que se pueda pasar de panel
														enQuePanel = prueba;
														panelesprimero.get(prueba).add(botonSiguientePanelprimero); //Añadimos el boton al panel es necesario repetir??(mirar arriba)
														panelesprimero.get(prueba).updateUI(); //Actualizamos el panel para que aparezca el boton, es realmente necesario repetirlo??
														
													}
													
												});
												if (x==0) {  //si es el primer panel se añade un boton a panel1 para pasar al panel siguiente
													panel1primero.add(cambioprimero.get(0)); 
												} else if (x>0) {//si no es el primer panel ponemos un boton al panel el cual sirva para pasar al siguiente panel
													//he quitadp panelesMult.getName();
													panelesMultprim.add(cambioprimero.get(x));
												}
												for (int i = 0; i < 3; i++) {//son filas columnas de botones por panel
													
										
													for (int o = 0; o < 3; o++) {//son tres columnas de botones por panel
														
														JButton pp2primero = new JButton(); //Creamos el boton del plato
														//CrearBoton(pp2);
														pp2primero.setBounds(spr, ppr,300, 75); // con s y p vamos cambiando la posicion del siguiente boton
														pp2primero.setText("prueba"+enQuePlato+x+i+o); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
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
																
																int ss= 40;
																
																int ps = 185;
																
																for (int x = 0; x <40 ; x++) { //creamos 40 paneles (eso tiene que cambiar con la bd)
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
																	JButton botonSiguientePanelsegundo = new JButton("siguiente panel"); //Creamos el boton para pasar al siguiente panel
																	botonSiguientePanelsegundo.setBounds(390, 575, 300, 75); //La posicion del boton
																	
																	botonSiguientePanelsegundo.setName("bSiguiente"+x);  //Ponemos nombre al boton
																	cambiosegundo.add(botonSiguientePanelsegundo);  //Lo añadimos al array de botones
																	panelessegundo.get(x).add(botonSiguientePanelsegundo); //añadimos el boton para cambiar de panel a cada panel
																	panelessegundo.get(x).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
																	
																	botonSiguientePanelsegundo.addActionListener(new ActionListener() {
																	
																		@Override
																		public void actionPerformed(ActionEvent arg0) {
																			// TODO Auto-generated method stub
																			
																			CambiarPanel(panelessegundo.get(pruebas), panelessegundo.get(pruebas+1)); //Cambiamos de paneles prueba elige el numero de panel
																			
																			pruebas++; //Incrementamos prueba para que se pueda pasar de panel
																			enQuePanel = pruebas;
																			panelessegundo.get(pruebas).add(botonSiguientePanelsegundo); //Añadimos el boton al panel es necesario repetir??(mirar arriba)
																			panelessegundo.get(pruebas).updateUI(); //Actualizamos el panel para que aparezca el boton, es realmente necesario repetirlo??
																			
																		}
																		
																	});
																	if (x==0) {  //si es el primer panel se añade un boton a panel1 para pasar al panel siguiente
																		panel1s.add(cambiosegundo.get(0)); 
																	} else if (x>0) {//si no es el primer panel ponemos un boton al panel el cual sirva para pasar al siguiente panel
																		//he quitadp panelesMult.getName();
																		panelesMultseg.add(cambiosegundo.get(x));
																	}
																	for (int i = 0; i < 3; i++) {//son filas columnas de botones por panel
																		
															
																		for (int o = 0; o < 3; o++) {//son tres columnas de botones por panel
																			
																			JButton pp2s = new JButton(); //Creamos el boton del plato
																			//CrearBoton(pp2);
																			pp2s.setBounds(ss, ps,300, 75); // con s y p vamos cambiando la posicion del siguiente boton
																			pp2s.setText("prueba"+enQuePlato+x+i+o); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
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
																					int sp= 40;
																					
																					int pp = 185;
																					CambiarPanel(panelessegundo.get(enQuePanel), panelespostre.get(0));
																					for (int x = 0; x <40 ; x++) { //creamos 40 paneles (eso tiene que cambiar con la bd)
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
																						JButton botonSiguientePanelpostre = new JButton("siguiente panel"); //Creamos el boton para pasar al siguiente panel
																						botonSiguientePanelpostre.setBounds(390, 575, 300, 75); //La posicion del boton
																						
																						botonSiguientePanelpostre.setName("bSiguiente"+x);  //Ponemos nombre al boton
																						cambiopostre.add(botonSiguientePanelpostre);  //Lo añadimos al array de botones
																						panelespostre.get(x).add(botonSiguientePanelpostre); //añadimos el boton para cambiar de panel a cada panel
																						panelespostre.get(x).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
																						
																						botonSiguientePanelpostre.addActionListener(new ActionListener() {
																						
																							@Override
																							public void actionPerformed(ActionEvent arg0) {
																								// TODO Auto-generated method stub
																								
																								CambiarPanel(panelespostre.get(pruebap), panelespostre.get(pruebap+1)); //Cambiamos de paneles prueba elige el numero de panel
																								
																								pruebap++; //Incrementamos prueba para que se pueda pasar de panel
																								enQuePanel = pruebap;
																								panelespostre.get(pruebap).add(botonSiguientePanelpostre); //Añadimos el boton al panel es necesario repetir??(mirar arriba)
																								panelespostre.get(pruebap).updateUI(); //Actualizamos el panel para que aparezca el boton, es realmente necesario repetirlo??
																								
																							}
																							
																						});
																						if (x==0) {  //si es el primer panel se añade un boton a panel1 para pasar al panel siguiente
																							panel1p.add(cambiopostre.get(0)); 
																						} else if (x>0) {//si no es el primer panel ponemos un boton al panel el cual sirva para pasar al siguiente panel
																							//he quitadp panelesMult.getName();
																							panelesMultpos.add(cambiopostre.get(x));
																						}
																						for (int i = 0; i < 3; i++) {//son filas columnas de botones por panel
																							
																				
																							for (int o = 0; o < 3; o++) {//son tres columnas de botones por panel
																								
																								JButton pp2p = new JButton(); //Creamos el boton del plato
																								//CrearBoton(pp2);
																								pp2p.setBounds(sp, pp,300, 75); // con s y p vamos cambiando la posicion del siguiente boton
																								pp2p.setText("prueba"+enQuePlato+x+i+o); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
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
																										
																										
																										
																										
																										
																										
																										
																										int sb= 40;
																										
																										int pb = 185;
																										
																										for (int x = 0; x <40 ; x++) { //creamos 40 paneles (eso tiene que cambiar con la bd)
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
																											JButton botonSiguientePanelbebida = new JButton("siguiente panel"); //Creamos el boton para pasar al siguiente panel
																											botonSiguientePanelbebida.setBounds(390, 575, 300, 75); //La posicion del boton
																											
																											botonSiguientePanelbebida.setName("bSiguiente"+x);  //Ponemos nombre al boton
																											cambiobebida.add(botonSiguientePanelbebida);  //Lo añadimos al array de botones
																											panelesbebida.get(x).add(botonSiguientePanelbebida); //añadimos el boton para cambiar de panel a cada panel
																											panelesbebida.get(x).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
																											
																											botonSiguientePanelbebida.addActionListener(new ActionListener() {
																										
																												@Override
																												public void actionPerformed(ActionEvent arg0) {
																													// TODO Auto-generated method stub
																													
																													CambiarPanel(panelesbebida.get(pruebab), panelesbebida.get(pruebab+1)); //Cambiamos de paneles prueba elige el numero de panel
																													pruebab++; //Incrementamos prueba para que se pueda pasar de panel
																													enQuePanel = pruebab;
																													panelesbebida.get(pruebab).add(botonSiguientePanelbebida); //Añadimos el boton al panel es necesario repetir??(mirar arriba)
																													panelesbebida.get(pruebab).updateUI(); //Actualizamos el panel para que aparezca el boton, es realmente necesario repetirlo??
																													
																												}
																												
																											});
																											if (x==0) {  //si es el primer panel se añade un boton a panel1 para pasar al panel siguiente
																												panel1b.add(cambiobebida.get(0)); 
																											} else if (x>0) {//si no es el primer panel ponemos un boton al panel el cual sirva para pasar al siguiente panel
																												//he quitadp panelesMult.getName();
																												panelesMultbeb.add(cambiobebida.get(x));
																											}
																											for (int i = 0; i < 3; i++) {//son filas columnas de botones por panel
																												
																									
																												for (int o = 0; o < 3; o++) {//son tres columnas de botones por panel
																													
																													JButton pp2b = new JButton(); //Creamos el boton del plato
																													//CrearBoton(pp2);
																													
																													pp2b.setBounds(sb, pb,300, 75); // con s y p vamos cambiando la posicion del siguiente boton
																													pp2b.setText(nombrebeb.get(contcontbebida)); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
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
																															CambiarPanel(panelesbebida.get(enQuePanel), panelFactura);
																															
																														}
																														
																													});
																													//pp2.setActionCommand(pp2.getText());	//Aqui hay que coger de la base de datos el nombre
																													
																													//he borrado borrarbo++;
																													
																										    	}
																											
																												pb=pb+100;//aumentamos la y de los botones
																												sb=40;//iniciamos la columna de nuevo
																												//he borrado borrarbi++;
																											}
																											sb=40;//iniciamos la columna de nuevo
																											pb=185; //iniciamos
																										}
																										CambiarPanel(panelespostre.get(enQuePanel), panelesbebida.get(0));
																										for (int i = 0; i < botonesbebida.size(); i++) {//imprimimos los datos de los botones que hemos creado
																											System.out.println(botonesbebida.get(i));
																											
																										}								
																								
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
																					for (int i = 0; i < botonessegundo.size(); i++) {//imprimimos los datos de los botones que hemos creado
																						System.out.println(botonessegundo.get(i));
																						
																					}
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
																for (int i = 0; i < botonessegundo.size(); i++) {//imprimimos los datos de los botones que hemos creado
																	System.out.println(botonessegundo.get(i));
																	
																}
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
											for (int i = 0; i < botonesprimero.size(); i++) {//imprimimos los datos de los botones que hemos creado
												System.out.println(botonesprimero.get(i));
												
											}
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
								for (int i = 0; i < botonesentrantes.size(); i++) {//imprimimos los datos de los botones que hemos creado
								System.out.println(botonesentrantes.get(i));
	
							}


											
											
						
				}
		    	   
				
			});
			
					
				
			
		
		
       
       bPrimerPlato.addActionListener(new ActionListener () {
    	   @Override
			public void actionPerformed(ActionEvent e) {
				
			}
       });
      
       
       bReturn.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (panelAddBoton.isEnabled()== true) {
				CambiarPanelRetorno(panelAddBoton, panelAdmin);
			} else if (panelQuitComida.isEnabled()== true) {
				CambiarPanelRetorno(panelQuitComida, panelAdmin);
			} else if (panelAdmin.isEnabled()== true) {
				CambiarPanelRetorno(panelAdmin, panelInicio);
			} else if (bPanelRecogerDomicilio.isEnabled()== true) {
				CambiarPanelRetorno(panelRecogerDomicilio, panelInicio);
			} else if (panelReserva.isEnabled()== true) {
				CambiarPanelRetorno(panelReserva, panelInicio);
			} else if (panelRecogida.isEnabled()== true) {
				CambiarPanelRetorno(panelRecogida, panelRecogerDomicilio);
			} else if (panelDomicilio.isEnabled()== true) {
				CambiarPanelRetorno(panelDomicilio, panelRecogerDomicilio);
			} else  {
				System.out.println("No funchiona");
			}
			
		}
	});
      
//pene
       
       cbb1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(tNombreProd.getText());
			
		}
	});
      
  
       panelSegundo.updateUI();
       panelInicio.add(bPanelRecogerDomicilio);
       panelInicio.add(bPanelReserva);
       
       panelInicio.add(bPanelAdmin);
       
       panelAdmin.add(bPanelBebidaComida);
       panelAdmin.add(bPanelAddBoton);
       
      
       panelReserva.add(lApellidoC);
       panelReserva.add(lNombreC);
       panelReserva.add(lHoraR);
       panelReserva.add(tApellidosReserva);
       panelReserva.add(tNombreReserva);
       panelReserva.add(cHoraReserva);
       panelReserva.updateUI();
       panelRecogerDomicilio.add(bPanelRecogida);

       panelRecogerDomicilio.add(bPanelDomicilio);       

       panelRecogerDomicilio.add(bPanelDomicilio);  
       
       panelDomicilio.add(lCalle);
       panelDomicilio.add(lEdificio);
       panelDomicilio.add(lPiso);
       panelDomicilio.add(lLetra);
       panelDomicilio.add(lNombre);
       panelDomicilio.add(lApellido);
       panelDomicilio.add(tCalle);
       panelDomicilio.add(tEdificio);
       panelDomicilio.add(tPiso);
       panelDomicilio.add(tLetra);
       panelDomicilio.add(tNombre);
       panelDomicilio.add(tApellido);
       panelDomicilio.updateUI();
       
       panelRecogida.add(lHora);
       panelRecogida.add(tHora);
       panelRecogida.add(lTlfn);
       panelRecogida.add(tTlfn);
       panelRecogida.add(lNombre2);
       panelRecogida.add(tNombre2);
       panelRecogida.add(lApellido2);
       panelRecogida.add(tApellido2);
       panelRecogida.add(lValidarTlfn);
       
       panelRecogida.updateUI();
       
       panelFactura.add(precio);
       panelFactura.add(iva);
       
       panelBebidaComida.add(bPanelQuitComida);
       panelBebidaComida.add(bPanelQuitBebida);
       
       panelQuitComida.add(lQuitComida);
       panelQuitComida.add(tQuitComida);
       panelQuitComida.add(bQuitComida);
       
       panelQuitBebida.add(lQuitBebida);
       panelQuitBebida.add(tQuitBebida);
       panelQuitBebida.add(bQuitBebida);
       
       panelMesa.add(bPrimerPlato);
       
       panelPrimero.add(lPrimerPlato);
       
       panelAddBoton.add(cbb1);
       panelAddBoton.add(tNombreProd);
       panelAddBoton.add(cbt2);
       panelAddBoton.add(lNombrarProd);
       panelAddBoton.add(lTituloPAddBoton);
       panelAddBoton.add(lSelImagen);
       panelAddBoton.add(cbl5);
       panelAddBoton.add(lTipo);
       panelAddBoton.add(cOrden);
       
       panelInicioSesion.add(lUsuario);
       panelInicioSesion.add(lContraseña);
       panelInicioSesion.add(bRegistrarse);
       panelInicioSesion.add(bIniciar);
       panelInicioSesion.add(tUsuario);
       panelInicioSesion.add(tPassword);
       panelFactura.add(fl1);
       panelFactura.add(fl2);
       
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
       
       frame.getContentPane().add(panelQuitComida);
       frame.getContentPane().add(panelQuitBebida);
       frame.getContentPane().add(panelBebidaComida);
       frame.getContentPane().add(panelAddBoton);
       
       frame.getContentPane().add(panelReserva);
       frame.getContentPane().add(panelMesa);
       
       frame.getContentPane().add(panelRecogerDomicilio);
       frame.getContentPane().add(panelRecogida);
       frame.getContentPane().add(panelDomicilio);
       
       frame.getContentPane().add(panelEntrantes);
       frame.getContentPane().add(panelPrimero);
       frame.getContentPane().add(panelSegundo);
       frame.getContentPane().add(panelPostre);
       frame.getContentPane().add(panelQuitBebida);

       frame.getContentPane().add(panelFactura);

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
		
		
			//h.add(bReturn);
		
		
	}
	public void CambiarPanelRetorno(JPanel g, JPanel h) {
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
	}
	

	public void CrearPanel(JPanel g) {
		g.setLayout(null);
		g.setVisible(false);
		g.setEnabled(false);
		g.setBounds(0, 0, 1080, 720);
		
		

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
