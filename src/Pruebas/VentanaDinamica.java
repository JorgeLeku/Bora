package Pruebas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import ventana.Principal;

public class VentanaDinamica extends JFrame{

	private List<JButton> botones;
	private int indice;
	private JScrollPane scroll;
	private JButton botonAgre;
	private JPanel panel;
	public VentanaDinamica() {
		botones = new ArrayList<>();
		indice = 0;
		scroll = new JScrollPane();
		JFrame frame = new JFrame ();
		panel = new JPanel ();
		botonAgre = new JButton("Agregar");
		botonAgre.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JButton boton =new JButton ("boton" + indice);
				panel.add(boton);
				botones.add(boton);
				panel.updateUI();
			}
			
		});
		panel.add(botonAgre);
		panel.add(scroll);
		
		frame.add(panel);
		frame.setBounds(350, 300, 1080, 720);
	       frame.setVisible(true);
	       frame.setTitle("Insertar nombre");
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setVisible(true);
	       frame.setLayout(null);
	       frame.setTitle("Bora");	
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
