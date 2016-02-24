package GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import GameObjects.Background;
import GameObjects.Diver;

public class GameWorld {
    private Diver diver;
    private Background ground;
    public GameWorld(){
        diver = new Diver(100,100,20,20);
        //background = new Background();
    }
    public void update(float delta) {
        diver.update(delta);
        //ground.update(delta);
    }
    public Diver getDiver(){
        return diver;
    }
    public Background getBackgroundround(){
    	return ground;
    }
}
