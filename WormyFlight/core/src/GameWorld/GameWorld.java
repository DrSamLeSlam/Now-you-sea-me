package GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import GameObjects.Background;
import GameObjects.Diver;

public class GameWorld {
    private Diver diver;
    private Background background;
    private int status = 0;
    public GameWorld(){
        diver = new Diver(100,100,20,20);
        background = new Background(0,0,1000,408,0);
    }
    public void update(float delta) {
        status = diver.update(delta);
        if (status == 1) {
        	background.update(delta, false);
        } if (status == 2) {
        	background.update(delta, true);
        }
        
    }
    public Diver getDiver(){
        return diver;
    }
    public Background getBackgroundround(){
    	return background;
    }
}
