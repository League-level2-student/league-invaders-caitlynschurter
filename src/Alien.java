//Lily's password is JesusChrist123!
import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	public void update() {
		super.update();
		_y++;
		}
	

	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(_x, _y, _width, _height);
	}
}
