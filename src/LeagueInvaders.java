import java.awt.Dimension;
import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final int width = 500;
	final int height = 800;

	GamePanel gamePanel;

	public static void main(String[] args) {
		new LeagueInvaders().setup();
	}

	LeagueInvaders() {
		frame = new JFrame();
		gamePanel = new GamePanel();
	}

	void setup() {
		frame.add(gamePanel);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.pack();
		
		gamePanel.startGame();
	}
}
