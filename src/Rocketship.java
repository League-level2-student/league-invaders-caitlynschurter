import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	
	int speed;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void update() {

	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(_x, _y, _width, _height);

	}
}
