package ventana;



import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Principal extends JFrame {
	JButton p1b1, p1b2, p2b1, p2b2, p2b3, p2b4, p3b1, p3b2, botonPruebas, pp1, pp2, pp3, pp4, pp5, pp6, pp7, pp8, pp9,
			pp10, pp11, pp12;
	Font fuente;

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

		panelPedido.setVisible(true);
		panelPedido.setEnabled(true);

		ImageIcon imagenp1b2 = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b2.jpg"));
		ImageIcon imagenp1b1 = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b1.jpg"));
		ImageIcon imagenp2b1 = new ImageIcon(this.getClass().getClassLoader().getResource("p2/p2b1.jpg"));
		ImageIcon imagenp2b2 = new ImageIcon(this.getClass().getClassLoader().getResource("p2/p2b3.jpg"));
		ImageIcon imagenp2b3 = new ImageIcon(this.getClass().getClassLoader().getResource("p2/p2b2.jpg"));
		ImageIcon imagenp3b1 = new ImageIcon(this.getClass().getClassLoader().getResource("p3/p3b1.jpg"));
		ImageIcon imagenp3b2 = new ImageIcon(this.getClass().getClassLoader().getResource("p3/p3b2.jpg"));
		ImageIcon imagenp4b1 = new ImageIcon(this.getClass().getClassLoader().getResource("p4/p4b1.jpg"));
		ImageIcon imagenPrueba = new ImageIcon(this.getClass().getClassLoader().getResource("prueba.png"));
		ImageIcon imagenp1b2bn = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b2b-n.jpg"));
		ImageIcon imagenp1b1bn = new ImageIcon(this.getClass().getClassLoader().getResource("p1/p1b1b-n.jpg"));
		ImageIcon imagenp2b1bn = new ImageIcon(this.getClass().getClassLoader().getResource("p2/p2b1b-n.jpg"));
		ImageIcon imagenp2b2bn = new ImageIcon(this.getClass().getClassLoader().getResource("p2/p2b3b-n.jpg"));
		ImageIcon imagenp2b3bn = new ImageIcon(this.getClass().getClassLoader().getResource("p2/p2b2b-n.jpg"));
		ImageIcon imagenp3b1bn = new ImageIcon(this.getClass().getClassLoader().getResource("p3/p3b1b-n.jpg"));
		ImageIcon imagenp3b2bn = new ImageIcon(this.getClass().getClassLoader().getResource("p3/p3b2b-n.jpg"));
		ImageIcon imagenp4b1bn = new ImageIcon(this.getClass().getClassLoader().getResource("p4/p4b1b-n.jpg"));
		
		p1b1 = new JButton(imagenp1b1);
		p1b2 = new JButton(imagenp1b2);
		p2b1 = new JButton(imagenp2b1);
		p2b2 = new JButton(imagenp2b2);
		p2b3 = new JButton(imagenp2b3);
		p3b1 = new JButton(imagenp3b1);
		p3b2 = new JButton(imagenp3b2);
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
		pp2 = new JButton("p1");
		pp3 = new JButton("p1");
		pp4 = new JButton("p1");
		pp5 = new JButton("p1");
		pp6 = new JButton("p1");
		pp7 = new JButton("p1");
		pp8 = new JButton("p1");
		pp9 = new JButton("p1");
		pp10 = new JButton("p1");
		pp11 = new JButton("p1");
		pp12 = new JButton("p1");
		
		CrearBoton(p1b1);
		CrearBoton(p1b2);
		CrearBoton(p2b1);
		CrearBoton(p2b2);
		CrearBoton(p2b3);
		CrearBoton(p3b1);
		CrearBoton(p3b2);
		CrearBoton(pp1);

		p1b1.setBounds(93, 185, 400, 350);
		p1b2.setBounds(566, 185, 400, 350);
		p2b1.setBounds(93, 205, 400, 125);
		p2b2.setBounds(293, 380, 400, 125);
		p2b3.setBounds(566, 205, 400, 125);
		p3b1.setBounds(93, 185, 400, 350);
		p3b2.setBounds(566, 185, 400, 350);
		botonPruebas.setBounds(0, 0, 50, 50);

		pp1.setBounds(38, 185, 300, 75);
		pp2.setBounds(38, 275, 300, 75);
		pp3.setBounds(38, 365, 300, 75);
		pp4.setBounds(38, 455, 300, 75);
		pp5.setBounds(379, 185, 300, 75);
		pp6.setBounds(379, 275, 300, 75);
		pp7.setBounds(379, 365, 300, 75);
		pp8.setBounds(379, 455, 300, 75);
		pp9.setBounds(722, 185, 300, 75);
		pp10.setBounds(722, 275, 300, 75);
		pp11.setBounds(722, 365, 300, 75);
		pp12.setBounds(722, 455, 300, 75);

		
		JLabel merluza = new JLabel ();
		merluza.setFont(newFont);
		merluza.setForeground(Color.white);
		merluza.setText("<html><body>Ingredientes:  1  cogote  de  merluza  del  cantábrico,  sal  de  Añana  al  vino,  4  dientes  de  ajo,<br>aceite  de  oliva  virgen  extra,  vinagre  de  sidra,  1  pimienta  cayena,  1  manojo  de  perejil.</body></html>" );
		merluza.setBounds(50, 450, 1080, 300);
		merluza.setBorder(null);
		merluza.setVisible(false);
		merluza.setOpaque(false);
		panelPruebas.add(merluza);
		
		botonPruebas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Base de datos
				CambiarPanel(panelPedido, panelPruebas);

			}

		});

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
		
		panelPedido.add(p1b1);
		panelPedido.add(p1b2);
		panelECarta.add(p2b1);
		panelECarta.add(p2b2);
		panelECarta.add(p2b3);
		panelCartaMenu.add(p3b1);
		panelCartaMenu.add(p3b2);
		panelPedido.add(botonPruebas);
		panelPruebas.add(pp1);
		panelPruebas.add(pp2);
		panelPruebas.add(pp3);
		panelPruebas.add(pp4);
		panelPruebas.add(pp5);
		panelPruebas.add(pp6);
		panelPruebas.add(pp7);
		panelPruebas.add(pp8);
		panelPruebas.add(pp9);
		panelPruebas.add(pp10);
		panelPruebas.add(pp11);
		panelPruebas.add(pp12);

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
