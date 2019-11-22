
//Evil Lily's password is JesusChrist123!
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship _rocketship;

	ArrayList<Projectile> projectiles;
	ArrayList<Alien> aliens;

	long enemyTimer;
	int enemySpawnTime;
	
	int score;

	public ObjectManager(Rocketship rocketship) {
		_rocketship = rocketship;
		projectiles = new ArrayList<Projectile>();
		aliens = new ArrayList<Alien>();

		enemyTimer = 0;
		enemySpawnTime = 2000;
		
		score = 0;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	

	void update() {
		_rocketship.update();
		for (Projectile p : projectiles) {
			p.update();
		}

		for (Alien a : aliens) {
			a.update();
		}
	}

	void draw(Graphics g) {
		_rocketship.draw(g);
		for (Projectile p : projectiles) {
			p.draw(g);
		}

		for (Alien a : aliens) {
			a.draw(g);
		}

	}

	void addProjectile(Projectile bullet) {
		projectiles.add(bullet);

	}

	void addAlien(Alien alien) {
		aliens.add(alien);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));
			// System.out.println("hi");
			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = aliens.size() - 1; i >= 0; i--) {
			if (!aliens.get(i).isAlive) {
				aliens.remove(i);
			}
		}
		for (int i = projectiles.size() - 1; i >= 0; i--) {
			if (!projectiles.get(i).isAlive) {
				projectiles.remove(i);
			}
		}
	}

	void checkCollision() {
		for (Alien a : aliens) {
			if (_rocketship.collisionBox.intersects(a.collisionBox)) {
				_rocketship.isAlive = false;
			}
		}
		for (Projectile p : projectiles) {
			for (Alien a : aliens) {
				if (a.collisionBox.intersects(p.collisionBox)) {
					a.isAlive = false;
					p.isAlive = false;
					score++;
					
				}
			}
		}

	}

}
