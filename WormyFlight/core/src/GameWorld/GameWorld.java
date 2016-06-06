package GameWorld;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.holmgren.ethan.NowYouSeaMe;

import GameObjects.Background;
import GameObjects.Diver;
import GameObjects.Fish;
import Helpers.AssetLoader;

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
    private boolean tryAgain;
    private boolean close;
    private boolean youWin;
    private double closeTimer;
    private double tryAgainTimer;
    private boolean tooSlow;
    int gameState;
    public static int volumeState = 1;
    
    double clock;
    
    BitmapFont timer;

    private int status = 0;
    public GameWorld() {
        diver = new Diver(100,50,20,20);
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
        tryAgain = false;
        close = false;
        youWin = false;
        tooSlow = false;
        closeTimer = 0;
        tryAgainTimer = 0;
        gameState = 0;
        clock = 25;
        AssetLoader.song.play();
    }
    public void update(float delta) {

        for( int i = 0; i < fishes.size(); i ++ ) {
        	fishes.get(i).update(delta);
        }
        if( gameState == 1 || gameState == 3 )
        	status = diver.update(delta);
        
        if( gameState == 1 || gameState == 3 ) {
        	clock = clock - delta;
        }
        
        if (status == 1 && (gameState == 1 || gameState == 3)) {
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
        if(closeTimer > 0) {
        	closeTimer -= delta;
       	}
        else {
        	close = false;
        	closeTimer = 0;
        } 
        if(tryAgainTimer > 0) {
    	tryAgainTimer -= delta;
    	}
	    else {
	    	tryAgain = false;
	    	tryAgainTimer = 0;
	    }
        if(clock < 0) {
        	tooSlow = true;
        	gameState = 4;
        }
        if (volumeState == 1){
        	AssetLoader.song.resume();
        }
        if (volumeState == -1){
        	AssetLoader.song.pause();
        }
    }
    public void hide() {
    	if( gameState == 4 ) {
    		Gdx.app.exit();
    	}
    	if( gameState == 0 ) 
    		gameState = 1;
    	else if ( gameState == 2 )
    		gameState = 3;
    	else if ( !hidden ) {
    		hiddenDiver = new Diver(diver.getSuper().x, diver.getSuper().y, 20, 20);
    		hiddenDiver.setOpacity(0.2f);
    		hidden = true;
    		gameState = 2;
    		clock = 45;
    		diver.setPosition(new Vector2(100,100));
    		diver.setSuper(new Vector2(100,100));
    		background.setPosition(new Vector2(0,0));
    		caveBackground.setPosition(new Vector2(480,0));
    		shipBackground.setPosition(new Vector2(960,0));
    		cave.setPosition(new Vector2(480,0));
    		ship.setPosition(new Vector2(960,0));
    	} else {
    		if (Math.abs(hiddenDiver.getX()-diver.getX()) < 20 && Math.abs(hiddenDiver.getY()-diver.getY()) < 20 ) {
    			youWin = true;
    			gameState = 4;
    		} else if (Math.abs(hiddenDiver.getX()-diver.getX()) < 50 && Math.abs(hiddenDiver.getY()-diver.getY()) < 50 ) {
    			close = true;
    			closeTimer = 1;
    			tryAgain = false;
    			tryAgainTimer = 0;
    		} else {
    			tryAgain = true;
    			tryAgainTimer = 1;
    			close = false;
    			closeTimer = 0;
    		}
    	}
    }
    public boolean tooSlow() {
    	return tooSlow;
    }
    public boolean youWin() {
    	return youWin;
    }
    public boolean close() {
    	return close;
    }
    public boolean tryAgain() {
    	return tryAgain;
    }
    public int getState() {
    	return gameState;
    }
    public int getVolumeState(){
    	return volumeState;
    }
    public int getClock() {
    	return (int)clock;
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
