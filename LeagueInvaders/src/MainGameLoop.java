import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MainGameLoop extends JPanel implements ActionListener, KeyListener {

	Timer timer;
	int xPos = 400;
	int yPos = 400;
	boolean key[];
	Shape shape;
	Text gameOver;
	Text menu;
	GameStates states;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int CURRENT_STATE = MENU_STATE;
	Rocketship rocket;
	ObjectManager manager;
	Alien alien;

	public MainGameLoop(int fpsCap) {
		timer = new Timer(fpsCap, this);
		key = new boolean[999];
		shape = new Shape(400, 400, 100, 100);
		gameOver = new Text(400/2, 900/2, "Game Over", new Font(Font.SANS_SERIF, Font.PLAIN, 100));
		menu = new Text(100/2, 900/2, "League Invaders", new Font(Font.SANS_SERIF, Font.PLAIN, 100));
		rocket = new Rocketship(900/2-50, 800, 100, 100, 5);
		alien = new Alien(0, 0, 100, 100);
		manager = new ObjectManager();
		manager.addObject(rocket);
		manager.addObject(alien);
		
	}

	public void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.red);
//		shape.render(g);
		if (key[4]) {
			System.out.println("Test.");
		}
		if(CURRENT_STATE == MENU_STATE){
			drawMenuState(g);
		} else if(CURRENT_STATE == GAME_STATE){
			drawGameState(g);
		} else if(CURRENT_STATE == END_STATE){
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if(key[2]){
			rocket.setxPos(rocket.getxPos()+rocket.getSpeed());
		} else if(key[3]){
			rocket.setxPos(rocket.getxPos()-rocket.getSpeed());
		}
		if(CURRENT_STATE == MENU_STATE){
			updateMenuState();
		} else if(CURRENT_STATE == GAME_STATE){
			updateGameState();
		} else if(CURRENT_STATE == END_STATE){
			updateEndState();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == e.VK_W) {
			key[0] = true;
		} else if (e.getKeyCode() == e.VK_S) {
			key[1] = true;
		} else if (e.getKeyCode() == e.VK_D) {
			key[2] = true;
		} else if (e.getKeyCode() == e.VK_A) {
			key[3] = true;
		} else if (e.getKeyCode() == e.VK_T) {
			key[4] = true;
			System.out.println("Test.");
		} else if(e.getKeyCode() == e.VK_ENTER){
			CURRENT_STATE++;
			if(CURRENT_STATE > END_STATE){
				CURRENT_STATE = MENU_STATE;
			}
		}
		else if(e.getKeyCode() == e.VK_SPACE){
			manager.addObject(new Projectile(rocket.getxPos()+rocket.getWidth()/2, rocket.getyPos()+rocket.getHeight()/2, 10, 10, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == e.VK_W) {
			key[0] = false;
		} else if (e.getKeyCode() == e.VK_S) {
			key[1] = false;
		} else if (e.getKeyCode() == e.VK_D) {
			key[2] = false;
		} else if (e.getKeyCode() == e.VK_A) {
			key[3] = false;
		} else if (e.getKeyCode() == e.VK_T) {
			key[4] = false;
		}
	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		manager.update();
		manager.checkCollision();
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.blue);
		menu.render(g);
	}

	public void drawGameState(Graphics g) {
		manager.draw(g);
		manager.manageEnemies();
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.red);
		gameOver.render(g);
	}
}
