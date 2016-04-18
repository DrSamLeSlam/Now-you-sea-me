package GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Fish {
	
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 superPosition;
	
	public int width;
	public int height;
	
	boolean direction;
	
	public int layer;
	public int type;
	
	public int size;
	
	public Fish(float x, float y, int type, float layer) {
		position = new Vector2(x,y);
		superPosition = new Vector2(x,y);
		this.type = type;
		if(x%2 == 0) {
			direction = true;
		} else {
			direction = false;
		}
		
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
