package Bora.src.Visual;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



	

	public class Principal extends JFrame{
		JButton p1b1, p1b2;
		public Principal (){
			ImageIcon imagenInicio = new ImageIcon(this.getClass().getClassLoader().getResource("fondo.jpg"));

			JPanel panelPedido = new JPanel (){
				public void paintComponent(Graphics g) {
			        Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
			        Graphics bufferGraphics = bufferImage.getGraphics();
			        bufferGraphics.drawImage(imagenInicio.getImage(), 0, 0, 1080, 720, null);
			        g.drawImage(bufferImage, 0, 0, this);
			       
			    }
				};
			JPanel panelEMenu = new JPanel ();
			
			JFrame frame = new JFrame ();
		
			
			panelPedido.setLayout(null);
			panelPedido.setVisible(true);
			panelPedido.setEnabled(true);
			panelEMenu.setVisible(false);
			panelEMenu.setEnabled(false);
			panelPedido.setBounds(0, 0, 1080, 720);
			panelEMenu.setBounds(0, 0, 1080, 720);
			
		
			panelEMenu.setBackground(Color.black);
			p1b1 = new JButton ("Comer en restaurante");
			
			p1b2 = new JButton ("Llevar");
			ImageIcon imagenp1b1 = new ImageIcon(this.getClass().getClassLoader().getResource("p1b1.jpg"));
			p1b1.setIcon(imagenp1b1);
			p1b1.setBounds(93, 185, 400, 350);
			ImageIcon imagenp1b2 = new ImageIcon(this.getClass().getClassLoader().getResource("p1b2.jpg"));
			p1b2.setIcon(imagenp1b2);
			p1b2.setBounds(566, 185, 400, 350);
			panelPedido.add(p1b1);
			panelPedido.add(p1b2);
			
			//frame.setIconImage(imagenIcono.getImage());
			frame.setBounds(350, 300, 1080, 720);
			frame.setVisible(true);
			frame.setTitle("Insertar nombre");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.setLayout(null);
			
			frame.getContentPane().add(panelPedido);
			frame.getContentPane().add(panelEMenu);
		}
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable () {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					new Principal ();
					
				}
				
			});
		}
	}



