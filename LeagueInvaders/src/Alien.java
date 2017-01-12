import java.awt.Color;
import java.awt.Graphics;

public class Alien extends Shape{

	public boolean isAlive = true;
	public Alien(int xPos, int yPos, int width, int height) {
		super(xPos, yPos, width, height);
		super.update();
	}

	public void render(Graphics g){
		g.drawImage(MainGameLoop.img[1], getxPos(), getyPos(), null);
	}
	
	public void update(){
		super.update();
			setyPos(getyPos()+1);
//			public void update(){
	}
	
}
