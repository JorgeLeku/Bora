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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton p1b1, p1b2, p2b1, p2b2, p2b3, p2b4, p3b1, p3b2, botonPruebas, pp1, bAb, bAtr, cbb1, cbb2;
	JLabel cbl1, cbl2, cbl3, cbl4, fl1, fl2;
	JTextField cbt1;
	Font fuente;
	
	int x = 1;
	public Principal() {
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
       
       ImageIcon imagenInicio = new ImageIcon(this.getClass().getClassLoader().getResource("frame/fondoBienvenida.jpg"));
       
       JFrame frame = new JFrame();
       Paneles panelPruebas = new Paneles ();
       Paneles panelPedido = new Paneles();
       Paneles panelECarta = new Paneles();
       Paneles panelCartaMenu = new Paneles();
       Paneles panelPPlato = new Paneles();
       Paneles panelSPlato = new Paneles();
       Paneles panelPostre = new Paneles();
       Paneles panelEMenu = new Paneles();
       Paneles panelReserva = new Paneles();
       Paneles panelPersonas = new Paneles();
       Paneles panelCreacionBoton = new Paneles ();
       Paneles panelFactura = new Paneles ();
       JPanel panelBienvenida =  new JPanel(){
			public void paintComponent(Graphics g) {
		        Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
		        Graphics bufferGraphics = bufferImage.getGraphics();
		        bufferGraphics.drawImage(imagenInicio.getImage(), 0, 0, 1080, 720, null);
		        g.drawImage(bufferImage, 0, 0, this);
		       
		    }
			};

       CrearPanel(panelCartaMenu);
       CrearPanel(panelEMenu);
       CrearPanel(panelReserva);
       CrearPanel(panelPostre);
       CrearPanel(panelSPlato);
       CrearPanel(panelPPlato);
       CrearPanel(panelECarta);
       CrearPanel(panelPedido);
       CrearPanel(panelPersonas);
       CrearPanel(panelPruebas);
       CrearPanel(panelBienvenida);
       CrearPanel(panelCreacionBoton);
       CrearPanel(panelFactura);

       panelBienvenida.setVisible(true);
       panelBienvenida.setEnabled(true);

       ImageIcon imagenp1b2 = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b2.jpg"));
       ImageIcon imagenp1b1 = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b1.jpg"));
       ImageIcon imagenp2b1 = new ImageIcon(this.getClass().getClassLoader().getResource("p2/p2b1.jpg"));
       ImageIcon imagenp2b2 = new ImageIcon(this.getClass().getClassLoader().getResource("p2/p2b3.jpg"));
       ImageIcon imagenp2b3 = new ImageIcon(this.getClass().getClassLoader().getResource("p2/p2b2.jpg"));
       ImageIcon imagenp3b1 = new ImageIcon(this.getClass().getClassLoader().getResource("p3/p3b1.jpg"));
       ImageIcon imagenp3b2 = new ImageIcon(this.getClass().getClassLoader().getResource("p3/p3b2.jpg"));
       ImageIcon imagenp4b1 = new ImageIcon(this.getClass().getClassLoader().getResource("p4/p4b1.jpg"));
       ImageIcon imagenbAb = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bAb.png"));
       ImageIcon imagenbAtr = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bAtr.png"));
       ImageIcon imagenbAtrbn = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bAtrb-n.png"));
       ImageIcon imagenbAbbn = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bAbb-n.png"));
       ImageIcon imagencbb2 = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bs1.png"));
       ImageIcon imagencbb2bn = new ImageIcon(this.getClass().getClassLoader().getResource("bg/bs1b-n.png"));
       ImageIcon imagenPrueba = new ImageIcon(this.getClass().getClassLoader().getResource("prueba.png"));
       ImageIcon imagenp1b2bn = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b2b-n.jpg"));
       ImageIcon imagenp1b1bn = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b1b-n.jpg"));
       ImageIcon imagenp2b1bn = new ImageIcon(this.getClass().getClassLoader().getResource("p2/p2b1b-n.jpg"));
       ImageIcon imagenp2b2bn = new ImageIcon(this.getClass().getClassLoader().getResource("p2/p2b3b-n.jpg"));
       ImageIcon imagenp2b3bn = new ImageIcon(this.getClass().getClassLoader().getResource("p2/p2b2b-n.jpg"));
       ImageIcon imagenp3b1bn = new ImageIcon(this.getClass().getClassLoader().getResource("p3/p3b1b-n.jpg"));
       ImageIcon imagenp3b2bn = new ImageIcon(this.getClass().getClassLoader().getResource("p3/p3b2b-n.jpg"));
       ImageIcon imagenp4b1bn = new ImageIcon(this.getClass().getClassLoader().getResource("p4/p4b1b-n.jpg"));
       
       //sad
       
       p1b1 = new JButton(imagenp1b1);
       p1b2 = new JButton(imagenp1b2);
       p2b1 = new JButton(imagenp2b1);
       p2b2 = new JButton(imagenp2b2);
       p2b3 = new JButton(imagenp2b3);
       p3b1 = new JButton(imagenp3b1);
       p3b2 = new JButton(imagenp3b2);
       bAb = new JButton(imagenbAb);
       bAtr = new JButton (imagenbAtr);
       cbb1 = new JButton(imagenbAb);
       cbb2 = new JButton(imagencbb2);
       cbb2.setRolloverIcon(imagencbb2bn);
       cbb1.setRolloverIcon(imagenbAbbn);
       bAtr.setRolloverIcon(imagenbAtrbn);
       bAb.setRolloverIcon(imagenbAbbn);
       p1b1.setRolloverIcon(imagenp1b1bn);
       p1b2.setRolloverIcon(imagenp1b2bn);
       p2b1.setRolloverIcon(imagenp2b1bn);
       p2b2.setRolloverIcon(imagenp2b2bn);
       p2b3.setRolloverIcon(imagenp2b3bn);
       p3b1.setRolloverIcon(imagenp3b2bn);
       p3b2.setRolloverIcon(imagenp3b1bn);
       botonPruebas = new JButton(imagenPrueba);
       pp1 = new JButton(imagenp4b1);
       pp1.setRolloverIcon(imagenp4b1bn);

       cbt1 = new JTextField();
       cbt1.setBounds(500, 250, 200, 40);
       
       cbl1 = new JLabel();
       cbl1.setBounds(250, 250, 400, 40);
       cbl1.setFont(newFont);
       cbl1.setText("Nombra  el  producto");
       
       cbl2 = new JLabel();
       cbl2.setBounds(450, 200, 400, 40);
       cbl2.setFont(newFont);
       cbl2.setText("Crear boton");
       
       cbl3 = new JLabel();
       cbl3.setBounds(250, 340, 400, 40);
       cbl3.setFont(newFont);
       cbl3.setText("Elegir imagen");
       
       cbl4 = new JLabel();
       cbl4.setBounds(750, 250, 200, 40);
       cbl4.setFont(newFont);
       
       fl1 = new JLabel();
       fl1.setBounds(500, 250, 200, 40);
       fl1.setFont(newFont);
       fl1.setText("Factura");
       
       fl2 = new JLabel();
       fl1.setBounds(350, 550, 200, 40);
       fl1.setFont(newFont);
       fl1.setText("Total");
       
       
       CrearBoton(p1b1);
       CrearBoton(p1b2);
       CrearBoton(p2b1);
       CrearBoton(p2b2);
       CrearBoton(p2b3);
       CrearBoton(p3b1);
       CrearBoton(p3b2);
       CrearBoton(pp1);
       CrearBoton(bAb);
       CrearBoton(bAtr);
       CrearBoton(cbb1);
       CrearBoton(cbb2);
       
       
       p1b1.setBounds(93, 185, 400, 350);
       p1b2.setBounds(566, 185, 400, 350);
       p2b1.setBounds(93, 205, 400, 125);
       p2b2.setBounds(293, 380, 400, 125);
       p2b3.setBounds(566, 205, 400, 125);
       p3b1.setBounds(93, 185, 400, 350);
       p3b2.setBounds(566, 185, 400, 350);
       botonPruebas.setBounds(0, 0, 500, 500);

       pp1.setBounds(38, 185, 300, 75);
       bAb.setBounds(500, 30, 80, 80);
       bAtr.setBounds(30, 30, 80, 80);
       cbb1.setBounds(500, 450, 80, 80);
       cbb2.setBounds(450, 325, 300, 75);

		
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
			CambiarPanel(panelBienvenida, panelPedido);
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
				CambiarPanel(panelPedido, panelPruebas);

			}

       });
