
//Evil Lily's password: JesusChrist123!
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	GameObject gameObject;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		gameObject = new GameObject(20, 30, 40, 50);
	}

	void startGame() {
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		gameObject.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gameObject.update();
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("hi");

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Hi");

	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("hI");

	}
}
