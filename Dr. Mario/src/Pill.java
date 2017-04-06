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

public class Pill extends Shape {
	int r = 0;
	public BufferedImage img = null;
	// private URL url = getClass().getResource("pill.png");
	public boolean moving = false;
	private int pillColor1;
	private int pillColor2;
	private Rectangle hitBox1;
	private Rectangle hitBox2;
	public boolean isPillFalling = true;

	public Pill(int xPos, int yPos, int width, int height) {
		super(xPos, yPos, width, height, true);
		super.update();
		pillColor1 = new Random().nextInt(3) + 1;
		pillColor2 = new Random().nextInt(3) + 1;
		hitBox1 = new Rectangle(xPos, yPos, width, height);
		try {
			img = ImageIO.read(this.getClass().getResourceAsStream("pill.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tint(img);
		// hitBox2 = new Rectangle(xPos, yPos, width, height);
	}

	public boolean isisPillFalling() {
		return isPillFalling;
	}

	public void setisPillFalling(boolean isPillFalling) {
		this.isPillFalling = isPillFalling;
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, getxPos(), getyPos(), null);
		// System.out.println("Hi.");
//		r--;
//		Graphics2D g2d = (Graphics2D) g;
//		tint(img);
//		AffineTransform at = new AffineTransform();
//		// g2d.drawImage(img, getxPos(), getyPos(), null);
//		at.translate(getxPos(), getyPos());
//		// at.rotate(Math.PI/r);
//		g2d.drawImage(img, at, null);
		// if (moving && getyPos() <= 843 - getHeight() - 20) {
		// setyPos(getyPos() + 2);
		// } else{
		// moving = false;
		// }
	}

	public void setImage(URL url) {

	}

	public void tint(BufferedImage img) {

		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {

				Color color;

				if (img.getRGB(x, y) == Color.white.getRGB()) {
					if (pillColor1 == 1) {
						color = Color.red;
						Color brighter = color.brighter();

						img.setRGB(x, y, brighter.getRGB());
					} else if (pillColor1 == 2) {
						color = Color.green;
						Color brighter = color.brighter();

						img.setRGB(x, y, brighter.getRGB());
					} else if (pillColor1 == 3) {
						color = Color.blue;
						Color brighter = color.brighter();

						img.setRGB(x, y, brighter.getRGB());
					}

				} else if (img.getRGB(x, y) == new Color(71, 255, 0).getRGB()) {
					if (pillColor2 == 1) {
						color = Color.red;
						Color brighter = color.brighter();

						img.setRGB(x, y, brighter.getRGB());
					} else if (pillColor2 == 2) {
						color = Color.green;
						Color brighter = color.brighter();

						img.setRGB(x, y, brighter.getRGB());
					} else if (pillColor2 == 3) {
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
		// hitBox1 = new Rectangle(getxPos(), getyPos(), getWidth() / 2,
		// getHeight() / 2);
		// hitBox2 = new Rectangle(getxPos(), getyPos() + getHeight() / 2,
		// getWidth(), getHeight() / 2);

		if (isPillFalling) {
			setyPos(getyPos() + 1);
		}
		if (getyPos() >= 792) {
			isPillFalling = false;
		}
		collisionBox = new Rectangle(getxPos(), getyPos(), getWidth() - 8, getHeight() - 8);
	}

}
