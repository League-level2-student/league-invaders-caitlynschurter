import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Rocketship _rocketship;

	ArrayList<Projectile> projectiles;

	public ObjectManager(Rocketship rocketship) {
		_rocketship = rocketship;
		projectiles = new ArrayList<Projectile>();
	}

	void update() {
		_rocketship.update();
		for(Projectile p: projectiles) {
			p.update();
		}
	}

	void draw(Graphics g) {
		_rocketship.draw(g);
		for(Projectile p: projectiles) {
			p.draw(g);
		}
	}
	
	void addProjectile(Projectile bullet) {
		projectiles.add(bullet);
		
	}
}
