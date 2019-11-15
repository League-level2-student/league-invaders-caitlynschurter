import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship _rocketship;

	ArrayList<Projectile> projectiles;
	ArrayList<Alien> aliens;

	long enemyTimer;
	int enemySpawnTime;

	public ObjectManager(Rocketship rocketship) {
		_rocketship = rocketship;
		projectiles = new ArrayList<Projectile>();
		aliens = new ArrayList<Alien>();

		enemyTimer = 0;
		enemySpawnTime = 1000;
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

			for (Alien a : aliens) {
				a.draw(g);
			}
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

			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = aliens.size() - 1; i >= 0; i--) {
			if (!aliens.get(i).isAlive) {
				aliens.remove(i);
			}
		}
	}

	void checkCollision() {
		for (Alien a : aliens) {

			if (_rocketship.collisionBox.intersects(a.collisionBox)) {

				_rocketship.isAlive = false;

			}

		}

	}

}
