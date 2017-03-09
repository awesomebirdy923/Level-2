import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseMotionListener {

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
	private Shape background;
	private Shape border;
	private Shape title;
	private Shape jar;
	private Shape[][] grid;
	private PillHalf pillHalf;
	private int frames = 0;
	private Pill p;

	public GamePanel(int fpsCap) {
		playSound("theme.wav");
		border = new Shape(700, 80, 300, 300, true);
		doctorKeith = new Shape(700, 100, 300 / 2, 300 / 2, true);
		title = new Shape(100, 0, 1, 1, true);
		jar = new Shape(900 / 2 / 2, 400, 1, 1, true);
		pillHalf = new PillHalf(800/2, 800/2, 50, 50);
		timer = new Timer(fpsCap / 60, this);
		// pointlessSquare = new Shape(900 / 2, 900 / 2, 100, 100);
		manager = new ObjectManager();
		background = new Shape(0, 0, 900, 900, true);
		background.setImage("Background.png");
		grid = new Shape[10][10];
		// pill =
		// manager.addObject(pointlessSquare);
		// manager.addObject(pill);
		setBackground(Color.BLACK);
		doctorKeith.setImage("dr_keith_pink.png");
		border.setImage("keith_border.png");
		title.setImage("dr_keith_title.png");
		jar.setImage("jar.png");
		pillHalf.setImage("pill_half.gif");
		manager.addObject(title);
		manager.addObject(border);
		manager.addObject(doctorKeith);
		manager.addObject(pillHalf);
		manager.addObject(jar);
		grid[9][9] = new Pill(450, 792, 32, 32);
		CURRENT_STATE = MENU_STATE;
	}

	public static void startLoop() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		frames++;
//		System.out.println(manager.isPillFalling());
		// System.out.println(frames);
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
		background.renderAsImage(g);
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
		int width = Runner.frame.getWidth() + 352;
		int height = Runner.frame.getHeight() + 607;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {

			}
		}
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
			// System.err.println(spacePressed);
//			if(!manager.getPill().inScene && manager.getPill()){
			
			System.out.println(manager.isPillFalling());
			if (spacePressed == 0) {
				if (!manager.isPillFalling()){
//					manager.addObject(new Pill(doctorKeith.getxPos() + 30, doctorKeith.getyPos() + 50, 32, 32));
					p = new Pill(doctorKeith.getxPos() + 30, doctorKeith.getyPos() + 50, 32, 32);
					manager.addPills(p);
					System.out.println(p.isPillFalling);
					
				spacePressed = 1;

				}
			} else if (spacePressed == 1) {
				if (!manager.isPillFalling()){
				p.setxPos(900 / 2);
				p.moving = true;
				spacePressed = 0;
				p.isPillFalling = true;
//				manager.getPill().setisPillFalling(true);
				}
			}
//			}
		} else if (e.getKeyCode() == e.VK_LEFT) {
			System.out.println("Hi.");
			manager.getPill().setxPos(manager.getPill().getxPos() - 10);
		} else if (e.getKeyCode() == e.VK_RIGHT) {
			System.out.println("Hi.");
			manager.getPill().setxPos(manager.getPill().getxPos() + 10);
		} else if (e.getKeyCode() == e.VK_DOWN) {
			System.out.println("Hi.");
			manager.getPill().setyPos(manager.getPill().getyPos() + 20);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static synchronized void playSound(final String url) {
		new Thread(new Runnable() {
			// The wrapper thread is unnecessary, unless it blocks on the
			// Clip finishing; see comments.
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResource(url));
					clip.open(inputStream);
					clip.start();
					clip.setLoopPoints(0, -1);
				} catch (Exception e) {
					// System.err.println(e.getMessage());
				}
			}
		}).start();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int mouseX = e.getX();
		int mouseY = e.getY();

		System.out.println(mouseY);

		// System.out.println("x = " + manager.getPill().getxPos() + " y = " +
		// manager.getPill().getyPos());
	}

}
