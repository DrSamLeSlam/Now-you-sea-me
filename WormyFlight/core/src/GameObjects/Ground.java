package GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Screen;


public class Ground {

	private Vector2 position;
	
	public int width;
	public int height;
	
	public Ground(float x, float y, int width, int height){
		this.width = width;
		this.height = height;
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
