import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends Shape{
private int speed;
public boolean isAlive = true;
	public Projectile(int xPos, int yPos, int width, int height, int speed) {
		super(xPos, yPos, width, height);
		super.update();
		this.speed = speed;
	}

	public void render(Graphics g){
		g.drawImage(MainGameLoop.img[2], getxPos(), getyPos(), null);
	}
	
	public void update(){
		super.update();
		setyPos(getyPos()-getSpeed());
		if(getyPos()<0){
			isAlive = false;
		}
	}

	public int getSpeed() {
		return speed;
	}
	
}
