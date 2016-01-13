package GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import GameObjects.Worm;

public class GameWorld {
    private Worm worm;
    public GameWorld(){
        worm = new Worm(64,50,20,20);
    }
    public void update(float delta) {
        worm.update(delta);
    }
    public Worm getWorm(){
        return worm;
    }
}
