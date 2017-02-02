import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	static Timer timer;
	private Shape pointlessSquare;
	private int CURRENT_STATE;
	private final int MENU_STATE = 1;
	private final int LEVEL1_STATE = 2;
	private final int LEVEL2_STATE = 3;
	private ObjectManager manager;
	private Pill pill;
	private Shape doctorKeith;
	int spacePressed = 0;
	URL url = getClass().getResource("dr_keith_pink.png");

	public GamePanel(int fpsCap) {
		doctorKeith = new Shape(700, 0, 300, 300, true);
		timer = new Timer(fpsCap / 60, this);
		// pointlessSquare = new Shape(900 / 2, 900 / 2, 100, 100);
		manager = new ObjectManager();
		// pill =
		// manager.addObject(pointlessSquare);
		// manager.addObject(pill);
		doctorKeith.setImage("dr_keith_pink.png");
		manager.addObject(doctorKeith);
		CURRENT_STATE = MENU_STATE;
	}

	public static void startLoop() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (CURRENT_STATE == MENU_STATE) {
			updateMenuState();
		} else if (CURRENT_STATE == LEVEL1_STATE) {
			updateLevel1State();
		} else if (CURRENT_STATE == LEVEL1_STATE) {
			updateLevel2State();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if (CURRENT_STATE == MENU_STATE) {
			paintMenuState(g);
		} else if (CURRENT_STATE == LEVEL1_STATE) {
			paintLevel1State(g);
		} else if (CURRENT_STATE == LEVEL1_STATE) {
			paintLevel2State(g);
		}
	}

	public void paintMenuState(Graphics g) {
		manager.draw(g);
		// doctorKeith.render(g);
	}

	public void paintLevel1State(Graphics g) {

	}

	public void paintLevel2State(Graphics g) {

	}

	public void updateMenuState() {

	}

	public void updateLevel1State() {

	}

	public void updateLevel2State() {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == e.VK_SPACE) {
			System.err.println(spacePressed);
			if (spacePressed == 0) {
				manager.addObject(new Pill(doctorKeith.getxPos() + 30, doctorKeith.getyPos() + 50, 32, 32));
				spacePressed = 1;
			} else if (spacePressed == 1) {
				manager.getPill().setxPos(900 / 2);
				manager.getPill().moving = true;
				spacePressed = 0;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
