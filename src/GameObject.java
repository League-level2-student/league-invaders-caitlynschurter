
//Evil Lily's password: JesusChrist123!
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int _x;
	int _y;
	int _width;
	int _height;
	Rectangle collisionBox;

	boolean isAlive;

	GameObject(int x, int y, int width, int height) {
		_x = x;
		_y = y;
		_width = width;
		_height = height;

		collisionBox = new Rectangle(_x, _y, _width, _height);
	}

	public void update() {
		collisionBox.setBounds(_x, _y, _width, _height);
	}

	public void draw(Graphics g) {

	}
}
