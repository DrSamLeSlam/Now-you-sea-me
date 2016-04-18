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
        background = new Background(0,0,1000,408,1);
        caveBackground = new Background(480,0,1000,480,1);
        shipBackground = new Background(960,0,1000,480,1);
        cave = new Background(480,0,1000,480,1.2f);
        ship = new Background(960,0,1000,480,1.2f);
        Random rand = new Random();
        for( int i = 0; i < 50; i ++) {
        	fishes.add(new Fish(rand.nextInt(960), rand.nextInt(400)+40, rand.nextInt(11), rand.nextInt(5)+1));
        }
        hidden = false;
    }
    public void update(float delta) {
        status = diver.update(delta);

        if (status == 1) {
        	background.update(delta, diver.getVelocity());
        	caveBackground.update(delta, diver.getVelocity());
        	shipBackground.update(delta, diver.getVelocity());
        	cave.update(delta, diver.getVelocity());
        	ship.update(delta, diver.getVelocity());
        	if(hidden) {
        		hiddenDiver.setPosition(new Vector2(hiddenDiver.getPosition().x-diver.getVelocity().x*1.2f, hiddenDiver.getPosition().y));
        	}
        } 
    }
    public void hide() {
    	if ( !hidden ) {
    		hiddenDiver = new Diver(diver.getSuper().x, diver.getSuper().y, 20, 20);
    		hiddenDiver.setOpacity(0.2f);
    		hidden = true;
    		diver.setPosition(new Vector2(200,200));
    		diver.setSuper(new Vector2(200,200));
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
