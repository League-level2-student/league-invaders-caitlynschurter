
//Evil Lily's password: JesusChrist123!
import java.awt.Graphics;

public class GameObject {
	int _x;
	int _y;
	int _width;
	int _height;

	GameObject(int x, int y, int width, int height) {
		_x = x;
		_y = y;
		_width = width;
		_height = height;
	}

	public void update() {
		// move the object around
		_x++;
		_y++;
	}

	public void draw(Graphics g) {
		g.fillRect(_x, _y, _width, _height);
	}
}