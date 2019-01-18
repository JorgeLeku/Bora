package ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
//eneko
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import sun.applet.AppletPanel;

public class Principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//JButton bPanelRecogerDomicilio, bPanelReserva, bPanelAdmin, bAddBoton, bQuitBoton, bPanelMesa, bPrimerPlato, bPanelRecogida, bPanelDomicilio, botonPruebas, bAb, bReturn, cbb1, bSelImg, botonPanelFactura;

	JButton bPanelRecogerDomicilio, bPanelReserva, bPanelAdmin, bAddBoton, bQuitBoton, bPanelMesa, bPrimerPlato, bPanelRecogida, bPanelDomicilio, botonPruebas, bAb, bReturn, cbb1, bSelImg, botonPanelFactura, bConfirmarDomicilio, bConfirmarRecogida;

	BotonesGrandes bPanelQuitBoton, bPanelAddBoton;

	//JLabel lNombrarProd, lTituloPAddBoton, lSelImagen, lDirImg, cbl5, fl1, fl2, facTotal, lTipo, lNombreC, lApellidoC, lHoraR, lPrimerPlato;

	JLabel lNombrarProd, lTituloPAddBoton, lSelImagen, lDirImg, cbl5, fl1, fl2, facTotal, lTipo, lNombreC, lApellidoC, lHoraR, lPrimerPlato, lCalle, lEdificio, lPiso, lLetra, lNombre, lApellido, lHora, lTlfn, lNombre2, lApellido2;

	JComboBox cOrden, cHoraReserva;

	//JTextField tNombreProd, cbt2, tNombreReserva, tApellidosReserva;

	JTextField tNombreProd, cbt2, tNombreReserva, tApellidosReserva, tCalle, tEdificio, tPiso, tLetra, tNombre, tApellido, tHora, tTlfn, tNombre2, tApellido2;

	Font fuente;
	int  pruebae =0, prueba = 0, pruebas =0, pruebap =0,pruebab =0, borrarbi = 0, borrarbo = 0, enQuePanel =0;
	private List<JButton> botonesprimero;
	//private List<JPanel> paneles;
	//Pruebas2
	
	int x = 1;
	public Principal() {

//	paneles = new ArrayList<>();
		
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
       Paneles panelInicio = new Paneles();//primer panel (el panel que pone bora)
       Paneles panelAdmin = new Paneles();//En este panel eliges si comer en el restaurante o pedir la comida para llevar (tambien esta el boton admin)
      
       Paneles panelQuitBoton = new Paneles(); //En este panel el admin puede quitar platos del menu
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
       Paneles panelBebida = new Paneles();
       
       Paneles panelFactura = new Paneles();
       
       Paneles panelPruebas = new Paneles ();//este panel sera eliminado en el futuro
       
       CrearPanel(panelBienvenida);
       //CrearPanel(panelInicio);
       CrearPanel(panelAdmin);
       CrearPanel(panelInicio);
       CrearPanel(panelQuitBoton);
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
       CrearPanel(panelBebida);
       
       CrearPanel(panelFactura);
       
       CrearPanel(panelPruebas);

       panelBienvenida.setVisible(true);
       panelBienvenida.setEnabled(true);

       ImageIcon imagenp1b2 = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b2.jpg"));
       ImageIcon imagenp1b1 = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b1.jpg"));
       ImageIcon imagenp1b2bn = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b2b-n.jpg"));
       ImageIcon imagenp1b1bn = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b1b-n.jpg"));
       
       ImageIcon imagenbAb = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bAb.png"));
       ImageIcon imagenbAtr = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bAtr.png"));
       ImageIcon imagenbAtrbn = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bAtrb-n.png"));
       ImageIcon imagenbAbbn = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bAbb-n.png"));
       ImageIcon imagencbb2 = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bs1.png"));
       ImageIcon imagencbb2bn = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bs1b-n.png"));
       ImageIcon imagenPrueba = new ImageIcon(this.getClass().getClassLoader().getResource("prueba.png"));


       //sad
       //Creacion objetos
       //Objetos panelInicial
       bPanelRecogerDomicilio = new JButton(imagenp1b1);
       bPanelReserva = new JButton(imagenp1b2);
       bPanelAdmin = new JButton();
       
       //Objetos panelAdmin
       bPanelQuitBoton = new BotonesGrandes();
       bPanelAddBoton = new BotonesGrandes();
       
       //Objetos panelAddBoton
       bAddBoton = new JButton();
       bSelImg = new JButton(imagencbb2);
       bSelImg.setRolloverIcon(imagencbb2bn);
       lNombrarProd = new JLabel();
       tNombreProd = new JTextField();
       lTituloPAddBoton = new JLabel();
       lSelImagen = new JLabel();
       lDirImg = new JLabel();
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
       bPanelRecogida = new JButton("Recogida");
       bPanelDomicilio = new JButton("Domicilio");
       

       //Objetos panelRecogida
       lHora = new JLabel();
       tHora = new JTextField();
       lTlfn = new JLabel();
       tTlfn = new JTextField();
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
       

       //Objetos panelMesa, de momento vamos a obviar el panelMesa
       bPrimerPlato = new JButton() {
    	   public void paintComponent(Graphics g) {
    		   
		        Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
		        Graphics bufferGraphics = bufferImage.getGraphics();
		        bufferGraphics.drawImage(imagenBotonBlancoPeq.getImage(), 0, 0, 300, 75, null);
		        g.drawImage(bufferImage, 0, 0, this);

		        }
		    
      };
       
       bPanelMesa = new Botones();
       //Objetos panelPrimerPlato
       lPrimerPlato = new JLabel ();
       lPrimerPlato.setFont(titulos);
       lPrimerPlato.setForeground(Color.WHITE);
       lPrimerPlato.setSize(50, 50);
       lPrimerPlato.setText("Primer Plato");
       
       bAb = new JButton(imagenbAb);
       bReturn = new JButton (imagenbAtr);
       cbb1 = new JButton(imagenbAb);

       cbb1.setRolloverIcon(imagenbAbbn);
       bReturn.setRolloverIcon(imagenbAtrbn);
       bAb.setRolloverIcon(imagenbAbbn);
       bPanelRecogerDomicilio.setRolloverIcon(imagenp1b1bn);
       bPanelReserva.setRolloverIcon(imagenp1b2bn);
       botonPruebas = new JButton(imagenPrueba);
       
       
       CrearBoton(bPanelRecogerDomicilio);
       CrearBoton(bPanelReserva);
       //CrearBoton(bPanelAdmin);
       
       CrearBoton(bPanelQuitBoton);
       CrearBoton(bPanelAddBoton);
       
       CrearBoton(bAddBoton);
       CrearBoton(bSelImg);
       
       CrearBoton(bQuitBoton);
       
       CrearBoton(bPanelMesa);
       
       CrearBoton(bPrimerPlato);
       
      // CrearBoton(bPanelRecogida);
       

     //PANEL RECOGIDA LABEL Y TF
       lHora.setBounds(360, 250, 200, 40);
       lHora.setFont(newFont);
       lHora.setText("Hora");
       tHora.setBounds(300, 300, 200, 40);
       
       lTlfn.setBounds(660, 250, 200, 40);
       lTlfn.setFont(newFont);
       lTlfn.setText("Telefono");
       tTlfn.setBounds(600, 300, 200, 40);
       
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
       
      // CrearBoton(bPanelDomicilio);
       CrearBoton(bAb);
       CrearBoton(bReturn);
       CrearBoton(cbb1);
       CrearBoton(bSelImg);
       
      bPanelRecogerDomicilio.setBounds(93, 185, 400, 350);
      bPanelReserva.setBounds(566, 185, 400, 350);
      bPanelAdmin.setBounds(500, 5, 50, 50);
      
     
             
      bPanelAddBoton.setBounds(93, 185, 400, 350);
      bPanelQuitBoton.setBounds(566, 185, 400, 350);

       
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
       cOrden.setBounds(705, 300, 200, 50);
      
       lDirImg.setBounds(600, 430, 400, 40);
       lDirImg.setFont(newFont);
       
       //Panel Reserva
       bPanelMesa.setBounds(390, 585, 300, 75);
       panelRecogida.add(bPanelMesa);
       panelReserva.add(bPanelMesa);
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
       fl1.setBounds(500, 100, 200, 70);
       fl1.setFont(newFont);
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
       
      
       botonPanelFactura = new JButton();
      // panelAddBoton.add(botonPanelFactura);
       botonPanelFactura.setBounds(200, 50, 150, 150);
       botonPanelFactura.setText("Boton Eneko");
       botonPanelFactura.addActionListener(new ActionListener() {
    	   
    	   @Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelAddBoton, panelFactura);

			}
       });
       
    
       
       
      

       botonPruebas.setBounds(0, 0, 50, 50);

      
       bAb.setBounds(500, 30, 80, 80);
       bReturn.setBounds(30, 30, 80, 80);
       cbb1.setBounds(500, 580, 80, 80);
       bSelImg.setBounds(250, 420, 300, 75);

		
       JLabel merluza = new JLabel ();
       merluza.setFont(newFont);
       merluza.setForeground(Color.white);
       merluza.setText("<html><body>Ingredientes:  1  cogote  de  merluza  del  cantábrico,  sal  de  Añana  al  vino,  4  dientes  de  ajo,<br>aceite  de  oliva  virgen  extra,  vinagre  de  sidra,  1  pimienta  cayena,  1  manojo  de  perejil.</body></html>" );
       merluza.setBounds(50, 450, 1080, 300);
       merluza.setBorder(null);
       merluza.setVisible(false);
       merluza.setOpaque(false);
       panelPruebas.add(merluza);
       
       frame.addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			CambiarPanel(panelBienvenida, panelInicio);
			System.out.println("hola");
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
       botonPruebas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
		    	int s= 40;
				int indi= 0;
				int p = 185;
				CambiarPanel(panelInicio, panelPruebas);
				for (int x = 0; x < 2; x++) {
					JPanel panelesMult = new JPanel();
					CrearPanel(panelesMult);
					frame.getContentPane().add(panelesMult);
					frame.update(getGraphics());
					for (int i = 0; i < 3; i++) {
						
			
						for (int o = 0; o < 3; o++) {
							Botones pp2 = new Botones();
							pp2.setBounds(s, p,300, 75);
							CrearBoton(pp2);
							s=320+s;
							pp2.addActionListener(new ActionListener () {
	
								@Override
								public void actionPerformed(ActionEvent arg0) {
									// TODO Auto-generated method stub
									CambiarPanel(panelPruebas, panelInicio);
								}
								
							});
							pp2.setActionCommand(pp2.getText());	//Aqui hay que coger de la base de datos el nombre
							panelPruebas.add(pp2);
							botonesprimero.add(pp2);
							panelPruebas.updateUI();
				    	}
						p=p+100;
						s=40;
					}
				}
				 
			}

       });
       
       bPanelAdmin.addActionListener(new ActionListener () {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			CambiarPanel(panelInicio, panelAdmin);
		}
    	   
       });
      
       bPanelRecogerDomicilio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelInicio, panelRecogerDomicilio);
			}

       });
       
       bPanelRecogida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelRecogerDomicilio, panelRecogida);
			}

      });
       
       bPanelDomicilio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelRecogerDomicilio, panelDomicilio);
			}

     }); 

       bPanelReserva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelInicio, panelReserva);
			}

       });
       
       
       bPanelQuitBoton.addActionListener(new ActionListener () {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			CambiarPanel(panelAdmin, panelQuitBoton);
		}
    	   
       });
       
       bPanelAddBoton.addActionListener(new ActionListener () {

   		@Override
   		public void actionPerformed(ActionEvent e) {
   			// TODO Auto-generated method stub
   			CambiarPanel(panelAdmin, panelAddBoton);
   		}
       	   
        });
       
		
		

		
			/*// TODO Auto-generated method stub
			List <JPanel> paneles = new ArrayList <> ();
			
			paneles=Paneles.VentanaDinamicaa(panelPrimero);
			for (int i = 0; i < paneles.size(); i++) {
				System.out.println(paneles.get(i));
			}
			for (int i = 0; i < paneles.size(); i++) {
				paneles.get(i).updateUI();
				frame.getContentPane().add(paneles.get(i));
				
			}*/
			
			
			
		
		String nombrebotoncambio = " " + 0;
		List<JButton> botonesentrantes, botonesprimero, botonessegundo, botonespostre, botonesbebida;//Arraylist de botones para guardar todos los botones creados
		List<JButton> cambioentrantes, cambioprimero, cambiosegundo, cambiopostre, cambiobebida;//Arraylist de botones para guardar todos los botones de cambio de panel
		List<JPanel> panelesentrantes, panelesprimero, panelessegundo, panelespostre, panelesbebida;//Arraylist de paneles para guardar todos los paneles creados
		
		JPanel panel1;
		
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
		
		panel1 =  new Paneles();
		CrearPanel(panel1);
		
		
		panelesprimero.add(panel1);
		frame.getContentPane().add(panel1);
		panelesprimero.get(0).updateUI();
		
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
					
					for (int x = 0; x <40 ; x++) { //creamos 40 paneles (eso tiene que cambiar con la bd)
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
								// TODO Auto-generated method stub
								
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
								pp2e.setText("prueba"+x+i+o); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
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
										
										
						
											int s= 40;
											
											int p = 185;
											CambiarPanel(panelesentrantes.get(enQuePanel), panelesprimero.get(0));
											for (int x = 0; x <40 ; x++) { //creamos 40 paneles (eso tiene que cambiar con la bd)
												JLabel lprimero = new JLabel();
												lprimero.setBounds(400, 50, 1000, 40);
												
											       lprimero.setFont(titulos);
											       lprimero.setForeground(Color.WHITE);
											       lprimero.setSize(500, 50);
											       lprimero.setText("Primer Plato");
											       
												Paneles panelesMult = new Paneles();  //creamos mas paneles
												panelesMult.setName("panelesMult" + x); //le ponemos un nombre
												CrearPanel(panelesMult);  //Le damoslos datos basicos
												frame.getContentPane().add(panelesMult); //lo añadimos al frame
												panelesprimero.add(panelesMult);  //Lo metemos en el array de paneles
												JButton botonSiguientePanel = new JButton("siguiente panel"); //Creamos el boton para pasar al siguiente panel
												botonSiguientePanel.setBounds(390, 550, 300, 75); //La posicion del boton
												
												botonSiguientePanel.setName("bSiguiente"+x);  //Ponemos nombre al boton
												panelesprimero.get(x).add(lprimero);
												cambioprimero.add(botonSiguientePanel);  //Lo añadimos al array de botones
												panelesprimero.get(x).add(botonSiguientePanel); //añadimos el boton para cambiar de panel a cada panel
												panelesprimero.get(x).updateUI(); //Actualizamos el panel para que se visualize el boton para cambiar de panel
												
												botonSiguientePanel.addActionListener(new ActionListener() {
												
													@Override
													public void actionPerformed(ActionEvent arg0) {
														// TODO Auto-generated method stub
														CambiarPanel(panelesprimero.get(prueba), panelesprimero.get(prueba+1)); //Cambiamos de paneles prueba elige el numero de panel
														
														prueba++; //Incrementamos prueba para que se pueda pasar de panel
														enQuePanel = prueba;
														panelesprimero.get(prueba).add(botonSiguientePanel); //Añadimos el boton al panel es necesario repetir??(mirar arriba)
														panelesprimero.get(prueba).updateUI(); //Actualizamos el panel para que aparezca el boton, es realmente necesario repetirlo??
														
													}
													
												});
												if (x==0) {  //si es el primer panel se añade un boton a panel1 para pasar al panel siguiente
													panel1.add(cambioprimero.get(0)); 
												} else if (x>0) {//si no es el primer panel ponemos un boton al panel el cual sirva para pasar al siguiente panel
													//he quitadp panelesMult.getName();
													panelesMult.add(cambioprimero.get(x));
												}
												for (int i = 0; i < 3; i++) {//son filas columnas de botones por panel
													
										
													for (int o = 0; o < 3; o++) {//son tres columnas de botones por panel
														
														JButton pp2 = new JButton(); //Creamos el boton del plato
														//CrearBoton(pp2);
														pp2.setBounds(s, p,300, 75); // con s y p vamos cambiando la posicion del siguiente boton
														pp2.setText("prueba"+x+i+o); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
														botonesprimero.add(pp2); //añadimos el boton al arraylist de botones
														s=320+s; //Incrementamos s para que el boton siguiente este a la izquierda
														panelesprimero.get(x).add(pp2); //añadimos el boton al panel correspondiente
														panelesprimero.get(x).updateUI(); //actualizamos el panel para que muestre los botones
														pp2.setName("prueba"+x+i+o);	//nombramos el boton para saber cual es (sacar de la bd)
														panel1.updateUI(); //actualizamos el panel1 a parte creo que esto sobra pero soy gilipollas y no tengo tiempo para mirarlo
														pp2.addActionListener(new ActionListener () {
						
													
															@Override
															public void actionPerformed(ActionEvent arg0) {
																// TODO Auto-generated method stub
																//me cago en dioooooooooooooooooooooososososoossos
																//CambiarPanel(panelesprimero.get(enQuePanel), panelSegundo);
																
																
																
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
																CambiarPanel(panelesprimero.get(enQuePanel), panelessegundo.get(0));
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
																	botonSiguientePanelsegundo.setBounds(390, 550, 300, 75); //La posicion del boton
																	
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
																			pp2s.setText("prueba"+x+i+o); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
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
																						botonSiguientePanelpostre.setBounds(390, 550, 300, 75); //La posicion del boton
																						
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
																								pp2p.setText("prueba"+x+i+o); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
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
																										CambiarPanel(panelespostre.get(enQuePanel), panelesbebida.get(0));
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
																											botonSiguientePanelbebida.setBounds(390, 550, 300, 75); //La posicion del boton
																											
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
																													pp2b.setText("prueba"+x+i+o); // Nombramos los botones para diferenciarlos (Aqui hay que ponerlo con la bd
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
																for (int i = 0; i < botonessegundo.size(); i++) {//imprimimos los datos de los botones que hemos creado
																	System.out.println(botonessegundo.get(i));
																	
																}
															}
															
														});
														//pp2.setActionCommand(pp2.getText());	//Aqui hay que coger de la base de datos el nombre
														
														//he borrado borrarbo++;
														
											    	}
												
													p=p+100;//aumentamos la y de los botones
													s=40;//iniciamos la columna de nuevo
													//he borrado borrarbi++;
												}
												s=40;//iniciamos la columna de nuevo
												p=185; //iniciamos
											}
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
      
       bAb.addMouseListener(new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				CambiarPanel(panelPruebas, panelAddBoton);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
			/*if (panelInicio.isEnabled()== true) {
				CambiarPanel(panelInicio, panelInicio);
			} else if (eliminarEstePanel.isEnabled()==true){
				CambiarPanel(eliminarEstePanel, panelInicio);
			} else if (panelECarta.isEnabled()==true) {
				CambiarPanel(panelECarta, eliminarEstePanel);
			} else if (panelEMenu.isEnabled()==true) {
				CambiarPanel(panelEMenu, eliminarEstePanel);
			} else if (panelPruebas.isEnabled()==true) {
				CambiarPanel(panelPruebas, panelInicio);
			}*/
		}
	});
       bSelImg.addActionListener(new ActionListener() {

    	   //  Lo que sucede al pulsar el boton
    	 public void actionPerformed(ActionEvent ae) {

    	 //Creamos selector de aperture

    	 JFileChooser fileChooser = new JFileChooser();

    	 int returnValue = fileChooser.showOpenDialog(null);// Nos retorna un entero

    	 // Si apretamos en aceptar un archive ocurrira esto

    	 if (returnValue == JFileChooser.APPROVE_OPTION) {

    	 File selectedFile = fileChooser.getSelectedFile();

    	 System.out.println(selectedFile.getName());
    	 lDirImg.setText(selectedFile.getAbsolutePath());
    	 }

       }

    });
       
       cbb1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(tNombreProd.getText());
			System.out.println(lDirImg.getText());
		}
	});
       JButton pene = new JButton();
       pene.setBounds(200, 200, 200, 200);
       pene.setText("vadsfsa");
       panelSegundo.add(pene);//esto se quita
       panelSegundo.updateUI();
       panelInicio.add(bPanelRecogerDomicilio);
       panelInicio.add(bPanelReserva);
       panelInicio.add(botonPruebas);
       panelInicio.add(bPanelAdmin);
       
       panelAdmin.add(bPanelQuitBoton);
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
       panelDomicilio.add(bPanelMesa);
       panelDomicilio.updateUI();
       
       panelRecogida.add(lHora);
       panelRecogida.add(tHora);
       panelRecogida.add(lTlfn);
       panelRecogida.add(tTlfn);
       panelRecogida.add(lNombre2);
       panelRecogida.add(tNombre2);
       panelRecogida.add(lApellido2);
       panelRecogida.add(tApellido2);
       
       panelRecogida.updateUI();
       
       panelMesa.add(bPrimerPlato);
       
       panelPruebas.add(bAb);
       
       panelPrimero.add(lPrimerPlato);
       
       panelAddBoton.add(cbb1);
       panelAddBoton.add(tNombreProd);
       panelAddBoton.add(cbt2);
       panelAddBoton.add(lNombrarProd);
       panelAddBoton.add(lTituloPAddBoton);
       panelAddBoton.add(lSelImagen);
       panelAddBoton.add(bSelImg);
       panelAddBoton.add(lDirImg);
       panelAddBoton.add(cbl5);
       panelAddBoton.add(lTipo);
       panelAddBoton.add(cOrden);
       
       
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

       frame.getContentPane().add(panelBienvenida);
       frame.getContentPane().add(panelInicio);
       frame.getContentPane().add(panelAdmin);
       
       frame.getContentPane().add(panelQuitBoton);
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
       frame.getContentPane().add(panelBebida);

       frame.getContentPane().add(panelFactura);
       
       frame.getContentPane().add(panelPruebas);
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
		h.add(bReturn);
		
		
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
