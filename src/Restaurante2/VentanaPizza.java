package Restaurante2;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class VentanaPizza extends JFrame {

	private JRadioButton radioPequenyo;
	private JRadioButton radioMediano;
	private JRadioButton radioGrande;
	private JComboBox comboTipo;
	private JCheckBox extraQueso;
	private JCheckBox extraAceite;
	private JCheckBox extraSalsa;
	private JButton botonPedir;
	
	public VentanaPizza() {
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(4, 1));
		
		JPanel panelTam = new JPanel();
		JPanel panelTipo = new JPanel();
		JPanel panelExtras = new JPanel();
		JPanel panelBoton = new JPanel();
		
		radioPequenyo = new JRadioButton("Pequeño");
		radioMediano = new JRadioButton("Mediano");
		radioGrande = new JRadioButton("Grande");
		
		ButtonGroup radioTam = new ButtonGroup();
		radioTam.add(radioPequenyo);
		radioTam.add(radioMediano);
		radioTam.add(radioGrande);
		
		radioPequenyo.setSelected(true);
		
		panelTam.add(new JLabel("Selecciona el tamaño: "));
		panelTam.add(radioPequenyo);
		panelTam.add(radioMediano);
		panelTam.add(radioGrande);
		
		comboTipo = new JComboBox();
		comboTipo.addItem("Margarita");
		comboTipo.addItem("4 Quesos");
		comboTipo.addItem("Carbonara");
		comboTipo.addItem("Barbacoa");
		
		panelTipo.add(new JLabel("Selecciona el tipo: "));
		panelTipo.add(comboTipo);
		
		extraQueso = new JCheckBox("Queso");
		extraAceite = new JCheckBox("Aceite");
		extraSalsa = new JCheckBox("Salsa barbacoa");
		
		panelExtras.add(new JLabel("Selecciona los extras: "));
		panelExtras.add(extraQueso);
		panelExtras.add(extraAceite);
		panelExtras.add(extraSalsa);
		
		botonPedir = new JButton("Pedir");
		botonPedir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Pizza nueva;
				int tam;
				String tip;
				ArrayList<String> ext;
				
				if (radioPequenyo.isSelected()) {
					tam = 0;
				} else if (radioMediano.isSelected()) {
					tam = 1;
				} else {
					tam = 2;
				}
				
				tip = (String) comboTipo.getSelectedItem();
				
				ext = new ArrayList<String>();
				
				if (extraQueso.isSelected()) {
					ext.add("Queso");
				}
				
				if (extraAceite.isSelected()) {
					ext.add("Aceite");
				}
				
				if (extraSalsa.isSelected()) {
					ext.add("Salsa barbacoa");
				}
				
				nueva = new Pizza(tam, tip, ext);
				
				JOptionPane.showMessageDialog(rootPane, "Has pedido una " + nueva.toString());
			}
			
		});
		panelBoton.add(botonPedir);
		
		cp.add(panelTam);
		cp.add(panelTipo);
		cp.add(panelExtras);
		cp.add(panelBoton);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Pizzas");
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaPizza();			
			}
		});

	}

}
