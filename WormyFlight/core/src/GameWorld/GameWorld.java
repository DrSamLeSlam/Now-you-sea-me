package GameWorld;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import GameObjects.Background;
import GameObjects.Diver;
import GameObjects.Fish;

public class GameWorld {
    private Diver diver;
    private Diver hiddenDiver;
    private Background background;
    private Background caveBackground;
    private Background shipBackground;
    private Background cave;
    private Background ship;
    private Background space;
    private ArrayList<Fish> fishes = new ArrayList<Fish>();
    private boolean hidden;

    private int status = 0;
    public GameWorld() {
        diver = new Diver(100,100,20,20);
        background = new Background(0,0,1000,408,0.5f);
        caveBackground = new Background(480,0,1000,480,0.5f);
        shipBackground = new Background(960,0,1000,480,0.5f);
        cave = new Background(480,0,1000,480,1);
        ship = new Background(960,0,1000,480,1);
        Random rand = new Random();
        for( int i = 0; i < 500; i ++) {
        	fishes.add(new Fish(rand.nextInt(1440), rand.nextInt(400)+40, rand.nextInt(11), 0.1f * (rand.nextInt(5) + 1 ) + 1 ));
        } for( int i = 0; i < 500; i ++) {
        	fishes.add(new Fish(rand.nextInt(1440), rand.nextInt(400)+40, rand.nextInt(11), 0.1f * rand.nextInt(5) + 0.5f ));
        }
        hidden = false;
    }
    public void update(float delta) {
        status = diver.update(delta);
        for( int i = 0; i < fishes.size(); i ++ ) {
        	fishes.get(i).update(delta);
        }

        if (status == 1) {
        	background.update(delta, diver.getVelocity());
        	caveBackground.update(delta, diver.getVelocity());
        	shipBackground.update(delta, diver.getVelocity());
        	cave.update(delta, diver.getVelocity());
        	ship.update(delta, diver.getVelocity());
        	for( int i = 0; i < fishes.size(); i ++ ) {
            	fishes.get(i).update(delta, diver.getVelocity());
            }
        	if(hidden) {
        		hiddenDiver.setPosition(new Vector2(hiddenDiver.getPosition().x-diver.getVelocity().x, hiddenDiver.getPosition().y));
        	}
        } 
    }
    public void hide() {
    	if ( !hidden ) {
    		hiddenDiver = new Diver(diver.getSuper().x, diver.getSuper().y, 20, 20);
    		hiddenDiver.setOpacity(0.2f);
    		hidden = true;
    		diver.setPosition(new Vector2(100,100));
    		diver.setSuper(new Vector2(100,100));
    		background.setPosition(new Vector2(0,0));
    		caveBackground.setPosition(new Vector2(480,0));
    		shipBackground.setPosition(new Vector2(960,0));
    		cave.setPosition(new Vector2(480,0));
    		ship.setPosition(new Vector2(960,0));
    		System.out.println("Here2");
    	} else {
    		if (Math.abs(hiddenDiver.getX()-diver.getX()) < 10 && Math.abs(hiddenDiver.getY()-diver.getY()) < 10 ) {
    			System.out.println("You Win!!!!");
    		} else {
    			System.out.println("Try Again!");
    		}
    	}
    }
    public Diver getDiver() {
        return diver;
    }
    public Fish getFish(int i) {
    	return fishes.get(i);
    }
    public ArrayList<Fish> getFishes() {
    	return fishes;
    }
    public Diver getHiddenDiver() {
    	return hiddenDiver;
    }
    public Background getBackground() {
    	return background;
    }
    public Background getCaveBackground() {
    	return caveBackground;
    }
    public Background getShipBackground() {
    	return shipBackground;
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
    public boolean hidden() {
    	return hidden;
    }
}
