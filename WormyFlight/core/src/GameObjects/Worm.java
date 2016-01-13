package GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import GameWorld.GameWorld;

public class Worm {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    public int width;
    public int height;

    public Worm(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x,y);
        velocity = new Vector2(20,20);
        acceleration = new Vector2(20,20);
    }
    public void update(float delta){
        position.y+=velocity.y;
        position.x=velocity.x;
        if (position.y < 0){
            position.y = 0;
        }
        if (position.y > 184){
            position.y = 184;
        }
    }
    public void KeyUp(){
        velocity.y=-1;
    }
    public void KeyDown(){
        velocity.y=1;

    }
    public void KeyLeft(){
        velocity.x=-1;
    }
    public void KeyRight(){
        velocity.x=1;
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
