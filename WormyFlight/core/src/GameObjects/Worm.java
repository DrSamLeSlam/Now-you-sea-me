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
    private double v;
    private double a;
    private float theta;
    private float thetaV;
    
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
        mousePos = new Vector2(0,0);
        distance = new Vector2(0,0);
    }
    public void update(float delta){
    	
    	distance.x = mousePos.x - position.x - 47; //components of distance between mouse and diver
    	distance.y = mousePos.y - position.y - 5;
    	
    	d = Math.sqrt(Math.pow(distance.x, 2) + Math.pow(distance.y, 2)); //d is the mangnitude of the distance between the mosue and the diver
    	
    	//System.out.println(distance.x + ", " + distance.y);
    	//System.out.println( "    " + position.x + " + " + position.y );
    	//System.out.println(distance.y/distance.x);
    	
    	theta = (float) Math.atan(distance.y/distance.x);//theta is the angle of the vector between the mouse and the diver. from -pi/2 to pi/2
    	
    	//System.out.println(theta);
    	
    	if ( distance.x < 0 && distance.y > 0 ) { //all of this crap changes theta to be 0 to 2pi
    		temp = (float)pi / 2 + theta;
    		theta = (float)pi / 2 + temp;
    	} else if ( distance.x < 0 && distance.y <= 0 ) {
    		theta += pi;
    	} else if ( distance.x >= 0 && distance.y < 0 ) {
    		temp = (float)pi / 2 + theta;
    		theta = 3 * (float)pi / 2 + temp; 
    	}
    	
    	System.out.println(theta);
    	System.out.println(d);
    	System.out.println("");
    	
    	v = Math.sqrt(Math.pow(velocity.x, 2) + Math.pow(velocity.y, 2)); //magnitude of velocity
    	
    	if ( d > 10 ) {
    		acceleration.x = 0.05f * (float)Math.cos(theta); //set acceleration towards the current mouse position
    		acceleration.y = 0.05f * (float)Math.sin(theta);
    	} if ( d <= 10 ) {
    		velocity.x = distance.x / 50;//stop the diver when he is close eneough to the mouse
    		velocity.y = distance.y / 50;
    	} 
    	
    	velocity.x+=acceleration.x; //update velocity. this will generally put the magnitude of the velocity over 2
    	velocity.y+=acceleration.y; //so we correct that below
    	
    	if ( v > 2 ) { //this caps the magnitude of velocity at 2 while maintaining the ratio of x and y components
    		thetaV = (float) Math.atan(velocity.y/velocity.x); //thetaV is the angle of the velocity vector. NOTE: this is different than regular theta

    		if ( velocity.x < 0 && velocity.y > 0 ) { //more crap to change theta to 0 to 2pi
        		temp = (float)pi / 2 + thetaV;
        		thetaV = (float)pi / 2 + temp;
        	} else if ( velocity.x < 0 && velocity.y <= 0 ) {
        		thetaV += pi;
        	} else if ( velocity.x >= 0 && velocity.y < 0 ) {
        		temp = (float)pi / 2 + thetaV;
        		thetaV = 3 * (float)pi / 2 + temp;
        	}
    		
    		velocity.x = 2 * (float)Math.cos(thetaV); //adjusts the velocity to new values
    		velocity.y = 2 * (float)Math.sin(thetaV); //magnitude will always be equal to 2
    	}	
    	
        position.y+=velocity.y; //update position
        position.x+=velocity.x;
        
        if (position.y < 0){
            position.y = 0;
            velocity.y=0;
        } if (position.y > 250){
            position.y = 250;
            velocity.y=0;
        } if (position.x<-20) {
        	position.x=-20;
        	velocity.x=0;
        } if (position.x>420) {
        	position.x=420;
        	velocity.x=0;
        }
        
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
