import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends Shape{
	private int speed;
public Rocketship(int xPos, int yPos, int width, int height, int speed){
	super(xPos,yPos,width,height);
	super.update();
	this.speed = speed;
}
public void render(Graphics g){
	g.setColor(Color.green);
	g.fillRect(getxPos(), getyPos(), getWidth(), getHeight());	
}
public int getSpeed() {
	return speed;
}
}