//borrar esto <--
       p1b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelPedido, panelCartaMenu);
			}

       });

       p1b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelPedido, panelCartaMenu);
			}

       });

       p2b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelECarta, panelPPlato);
			}

       });

       p2b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelECarta, panelSPlato);
			}

       });

       p2b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelECarta, panelPostre);
			}

       });

       p3b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelCartaMenu, panelECarta);
			}

       });

       p3b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelCartaMenu, panelEMenu);
			}

       });

		
       pp1.addMouseListener(new MouseListener () {
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
       });
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
				CambiarPanel(panelPruebas, panelCreacionBoton);
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
       bAtr.addMouseListener(new MouseListener() {
		
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
			if (panelPedido.isEnabled()== true) {
				CambiarPanel(panelPedido, panelPedido);
			} else if (panelCartaMenu.isEnabled()==true){
				CambiarPanel(panelCartaMenu, panelPedido);
			} else if (panelECarta.isEnabled()==true) {
				CambiarPanel(panelECarta, panelCartaMenu);
			} else if (panelEMenu.isEnabled()==true) {
				CambiarPanel(panelEMenu, panelCartaMenu);
			} else if (panelPruebas.isEnabled()==true) {
				CambiarPanel(panelPruebas, panelPedido);
			}
		}
	});
       cbb2.addActionListener(new ActionListener() {

    	   //  Lo que sucede al pulsar el boton
    	 public void actionPerformed(ActionEvent ae) {

    	 //Creamos selector de aperture

    	 JFileChooser fileChooser = new JFileChooser();

    	 int returnValue = fileChooser.showOpenDialog(null);// Nos retorna un entero

    	 // Si apretamos en aceptar un archive ocurrira esto

    	 if (returnValue == JFileChooser.APPROVE_OPTION) {

    	 File selectedFile = fileChooser.getSelectedFile();

    	 System.out.println(selectedFile.getName());
    	 cbl4.setText(selectedFile.getAbsolutePath());
    	 }

       }

    });
       
       cbb1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(cbt1.getText());
			System.out.println(cbl4.getText());
		}
	});
       
       
       
       panelPedido.add(p1b1);
       panelPedido.add(p1b2);
       panelECarta.add(p2b1);
       panelECarta.add(p2b2);
       panelECarta.add(p2b3);
       panelCartaMenu.add(p3b1);
       panelCartaMenu.add(p3b2);
       panelPedido.add(botonPruebas);
       panelPruebas.add(pp1);
       panelPruebas.add(bAb);	
       panelCreacionBoton.add(cbb1);
       panelCreacionBoton.add(cbt1);
       panelCreacionBoton.add(cbl1);
       panelCreacionBoton.add(cbl2);
       panelCreacionBoton.add(cbl3);
       panelCreacionBoton.add(cbb2);
       panelCreacionBoton.add(cbl4);
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
       
       frame.getContentPane().add(panelPedido);
       frame.getContentPane().add(panelECarta);
       frame.getContentPane().add(panelPPlato);
       frame.getContentPane().add(panelSPlato);
       frame.getContentPane().add(panelPostre);
       frame.getContentPane().add(panelCartaMenu);
       frame.getContentPane().add(panelReserva);
       frame.getContentPane().add(panelPersonas);
       frame.getContentPane().add(panelPruebas);
       frame.getContentPane().add(panelBienvenida);
       frame.getContentPane().add(panelCreacionBoton);
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
		h.add(bAtr);
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
