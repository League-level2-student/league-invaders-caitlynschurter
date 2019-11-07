import java.awt.Graphics;

public class ObjectManager {
	Rocketship _rocketship;
	
	public ObjectManager(Rocketship rocketship) {
		_rocketship = rocketship;
	}
	
	void update() {
		_rocketship.update();
	}
	
	void draw(Graphics g) {
		_rocketship.draw(g);
	}
}
