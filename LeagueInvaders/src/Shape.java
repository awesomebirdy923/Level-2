import java.awt.Graphics;
import java.awt.Rectangle;

public class Shape {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	public Rectangle collisionBox;
	public boolean isAlive = true;

	public Shape(int xPos, int yPos, int width, int height) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(xPos,yPos,width,height);
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
		g.fillRect(getxPos(), getyPos(), getWidth(), getHeight());
	}

	public void update() {
		collisionBox.setBounds(xPos, yPos, width, height);
	}

}
