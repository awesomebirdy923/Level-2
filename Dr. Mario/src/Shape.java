import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Shape {
	public boolean isAlive = true;
	public int xPos;
	public int yPos;
	public int width;
	public int height;
	public Rectangle collisionBox;
	private BufferedImage img;
	private boolean isImage;

	public Shape(int xPos, int yPos, int width, int height, boolean isImage) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.isImage = isImage;
		collisionBox = new Rectangle(xPos, yPos, width, height);
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void render(Graphics g) {
		if(!isImage){
		g.setColor(Color.pink);
		g.fillRect(xPos, yPos, width, height);
		} else{
			g.drawImage(img, xPos, yPos, null);
		}
	}
	
	public void renderAsImage(Graphics g) {
		g.drawImage(img, xPos, yPos, null);
	}
	
	public void setImage(String fileName){
		URL url = getClass().getResource(fileName);
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {
		collisionBox.setBounds(xPos, yPos, width, height);
	}
}
