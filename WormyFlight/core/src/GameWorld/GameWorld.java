package GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import GameObjects.Ground;
import GameObjects.Worm;

public class GameWorld {
    private Worm worm;
    private Ground ground;
    public GameWorld(){
        worm = new Worm(64,50,20,20);
        ground = new Ground(0,400,408, 20);
    }
    public void update(float delta) {
        worm.update(delta);
        ground.update(delta);
    }
    public Worm getWorm(){
        return worm;
    }
    public Ground getGround(){
    	return ground;
    }
}
