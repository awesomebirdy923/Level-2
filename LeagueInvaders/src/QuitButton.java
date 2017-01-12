import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import org.w3c.dom.css.Rect;

public class QuitButton extends Shape{

	Rectangle buttonBox;
	
	public QuitButton(int xPos, int yPos, int width, int height){
		super(xPos, yPos, width, height);
		buttonBox = new Rectangle(xPos, yPos, width, height);
		super.update();
	}
	
	public void render(Graphics g){
		g.setColor(Color.red);
		g.fillRect(getxPos(),getyPos(),getWidth(),getHeight());
		g.setColor(Color.white);
		g.drawString("Rage Quit", getxPos(), getyPos()+10);
	}
	
	public void update(){
		buttonBox.setBounds(new Rectangle(getxPos(), getyPos(), getWidth(), getHeight()));
	}
	
}
