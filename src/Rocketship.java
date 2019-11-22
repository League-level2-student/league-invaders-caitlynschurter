//Evil Lily's password is JesusChrist123!
import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	int speed;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 8;
	}

	public void update() {
		super.update();
	}

	public void draw(Graphics g) {
		  g.drawImage(GamePanel.rocketImg, _x, _y, _width, _height, null);

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
