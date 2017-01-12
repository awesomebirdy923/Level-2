import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends Shape{
	private int speed;
public Rocketship(int xPos, int yPos, int width, int height, int speed){
	super(xPos,yPos,width,height);
	this.speed = speed;
}
public void render(Graphics g){
//	g.fillRect(getxPos(), getyPos(), getWidth(), getHeight());	
	g.drawImage(MainGameLoop.img[0], getxPos(), getyPos(), null);
}
public int getSpeed() {
	return speed;
}

public void update(){
	super.update();
}
}
