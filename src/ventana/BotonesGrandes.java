package ventana;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonesGrandes extends JButton{
	ImageIcon imagenInicio = new ImageIcon(this.getClass().getClassLoader().getResource("p4/botonGrandeBlanco.jpg"));
	ImageIcon imagenPaco = new ImageIcon(this.getClass().getClassLoader().getResource("p4/paco.jpeg"));
	
	@Override
	public void setSize(int width, int height) {
		// TODO Auto-generated method stub
		super.setSize(400, 350);
	}
	@Override
	
	public void paintComponent(Graphics g) {
		Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
		Graphics bufferGraphics = bufferImage.getGraphics();
		
		bufferGraphics.drawImage(imagenInicio.getImage(), 0, 0, 400, 350, null);
		
		
		//bufferGraphics.drawImage(imagenPaco.getImage(), 10, 10, 50, 50, null);
		g.drawImage(bufferImage, 0, 0, this);

	}
}
