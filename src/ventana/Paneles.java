package ventana;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Paneles extends JPanel{
	ImageIcon imagenInicio = new ImageIcon(this.getClass().getClassLoader().getResource("frame/fondo.jpg"));
	public void paintComponent(Graphics g) {
		Image bufferImage = this.createImage(this.getSize().width, this.getSize().height);
		Graphics bufferGraphics = bufferImage.getGraphics();
		bufferGraphics.drawImage(imagenInicio.getImage(), 0, 0, 1080, 720, null);
		g.drawImage(bufferImage, 0, 0, this);

	}
}
