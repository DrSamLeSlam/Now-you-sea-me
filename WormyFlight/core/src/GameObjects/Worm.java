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
    
    private Vector2 distance;
    private Vector2 mousePos;
    
    private double d;
    
    private float time;
    private float maxSpeed;
    private float theta;
    
    private float velocityNet;
    private float accelerationNet;
    private float distanceNet;
    
    private float temp;
    private double pi = 3.14159265359;

    public int width;
    public int height;
    
    public boolean turn = false;

    public Worm(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x,y);
        velocity = new Vector2(0,0);
        acceleration = new Vector2(0,0);
        mousePos = new Vector2(31,50);
        distance = new Vector2(0,0);
    }
    public void update(float delta){
    	
    	distance.x = mousePos.x - position.x - 47;
    	distance.y = mousePos.y - position.y - 5;
    	
    	d = Math.sqrt(Math.pow(distance.x, 2) + Math.pow(distance.y, 2));
    	
    	//System.out.println(distance.x + ", " + distance.y);
    	//System.out.println( "    " + position.x + " + " + position.y );
    	//System.out.println(distance.y/distance.x);
    	
    	theta = (float) Math.atan(distance.y/distance.x);
    	
    	//System.out.println(theta);
    	
    	if ( distance.x < 0 && distance.y > 0 ) {
    		temp = (float)pi / 2 + theta;
    		theta = (float)pi / 2 + temp;
    	} else if ( distance.x < 0 && distance.y <= 0 ) {
    		theta += pi;
    	} else if ( distance.x >= 0 && distance.y < 0 ) {
    		temp = (float)pi / 2 + theta;
    		theta = 3 * (float)pi / 2 + temp;
    	}
    	System.out.println(theta);
    	System.out.println("");
    	
    	
    	
    	velocity.x+=acceleration.x;
    	velocity.y+=acceleration.y;
        position.y+=velocity.y;
        position.x+=velocity.x;
        
//        if (position.y < 0){
//            position.y = 0;
//            velocity.y=0;
//        } if (position.y > 184){
//            position.y = 184;
//            velocity.y=0;
//        } if (position.x<-20) {
//        	position.x=-20;
//        	velocity.x=0;
//        } if (position.x>75) {
//        	position.x=75;
//        	velocity.x=0;
//        }
        
        //System.out.println(mousePos.x+" "+mousePos.y);
        
        
    }
    public void Move(int mouseX, int mouseY) {
    	mousePos.x=mouseX / 2;
    	mousePos.y=mouseY / 2;
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
