package ventana;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import ventana.Botones;


public class VentanaDinamica extends JFrame{

	private List<JButton> botones;

	private JScrollPane scroll;
	private JButton botonAgre;
	private JPanel panel, panel1;
	public VentanaDinamica() {
		botones = new ArrayList<>();

		scroll = new JScrollPane();
		JFrame frame = new JFrame ();
		panel = new JPanel ();
		botonAgre = new JButton("Agregar");
		panel1 = new JPanel();
		ImageIcon imagenBotonBlancoPeq = new ImageIcon(this.getClass().getClassLoader().getResource("p4/boton.jpg"));

		botonAgre.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CambiarPanel(panel, panel1);
				int s= 40;
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
							CambiarPanel(panel1, panelesMult);
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
									CambiarPanel(panel1, panel);
								}
								
							});
							pp2.setActionCommand(pp2.getText());	//Aqui hay que coger de la base de datos el nombre
							panel1.add(pp2);
							botones.add(pp2);
							panel1.updateUI();
				    	}
						p=p+100;
						s=40;
					}
				}
			}
	    	   
			
		});
		panel.add(botonAgre);
		panel.add(scroll);
		
		frame.add(panel);
		frame.add(panel1);
		frame.setBounds(350, 300, 1080, 720);
	       frame.setVisible(true);
	       frame.setTitle("Insertar nombre");
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setVisible(true);
	       frame.setLayout(null);
	       frame.setTitle("Bora");	
	}
	public void CrearPanel(JPanel g) {
		g.setLayout(null);
		g.setVisible(false);
		g.setEnabled(false);
		g.setBounds(0, 0, 1080, 720);
		

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new VentanaDinamica();

			}

		});
	}

}