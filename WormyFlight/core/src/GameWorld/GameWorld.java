package GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import GameObjects.Background;
import GameObjects.Diver;

public class GameWorld {
    private Diver diver;
    private Background background;
    private Background cave;
    private Background ship;
    private Background space;
    private int status = 0;
    public GameWorld(){
        diver = new Diver(100,100,20,20);
        background = new Background(0,0,1000,408,1);
        cave = new Background(480,0,1000,480,1);
    }
    public void update(float delta) {
        status = diver.update(delta);
        if (status == 1) {
        	background.update(delta, false, diver.getVelocity());
        	cave.update(delta, false, diver.getVelocity());
        } if (status == 2) {
        	background.update(delta, false, diver.getVelocity());
        	cave.update(delta, true, diver.getVelocity());
        }
        
    }
    public Diver getDiver(){
        return diver;
    }
    public Background getBackgroundround(){
    	return background;
    }
    public Background getCave() {
    	return cave;
    }
    public Background getShip() {
    	return ship;
    }
    public Background getSpace() {
    	return space;
    }
}
