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
    private Diver playerTwo;
    private int status = 0;
    public GameWorld() {
        diver = new Diver(100,100,20,20);
        background = new Background(0,0,1000,408,1);
        cave = new Background(480,0,1000,480,1);
        ship = new Background(960,0,1000,480,1);
    }
    public void update(float delta) {
        status = diver.update(delta);

        if (status == 1) {
        	background.update(delta, diver.getVelocity());
        	cave.update(delta, diver.getVelocity());
        	ship.update(delta, diver.getVelocity());
        } 
    }
    public void playerTwo() {
    	playerTwo = new Diver(100,100,20,20);
    }
    public Diver getDiver() {
        return diver;
    }
    public Background getBackgroundround() {
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
