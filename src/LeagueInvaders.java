import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final int width = 500;
	final int height = 800;

	public static void main(String[] args) {
new LeagueInvaders().setup();
	}

	LeagueInvaders() {
		frame = new JFrame();
	}

	void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.pack();
	}
}
