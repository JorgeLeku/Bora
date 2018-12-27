package ventana;



import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botones extends JButton{
	ImageIcon imagenInicio = new ImageIcon(this.getClass().getClassLoader().getResource("p4/boton.jpg"));
	ImageIcon imagenPaco = new ImageIcon(this.getClass().getClassLoader().getResource("p4/paco.jpeg"));
	@Override
	public void setBounds(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		super.setBounds(37, 185, 300, 75);
	}
	@Override
	
	public void paintComponent(Graphics g) {
		Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
		Graphics bufferGraphics = bufferImage.getGraphics();
		bufferGraphics.drawImage(imagenInicio.getImage(), 0, 0, 300, 75, null);
		g.drawImage(bufferImage, 0, 0, this);

	}
	
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
		Graphics bufferGraphics = bufferImage.getGraphics();
		bufferGraphics.drawImage(imagenPaco.getImage(), 10, 10, 300, 75, null);
		g.drawImage(bufferImage, 0, 0, this);
	}
	/*@Override
	public void setIcon(Icon defaultIcon) {
		// TODO Auto-generated method stub
		super.setIcon(fondoBoton);
	}*/

	
}
