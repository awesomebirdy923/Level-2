import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

public class PillHalf extends Shape {
	int r = 0;
	public BufferedImage img = null;
	private URL url = getClass().getResource("Pill_Half.png");
	public boolean moving = false;
	private int PillHalfColor1;
	private int PillHalfColor2;
	private Rectangle hitBox1;
	private Rectangle hitBox2;
	private Rectangle collisionBox;

	public PillHalf(int xPos, int yPos, int width, int height) {
		super(xPos, yPos, width, height, true);
		super.update();
		PillHalfColor1 = new Random().nextInt(3) + 1;
		PillHalfColor2 = new Random().nextInt(3) + 1;
		hitBox1 = new Rectangle(xPos, yPos, width, height);
		hitBox2 = new Rectangle(xPos, yPos, width, height);
		System.out.println(PillHalfColor2);
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		r--;
		Graphics2D g2d = (Graphics2D) g;
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tint(img);
//		AffineTransform at = new AffineTransform();
		// g2d.drawImage(img, getxPos(), getyPos(), null);
//		at.translate(getxPos(), getyPos());
		
		// at.rotate(Math.PI/r);
		g2d.drawImage(img, getxPos(), getyPos(), getWidth(), getHeight(), null);
		if (moving && getyPos() <= 843 - getHeight() - 20) {
			setyPos(getyPos() + 2);
		} else{
			
		}
	}

	public void tint(BufferedImage img) {

		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {

				Color color;

				if (img.getRGB(x, y) == Color.black.getRGB()) {
					if (PillHalfColor1 == 1) {
						color = Color.red;
						Color brighter = color.brighter();

						img.setRGB(x, y, brighter.getRGB());
					} else if (PillHalfColor1 == 2) {
						color = Color.green;
						Color brighter = color.brighter();

						img.setRGB(x, y, brighter.getRGB());
					} else if (PillHalfColor1 == 3) {
						color = Color.blue;
						Color brighter = color.brighter();

						img.setRGB(x, y, brighter.getRGB());
					}

				} else if (img.getRGB(x, y) == new Color(71, 255, 0).getRGB()) {
					if (PillHalfColor2 == 1) {
						color = Color.red;
						Color brighter = color.brighter();

						img.setRGB(x, y, brighter.getRGB());
					} else if (PillHalfColor2 == 2) {
						color = Color.green;
						Color brighter = color.brighter();

						img.setRGB(x, y, brighter.getRGB());
					} else if (PillHalfColor2 == 3) {
						color = Color.blue;
						Color brighter = color.brighter();

						img.setRGB(x, y, brighter.getRGB());
					}
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

	

	public void update() {
		hitBox1 = new Rectangle(getxPos(), getyPos(), getWidth() / 2, getHeight() / 2);
		hitBox2 = new Rectangle(getxPos(), getyPos() + getHeight() / 2, getWidth(), getHeight() / 2);
		collisionBox = new Rectangle(getxPos(), getyPos(), getWidth(), getHeight());
	}

}
