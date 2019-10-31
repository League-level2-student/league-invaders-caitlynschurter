import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	int speed;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}

	public void update() {

	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(_x, _y, _width, _height);

	}

	public void right() {
		_x += speed;

		if (_x > LeagueInvaders.width - _width) {
			_x = LeagueInvaders.width - _width;
		}

	}

	public void left() {
		_x -= speed;
		if (_x < 0) {
			_x = 0;
		}
	}

	public void down() {
		_y += speed;
		if (_y > LeagueInvaders.height - _height) {
			_y = LeagueInvaders.height - _height;
		}
	}

	public void up() {
		_y -= speed;
		if (_y < 0) {
			_y = 0;
		}
	}
}
