import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

	static Timer timer;
	private Shape pointlessSquare;
	private int CURRENT_STATE;
	private final int MENU_STATE = 1;
	private final int LEVEL1_STATE = 2;
	private final int LEVEL2_STATE = 3;
	private ObjectManager manager;
	private Pill pill;
	
	public GamePanel(int fpsCap) {
		timer = new Timer(fpsCap / 60, this);
		pointlessSquare = new Shape(900 / 2, 900 / 2, 100, 100);
		manager = new ObjectManager();
		pill = new Pill(600/2, 600/2, 32, 32);
		manager.addObject(pointlessSquare);
		manager.addObject(pill);
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

}
