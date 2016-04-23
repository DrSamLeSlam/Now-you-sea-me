package GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import GameWorld.GameRenderer;

public class Diver {
	private Vector2 superPosition;
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    
    private Vector2 distance;
    private Vector2 mousePos;
    
    private double d;
    private double v;
    
    private float theta;
    private float thetaV;
    
    private float temp;
    private double pi = 3.14159265359;

    private int width;
    private int height;
    
    private float opacity;

    public Diver(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        this.opacity = 1;
        superPosition = new Vector2(x,y);
        position = new Vector2(x,y);
        velocity = new Vector2(0,0);
        acceleration = new Vector2(0,0);
        mousePos = new Vector2(0,0);
        distance = new Vector2(0,0);
    }
    
    public int update(float delta) {
    	
    	distance.x = mousePos.x - position.x - 47; //components of distance between mouse and diver
    	distance.y = mousePos.y - position.y - 5;
    	
    	d = Math.sqrt(Math.pow(distance.x, 2) + Math.pow(distance.y, 2)); //d is the mangnitude of the distance between the mosue and the diver
    	
    	theta = (float) Math.atan(distance.y/distance.x);//theta is the angle of the vector between the mouse and the diver. from -pi/2 to pi/2
    	
    	if ( distance.x < 0 && distance.y > 0 ) { //all of this crap changes theta to be 0 to 2pi
    		temp = (float)pi / 2 + theta;
    		theta = (float)pi / 2 + temp;
    	} else if ( distance.x < 0 && distance.y <= 0 ) {
    		theta += pi;
    	} else if ( distance.x >= 0 && distance.y < 0 ) {
    		temp = (float)pi / 2 + theta;
    		theta = 3 * (float)pi / 2 + temp; 
    	}
    	
    	v = Math.sqrt(Math.pow(velocity.x, 2) + Math.pow(velocity.y, 2)); //magnitude of velocity
    	
    	if ( d > 10 ) {
    		acceleration.x = 0.13f * (float)Math.cos(theta); //set acceleration towards the current mouse position
    		acceleration.y = 0.13f * (float)Math.sin(theta);
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
    	
    	superPosition.x+=velocity.x;
    	superPosition.y+=velocity.y;
    	
        position.y+=velocity.y; //update position
        position.x+=velocity.x;
        
        
        if (position.y < 0){
            position.y = 0;
            //velocity.y=0;
        } if (position.y > 250){
            position.y = 250;
            //velocity.y=0;
        } if (position.x<50) {
        	position.x=50;
        	if(superPosition.x<50){
        		superPosition.x = 50;
        		return 0;
        	}
        	return 1;
        } if (position.x>370){
        	position.x=370;
        	if(superPosition.x>1330){
        		superPosition.x=1330;
        		return 0;
        	}
        	return 1;
        }
        
        return 0;
    }
    
    public float getOpacity() {
    	return opacity;
    }
    
    public void UpdateHidden (float delta, Vector2 Velocity) {
    	
    }
    
    public Vector2 getPosition() {
    	return position;
    }
    public void setPosition(Vector2 pos) {
    	position = pos;
    }
    public Vector2 getSuper() {
    	return superPosition;
    }
    public void setSuper(Vector2 superPos) {
    	superPosition = superPos;
    }
    public void Move(int mouseX, int mouseY) {
    	mousePos.x = GameRenderer.mousePosition.x;
    	mousePos.y = GameRenderer.mousePosition.y;
    }
    
    public void setOpacity(float O) {
    	opacity = O;
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
    public float getTheta() {
    	return theta;
    }
    public Vector2 getVelocity() {
    	return velocity;
    }
    public Vector2 getAcceleration() {
    	return acceleration;
    }

}
