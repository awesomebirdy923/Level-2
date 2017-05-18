import java.awt.Color;
import java.awt.Font;
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
	private final int LEVEL3_STATE = 4;
	private final int LEVEL4_STATE = 5;
	private final int GAMEOVER_STATE = 7;
	private final int END_STATE = 6;
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
	private static Virus virus;
	private static Virus virus1;
	private static Virus virus2;
	private static Virus satan;

	public GamePanel(int fpsCap) {
		playSound("theme.wav");
		border = new Shape(700, 80, 300, 300, true);
		doctorKeith = new Shape(700, 100, 300 / 2, 300 / 2, true);
		title = new Shape(100, 0, 1, 1, true);
		jar = new Shape(900 / 2 / 2, 400, 1, 1, true);
		pillHalf = new PillHalf(800 / 2, 800 / 2, 20 * 3 - 14, 20 * 3 - 14);
		timer = new Timer(fpsCap / 60, this);
		// pointlessSquare = new Shape(900 / 2, 900 / 2, 100, 100);
		manager = new ObjectManager();
		background = new Shape(0, 0, 900, 900, true);
		background.setImage("Background.png");
		grid = new Shape[10][10];
		virus = new Virus(500, 800, 92 / 5, 96 / 5, 2);
		virus1 = new Virus(400, 600, 92 / 5, 95 / 5, 1);
		virus2 = new Virus(460, 700, 93 / 4, 96 / 4, 1);
		satan = new Virus(900 / 2, 900 / 2, 200, 200, 0);
		// pill =
		// manager.addObject(pointlessSquare);
		// manager.addObject(pill);
		setBackground(Color.BLACK);
		doctorKeith.setImage("dr_keith_pink.png");
		border.setImage("keith_border.png");
		title.setImage("dr_keith_title.png");
		jar.setImage("jar.png");
		pillHalf.setImage("pill_half.gif");
		manager.addObject(title, 1);
		manager.addObject(border, 1);
		manager.addObject(doctorKeith, 1);
		manager.addObject(pillHalf, 1);
		manager.addObject(jar, 1);
		manager.addVirus(virus);
		manager.addVirus(virus1);
		grid[9][9] = new Pill(450, 792, 32, 32);
		CURRENT_STATE = MENU_STATE;
		System.out.println("Width = " + pillHalf.getWidth() + ", Height = " + pillHalf.getHeight());
	}

	public static void startLoop() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		frames++;
		manager.managePillCollision();
		// System.out.println(manager.moving());
		// System.out.println(frames);
		if (CURRENT_STATE == MENU_STATE) {
			updateMenuState();
		} else if (CURRENT_STATE == LEVEL1_STATE) {
			updateLevel1State();
		} else if (CURRENT_STATE == LEVEL2_STATE) {
			updateLevel2State();
		} else if (CURRENT_STATE == LEVEL3_STATE) {
			updateLevel3State();
		} else if (CURRENT_STATE == LEVEL4_STATE) {
			updateLevel4State();
		} else if (CURRENT_STATE == END_STATE) {
			updateEndState();
		} else if (CURRENT_STATE == GAMEOVER_STATE) {
			updateGameOverState();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		background.renderAsImage(g);
		if (manager.checkForPillLimit()) {
			CURRENT_STATE = GAMEOVER_STATE;
		}
		if (CURRENT_STATE == MENU_STATE) {
			paintMenuState(g);
		} else if (CURRENT_STATE == LEVEL1_STATE) {
			paintLevel1State(g);
		} else if (CURRENT_STATE == LEVEL2_STATE) {
			paintLevel2State(g);
		} else if (CURRENT_STATE == LEVEL3_STATE) {
			paintLevel3State(g);
		} else if (CURRENT_STATE == LEVEL4_STATE) {
			paintLevel4State(g);
		} else if (CURRENT_STATE == END_STATE) {
			paintEndState(g);
		} else if (CURRENT_STATE == GAMEOVER_STATE) {
			paintGameOverState(g);
		}
	}

	public void paintMenuState(Graphics g) {

		Shape menu = new Shape(0, 0, 500, 500, true);
		menu.setImage("title_screen.png");
		menu.render(g);

		// doctorKeith.render(g);
	}

	public void paintLevel1State(Graphics g) {
		manager.draw(g, 1);
		manager.draw(g, 2);
		g.setFont(new Font(Font.SANS_SERIF, 2, 20));
		g.setColor(Color.WHITE);
		g.drawString("Press Space to shoot pills", 0, 200);
	}

	public void addLevel2StateEntities() {
		System.out.println("amkBDHWAHFEEH dFvuhafJIOJidhjchbvfhdfabh");
		manager.addVirus(virus);
		manager.addVirus(virus1);
		manager.addVirus(virus2);
	}

	private void addLevel5Entities() {

	}

	private void addLevel4StateEntities() {
		manager.addVirus(satan);
	}

	public void addLevel3StateEntities() {
		manager.addVirus(virus);
		manager.addVirus(virus1);
		manager.addVirus(virus2);
		manager.addVirus(new Virus(500, 900, 92 / 5, 96 / 5, 1));
		manager.addVirus(new Virus(600, 800, 92 / 5, 96 / 5, 2));
	}

	public void paintLevel4State(Graphics g) {
		manager.draw(g, 1);
	}

	public void updateLevel4State() {
		int width = Runner.frame.getWidth() + 352;
		int height = Runner.frame.getHeight() + 607;
		manager.update();
		manager.manageVirusCollision();
		if (manager.score == 1) {
			manager.score = 0;
			manager.removeAllPills();
			CURRENT_STATE = END_STATE;
			addEndStateEntities();
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {

			}
		}
	}

	public void paintLevel2State(Graphics g) {
		// manager.addVirus(virus);
		// manager.addVirus(virus1);
		// manager.addVirus(new Virus(460, 700, 93/4, 96/4, 1));
		manager.draw(g, 1);
	}

	public void paintLevel3State(Graphics g) {
		manager.draw(g, 1);
	}

	public void updateMenuState() {

	}

	public void updateLevel1State() {
		int width = Runner.frame.getWidth() + 352;
		int height = Runner.frame.getHeight() + 607;
		manager.update();
		manager.manageVirusCollision();

		if (manager.score == 2) {
			manager.score = 0;
			manager.removeAllPills();
			CURRENT_STATE = LEVEL2_STATE;
			addLevel2StateEntities();
			manager.pillLimit = 2;
			manager.thrownPills = 0;
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {

			}
		}
	}

	public void updateEndState() {

	}

	public void updateLevel2State() {
		int width = Runner.frame.getWidth() + 352;
		int height = Runner.frame.getHeight() + 607;
		manager.update();
		manager.manageVirusCollision();
		if (manager.score == 3) {
			manager.score = 0;
			manager.removeAllPills();
			CURRENT_STATE = LEVEL3_STATE;
			addLevel3StateEntities();
			manager.pillLimit = 3;
			manager.thrownPills = 0;
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {

			}
		}
	}

	public void updateLevel3State() {
		int width = Runner.frame.getWidth() + 352;
		int height = Runner.frame.getHeight() + 607;
		manager.update();
		manager.manageVirusCollision();
		if (manager.score == 4) {
			manager.score = 0;
			manager.removeAllPills();
			CURRENT_STATE = LEVEL4_STATE;
			addLevel4StateEntities();
			manager.pillLimit = 2;
			manager.thrownPills = 0;
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {

			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (CURRENT_STATE == MENU_STATE) {
			if (e.getKeyCode() == e.VK_SPACE) {
				CURRENT_STATE = LEVEL1_STATE;

			}
		}
		if (e.getKeyCode() == e.VK_SPACE) {
			manager.addPills(2);
			// System.err.println(spacePressed);
			// if(!manager.getPill().inScene && manager.getPill()){

			// System.out.println(manager.getPill().moving);
			// if (spacePressed == 0) {
			// if (!manager.getPill().moving){
			//// manager.addObject(new Pill(doctorKeith.getxPos() + 30,
			// doctorKeith.getyPos() + 50, 32, 32));
			// p = new Pill(doctorKeith.getxPos() + 30, doctorKeith.getyPos() +
			// 50, 32, 32);
			// manager.movingPill = p;
			// System.out.println(p.moving);
			//
			// spacePressed = 1;
			//
			// }
			// } else if (spacePressed == 1) {
			// if (!manager.getPill().moving){
			// p.setxPos(900 / 2);
			// p.moving = true;
			// spacePressed = 0;
			// p.moving = true;
			//// manager.getPill().setmoving(true);
			// }
			// }
			// }
		} else if (e.getKeyCode() == e.VK_LEFT && manager.getPill().isPillFalling == true) {
			System.out.println("Hi.");
			manager.getPill().setxPos(manager.getPill().getxPos() - 10);
		} else if (e.getKeyCode() == e.VK_RIGHT && manager.getPill().isPillFalling == true) {
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

	public Pill getMovingPill() {
		return p;
	}

	public void paintEndState(Graphics g) {
		manager.draw(g, 1);
	}

	public void addEndStateEntities() {
		Shape win = new Shape(0, 0, 900, 900, true);
		win.setImage("end.png");
		manager.addObject(win, 1);
	}

	private void updateGameOverState() {
	}

	private void paintGameOverState(Graphics g) {
		Shape gameOver = new Shape(0, 0, 900, 900, true);
		gameOver.setImage("game_over.png");
		gameOver.render(g);
	}
}
