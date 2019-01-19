package ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonesGrandes extends JButton{
	ImageIcon imagenInicio; 
	String nombre;
	Font fuente;
	
	public BotonesGrandes() {
		super();
		this.nombre = " ";
		this.imagenInicio= new ImageIcon(this.getClass().getClassLoader().getResource("p4/botonGrandeBlanco.jpg"));
		
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
		 
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public void setSize(int width, int height) {
		// TODO Auto-generated method stub
		super.setSize(400, 350);
	}
	@Override
	
	public void paintComponent(Graphics g) {
		Font newFont = fuente.deriveFont(fuente.getSize() * 20F);
		Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
		Graphics bufferGraphics = bufferImage.getGraphics();
		
		bufferGraphics.drawImage(imagenInicio.getImage(), 0, 0, 400, 350, null);
		bufferGraphics.setFont(newFont);
		bufferGraphics.setColor(Color.black);
		bufferGraphics.drawString(nombre, 90, 190);
		
		//bufferGraphics.drawImage(imagenPaco.getImage(), 10, 10, 50, 50, null);
		g.drawImage(bufferImage, 0, 0, this);

	}
}
