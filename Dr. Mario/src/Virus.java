import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Virus extends Shape {

	Image img;
	Rectangle hitBox;
	int ID;

	public Virus(int xPos, int yPos, int width, int height, int ID) {
		super(xPos, yPos, width, height, true);
		this.ID = ID;
		hitBox = new Rectangle();
	}

	public int getID() {
		return ID;
	}

	public void render(Graphics g) {
		if(getID() == 0){
			setImage("virus_satan.gif");
		} else if(getID() == 1){
			setImage("blue_virus.gif");
		} else if(getID() == 2){
			setImage("green_virus.gif");
		}
		g.drawImage(img, getxPos(), getyPos(), getWidth(), getHeight(), null);
	}

	public void setImage(String url) {
		URL Url = getClass().getResource(url);
		try {
			img = ImageIO.read(Url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {
		hitBox.setBounds(getxPos(), getyPos(), getWidth(), getHeight());
	}

}
