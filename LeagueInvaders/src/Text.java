import java.awt.Font;
import java.awt.Graphics;

public class Text {
private int xPos;
private int yPos;
private String text;
private Font font;
public Text(int xPos, int yPos, String text, Font font) {
	this.xPos = xPos;
	this.yPos = yPos;
	this.text = text;
	this.font = font;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
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
public Font getFont() {
	return font;
}

public void render(Graphics g){
	g.setFont(getFont());
	g.drawString(getText(), getxPos(), getyPos());
}	

}
