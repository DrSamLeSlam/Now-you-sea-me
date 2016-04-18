package GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Fish {
	
	private Vector2 position;
	
	public int width;
	public int height;
	
	public int type;
	
	public Fish(Boolean side, float y, float x, int width, int height, float layer) {
		
	}
	
	public void update(float delta, Vector2 velocity) {
		
	}
	public void setPosition(Vector2 pos) {
		position = pos;
	}
	public Vector2 getPosition() {
		return position;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getType() {
		return type;
	}

}
