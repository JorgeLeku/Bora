package ventana;



import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botones extends JButton{
	ImageIcon imagenInicio = new ImageIcon(this.getClass().getClassLoader().getResource("p4/boton.jpg"));

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
		Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
		Graphics bufferGraphics = bufferImage.getGraphics();
		
		bufferGraphics.drawImage(imagenInicio.getImage(), 0, 0, 300, 75, null);
		//bufferGraphics.drawString(nombre, 50, 20);
		
		g.drawImage(bufferImage, 0, 0, this);

	}
	
	
	

	
}
