package Pruebas;


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
//commit

public class VentanaDinamica extends JFrame{
	int prueba = 0;
	int borrarbi = 0;
	int borrarbo = 0;
	String nombrebotoncambio = " " + 0;
	private List<JButton> botones, cambio;
	private List<JPanel> paneles;
	private JScrollPane scroll;
	private JButton botonAgre;
	private JPanel panel, panel1;
	public VentanaDinamica() {
		botones = new ArrayList<>();
		cambio = new ArrayList<>();
		paneles = new ArrayList<>();
		
		JFrame frame1 = new JFrame ();
		panel = new JPanel ();
		panel.setVisible(true);
		panel.setEnabled(true);
		panel.setLayout(null);
		panel.setBounds(0, 0, 1080, 720);
		botonAgre = new JButton("Agregar");
		panel1 = new JPanel();
		CrearPanel(panel1);
		
		botonAgre.setBounds(500, 400, 100, 100);
		botonAgre.setVisible(true);
		paneles.add(panel1);
		
		
		botonAgre.addActionListener(new ActionListener () {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CambiarPanel(panel, paneles.get(0));
				
				int s= 40;
				int indi= 0;
				int p = 185;
				
				for (int x = 0; x <40 ; x++) {
					JPanel panelesMult = new JPanel();
					panelesMult.setName("panelesMult" + x);
					CrearPanel(panelesMult);
					frame1.getContentPane().add(panelesMult);
					paneles.add(panelesMult);
					JButton botonSiguientePanel = new JButton("siguiente panel");
					botonSiguientePanel.setBounds(390, 550, 300, 75);
					
					botonSiguientePanel.setName("bSiguiente"+x);
					cambio.add(botonSiguientePanel);
					paneles.get(x).add(botonSiguientePanel);
					paneles.get(x).updateUI();
					botonSiguientePanel.addActionListener(new ActionListener() {
					
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							CambiarPanel(paneles.get(prueba), paneles.get(prueba+1));
							prueba++;
							paneles.get(prueba).add(botonSiguientePanel);
							paneles.get(prueba).updateUI();
						}
						
					});
					if (x==0) {
						panel1.add(cambio.get(0));
					} else if (x>0) {
						panelesMult.getName();
						panelesMult.add(cambio.get(x));
					}
					for (int i = 0; i < 3; i++) {
						
			
						for (int o = 0; o < 3; o++) {
							
							JButton pp2 = new JButton();
							//CrearBoton(pp2);
							pp2.setBounds(s, p,300, 75);
							pp2.setText("prueba"+x+i+o);
							botones.add(pp2);
							s=320+s;
							paneles.get(x).add(pp2);
							paneles.get(x).updateUI();
							pp2.setName("prueba"+x+i+o);
							panel1.updateUI();
							pp2.addActionListener(new ActionListener () {

								@Override
								public void actionPerformed(ActionEvent arg0) {
									// TODO Auto-generated method stub
									System.out.println(arg0.getSource());//9*prueba
								}
								
							});
							//pp2.setActionCommand(pp2.getText());	//Aqui hay que coger de la base de datos el nombre
							
							borrarbo++;
							
				    	}
					
						p=p+100;
						s=40;
						borrarbi++;
					}
					s=40;
					p=185;
				}
				for (int i = 0; i < botones.size(); i++) {
					System.out.println(botones.get(i));
					
				}
				
			}
	    	   
			
		});
		panel.add(botonAgre);
		//panel.add(scroll);
		
		frame1.add(panel);
		frame1.add(panel1);
		frame1.setBounds(350, 300, 1080, 720);
	       frame1.setVisible(true);
	       frame1.setTitle("Insertar nombre");
	       frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame1.setVisible(true);
	       frame1.setLayout(null);
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