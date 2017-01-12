import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.LeagueInvaders;

public class Runner {
public JFrame frame;
private JPanel panel;

private static final int WIDTH = 900;
private static final int HEIGHT = 900;

private static MainGameLoop game;

public Runner(int width, int height, Color color){
	try {
		game = new MainGameLoop(1000/60);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	frame = new JFrame();
	panel = new JPanel();
	panel.add(game);
	frame.add(game);
	frame.setSize(new Dimension(width, height));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBackground(color);
	frame.setVisible(true);
	frame.addKeyListener(game);
	frame.addMouseMotionListener(game);
	frame.addMouseListener(game);
}

public static void main(String[] args) {
	LeagueInvaders invader = new LeagueInvaders();
	new Runner(WIDTH, HEIGHT, new Color(200, 200, 200));
	game.startGame();
}
}
