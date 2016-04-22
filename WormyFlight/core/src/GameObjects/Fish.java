package GameObjects;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import Helpers.AssetLoader;

public class Fish {
	
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 superPosition;
	
	private Sprite sprite;
	
	private Vector2 size;
	
	int direction;
	
	private float layer;
	
	
	public Fish(float x, float y, int type, float layer) {
		position = new Vector2(x,y);
		superPosition = new Vector2(x,y);
		velocity = new Vector2(0.5f,0);
		
		this.layer = layer;
		if( x % 2 == 1 ) {
			velocity.x *= -1;
			sprite = AssetLoader.fishSprites.get(type);
		} else
			sprite = AssetLoader.fishSpritesFlipped.get(type);
		
		size = new Vector2(sprite.getWidth(),sprite.getHeight());
		size.x *= layer;
		size.y *= layer;
	
	}
	public void update(float delta) {
		position.x += velocity.x*layer;
		superPosition.x += velocity.x*layer;
		Random rand = new Random();
		if ( superPosition.x < -200 && velocity.x < 0 ) {
			position.x = 1440;
			superPosition.x = 1440;
			position.y = rand.nextInt(400)+40;
			superPosition.y = position.y;
		} if ( superPosition.x > 1700 && velocity.x > 0) {
			position.x = -200;
			superPosition.x = -200;
		}
	}
	public void update(float delta, Vector2 diverVelocity) {
		position.x -= diverVelocity.x*layer;
	}
	
	public float getLayer() {
		return layer;
	}
	public void setPosition(Vector2 pos) {
		position = pos;
	}
	public Vector2 getPosition() {
		return position;
	}
	
	public Vector2 getSize() {
		return size;
	}
	
	public Sprite getSprite() {
		return sprite;
	}

}
