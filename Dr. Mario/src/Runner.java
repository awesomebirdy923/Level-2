import javax.swing.JFrame;

public class Runner {

	private JFrame frame;
	private static GamePanel game;

	public Runner() {

		frame = new JFrame();
		game = new GamePanel(1000);
		frame.setSize(900, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.setVisible(true);
		frame.addKeyListener(game);
		frame.setResizable(false);

	}

	public static void main(String[] args) {
		new Runner();
		game.startLoop();
	}

}
