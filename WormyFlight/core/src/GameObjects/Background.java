package GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Background {

	private Vector2 position;
	
	private float layer;
	
	public int width;
	public int height;
	
	public Background(float x, float y, int width, int height, float layer){
		this.width = width;
		this.height = height;
		this.layer = layer;
		position = new Vector2(x,y);
	}
	
	public void update (float delta, boolean direction){
		System.out.println("here");
		if (direction) {
			position.x -= 2; 
		} else
			position.x +=2;
	}
	
	public float getX(){
        return position.x;
    }
    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
    public Vector2 getPosition() {
    	return position;
    }
}
