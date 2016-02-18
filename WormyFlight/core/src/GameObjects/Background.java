package GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Screen;


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
	
	public void update (float delta){
		
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
}
