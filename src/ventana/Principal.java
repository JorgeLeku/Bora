package ventana;

//p1

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
	JButton bPanelRecogerDomicilio, bPanelReserva, bPanelAdmin, bAddBoton, bQuitBoton, bPanelMesa, bPrimerPlato, bPanelRecogida, bPanelDomicilio, botonPruebas, bAb, bReturn, cbb1, bSelImg, botonPanelFactura;
	BotonesGrandes bPanelQuitBoton, bPanelAddBoton;
	JLabel lNombrarProd, lTituloPAddBoton, lSelImagen, lDirImg, cbl5, fl1, fl2, facTotal, lTipo, lNombreC, lApellidoC, lHoraR, lPrimerPlato;
	JComboBox cOrden, cHoraReserva;
	JTextField tNombreProd, cbt2, tNombreReserva, tApellidosReserva;
	Font fuente;
	private List<JButton> botones;
	//private List<JPanel> paneles;
	//Pruebas2
	
	int x = 1;
	public Principal() {
	botones = new ArrayList<>();
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
       
       Paneles.CrearPanel(panelBienvenida);
       //CrearPanel(panelInicio);
       Paneles.CrearPanel(panelAdmin);
       Paneles.CrearPanel(panelInicio);
       Paneles.CrearPanel(panelQuitBoton);
       Paneles.CrearPanel(panelAddBoton);
       
       Paneles.CrearPanel(panelReserva);
       Paneles.CrearPanel(panelMesa);
       
       Paneles.CrearPanel(panelRecogerDomicilio);
       Paneles.CrearPanel(panelRecogida);
       Paneles.CrearPanel(panelDomicilio);
       
       Paneles.CrearPanel(panelEntrantes);
       Paneles.CrearPanel(panelPrimero);
       Paneles.CrearPanel(panelSegundo);
       Paneles.CrearPanel(panelPostre);
       Paneles.CrearPanel(panelBebida);
       
       Paneles.CrearPanel(panelFactura);
       
       Paneles.CrearPanel(panelPruebas);

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
       
       //Objetos panelMesa, de momento vamos a obviar el panelMesa
       bPrimerPlato = new JButton() {
    	   public void paintComponent(Graphics g) {
    		   
		        Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
		        Graphics bufferGraphics = bufferImage.getGraphics();
		        bufferGraphics.drawImage(imagenBotonBlancoPeq.getImage(), 0, 0, 300, 75, null);
		        g.drawImage(bufferImage, 0, 0, this);

		        }
		    
      };
       
       bPanelMesa = new JButton() {
    	   public void paintComponent(Graphics g) {
    		   
		        Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
		        Graphics bufferGraphics = bufferImage.getGraphics();
		        bufferGraphics.drawImage(imagenBotonBlancoPeq.getImage(), 0, 0, 300, 75, null);
		        g.drawImage(bufferImage, 0, 0, this);

		        }
		    
       };
              
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
       
       
       Paneles.CrearBoton(bPanelRecogerDomicilio);
       Paneles.CrearBoton(bPanelReserva);
       //CrearBoton(bPanelAdmin);
       
       Paneles.CrearBoton(bPanelQuitBoton);
       Paneles.CrearBoton(bPanelAddBoton);
       
       Paneles.CrearBoton(bAddBoton);
       Paneles.CrearBoton(bSelImg);
       
       Paneles.CrearBoton(bQuitBoton);
       
       Paneles.CrearBoton(bPanelMesa);
       
       Paneles.CrearBoton(bPrimerPlato);
       
      // CrearBoton(bPanelRecogida);
       
      // CrearBoton(bPanelDomicilio);
       Paneles.CrearBoton(bAb);
       Paneles.CrearBoton(bReturn);
       Paneles.CrearBoton(cbb1);
       Paneles.CrearBoton(bSelImg);
       
      bPanelRecogerDomicilio.setBounds(93, 185, 400, 350);
      bPanelReserva.setBounds(566, 185, 400, 350);
      bPanelAdmin.setBounds(500, 5, 50, 50);
      
     
             
      bPanelAddBoton.setBounds(93, 185, 400, 350);
      bPanelQuitBoton.setBounds(566, 185, 400, 350);
      //pp1.setRolloverIcon(imagenp4b1bn);
      // pp1.setBounds(38, 185, 300, 75);
      //pp1.setBounds(38, 185,300, 75);
	  // panelPruebas.add(pp1);
      

		
       
       
       
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
				// Base de datos
				/*Botones pp1 = new Botones();
				pp1.setBounds(34, 185,300, 75);
				CrearBoton(pp1);
				panelPruebas.add(pp1);
		    	panelPruebas.updateUI();
				pp1.setBounds(354, 185,300, 75);
				CrearBoton(pp1);
		    	panelPruebas.add(pp1);
		    	panelPruebas.updateUI();*/
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
							botones.add(pp2);
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
       
       bPanelMesa.addActionListener(new ActionListener () {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			List <JPanel> paneles = new ArrayList <> ();
			CambiarPanel(panelReserva, panelPrimero);
			paneles=Paneles.VentanaDinamicaa(panelPrimero);
			for (int i = 0; i < paneles.size(); i++) {
				paneles.get(i).updateUI();
				frame.getContentPane().add(paneles.get(i));
				
			}
			/*int s= 40;
			int indi= 0;
			int p = 185;
			//CambiarPanel(panelInicio, panelPruebas);
			for (int x = 0; x < 2; x++) {
				JPanel panelesMult = new JPanel();
				CrearPanel(panelesMult);
				frame.getContentPane().add(panelesMult);
				//frame.update(getGraphics());
				JButton botonSiguientePanel = new JButton() {
			    	   public void paintComponent(Graphics g) {
			    		   
					        Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
					        Graphics bufferGraphics = bufferImage.getGraphics();
					        bufferGraphics.drawImage(imagenBotonBlancoPeq.getImage(), 0, 0, 300, 75, null);
					        g.drawImage(bufferImage, 0, 0, this);

					        }
					    
			      };
			       
				botonSiguientePanel.setBounds(800, 550, 300, 75);
				CrearBoton(botonSiguientePanel);
				botonSiguientePanel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						CambiarPanel(panelPrimero, panelesMult);
					}
					
				});
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
								CambiarPanel(panelPrimero, panelSegundo);
							}
							
						});
						pp2.setActionCommand(pp2.getText());	//Aqui hay que coger de la base de datos el nombre
						panelPrimero.add(pp2);
						botones.add(pp2);
						panelPrimero.updateUI();
			    	}
					p=p+100;
					s=40;
				}
			}*/
		}
    	   
       });
       bPrimerPlato.addActionListener(new ActionListener () {
    	   @Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				/*Botones pp1 = new Botones();
				pp1.setBounds(34, 185,300, 75);
				CrearBoton(pp1);
				panelPruebas.add(pp1);
		    	panelPruebas.updateUI();
				pp1.setBounds(354, 185,300, 75);
				CrearBoton(pp1);
		    	panelPruebas.add(pp1);
		    	panelPruebas.updateUI();*/
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
									CambiarPanel(panelPrimero, panelSegundo);
								}
								
							});
							pp2.setActionCommand(pp2.getText());	//Aqui hay que coger de la base de datos el nombre
							panelPrimero.add(pp2);
							botones.add(pp2);
							panelPrimero.updateUI();
				    	}
						p=p+100;
						s=40;
					}
				}
				 
			}
       });
       /*
       NBotones = cantidad de filas que tiene la tabla
<<<<<<< HEAD
=======
       select count(*) from nombetabla;
>>>>>>> refs/remotes/origin/master
       */
      /*for (int i = 1; i < 1+NBotones; i++) {
			  pp1.setLocation(38*i, 185*i);
			  
			  panelPruebas.add(pp1);
	}*/
       	
     /*  pp1.addMouseListener(new MouseListener () {
			public void mouseEntered(MouseEvent e) {
				merluza.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				CambiarPanel(panelPruebas, panelPedido);
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
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				merluza.setVisible(false);
			}
       });*/
       bAb.addMouseListener(new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				/*if (si el nombre a poder ser un string(De ahi sacar el ultimo numero ej p4b1, p4b2) es multiplo de 8 se crea un JPanel nuevo) {
					
				} else {

				}
				String p = "p4b" +x;
			     JButton v = new JButton ();
			     */
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
       
       
       
       panelInicio.add(bPanelRecogerDomicilio);
       panelInicio.add(bPanelReserva);
       panelInicio.add(botonPruebas);
       panelInicio.add(bPanelAdmin);
       
       panelAdmin.add(bPanelQuitBoton);
       panelAdmin.add(bPanelAddBoton);
       
       panelReserva.add(bPanelMesa);
       panelReserva.add(lApellidoC);
       panelReserva.add(lNombreC);
       panelReserva.add(lHoraR);
       panelReserva.add(tApellidosReserva);
       panelReserva.add(tNombreReserva);
       panelReserva.add(cHoraReserva);
       
       panelRecogerDomicilio.add(bPanelRecogida);
       panelRecogerDomicilio.add(bPanelDomicilio);       
       
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
