
//Evil Lily's password: JesusChrist123!
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	int kills;
	Font titleFont;
	Font titleFontEnter;
	Font titleFontSpace;

	Font gameOverFont;
	Font gameOverFontKills;
	Font gameOverFontRestart;

	Rocketship rocketShip;

	ObjectManager manager;

	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	public static BufferedImage spaceImg;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		titleFontEnter = new Font("Arial", Font.PLAIN, 36);
		titleFontSpace = new Font("Arial", Font.PLAIN, 36);

		gameOverFont = new Font("Arial", Font.BOLD, 48);
		gameOverFontKills = new Font("Arial", Font.PLAIN, 36);

		rocketShip = new Rocketship(250, 700, 50, 50);

		manager = new ObjectManager(rocketShip);

		try {

			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	void startGame() {
		timer.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObjects();

		if (rocketShip.isAlive == false) {
			currentState = END_STATE;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("League Invaders!", 75, 150);
		g.setFont(titleFontEnter);
		g.drawString("Press ENTER to Start", 75, 400);
		g.setFont(titleFontSpace);
		g.drawString("Press SPACE for Instructions", 25, 500);
	}

	void drawGameState(Graphics g) {
		g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.width, LeagueInvaders.height, null);
		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.BLACK);
		g.setFont(gameOverFont);
		g.drawString("Game Over", 120, 150);
		g.setFont(gameOverFontKills);
		g.drawString("You Murdered " + manager.getScore() + " Enemies", 60, 200);
		g.setFont(gameOverFontRestart);
		g.drawString("Press ENTER to start again!", 30, 500);
	}

	@Override
	public void paintComponent(Graphics g) {
		switch (currentState) {
		case MENU_STATE:
			drawMenuState(g);
			break;
		case GAME_STATE:
			drawGameState(g);
			break;
		case END_STATE:
			drawEndState(g);
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		/*
		 * if (currentState == MENU_STATE) { updateMenuState(); }
		 * 
		 * else if (currentState == GAME_STATE) { updateGameState(); }
		 * 
		 * else if (currentState == END_STATE) { updateEndState(); }
		 */

		switch (currentState) {
		case MENU_STATE:
			updateMenuState();
			break;
		case GAME_STATE:
			updateGameState();
			break;
		case END_STATE:
			updateEndState();
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println("hi");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (currentState == END_STATE) {
				rocketShip = new Rocketship(250, 700, 50, 50);
				System.out.println("hello");
				manager = new ObjectManager(rocketShip);
			}

			currentState++;

		}

		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocketShip.down();
		}

		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocketShip.up();
		}

		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocketShip.right();
		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocketShip.left();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// System.out.println("Hi");
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addProjectile(new Projectile(rocketShip._x + rocketShip._width / 2 - 5, rocketShip._y, 10, 10));

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// System.out.println("hI");

	}
}
