package ventana;



import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botones extends JButton{
	ImageIcon imagenInicio; 
	String nombre;
	Font fuente;
	
	public Botones() {
		super();
		this.nombre = " ";
		this.imagenInicio= new ImageIcon(this.getClass().getClassLoader().getResource("p4/boton.jpg"));
		
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

	/*@Override
	public void setBounds(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		super.setBounds(37, 185, 300, 75);
	}
	*/
	@Override
	public void setSize(int width, int height) {
		// TODO Auto-generated method stub
		super.setSize(300, 75);
	}
	
	public void paintComponent(Graphics g) {
		Font newFont = fuente.deriveFont(fuente.getSize() * 15F);
		Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
		Graphics bufferGraphics = bufferImage.getGraphics();
		
		bufferGraphics.drawImage(imagenInicio.getImage(), 0, 0, 300, 75, null);
		bufferGraphics.setFont(newFont);
		bufferGraphics.setColor(Color.GRAY);
		bufferGraphics.drawString(nombre, 100, 40);
		
		g.drawImage(bufferImage, 0, 0, this);

	}
	
	
	

	
}
