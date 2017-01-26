import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Pill extends Shape {
	public BufferedImage img = null;
	private URL url = getClass().getResource("pill.png");
	public boolean moving = false;

	public Pill(int xPos, int yPos, int width, int height) {
		super(xPos, yPos, width, height);
		super.update();
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tint(img);
		g.drawImage(img, getxPos(), getyPos(), null);
		if (moving) {
			setyPos(getyPos() + 2);
		}
	}

	public static void tint(BufferedImage img) {

		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {

				Color color;

				if (img.getRGB(x, y) == Color.white.getRGB()) {
					color = Color.red;
					Color brighter = color.brighter();

					img.setRGB(x, y, brighter.getRGB());
				} else if (img.getRGB(x, y) == new Color(71, 255, 0).getRGB()) {
					color = Color.blue;
					Color brighter = color.brighter();

					img.setRGB(x, y, brighter.getRGB());
				}

				// do something with the color :) (change the hue, saturation
				// and/or brightness)
				// float[] hsb = new float[3];
				// Color.RGBtoHSB(color.getRed(), old.getGreen(), old.getBlue(),
				// hsb);

				// or just call brighter to just tint it
			}
		}
	}
}
