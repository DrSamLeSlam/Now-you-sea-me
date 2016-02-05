package GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.sun.org.apache.xpath.internal.operations.Bool;

import GameWorld.GameWorld;
import Helpers.AssetLoader;

public class Worm {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    
    private float time;
    private Vector2 mousePos;
    private Vector2 distance;
    private float d;
    
    float velocityNet;
    float accelerationNet;

    public int width;
    public int height;
    
    public boolean turn = false;

    public Worm(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x,y);
        velocity = new Vector2(0,0);
        acceleration = new Vector2(0,0);
    }
    public void update(float delta){
    	velocity.x+=acceleration.x;
    	velocity.y+=acceleration.y;
        position.y+=velocity.y;
        position.x+=velocity.x;
        
        if (velocity.x>1) {
        	velocity.x=1;
        } if (velocity.y>1) {
        	velocity.y=1;
        } if (velocity.x<-1) {
        	velocity.x=-1;
        } if (velocity.y<-1) {
        	velocity.y=-1;
        }
        
        
        
        if (position.y < 0){
            position.y = 0;
            velocity.y=0;
        } if (position.y > 184){
            position.y = 184;
            velocity.y=0;
        } if (position.x<-20) {
        	position.x=-20;
        	velocity.x=0;
        } if (position.x>75) {
        	position.x=75;
        	velocity.x=0;
        }
        distance.x=mousePos.x-position.x;
        distance.y=mousePos.y-position.y;
        velocityNet = (float) Math.sqrt((Math.pow(velocity.x,2)+Math.pow(velocity.y, 2)));
        accelerationNet = (float) Math.sqrt((Math.pow(acceleration.x,2)+Math.pow(acceleration.y, 2)));
        d=(float) Math.sqrt((Math.pow(distance.x,2)+Math.pow(distance.y, 2)));
        time = velocityNet/accelerationNet;
        if( velocityNet * time / 2 >= d ) {
        	
        }
    }
    public void Move(int mouseX, int mouseY) {
    	mousePos.x=mouseX;
    	mousePos.y=mouseY;
    }
    public void KeyUp(){
        acceleration.y=-0.05f;
    }
    public void KeyDown(){
    	acceleration.y=0.05f;
    }
    public void KeyLeft(){
        acceleration.x=-0.05f;
        if (turn == false){
        	 //AssetLoader.sprite.flip(true, false);
        	 //turn = true;
        }
    }
    public void KeyRight(){
        acceleration.x=0.05f;
        if (turn == false){
        	 //AssetLoader.sprite.flip(true, false);
        	 //turn = true;
        }       
    }
    public void EndKeyUp(){
        acceleration.y=0;
    }
    public void EndKeyDown(){
    	acceleration.y=0;
    }
    public void EndKeyLeft(){
    	acceleration.x=0;
    	turn = false;
    }
    public void EndKeyRight(){
    	acceleration.x=0;
    	turn = false;
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
